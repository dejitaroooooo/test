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
<meta name="keyword" content=""/>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<title>ItemCreateComplete画面</title>

<link rel="stylesheet" type="text/css" href="./css/style.css">
<script type="text/javascript" src="javascript/script.js">
</script>

</head>
<body>
	<!-- ヘッダー -->
	<jsp:include page="headerAdmin.jsp"/>

	<!-- メイン -->
	<div id="main">
		<!-- トップ -->
		<div id="top">
			<p>ItemCreateComplete</p>
		</div>

		<!-- コンテンツ -->
		<div id="contents">
			<h3>商品の登録が完了致しました。<br>さらに追加しますか？</h3>

				<s:form name="s">
					<td><input type="button" value="はい" onclick="submitAction('ItemCreateAction')"/></td>
					<td><input type="button" value="いいえ" onclick="submitAction('AdminAction')"/></td>
				</s:form>

			<!-- ボトム -->
			<div id="bottom">
				商品リストの確認は
				<a href='<s:url action="ItemListAction"/>'>こちら</a>
			</div>
		</div>

	</div>

	<!-- フッター -->
	<jsp:include page="footer.jsp"/>
</body>
</html>