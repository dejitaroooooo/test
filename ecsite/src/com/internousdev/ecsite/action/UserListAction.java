package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dao.UserListDAO;
import com.internousdev.ecsite.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListAction extends ActionSupport{
	private ArrayList<UserInfoDTO> userList = new ArrayList<UserInfoDTO>();
	private UserListDAO userListDAO = new UserListDAO();

	public String execute() throws SQLException{
		userList = userListDAO.getUserInfo();
		return SUCCESS;
	}

	public ArrayList<UserInfoDTO> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<UserInfoDTO> userList) {
		this.userList = userList;
	}

	public UserListDAO getUserListDAO() {
		return userListDAO;
	}

	public void setUserListDAO(UserListDAO userListDAO) {
		this.userListDAO = userListDAO;
	}

}
