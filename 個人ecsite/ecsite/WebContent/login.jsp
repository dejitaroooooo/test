<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css"/>
<meta http-equiv="Content-Script-Type" content="text/javascript">
<meta http-equiv="imagetoolbar" content="no"/>
<meta name="description" content=""/>
<meta name="keywords" content=""/>
<title>Login画面</title>

<link rel="stylesheet" type="text/css" href="./css/style.css">

</head>
<body>

	<!-- ヘッダー -->
	<jsp:include page="header.jsp"/>

	<!-- メイン -->
	<div id="main">

		<!-- トップ -->
		<div id="top">
			<p>Login</p>
		</div>

		<!-- コンテンツ -->
		<div id="contents">
			<h3>商品を購入する際にはログインをお願いします。</h3>

			<!-- メッセージ表示 -->
			<s:if test="checkFlg == 1">
				<h3 style="color:red;"><s:property value="message"/></h3>
			</s:if>

			<!-- 入力フォーム -->
			<s:form action="LoginAction">
				<s:textfield name="loginUserId" placeholder = "ログインID"/>
				<s:password name="loginPassword" placeholder = "パスワード"/>
				<input type="hidden" name="checkFlg" value="1"/>
				<s:submit value="ログイン"/>
			</s:form>

		</div>

		<!-- ボトム -->
		<div id="bottom">
			<p>新規ユーザ登録は<a href='<s:url action="UserCreateAction"/>'>こちら</a></p>
			<p>Homeへ戻る場合は<a href='<s:url action="GoHomeAction"/>'>こちら</a></p>
		</div>

	</div>

	<!-- フッター -->
	<jsp:include page="footer.jsp"/>

</body>
</html>