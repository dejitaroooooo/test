package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware{
	public Map<String, Object> session;
	private int count;
	private String pay;
	private ItemListDAO itemInfoDAO = new ItemListDAO();
	private ArrayList<ItemInfoDTO> itemList = new ArrayList<ItemInfoDTO>();


	public String execute() throws SQLException{
		String result = SUCCESS;



		itemList = itemInfoDAO.getItemInfo();
		session.put("count",count);
		int intCount = Integer.parseInt(session.get("count").toString());
		int intPrice = Integer.parseInt(session.get("buyItem_price").toString());
		session.put("total_price", intCount * intPrice);



		System.out.println(itemList.size());
		for(int i=0; i<itemList.size();i++){
			System.out.println("商品名：" + itemList.get(i).getItemName());
			System.out.println("価格：" + itemList.get(i).getItemPrice());
			System.out.println("ストック数：" + itemList.get(i).getItemStock());
		}

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
