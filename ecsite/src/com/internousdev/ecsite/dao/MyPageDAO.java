package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.internousdev.ecsite.dto.MyPageDTO;
import com.internousdev.ecsite.util.DBConnector;

public class MyPageDAO {
	public Map<String, Object> session;
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public ArrayList<MyPageDTO> getMyPageUserInfo(
	String user_master_id) throws SQLException{
		ArrayList<MyPageDTO> myPageDTO = new ArrayList<MyPageDTO>();
//		String sql = "SELECT "
//				+ "ubit.id, iit.item_name, ubit.total_price, ubit.total_count, ubit.pay, ubit.insert_date"
//				+ " FROM"
//				+ " user_buy_item_transaction ubit"
//				+ " LEFT JOIN"
//				+ " item_info_transaction iit"
//				+ " ON"
//				+ " ubit.item_transaction_id = iit.id"
//				+ " WHERE"
//				+ " ubit.item_transaction_id=? AND ubit.user_master_id=?"
//				+ " ORDER BY"
//				+ " insert_date DESC";

		String sql = "SELECT * FROM user_buy_item_transaction WHERE user_master_id=? ORDER BY insert_date DESC";
		String sqlItem = "SELECT item_name FROM item_info_transaction WHERE id=?";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setString(1, item_transaction_id);
//			preparedStatement.setString(2, user_master_id);
			preparedStatement.setString(1, user_master_id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()){

				if(resultSet.getString("id") != null){
					MyPageDTO dto = new MyPageDTO();
					dto.setId(resultSet.getString("item_transaction_id"));
//					dto.setItemName(resultSetItem.getString("item_name"));
					dto.setTotalPrice(resultSet.getString("total_price"));
					dto.setTotalCount(resultSet.getString("total_count"));
					dto.setPayment(resultSet.getString("pay"));
					dto.setInsert_date(resultSet.getString("insert_date"));
					myPageDTO.add(dto);
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		try{
			for(int i=0;i<myPageDTO.size();i++){
				PreparedStatement preparedStatementItem = connection.prepareStatement(sqlItem);
				preparedStatementItem.setString(1, myPageDTO.get(i).getId());
				ResultSet resultSetItem = preparedStatementItem.executeQuery();
				if(resultSetItem.next()){
					myPageDTO.get(i).setItemName(resultSetItem.getString("item_name"));
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		return myPageDTO;
	}

	public int buyItemHistoryDelete(String user_master_id) throws SQLException{
		String sql = "DELETE FROM user_buy_item_transaction WHERE user_master_id=?";
		PreparedStatement preparedStatement;
		int result = 0;
		try{
			preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setString(1, item_transaction_id);
//			preparedStatement.setString(2, user_master_id);
			preparedStatement.setString(1, user_master_id);
			result = preparedStatement.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		return result;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
