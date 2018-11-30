<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css"/>
<meta http-equiv="Content-Script-Type" content="text/javascript"/>
<meta http-equiv="imagetoolbar" content="no"/>
<meta name="description" content=""/>
<meta name="keywords" content=""/>
<title>UserCreate画面</title>

<link rel="stylesheet" type="text/css" href="./css/style.css">

</head>
<body>

	<!-- ヘッダー -->
	<jsp:include page="header.jsp"/>

	<!-- メイン -->
	<div id="main">

		<!-- トップ -->
		<div id="top">
			<p>UserCreate</p>
		</div>

		<!-- コンテンツ -->
		<div id="contents">

			<!-- メッセージ表示 -->
			<s:if test="errorMessage != ''">
				<h3><font color = "red"><s:property value="errorMessage" escape="false"/></font></h3>
			</s:if>

			<!-- 入力フォーム -->
			<table>
				<s:form action="UserCreateConfirmAction">
					<tr>
						<td><label>ログインID：</label></td>
						<td><input type="text" name="loginUserId" value="" required/></td>
					</tr>
					<tr>
						<td><label>ログインPASS：</label></td>
						<td><input type="password" name="loginPassword" value="" required/></td>
					</tr>
					<tr>
						<td><label>ユーザ名：</label></td>
						<td><input type="text" name="userName" value="" required/></td>
					</tr>
					<s:submit value="登録"/>
				</s:form>
			</table>

			<!-- ボトム -->
			<div id="bottom">
				<span>Login画面に戻る場合は</span>
				<a href='<s:url action="LoginAction"/>'>こちら</a>
			</div>

		</div>

	</div>

	<!-- フッター -->
	<jsp:include page="footer.jsp"/>

</body>
</html>