package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BuyItemConfirmAction extends ActionSupport implements SessionAware{
	public Map<String, Object> session;
	private String id;
	private String itemName;
	private int itemPrice;
	private int count;
	private int itemStock;
	private String pay;

	public String execute() throws SQLException{
		String result = SUCCESS;

		/*購入する商品に関する情報をセッションに保存*/
		session.put("buyItem_id", id);
		session.put("buyItem_name", itemName);
		session.put("buy_item_price", itemPrice);
		session.put("buy_item_Stock", itemStock);
		session.put("count",count);
		session.put("total_price", count * itemPrice);
		if(pay.equals("1")){
			session.put("pay", "現金払い");
		}
		else{
			session.put("pay", "クレジットカード");
		}

		return result;
	}

	/*以下セッター＆ゲッター*/
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
