package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{
	private String loginUserId;
	private String loginPassword;
	public Map<String, Object> session;
	private LoginDAO loginDAO = new LoginDAO();
	private LoginDTO loginDTO = new LoginDTO();
	private String message;
	private int checkFlg;
	private ArrayList<ItemInfoDTO> itemList = new ArrayList<ItemInfoDTO>();

	public String execute() throws SQLException{
		String result = ERROR;

		/*入力された情報を用いてDBからユーザ情報を取得する*/
		loginDTO = loginDAO.getLoginUserInfo(loginUserId, loginPassword);
		session.put("loginUser", loginDTO);

		/*ログインに成功した場合*/
		if(((LoginDTO) session.get("loginUser")).getLoginFlg()){
			session.put("login_user_id", loginDTO.getLoginId());
			result = SUCCESS;
		}
		/*ログインに失敗した場合*/
		else{
			setMessage("IDまたはパスワードに誤りがあります。");
		}


		/*商品リストを取得*/
		ItemListDAO itemInfoDAO = new ItemListDAO();
		itemList = itemInfoDAO.getItemInfo();

		return result;
	}

	/*以下セッター＆ゲッター*/
	public ArrayList<ItemInfoDTO> getItemList() {
		return itemList;
	}
	public void setItemList(ArrayList<ItemInfoDTO> itemList) {
		this.itemList = itemList;
	}
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
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCheckFlg() {
		return checkFlg;
	}

	public void setCheckFlg(int checkFlg) {
		this.checkFlg = checkFlg;
	}

}
