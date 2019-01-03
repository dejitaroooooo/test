package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.MyPageDTO;
import com.internousdev.ecsite.util.DBConnector;

public class UserBuyItemListDAO {
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();

	public ArrayList<MyPageDTO> getUserBuyItemInfo(String order_column, String order_type) throws SQLException{
		StringBuilder buf = new StringBuilder();
		ArrayList<MyPageDTO> UserBuyItemDTO = new ArrayList<MyPageDTO>();

		String preSql = "SELECT "
				+ " ubit.id, iit.item_name, iit.item_genre, ubit.total_price, ubit.total_count, ubit.user_master_id, ubit.pay, ubit.insert_date"
				+ " FROM"
				+ " user_buy_item_transaction ubit"
				+ " LEFT JOIN"
				+ " item_info_transaction iit"
				+ " ON "
				+ " ubit.item_transaction_id = iit.id"
				+ " ORDER BY";
		buf.append(preSql);
		buf.append(" ");
		buf.append(order_column);
		buf.append(" ");
		buf.append(order_type);
		String sql = buf.toString();

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				MyPageDTO dto = new MyPageDTO();
				dto.setId(rs.getString("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemGenre(rs.getString("item_genre"));
				dto.setTotalPrice(rs.getString("total_price"));
				dto.setTotalCount(rs.getString("total_count"));
				dto.setUserName(rs.getString("user_master_id"));
				dto.setPayment(rs.getString("pay"));
				dto.setInsert_date(rs.getString("insert_date"));
				UserBuyItemDTO.add(dto);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			con.close();
		}

		return UserBuyItemDTO;
	}

	public void deleteUserBuyItemInfo() throws SQLException{
		String sql = "DELETE from user_buy_item_transaction";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.execute();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			con.close();
		}
	}

}
