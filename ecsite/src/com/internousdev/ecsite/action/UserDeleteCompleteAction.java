package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.MyPageDAO;
import com.internousdev.ecsite.dao.UserDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserDeleteCompleteAction extends ActionSupport implements SessionAware{
	public Map<String, Object> session;
	private MyPageDAO myPageDAO = new MyPageDAO();
	private UserDeleteCompleteDAO userDeleteCompleteDAO = new UserDeleteCompleteDAO();

	public String execute() throws SQLException{
		String result = SUCCESS;

		myPageDAO.buyItemHistoryDelete(session.get("login_user_id").toString());
		userDeleteCompleteDAO.loginUserDelete(session.get("login_user_id").toString());
		session.clear();

		return result;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
