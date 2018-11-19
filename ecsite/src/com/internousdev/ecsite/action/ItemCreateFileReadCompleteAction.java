package com.internousdev.ecsite.action;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemCreateFileReadDAO;
import com.internousdev.ecsite.dto.ItemCreateFileReadDTO;
import com.internousdev.ecsite.util.ItemCreateFileReadUtil;
import com.opensymphony.xwork2.ActionSupport;

public class ItemCreateFileReadCompleteAction extends ActionSupport implements SessionAware{
	Map <String, Object> session;
	ItemCreateFileReadDAO dao = new ItemCreateFileReadDAO();
	ArrayList<ItemCreateFileReadDTO> itemList = new ArrayList<ItemCreateFileReadDTO>();
	ArrayList<ItemCreateFileReadDTO> excelList = new ArrayList<ItemCreateFileReadDTO>();

	public String execute() throws SQLException, FileNotFoundException, IOException{
		String result = SUCCESS;
		ItemCreateFileReadDAO dao = new ItemCreateFileReadDAO();
		String filename = "ItemList.xlsx";
		String sheetname = "Sheet1";
//		itemList = (ArrayList<ItemCreateFileReadDTO>) session.get("excel_item_list");
		ItemCreateFileReadUtil readExcel = new ItemCreateFileReadUtil();

		itemList = readExcel.excelRead(filename, sheetname);

//		for(int i=0;i<itemList.size();i++){
//			System.out.println(itemList.get(i).getItemName());
//		}

		dao.insertExcelItemInfo(itemList);


		return result;
	}

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
