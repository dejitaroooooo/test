package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class UserListDeleteCompleteDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	/*全ユーザのユーザ情報をDBから削除する*/
	public int userInfoDelete() throws SQLException{
		String sql = "delete from login_user_transaction";
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
