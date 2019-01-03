package com.internousdev.ecsite.action;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemCreateFileReadDAO;
import com.internousdev.ecsite.dto.ItemCreateFileReadDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemCreateFileReadCompleteAction extends ActionSupport implements SessionAware{
	Map <String, Object> session;
	ArrayList<ItemCreateFileReadDTO> itemList = new ArrayList<ItemCreateFileReadDTO>();
	ArrayList<ItemCreateFileReadDTO> excelList = new ArrayList<ItemCreateFileReadDTO>();

	public String execute() throws SQLException, FileNotFoundException, IOException{
		String result = SUCCESS;

		/*商品情報をDBに保存*/
		@SuppressWarnings("unchecked")
		ArrayList<ItemCreateFileReadDTO> excelItemList = (ArrayList<ItemCreateFileReadDTO>)session.get("excel_item_list");
		ItemCreateFileReadDAO dao = new ItemCreateFileReadDAO();
		dao.insertExcelItemInfo(excelItemList);

		/*エクセルから取得した商品情報をセッションから削除*/
		session.remove("excel_item_list");

		return result;
	}

	/*以下セッター＆ゲッター*/
	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ArrayList<ItemCreateFileReadDTO> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<ItemCreateFileReadDTO> itemList) {
		this.itemList = itemList;
	}

	public ArrayList<ItemCreateFileReadDTO> getExcelList() {
		return excelList;
	}

	public void setExcelList(ArrayList<ItemCreateFileReadDTO> excelList) {
		this.excelList = excelList;
	}

}
