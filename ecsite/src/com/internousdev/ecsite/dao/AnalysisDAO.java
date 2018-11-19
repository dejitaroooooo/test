package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.AnalysisDTO;
import com.internousdev.ecsite.util.DBConnector;

public class AnalysisDAO {
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();

	public ArrayList<AnalysisDTO> itamTotalCountInfo() throws SQLException{
		ArrayList<AnalysisDTO> analysisDTO = new ArrayList<AnalysisDTO>();
		String sql = "SELECT "
					+ " ubit.id, iit.item_name, iit.item_genre, sum(ubit.total_count) as total"
					+ " FROM"
					+ " user_buy_item_transaction ubit"
					+ " LEFT JOIN"
					+ " item_info_transaction iit"
					+ " ON"
					+ " ubit.item_transaction_id = iit.id"
					+ " GROUP BY"
					+ " iit.item_name"
					+ " ORDER BY"
					+ " item_genre"
					+ " DESC";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				AnalysisDTO dto = new AnalysisDTO();
				dto.setId(rs.getString("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemGenre(rs.getString("item_genre"));
				dto.setTotalItemCount(rs.getInt("total"));
				analysisDTO.add(dto);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			con.close();
		}

		return analysisDTO;
	}

}
