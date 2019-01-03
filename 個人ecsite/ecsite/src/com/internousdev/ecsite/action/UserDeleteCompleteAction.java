package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.MyPageDAO;
import com.internousdev.ecsite.dao.UserDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserDeleteCompleteAction extends ActionSupport implements SessionAware{
	public Map<String, Object> session;

	public String execute() throws SQLException{

		/*ログインユーザの購入履歴をDBから削除する*/
		MyPageDAO myPageDAO = new MyPageDAO();
		myPageDAO.buyItemHistoryDelete(session.get("login_user_id").toString());
		/*ログインユーザの情報をDBから削除する*/
		UserDeleteCompleteDAO userDeleteCompleteDAO = new UserDeleteCompleteDAO();
		userDeleteCompleteDAO.loginUserDelete(session.get("login_user_id").toString());
		/*セッション内の情報を全て削除する*/
		session.clear();

		return SUCCESS;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
