package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dao.UserListDAO;
import com.internousdev.ecsite.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListAction extends ActionSupport{
	private ArrayList<UserInfoDTO> userList = new ArrayList<UserInfoDTO>();

	public String execute() throws SQLException{

		/*全ユーザ情報をDBから取得する*/
		UserListDAO userListDAO = new UserListDAO();
		userList = userListDAO.getUserInfo();
		return SUCCESS;
	}

	/*以下セッター＆ゲッター*/
	public ArrayList<UserInfoDTO> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<UserInfoDTO> userList) {
		this.userList = userList;
	}

}
