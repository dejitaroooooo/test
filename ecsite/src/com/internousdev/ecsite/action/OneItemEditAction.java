package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class OneItemEditAction extends ActionSupport implements SessionAware{
	private String id;
	private String itemName;
	private String itemPrice;
	private String itemStock;
	public Map<String, Object> session;
//	private ItemListDAO itemInfoDAO = new ItemListDAO();
//	private ArrayList<ItemInfoDTO> itemList = new ArrayList<ItemInfoDTO>();

	public String execute() throws SQLException{
//		itemList = itemInfoDAO.getItemInfo();
		session.put("edit_Id", id);
		session.put("edit_ItemName", itemName);
		session.put("edit_ItemPrice", itemPrice);
		session.put("edit_ItemStock", itemStock);

		String ret = SUCCESS;

		return ret;
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
//	public ArrayList<ItemInfoDTO> getItemList() {
//		return itemList;
//	}
//	public void setItemList(ArrayList<ItemInfoDTO> itemList) {
//		this.itemList = itemList;
//	}
}
