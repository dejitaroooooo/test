package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class ItemListDeleteCompleteDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	/*商品情報をDBから全て削除する*/
	public int itemInfoDelete() throws SQLException{
		String sql = "delete from item_info_transaction";
		PreparedStatement preparedStatement;
		int ret = 0;
		try{
			preparedStatement = connection.prepareStatement(sql);
			ret = preparedStatement.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		return ret;
	}

}
