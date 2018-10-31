package com.internousdev.webproj3.action;

import com.internousdev.webproj3.dao.HelloStrutsDAO;
import com.internousdev.webproj3.dto.HelloStrutsDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HelloStrutsAction extends ActionSupport{

	/*結果を格納するための変数*/
	private String result;

	/**/
	public String execute(){

		String ret = ERROR;

		/*DAOクラスを呼び出すためのインスタンス化*/
		HelloStrutsDAO dao = new HelloStrutsDAO();
		/*DTO箱を使うためのインスタンス化*/
		HelloStrutsDTO dto = new HelloStrutsDTO();

		/*DAOクラスの selectメソッドを実行し、DBに接続。その結果をdto箱に格納？？*/
		dto = dao.select();

		/*dto箱の中身をweb上に出力*/
		System.out.println(dto.getResult());

		/*dto箱の中身をresultに格納*/
		result = dto.getResult();

		/*resultの中身によって以下を処理*/
		/*(接続できたかどうかをretで表現)*/
		if(result.equals("MySQLと接続できます。")){
			ret = SUCCESS;
		}
		else{
			ret = ERROR;
		}

		/*結果(接続できたかどうか)を出力*/
		return ret;
	}

	public String getResult(){
		return result;
	}
	public void setResult(String result){
		this.result = result;
	}

}
