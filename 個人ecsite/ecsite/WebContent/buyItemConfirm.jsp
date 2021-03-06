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
<title>BuyItemConfirm画面</title>

<link rel="stylesheet" type="text/css" href="./css/style.css">

<script type="text/javascript" src="javascript/script.js">
</script>

</head>
<body>

	<!-- ヘッダー -->
	<jsp:include page="header.jsp"/>

	<!-- メイン -->
	<div id="main">

		<!-- トップ -->
		<div id="top">
			<p>BuyItemConfirm</p>
		</div>

		<!-- コンテンツ -->
		<div id="contents">
			<!-- 確認フォーム -->
			<p><b>以下の商品を購入します<br>よろしいですか？</b></p>
			<s:form name="s">
				<tr>
					<td>商品名</td>
					<td><s:property value="session.buyItem_name"/></td>
				</tr>
				<tr>
					<td>価格</td>
					<td><s:property value="session.total_price"/><span>円</span></td>
				</tr>
				<tr>
					<td>購入個数</td>
					<td><s:property value="session.count"/><span>個</span></td>
				</tr>
				<tr>
					<td>支払い方法</td>
					<td><s:property value="session.pay"/></td>
				</tr>
				<tr>
					<td><input type="button" value="戻る" onclick="submitAction('BuyItemAction')"/><td>
					<td><input type="button" value="購入" onclick="submitAction('BuyItemCompleteAction')"/><td>
				</tr>
			</s:form>
		</div>

	</div>

	<!-- フッター -->
	<jsp:include page="footer.jsp"/>

</body>
</html>