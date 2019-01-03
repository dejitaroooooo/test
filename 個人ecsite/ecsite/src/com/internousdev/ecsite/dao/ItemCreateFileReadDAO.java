package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.ItemCreateFileReadDTO;
import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class ItemCreateFileReadDAO {
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	private DateUtil dateutil = new DateUtil();
	private String sql;

	/*商品情報をDBに登録する*/
	public void insertExcelItemInfo(ArrayList<ItemCreateFileReadDTO> itemList) throws SQLException{
		sql = "INSERT INTO item_info_transaction(item_name, item_genre, item_price, item_stock, insert_date) values (?,?,?,?,?)";
		try{
			for(int i=0;i<itemList.size();i++){
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, itemList.get(i).getItemName());
				ps.setString(2, itemList.get(i).getGenre());
				ps.setString(3, itemList.get(i).getPrice());
				ps.setString(4, itemList.get(i).getStock());
				ps.setString(5, dateutil.getDate());
				ps.execute();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			con.close();
		}
	}

}
