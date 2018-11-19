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
	ArrayList<ItemCreateFileReadDTO> itemList = new ArrayList<ItemCreateFileReadDTO>();
	String filename = "ItemList.xlsx";
	String sheetname = "Sheet1";

	public String execute() throws FileNotFoundException, IOException{
		String result = SUCCESS;
		ItemCreateFileReadUtil readExcel = new ItemCreateFileReadUtil();

		itemList = readExcel.excelRead(filename, sheetname);
		session.put("excel_item_list", itemList);

		return result;
	}

	public ArrayList<ItemCreateFileReadDTO> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<ItemCreateFileReadDTO> itemList) {
		this.itemList = itemList;
	}

	public String getFilename(){
		return filename;

	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
