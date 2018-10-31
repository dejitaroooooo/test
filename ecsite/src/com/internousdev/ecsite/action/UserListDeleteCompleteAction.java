package com.internousdev.ecsite.action;

import java.sql.SQLException;

import com.internousdev.ecsite.dao.UserListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListDeleteCompleteAction extends ActionSupport{
	private UserListDeleteCompleteDAO userListDeleteCompleteDAO = new UserListDeleteCompleteDAO();
	private int ret;

	public String execute() throws SQLException{
		ret = userListDeleteCompleteDAO.userInfoDelete();
		System.out.println("合計 " + ret + "件のユーザ情報を削除しました。");

		return SUCCESS;
	}

	public int getRet() {
		return ret;
	}

	public void setRet(int ret) {
		this.ret = ret;
	}

}
