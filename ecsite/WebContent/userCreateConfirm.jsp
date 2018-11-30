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
<title>UserCreateConfirm画面</title>

<link rel="stylesheet" type="text/css" href="./css/style.css">
<script type="text/javascript" src="javascript/script.js">
</script>
</head>
<body>

	<jsp:include page="header.jsp"/>

	<div id="main">

		<div id="top">
			<p>UserCreateConfirm</p>
		</div>

		<div id="contents">
			<h3>以下の内容で登録します<br>よろしいですか？</h3>
			<table>
				<s:form action="UserCreateCompleteAction" name="s">
					<tr id="box">
						<td><label>ログインID：</label></td>
						<td><s:property value="loginUserId" escape="false"/></td>
					</tr>
					<tr id="box">
						<td><label>ログインPASS：</label></td>
						<td><s:property value="loginPassword" escape="false"/></td>
					</tr>
					<tr id="box">
						<td><label>ユーザ名：</label></td>
						<td><s:property value="userName" escape="false"/></td>
					</tr>
					<tr>
						<td><input type="button" value="戻る" onclick="submitAction('UserCreateAction')"/><td>
						<td><input type="button" value="登録" onclick="submitAction('UserCreateCompleteAction')"/><td>
					</tr>
				</s:form>
			</table>
		</div>

	</div>

	<jsp:include page="footer.jsp"/>

</body>
</html>























