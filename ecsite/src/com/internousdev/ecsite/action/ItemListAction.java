package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListAction extends ActionSupport implements SessionAware{
	public Map<String, Object> session;
	private ArrayList<ItemInfoDTO> itemList = new ArrayList<ItemInfoDTO>();
	private String id;
	private String item;
	private String deleteFlg = "0";
	private String message;
	private int ret;

	public String execute() throws SQLException{

		/*削除ボタンが押下され、デリートフラグが立った場合*/
		if(deleteFlg.equals("1")){
			/*選択された商品の情報を削除する*/
			delete();
		}

		/*商品情報をDBから取得する*/
		ItemListDAO itemInfoDAO = new ItemListDAO();
		itemList = itemInfoDAO.getItemInfo();

		return SUCCESS;
	}

	/*選択された商品の情報をDBから削除*/
	public void delete() throws SQLException {

		/*渡されたidをもつ商品の情報をDBから削除*/
		ItemListDAO itemDeleteDAO = new ItemListDAO();
		ret = itemDeleteDAO.oneItemDelete(id);

		/*問題なく削除できた場合*/
		if(ret>0){
			setMessage("[" + item  + "]を削除しました。");
		}
		/*既に購入しているユーザがいる場合*/
		else if(ret == -1){
			setMessage("[" + item  + "]を削除できません。\n既に購入しているユーザがいます。");
		}
		/*削除に失敗した場合*/
		else{
			setMessage("削除に失敗しました。");
		}
	}

	/*以下セッター＆ゲッター*/
	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void OneItemDelete(){

	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ArrayList<ItemInfoDTO> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<ItemInfoDTO> itemList) {
		this.itemList = itemList;
	}

	public String getDeleteFlg() {
		return deleteFlg;
	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	public int getRet() {
		return ret;
	}

	public void setRet(int ret) {
		this.ret = ret;
	}
}
