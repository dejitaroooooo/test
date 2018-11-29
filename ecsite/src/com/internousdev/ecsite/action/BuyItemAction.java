package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware{
	public Map<String, Object> session;
	private String id;
	private String itemName;
	private int itemPrice;
	private int count;
	private int itemStock;
	private String pay;

	public String execute() throws SQLException{
		String result = SUCCESS;

		session.put("buyItem_id", id);
		session.put("buyItem_name", itemName);
		session.put("buy_item_price", itemPrice);
		session.put("buy_item_Stock", itemStock);
		session.put("count",count);
//		int intCount = Integer.parseInt(session.get("count").toString());
//		int intPrice = Integer.parseInt(session.get("buyItem_price").toString());
//		int intPrice = Integer.parseInt(itemPrice);

		session.put("total_price", count * itemPrice);

		String payment;
		if(pay.equals("1")){
			payment="現金払い";
			session.put("pay", payment);
		}
		else{
			payment="クレジットカード";
			session.put("pay", payment);
		}
		return result;
	}
/*
	public ItemListDAO getItemInfoDAO() {
		return itemInfoDAO;
	}

	public void setItemInfoDAO(ItemListDAO itemInfoDAO) {
		this.itemInfoDAO = itemInfoDAO;
	}

	public ArrayList<ItemInfoDTO> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<ItemInfoDTO> itemList) {
		this.itemList = itemList;
	}
	*/

	public int getItemStock() {
		return itemStock;
	}

	public void setItemStock(int itemStock) {
		this.itemStock = itemStock;
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

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public void setCount(int count){
		this.count = count;
	}

	public void setPay(String pay){
		this.pay = pay;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
