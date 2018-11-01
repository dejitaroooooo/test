package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemCreateConfirmAction extends ActionSupport implements SessionAware{
	private String itemName;
	private String itemPrice;
	private String itemStock;
	public Map<String, Object> session;
	String errorMessage;

	private ArrayList<ItemInfoDTO> registrationItem = new ArrayList<ItemInfoDTO>();


	public String execute() throws SQLException{
		String result = SUCCESS;

		/*入力漏れがないか確認*/
//		for(int i=0; i<registrationItem.size(); i++){

			/*デバック用*/
//			System.out.println("商品名：" + registrationItem.get(i).getItemName());
//			System.out.println("価格：" + registrationItem.get(i).getItemPrice());
//			System.out.println("在庫数：" + registrationItem.get(i).getItemStock());

//			if(!(registrationItem.get(i).getItemName().equals(""))
//					&& !(registrationItem.get(i).getItemPrice().equals(""))
//					&& !(registrationItem.get(i).getItemStock().equals(""))){
			if(!(itemName.equals(""))
				&& !(itemPrice.equals(""))
				&& !(itemStock.equals(""))){
				session.put("createItemName", itemName);
				session.put("createItemPrice", itemPrice);
				session.put("createItemStock", itemStock);
			}
			else{
				setErrorMessage("未入力の項目があります。");
				result = ERROR;
//			}
		}
		/*Mapに登録*/
//		session.put("registrationItem", registrationItem);

		return result;
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
