package com.internousdev.webproj3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.webproj3.dto.HelloStrutsDTO;
import com.internousdev.webproj3.util.DBConnector;

public class HelloStrutsDAO {

	public HelloStrutsDTO select(){

		/*DBに接続するための設定*/
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		/*結果を格納するための箱(名前：dto)を用意*/
		HelloStrutsDTO dto = new HelloStrutsDTO();

		/*DBを操作するためのSQL構文*/
		String sql = "select * from users";

		try{
			/*DBを操作するための下準備*/
			PreparedStatement ps = con.prepareStatement(sql);
			/*DBの操作を実行*/
			ResultSet rs = ps.executeQuery();

			/*参考URL:https://qiita.com/AIN/items/ff3b48fe9a61f5cd297f*/
			if(rs.next()){
				/*dto箱に結果を格納（今回は成功）*/
				dto.setResult("MySQLと接続できます。");
			}
			else{
				/*dto箱に結果を格納（今回は失敗）*/
				dto.setResult("MySQLと接続できません。");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}

		try{
			/*DBとの接続を切る*/
			con.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}

		/*dto箱を返す*/
		/*（中身を別メソッドで参照する）*/
		return dto;
	}
}
