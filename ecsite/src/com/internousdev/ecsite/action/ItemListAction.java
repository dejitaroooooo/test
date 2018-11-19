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
	private ItemListDAO itemInfoDAO = new ItemListDAO();
	private ItemListDAO itemDeleteDAO = new ItemListDAO();
	private ArrayList<ItemInfoDTO> itemList = new ArrayList<ItemInfoDTO>();
	private String id;
	private String itemName;
	private String deleteFlg;
	private String message;
	private int ret;

	public int getRet() {
		return ret;
	}

	public void setRet(int ret) {
		this.ret = ret;
	}

	public String execute() throws SQLException{
		if(deleteFlg== null){
		}
		else if(deleteFlg.equals("1")){
			delete();
		}

		itemList = itemInfoDAO.getItemInfo();

		return SUCCESS;
	}

	public void delete() throws SQLException {

		ret = itemDeleteDAO.oneItemDelete(id);

		if(ret < 0){
			setMessage("[" + itemName  + "]を削除できません。\n既に購入しているユーザがいます。");
		}
		else if(ret>0){
			setMessage("[" + itemName  + "]を削除しました。");
		}

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
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

	public ItemListDAO getItemInfoDAO() {
		return itemInfoDAO;
	}

	public void setItemInfoDAO(ItemListDAO itemInfoDAO) {
		this.itemInfoDAO = itemInfoDAO;
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
}
