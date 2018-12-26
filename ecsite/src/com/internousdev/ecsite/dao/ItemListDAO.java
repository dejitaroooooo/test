package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ItemListDAO {
	DBConnector dbConnector = new DBConnector();
	Connection connection = dbConnector.getConnection();

	public ArrayList<ItemInfoDTO> getItemInfo() throws SQLException{
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

	public ArrayList<ItemInfoDTO> getItemInfo(String genre) throws SQLException{
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

	/*該当する商品の価格とストック数を変更する*/
	public int updateItem(String id, String itemPrice, String itemStock) throws SQLException{
		String sql ="UPDATE item_info_transaction SET item_price=?, item_stock=? WHERE id=?";
		int ret = 0;
		try{
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, itemPrice);
			ps.setString(2, itemStock);
			ps.setString(3, id);
			ret = ps.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		return ret;
	}

	public int oneItemDelete(String id) throws SQLException{
		int ret = 1;
		String presql = "SELECT item_transaction_id FROM user_buy_item_transaction WHERE item_transaction_id=?";
		String sql = "DELETE FROM item_info_transaction WHERE id=?";

		/*渡されたIDを持つ商品が購入履歴DBに存在するかどうか確認する*/
		try{
			PreparedStatement preps = connection.prepareStatement(presql);
			preps.setString(1, id);
			ResultSet resultSet = preps.executeQuery();

			/*該当する商品がDBに存在する場合*/
			if(resultSet.isBeforeFirst()){
				/*そのままメソッドを終了する*/
				return -1;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}

		/*渡されたIDを持つ商品の情報をDBから削除する*/
		try{
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, id);
			ret = ps.executeUpdate();
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
