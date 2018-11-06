package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class UserCreateCompleteDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private DateUtil dateutil = new DateUtil();
	private String sql;

	public void createUser(String loginUserId, String loginUserPassword, String userName) throws SQLException{
		sql = "insert into login_user_transaction(login_id, login_pass, user_name, insert_date) values(?,?,?,?)";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginUserId);
			preparedStatement.setString(2, loginUserPassword);
			preparedStatement.setString(3, userName);
			preparedStatement.setString(4, dateutil.getDate());
			preparedStatement.execute();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
	}

	public boolean userSameInfo(String loginUserId) throws SQLException{
		Boolean ret = false;
		sql = "SELECT * FROM login_user_transaction WHERE login_id=?";

		try{
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, loginUserId);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				ret = true;
			}
			else{
				ret = false;
			}
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
