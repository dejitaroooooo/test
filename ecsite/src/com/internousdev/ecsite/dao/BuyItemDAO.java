package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class BuyItemDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
//	private BuyItemDTO buyItemDTO = new BuyItemDTO();


	public ArrayList<ItemInfoDTO> getItemInfo(String name, String genre) throws SQLException{

		ArrayList<ItemInfoDTO> buyItemDTO = new ArrayList<ItemInfoDTO>();


		if(!(name.equals("")) && !(genre.equals("全て"))){
			buyItemDTO = selectedGenreAndName(genre, name);
		}
		else if(name.equals("") && genre.equals("全て")){
			buyItemDTO = selectedALL();
		}
		else if(genre.equals("全て")){
			buyItemDTO = selectedName(name);
		}
		else{
			buyItemDTO = selectedGenre(genre);
		}

		return buyItemDTO;
	}





	public ArrayList<ItemInfoDTO> selectedALL() throws SQLException{
		ArrayList<ItemInfoDTO> itemInfoDTO = new ArrayList<ItemInfoDTO>();

		String sql = "select * from item_info_transaction";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()){
				ItemInfoDTO dto = new ItemInfoDTO();
				dto.setId(resultSet.getString("id"));
				dto.setItemName(resultSet.getString("item_name"));
				dto.setItemGenre(resultSet.getString("item_genre"));
				dto.setItemPrice(resultSet.getString("item_price"));
				dto.setItemStock(resultSet.getString("item_stock"));
				dto.setInsertDate(resultSet.getString("insert_date"));
				itemInfoDTO.add(dto);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}

		return itemInfoDTO;
	}

	public ArrayList<ItemInfoDTO> selectedGenre(String genre) throws SQLException{
		ArrayList<ItemInfoDTO> itemInfoDTO = new ArrayList<ItemInfoDTO>();

		String sql = "select * from item_info_transaction where item_genre=?";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, genre);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()){
				ItemInfoDTO dto = new ItemInfoDTO();
				dto.setId(resultSet.getString("id"));
				dto.setItemName(resultSet.getString("item_name"));
				dto.setItemGenre(resultSet.getString("item_genre"));
				dto.setItemPrice(resultSet.getString("item_price"));
				dto.setItemStock(resultSet.getString("item_stock"));
				dto.setInsertDate(resultSet.getString("insert_date"));
				itemInfoDTO.add(dto);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}

		return itemInfoDTO;
	}

	public ArrayList<ItemInfoDTO> selectedName(String name) throws SQLException{
		ArrayList<ItemInfoDTO> itemInfoDTO = new ArrayList<ItemInfoDTO>();

		String sql = "select * from item_info_transaction where item_name=?";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()){
				ItemInfoDTO dto = new ItemInfoDTO();
				dto.setId(resultSet.getString("id"));
				dto.setItemName(resultSet.getString("item_name"));
				dto.setItemGenre(resultSet.getString("item_genre"));
				dto.setItemPrice(resultSet.getString("item_price"));
				dto.setItemStock(resultSet.getString("item_stock"));
				dto.setInsertDate(resultSet.getString("insert_date"));
				itemInfoDTO.add(dto);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}

		return itemInfoDTO;
	}

	public ArrayList<ItemInfoDTO> selectedGenreAndName(String genre, String name) throws SQLException{
		ArrayList<ItemInfoDTO> itemInfoDTO = new ArrayList<ItemInfoDTO>();

		String sql = "select * from item_info_transaction where item_name=? AND item_genre=?";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, genre);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()){
				ItemInfoDTO dto = new ItemInfoDTO();
				dto.setId(resultSet.getString("id"));
				dto.setItemName(resultSet.getString("item_name"));
				dto.setItemGenre(resultSet.getString("item_genre"));
				dto.setItemPrice(resultSet.getString("item_price"));
				dto.setItemStock(resultSet.getString("item_stock"));
				dto.setInsertDate(resultSet.getString("insert_date"));
				itemInfoDTO.add(dto);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}

		return itemInfoDTO;
	}

}
