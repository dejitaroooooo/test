package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class BuyItemCompleteDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private DateUtil dateUtil = new DateUtil();
	private String sql;

	/*ログインユーザの購入情報を登録するメソッド*/
	public void buyItemeInfo(String item_transaction_id,
		String user_master_id, String total_price,
		String total_count, String pay) throws SQLException{

		sql = "insert into user_buy_item_transaction"
			+ "(item_transaction_id, total_price, total_count, "
			+ "user_master_id, pay, insert_date) values (?,?,?,?,?,?)";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, item_transaction_id);
			preparedStatement.setString(2, total_price);
			preparedStatement.setString(3, total_count);
			preparedStatement.setString(4, user_master_id);
			preparedStatement.setString(5, pay);
			preparedStatement.setString(6, dateUtil.getDate());
			preparedStatement.execute();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
	}

	/*在庫数を購入後の在庫数に変更するメソッド*/
	public void itemStockDecrease(String id, String stock) throws SQLException{
		sql ="UPDATE item_info_transaction SET item_stock=? WHERE id=?";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, stock);
			preparedStatement.setString(2, id);
			preparedStatement.execute();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
	}

}
