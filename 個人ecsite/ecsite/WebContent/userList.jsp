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
<title>UserList画面</title>

<link rel="stylesheet" type="text/css" href="./css/style.css">

</head>
<body>

	<!-- ヘッダー -->
	<jsp:include page="headerAdmin.jsp"/>

	<!-- メイン -->
	<div id="main">

		<!-- トップ -->
		<div id="top">
			<p>UserList</p>
		</div>

		<!-- コンテンツ -->
		<div id="contents">

			<!-- ユーザリスト -->
			<h3>ユーザ一覧</h3>
			<table border="1">
				<tr>
					<th>ログインID</th>
					<th>パスワード</th>
					<th>ユーザ名</th>
					<th>登録日</th>
				</tr>
				<s:iterator value="userList">
					<tr>
						<td><s:property value="loginId"/></td>
						<td><s:property value="loginPass"/></td>
						<td><s:property value="userName"/></td>
						<td><s:property value="insert_date"/></td>
					</tr>
				</s:iterator>
			</table>
			<!-- ユーザ全削除 -->
			<s:form action="UserListDeleteConfirmAction">
				<s:submit value="削除"/>
			</s:form>
		</div>

		<!--ボトム -->
		<div id="bottom">
		</div>

	</div>

	<!-- フッター -->
	<jsp:include page="footer.jsp"/>

</body>
</html>