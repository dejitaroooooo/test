package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware{
	public Map<String, Object> session;
	private ArrayList<ItemInfoDTO> itemList = new ArrayList<ItemInfoDTO>();

	public String execute() throws SQLException{

		/*セッション情報を全て削除する*/
		session.clear();

		/*商品リストを取得*/
		ItemListDAO itemInfoDAO = new ItemListDAO();
		itemList = itemInfoDAO.getItemInfo();

		return SUCCESS;
	}

	/*以下セッター＆ゲッター*/
	public ArrayList<ItemInfoDTO> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<ItemInfoDTO> itemList) {
		this.itemList = itemList;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
