package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemCompleteAction extends ActionSupport implements SessionAware{
	public Map<String, Object> session;

	public String execute() throws SQLException{
		String result = ERROR;

		/*在庫数を取得*/
		int intStock = Integer.parseInt(session.get("buy_item_Stock").toString());
		/*購入個数を取得*/
		int intCount = Integer.parseInt(session.get("count").toString());
		/*購入後の在庫数を計算*/
		int stockDecrease = intStock - intCount;

		/*在庫数が足りていた(購入後の在庫数が0以上である)場合*/
		if(stockDecrease >= 0){

			/* 商品の購入情報をDBに保存*/
			BuyItemCompleteDAO buyItemCompleteDAO = new BuyItemCompleteDAO();
			buyItemCompleteDAO.buyItemeInfo(
				session.get("buyItem_id").toString(),
				session.get("login_user_id").toString(),
				session.get("total_price").toString(),
				session.get("count").toString(),
				session.get("pay").toString());

			/*DB上の在庫数を購入後の在庫数に変更*/
			BuyItemCompleteDAO StockDecreaseDAO = new BuyItemCompleteDAO();
			StockDecreaseDAO.itemStockDecrease(session.get("buyItem_id").toString(), String.valueOf(stockDecrease));

			result = SUCCESS;
		}

		return result;
	}

	/*以下セッター＆ゲッター*/
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
