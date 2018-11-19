package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware{
	public Map<String, Object> session;
	private BuyItemDAO buyItemDAO = new BuyItemDAO();
//	private BuyItemDTO buyItemDTO = new BuyItemDTO();

//	private ItemListDAO itemInfoDAO = new ItemListDAO();
	private ArrayList<ItemInfoDTO> itemList = new ArrayList<ItemInfoDTO>();
	private ArrayList<String> genreList= new ArrayList<String>();
	private String selectedGenre = "全て";
	private String search = "";

	public String execute() throws SQLException{
//		genreList.add("文房具");
//		genreList.add("家電");
//		genreList.add("家具");
//		genreList.add("食材");
//		session.put("genreList", genreList);
//		System.out.println(selectedGenre);

		String result = "login";
		if(session.containsKey("login_user_id")){

			itemList = buyItemDAO.getItemInfo(search, selectedGenre);

			session.put("itemList", itemList);

			result = SUCCESS;
		}
		return result;
	}

	public ArrayList<ItemInfoDTO> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<ItemInfoDTO> itemList) {
		this.itemList = itemList;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
	public Map<String, Object> getSession(){
		return this.session;
	}

	public String getSelectedGenre() {
		return selectedGenre;
	}

	public void setSelectedGenre(String selectedGenre) {
		this.selectedGenre = selectedGenre;
	}

	public ArrayList<String> getGenreList() {
		return genreList;
	}

	public void setGenreList(ArrayList<String> genreList) {
		this.genreList = genreList;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

}
