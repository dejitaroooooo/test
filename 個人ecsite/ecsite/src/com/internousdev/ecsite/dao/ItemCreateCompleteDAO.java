package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class ItemCreateCompleteDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private DateUtil dateutil = new DateUtil();
	String sql = "insert into item_info_transaction (item_name, item_genre, item_price, item_stock, insert_date) values (?,?,?,?,?)";

	/*新しい商品情報をDBに保存する*/
	public void createItem(String itemName, String itemGenre, String itemPrice, String itemStock) throws SQLException{

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, itemName);
			preparedStatement.setString(2, itemGenre);
			preparedStatement.setString(3, itemPrice);
			preparedStatement.setString(4, itemStock);
			preparedStatement.setString(5, dateutil.getDate());
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
