package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemCreateCompleteAction extends ActionSupport implements SessionAware{
	private String itemName;
	private String itemPrice;
	private String userName;
	public Map<String, Object> session;

	public String execute() throws SQLException{

		/*商品情報をDBに登録する*/
		ItemCreateCompleteDAO itemCreateCompleteDAO = new ItemCreateCompleteDAO();
		itemCreateCompleteDAO.createItem(
			session.get("createItemName").toString(),
			session.get("createItemGenre").toString(),
			session.get("createItemPrice").toString(),
			session.get("createItemStock").toString());

		return SUCCESS;
	}

	/*以下セッター＆ゲッター*/
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}

