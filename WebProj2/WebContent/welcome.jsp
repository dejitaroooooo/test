<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "s" uri = "/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>

	<body>
		名前とパスワードを入力して下さい
		<s:form method="post" action="LoginAction">
			<s:textfield name="username" lavel="ユーザ名："/>
			<s:password name="password" lavel="パスワード："/>
			<s:submit value="送信"/>
		</s:form>
	</body>

</html>