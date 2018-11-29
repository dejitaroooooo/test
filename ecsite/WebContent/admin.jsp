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
<title>Admin画面</title>

<link rel="stylesheet" type="text/css" href="./css/style.css">
<link rel="stylesheet" type="text/css" href="./css/style-admin.css">

<style type="text/css">
	#content-box{
		display:inline-block;
		text-align:center;
	}
	#content{
		border:1px solid black;
		display:inline-block;
	}

</style>

</head>
<body>
	<!-- ヘッダー -->
	<div id="header">
		<div id="top">
		</div>
	</div>
	<!-- メイン -->
	<div id="main">
		<div id="top">
			<p>Admin</p>
		</div>
		<div id="content-box">
			<!-- 商品関係 -->
			<div id="content">
				<p>商品</p>
				<s:form action="ItemCreateAction">
					<s:submit value="新規登録"/>
				</s:form>
				<s:form action="ItemListAction">
					<s:submit value="一覧"/>
				</s:form>
			</div>
			<!-- ユーザ -->
			<div id="content">
				<p>ユーザ</p>
				<s:form action="UserCreateAction">
					<s:submit value="新規登録"/>
				</s:form>
				<s:form action="UserListAction">
					<s:submit value="一覧"/>
				</s:form>
			</div>
			<div id="content">
				<p>購入状況</p>
				<s:form action="UserBuyItemListAction">
					<s:submit value="一覧"/>
				</s:form>
			</div>

			<div id="under">
				<p>Homeへ戻る場合は<a href='<s:url action="GoHomeAction"/>'>こちら</a></p>
			</div>
		</div>
	</div>

	<!-- フッター -->
	<div id="footer">
		<div id="pr">
		</div>
	</div>
</body>
</html>