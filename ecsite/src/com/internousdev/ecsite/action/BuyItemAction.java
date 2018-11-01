package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware{
	public Map<String, Object> session;
	private String id;
	private String itemName;
	private String itemPrice;
	private int count;
	private String pay;
//	private ItemListDAO itemInfoDAO = new ItemListDAO();
//	private ArrayList<ItemInfoDTO> itemList = new ArrayList<ItemInfoDTO>();


	public String execute() throws SQLException{
		String result = SUCCESS;

//		System.out.println(itemName);
//		System.out.println(itemPrice);
//		itemList = itemInfoDAO.getItemInfo();
		session.put("buyItem_id", id);
		session.put("buyItem_name", itemName);
		session.put("buy_item_price", itemPrice);
		session.put("count",count);
//		int intCount = Integer.parseInt(session.get("count").toString());
//		int intPrice = Integer.parseInt(session.get("buyItem_price").toString());
		int intPrice = Integer.parseInt(itemPrice);

		session.put("total_price", count * intPrice);

		/*
		System.out.println(itemList.size());
		for(int i=0; i<itemList.size();i++){
			System.out.println("商品名：" + itemList.get(i).getItemName());
			System.out.println("価格：" + itemList.get(i).getItemPrice());
			System.out.println("ストック数：" + itemList.get(i).getItemStock());
		}
		*/
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
