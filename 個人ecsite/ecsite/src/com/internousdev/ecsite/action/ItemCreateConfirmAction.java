package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemCreateConfirmAction extends ActionSupport implements SessionAware{
	private String itemName;
	private String itemGenre;
	private String itemPrice;
	private String itemStock;
	private String errorMessage;
	public Map<String, Object> session;
	private ArrayList<ItemInfoDTO> registrationItem = new ArrayList<ItemInfoDTO>();

	public String execute() throws SQLException{
		String result = ERROR;

		/*記入漏れがないか確認*/
		if(!(itemName.equals("")) && !(itemPrice.equals("")) && !(itemStock.equals(""))){
			/*セッションに商品情報を保存*/
			session.put("createItemName", itemName);
			session.put("createItemGenre", itemGenre);
			session.put("createItemPrice", itemPrice);
			session.put("createItemStock", itemStock);
			result = SUCCESS;
		}
		else{
			/*エラーメッセージを入れる*/
			setErrorMessage("未入力の項目があります。");
		}

		return result;
	}

	/*以下セッター＆ゲッター*/
	public String getItemGenre() {
		return itemGenre;
	}

	public void setItemGenre(String itemGenre) {
		this.itemGenre = itemGenre;
	}

	public ArrayList<ItemInfoDTO> getRegistrationItem() {
		return registrationItem;
	}

	public void setRegistrationItem(ArrayList<ItemInfoDTO> registrationItem) {
		this.registrationItem = registrationItem;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
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

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
