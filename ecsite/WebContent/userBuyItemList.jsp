<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css"/>
<meta http-equiv="Content-Script-Type" content="text/javascript"/>
<meta http-equiv="imagetoolbar" content="no"/>
<meta name="description" content=""/>
<meta name="keywords" content=""/>
<title>UserBuyItemList画面</title>

<link rel="stylesheet" type="text/css" href="./css/style.css">
<link rel="stylesheet" type="text/css" href="./css/style-admin.css">

<script type="text/javascript">
	function deleteCheck(){
		if(confirm("購入履歴を削除します。\nよろしいですか？")){
			alert("削除します");
	    	return true;
	    }
	    else {
	    	return false;
	    }
	}
</script>
</head>
<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>UserBuyItemList</p>
		</div>
		<div>
			<h3>購入履歴一覧</h3>

			<s:form action="UserBuyItemListAction">
				<div id="order">
					<select name="order_column">
						<option value="item_name">商品名</option>
						<option value="item_genre">ジャンル</option>
						<option value="user_master_id">購入者</option>
						<option value="insert_date">購入日</option>
					</select>
					<select name="order_type">
						<option value="DESC">降順</option>
						<option value="ASC">昇順</option>
					</select>
					<s:submit value="並び替え"/>
				</div>
			</s:form>
			<table border="1">
				<tr>
					<th>商品名</th>
					<th>ジャンル</th>
					<th>購入額</th>
					<th>購入数</th>
					<th>購入者</th>
					<th>支払い</th>
					<th>購入日</th>
				</tr>
				<s:iterator value="userBuyItemList">
					<tr>
						<td><s:property value="itemName"/></td>
						<td><s:property value="itemGenre"/></td>
						<td><s:property value="totalPrice"/></td>
						<td><s:property value="totalCount"/></td>
						<td><s:property value="userName"/></td>
						<td><s:property value="payment"/></td>
						<td><s:property value="insert_date"/></td>
					</tr>
				</s:iterator>
			</table>
			<s:form action="UserBuyItemListAction" name="deleteItem" onsubmit="return deleteCheck();">
				<input type="hidden" name="deleteFlg" value="1">
				<s:submit value="削除"/>
			</s:form>
			<div id="text-right">
				<p>管理画面TOPへ戻る場合は<a href='<s:url action="AdminAction"/>'>こちら</a></p>
			</div>
		</div>
	</div>
	<div id="push">
	</div>
	<div id="footer">
		<div id="pr">
		</div>
	</div>
</body>
</html>