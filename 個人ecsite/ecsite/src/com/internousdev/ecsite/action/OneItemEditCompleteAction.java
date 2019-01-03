package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class OneItemEditCompleteAction extends ActionSupport implements SessionAware{
	public Map<String, Object> session;
	private ArrayList<ItemInfoDTO> itemList = new ArrayList<ItemInfoDTO>();
	private String editItemPrice;
	private String editItemStock;

	public String execute() throws SQLException{
		String result = ERROR;
		ItemListDAO itemInfoDAO = new ItemListDAO();

		/*記入漏れが無い場合*/
		if( !(editItemPrice.equals("")) && !(editItemStock.equals("")) ){

			/*該当するIDを持つ商品の価格とストック数を変更する*/
			int count = itemInfoDAO.updateItem(session.get("edit_Id").toString(), editItemPrice, editItemStock);

			/*変更できた場合*/
			if(count > 0){
				/*全商品情報をDBから取得する*/
				itemInfoDAO = new ItemListDAO();
				itemList = itemInfoDAO.getItemInfo();

				result = SUCCESS;
			}
		}

		return result;
	}

	/*以下セッター＆ゲッター*/
	public ArrayList<ItemInfoDTO> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<ItemInfoDTO> itemList) {
		this.itemList = itemList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getEditItemPrice() {
		return editItemPrice;
	}

	public void setEditItemPrice(String editItemPrice) {
		this.editItemPrice = editItemPrice;
	}

	public String getEditItemStock() {
		return editItemStock;
	}

	public void setEditItemStock(String editItemStock) {
		this.editItemStock = editItemStock;
	}
}
