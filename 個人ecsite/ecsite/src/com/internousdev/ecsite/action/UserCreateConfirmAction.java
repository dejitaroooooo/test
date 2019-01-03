package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware{
	private String loginUserId;
	private String loginPassword;
	private String userName;
	public Map<String, Object> session;
	private String errorMessage;
	UserCreateCompleteDAO uccDAO = new UserCreateCompleteDAO();

	public String execute() throws SQLException{
		String result = ERROR;

		/*入力フォームに未入力箇所がある場合*/
		if((loginUserId.equals("")) || (loginPassword.equals("")) || (userName.equals(""))){
			setErrorMessage("未入力の項目があります。");
		}
		/*登録しようとしたIDが既に利用されている場合*/
		else if(uccDAO.userSameInfo(loginUserId)){
			setErrorMessage("入力したIDは既に使用されています。");
		}
		/*入力内容に問題がない場合*/
		else{
			session.put("loginUserId", loginUserId);
			session.put("loginPassword", loginPassword);
			session.put("userName", userName);
			result = SUCCESS;
		}

		return result;
	}

	/*以下セッター＆ゲッター*/
	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
