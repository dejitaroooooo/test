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
<title>UserDelete画面</title>

<link rel="stylesheet" type="text/css" href="./css/style.css">

</head>
<body>

	<jsp:include page="header.jsp"/>

	<div id="main">
		<div id="top">
			<p>UserDelete</p>
		</div>

		<div id="contents">

			<s:form action="UserDeleteConfirmAction">
				<h3>パスワードを入力してください</h3>
				<s:if test="errorMessage != ''">
					<h3><font color = "red"><s:property value="errorMessage" escape="false"/></font></h3>
				</s:if>

				<table>
					<tr>
						<td>ID:</td>
						<td><s:property value="session.login_user_id"/></td>
					</tr>
					<tr>
						<td>PASS:</td>
						<td><input type="text" name="loginPass"/></td>
					</tr>
					<s:submit value="送信"/>
				</table>
			</s:form>

			<div id="bottomt">
				<p>MyPageへ戻る場合は<a href='<s:url action="MyPageAction"/>'>こちら</a><p>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp"/>

</body>
</html>