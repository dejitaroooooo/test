package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserDeleteConfirmAction extends ActionSupport implements SessionAware{
	Map<String, Object> session;
	private String loginPass;
	private String errorMessage;
	private LoginDTO loginDTO = new LoginDTO();

	public String execute(){
		String result = ERROR;

		/*パスワードをDBと照合*/
		LoginDAO loginDAO = new LoginDAO();
		loginDTO = loginDAO.getLoginUserInfo(session.get("login_user_id").toString(), loginPass);

		/*パスワードが正しい場合*/
		if(loginDTO.getLoginFlg()){
			result = SUCCESS;
		}
		/*パスワードが間違っている場合*/
		else{
			/*エラーメッセージを入れる*/
			setErrorMessage("パスワードが違います。");
		}

		return result;
	}

	/*以下セッター＆ゲッター*/
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getLoginPass() {
		return loginPass;
	}

	public void setLoginPass(String loginPass) {
		this.loginPass = loginPass;
	}
}
