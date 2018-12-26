package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dao.UserBuyItemListDAO;
import com.internousdev.ecsite.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserBuyItemListAction extends ActionSupport{
	private String order_column = "insert_date";
	private String order_type = "DESC";
	private ArrayList<MyPageDTO> userBuyItemList = new ArrayList<MyPageDTO>();
	private String deleteFlg;

	public String execute() throws SQLException{
		String result = SUCCESS;

		/*デリートフラグが立っていない場合*/
		if(deleteFlg == null){
			UserBuyItemListDAO userBuyItemDAO = new UserBuyItemListDAO();
			userBuyItemList = userBuyItemDAO.getUserBuyItemInfo(order_column, order_type);
		}
		/*削除ボタンが押下され、デリートフラグが立った場合*/
		else if(deleteFlg.equals("1")){
			delete();
		}

		return result;
	}

	public void delete() throws SQLException{
		/*全ユーザの購入履歴を全て削除*/
		UserBuyItemListDAO userBuyItemDAO = new UserBuyItemListDAO();
		userBuyItemDAO.deleteUserBuyItemInfo();
	}

	/*以下セッター＆ゲッター*/
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
