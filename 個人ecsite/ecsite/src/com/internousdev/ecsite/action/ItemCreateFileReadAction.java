package com.internousdev.ecsite.action;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dto.ItemCreateFileReadDTO;
import com.internousdev.ecsite.util.ItemCreateFileReadUtil;
import com.opensymphony.xwork2.ActionSupport;

public class ItemCreateFileReadAction extends ActionSupport implements SessionAware{
	Map<String, Object> session;
	private ArrayList<ItemCreateFileReadDTO> itemList = new ArrayList<ItemCreateFileReadDTO>();

	public String execute() throws FileNotFoundException, IOException{
		String result = SUCCESS;
		String filename = "ItemList.xlsx"; //読み込むファイル名
		String sheetname = "Sheet1"; //読み込むシート名

		/*エクセルから商品情報を取得する*/
		ItemCreateFileReadUtil readExcel = new ItemCreateFileReadUtil();
		itemList = readExcel.excelRead(filename, sheetname);

		/*エクセルから取得した商品情報をセッションに保存*/
		session.put("excel_item_list", itemList);

		return result;
	}

	/*以下セッター＆ゲッター*/
	public ArrayList<ItemCreateFileReadDTO> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<ItemCreateFileReadDTO> itemList) {
		this.itemList = itemList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
