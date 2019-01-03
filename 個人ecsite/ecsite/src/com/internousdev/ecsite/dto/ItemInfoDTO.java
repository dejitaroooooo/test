package com.internousdev.ecsite.dto;

public class ItemInfoDTO {
	public String id;
	public String itemName;
	public String itemGenre;
	public String itemPrice;
	public String itemStock;
	public String insertDate;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getItemStock() {
		return itemStock;
	}
	public void setItemStock(String itemStock) {
		this.itemStock = itemStock;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	public String getItemGenre() {
		return itemGenre;
	}
	public void setItemGenre(String itemGenre) {
		this.itemGenre = itemGenre;
	}

}
