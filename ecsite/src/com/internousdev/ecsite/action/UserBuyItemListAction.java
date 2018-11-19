package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dao.UserBuyItemListDAO;
import com.internousdev.ecsite.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserBuyItemListAction extends ActionSupport{
	private String order_column = "insert_date";
	private String order_type = "DESC";
	private UserBuyItemListDAO userBuyItemDAO = new UserBuyItemListDAO();
	private ArrayList<MyPageDTO> userBuyItemList = new ArrayList<MyPageDTO>();
	private String deleteFlg;

	public String execute() throws SQLException{
		String result = SUCCESS;

		if(deleteFlg == null){
			System.out.println("column = " + order_column);
			System.out.println("type = " + order_type);
			userBuyItemList = userBuyItemDAO.getUserBuyItemInfo(order_column, order_type);
		}
		else if(deleteFlg.equals("1")){
			delete();
		}

		return result;
	}

	public void delete() throws SQLException{
		userBuyItemDAO.deleteUserBuyItemInfo();
	}

	public String getOrder_column() {
		return order_column;
	}

	public void setOrder_column(String order_column) {
		this.order_column = order_column;
	}

	public String getOrder_type() {
		return order_type;
	}

	public void setOrder_type(String order_type) {
		this.order_type = order_type;
	}

	public ArrayList<MyPageDTO> getUserBuyItemList() {
		return userBuyItemList;
	}
	public void setUserBuyItemList(ArrayList<MyPageDTO> userBuyItemList) {
		this.userBuyItemList = userBuyItemList;
	}

	public String getDeleteFlg() {
		return deleteFlg;
	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}
}
