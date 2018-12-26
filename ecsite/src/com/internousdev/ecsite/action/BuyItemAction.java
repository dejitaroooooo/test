package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.internousdev.ecsite.dto.PaginationDTO;
import com.internousdev.ecsite.util.Pagination;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware{
	public Map<String, Object> session;
	private ArrayList<ItemInfoDTO> itemList = new ArrayList<ItemInfoDTO>();
	private ArrayList<String> genreList= new ArrayList<String>();
	private String selectedGenre = "全て";
	private String search = "";
	private List<ItemInfoDTO> itemInfoDtoList;
	private String pageNo;

	public String execute() throws SQLException{
		String result = "login";

		/*ログインしている場合*/
		if(session.containsKey("login_user_id")){

			/*商品情報を取得*/
			BuyItemDAO buyItemDAO = new BuyItemDAO();
			itemList = buyItemDAO.getItemInfo(search, selectedGenre);
			session.put("itemList", itemList);

			//ページネーションに関する情報を取得する
			Pagination pagination = new Pagination();
			PaginationDTO paginationDTO = new PaginationDTO();
			if(pageNo==null){
				paginationDTO = pagination.initialize(itemList, 9);
			}
			else{
				paginationDTO = pagination.getPage(itemList, 9, pageNo);
			}

			/*ページネーション用の情報をセッションに保存*/
			session.put("itemInfoDtoList", paginationDTO.getCurrentItemInfoPage());
			session.put("totalPageSize", paginationDTO.getTotalPageSize());
			session.put("currentPageNo", paginationDTO.getCurrentPageNo());
			session.put("totalRecordSize", paginationDTO.getTotalPageSize());
			session.put("startRecordNo", paginationDTO.getStartRecordNo());
			session.put("endRecordNo", paginationDTO.getEndRecordNo());
			session.put("pageNumberList", paginationDTO.getPageNumberList());
			session.put("productInfoDtoList", paginationDTO.getCurrentItemInfoPage());
			session.put("hasNextPage", paginationDTO.isHasNextPage());
			session.put("hasPreviousPage", paginationDTO.isHasPreviousPage());
			session.put("nextPageNo", paginationDTO.getNextPageNo());
			session.put("previousPageNo", paginationDTO.getPreviousPageNo());

			result = SUCCESS;
		}

		return result;
	}

	/*以下セッター＆ゲッター*/
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

	public List<ItemInfoDTO> getItemInfoDtoList() {
		return itemInfoDtoList;
	}

	public void setItemInfoDtoList(List<ItemInfoDTO> itemInfoDtoList) {
		this.itemInfoDtoList = itemInfoDtoList;
	}

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

}
