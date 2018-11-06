package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class UserDeleteCompleteDAO {
	DBConnector db = new DBConnector();
	Connection con = db.getConnection();
	String sql = "DELETE from login_user_transaction where login_id=?";

	public void loginUserDelete(String login_id) throws SQLException{

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, login_id);
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
