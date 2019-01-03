package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dao.MyPageDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.internousdev.ecsite.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware{
	public Map<String, Object> session;
	private MyPageDAO myPageDAO = new MyPageDAO();
	private ArrayList<MyPageDTO> myPageList = new ArrayList<MyPageDTO>();
	private String deleteFlg;
	private String message;
	private int totalPayment = 0;
	private ArrayList<ItemInfoDTO> itemList = new ArrayList<ItemInfoDTO>();

	public String execute() throws SQLException{

		/*ログインしていない場合*/
		if(!session.containsKey("login_user_id")){

			/*商品リストを取得*/
			ItemListDAO itemInfoDAO = new ItemListDAO();
			itemList = itemInfoDAO.getItemInfo();

			return ERROR;
		}

		/*履歴削除フラグが立っていない場合*/
		if(deleteFlg == null){
			/*DBから取得した履歴情報を「myPageList」に格納*/
			myPageList = myPageDAO.getMyPageUserInfo(session.get("login_user_id").toString());

			/*購入した商品の総額を計算*/
			for(int i=0;i<myPageList.size();i++){
				totalPayment += Integer.parseInt(myPageList.get(i).getTotalPrice());
			}

		}
		/*履歴削除フラグが立っている場合*/
		else if(deleteFlg.equals("1")){
			delete();
		}

		return SUCCESS;
	}

	/*購入履歴を削除するメソッド*/
	public void delete() throws SQLException{
		/*購入履歴を削除する*/
		int res = myPageDAO.buyItemHistoryDelete(session.get("login_user_id").toString());
		/*1件以上削除できた場合*/
		if(res>0){
			myPageList = null;
			setMessage("商品情報を正しく削除しました。");
		}
		/*削除件数が0の場合*/
		else if(res==0){
			setMessage("商品情報の削除に失敗しました。");
		}
	}

	/*以下セッター＆ゲッター*/
	public void setDeleteFlg(String deleteFlg){
		this.deleteFlg = deleteFlg;
	}
	public Map<String, Object> getSession(){
		return session;
	}
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
	public ArrayList<MyPageDTO> getMyPageList(){
		return this.myPageList;
	}
	public String getMessage(){
		return this.message;
	}
	public void setMessage(String message){
		this.message = message;
	}
	public int getTotalPayment() {
		return totalPayment;
	}
	public void setTotalPayment(int totalPayment) {
		this.totalPayment = totalPayment;
	}
	public ArrayList<ItemInfoDTO> getItemList() {
		return itemList;
	}
	public void setItemList(ArrayList<ItemInfoDTO> itemList) {
		this.itemList = itemList;
	}

}
