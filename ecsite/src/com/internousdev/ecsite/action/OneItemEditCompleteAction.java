package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class OneItemEditCompleteAction extends ActionSupport implements SessionAware{
	private String id;
	private String itemName;
	private String itemPrice;
	private String itemStock;
	public Map<String, Object> session;;
	private ItemListDAO itemUpdateDAO = new ItemListDAO();
	private ItemListDAO itemInfoDAO = new ItemListDAO();
	private ArrayList<ItemInfoDTO> itemList = new ArrayList<ItemInfoDTO>();
//	private String itemName;
	private String editItemPrice;
	private String editItemStock;

	public String execute() throws SQLException{
		String result = ERROR;
		id = session.get("edit_Id").toString();
		itemName = session.get("edit_ItemName").toString();
		itemPrice = session.get("edit_ItemPrice").toString();
		itemStock = session.get("edit_ItemStock").toString();
//		System.out.println(id);
//		System.out.println(itemName);
//		System.out.println(itemPrice);
//		System.out.println(itemStock);
//		System.out.println(editItemPrice);
//		System.out.println(editItemStock);

		if( !(editItemPrice.equals("")) && !(editItemStock.equals("")) ){
			int count = itemUpdateDAO.updateItem(id, editItemPrice, editItemStock);
			System.out.println(count);
			if(count > 0){
				itemList = itemInfoDAO.getItemInfo();

				result = SUCCESS;
			}
		}
		else{
			return result;
		}
		return result;
	}

	public ArrayList<ItemInfoDTO> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<ItemInfoDTO> itemList) {
		this.itemList = itemList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemStock() {
		return itemStock;
	}

	public void setItemStock(String itemStock) {
		this.itemStock = itemStock;
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

	//private ItemUpdateDAO


}
