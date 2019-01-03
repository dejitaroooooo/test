<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta http-equiv="Content-Script-Type" content="text/javascript">
<meta http-equiv="imagetoolbar" content="no">
<meta name="description" content="">
<meta name="keywords" content="">
<title>ItemCreateFileReadComplete画面</title>

<link rel="stylesheet" type="text/css" href="./css/style.css">

</head>
<body>

	<!-- ヘッダー -->
	<jsp:include page="headerAdmin.jsp"/>

	<!-- メイン -->
	<div id="main">

		<!-- トップ -->
		<div id="top">
			<p>ItemCreateFileReadComplete</p>
		</div>

		<!-- コンテンツ -->
		<div id="contents">
			<p>商品リストに追加しました。</p>
		<!-- ボトム -->
		<div id="bottom">
			<p><a href='<s:url action="AdminAction"/>'>管理画面TOPへ</a></p>
		</div>
		</div>

		<!-- ボトム -->
		<div id="bottom">
			商品リストの確認は<a href='<s:url action="ItemListAction"/>'>こちら</a>
		</div>

	</div>

	<!-- フッター -->
	<jsp:include page="footer.jsp"/>

</body>
</html>