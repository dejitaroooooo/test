package com.internousdev.ecsite.action;

import java.sql.SQLException;

import com.internousdev.ecsite.dao.ItemListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListDeleteCompleteAction extends ActionSupport{
	private ItemListDeleteCompleteDAO itemListDeleteCompleteDAO = new ItemListDeleteCompleteDAO();
	private int ret;

	public String execute() throws SQLException{
		ret = itemListDeleteCompleteDAO.itemInfoDelete();
		System.out.println("合計 " + ret + "件の商品情報を削除しました。");

		return SUCCESS;
	}

	public int getRet() {
		return ret;
	}

	public void setRet(int ret) {
		this.ret = ret;
	}

}
