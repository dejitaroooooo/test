package com.internousdev.ecsite.dto;

public class AnalysisDTO {
	private String id;
	private String itemName;
	private String itemGenre;
	private int totalItemCount;

//	public String id;
//	public String itemName;
//	public String itemGenre;
//	public int totalItemCount;


	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemGenre() {
		return itemGenre;
	}
	public void setItemGenre(String itemGenre) {
		this.itemGenre = itemGenre;
	}
	public int getTotalItemCount() {
		return totalItemCount;
	}
	public void setTotalItemCount(int totalItemCount) {
		this.totalItemCount = totalItemCount;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
