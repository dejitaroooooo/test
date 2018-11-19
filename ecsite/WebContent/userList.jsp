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
<link rel="stylesheet" type="text/css" href="./css/style-admin.css">

</head>
<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>UserList</p>
		</div>
		<div>
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
			<s:form action="UserListDeleteConfirmAction">
				<s:submit value="削除"/>
			</s:form>
			<div id="text-right">
				<p>管理画面TOPへ戻る場合は<a href='<s:url action="AdminAction"/>'>こちら</a></p>
			</div>
		</div>
	</div>
	<div id="footer">
		<div id="pr">
		</div>
	</div>
</body>
</html>