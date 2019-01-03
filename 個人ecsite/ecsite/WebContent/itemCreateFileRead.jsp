<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta http-equiv="Content-Script-Type" content="text/javascript">
<meta http-equiv="imagetoolbar" content="no"/>
<meta name="description" content="">
<meta name="keywords"content="">
<title>ItemCreateFileRead画面</title>

<link rel="stylesheet" type="text/css" href="./css/style.css">

<script type="text/javascript" src="javascript/script.js">
</script>

</head>
<body>
	<!-- ヘッダー -->
	<jsp:include page="headerAdmin.jsp"/>
	<div id="main">

		<!-- トップ -->
		<div id="top">
			<h3>ItemCreateFileRead</h3>
		</div>

		<!-- コンテンツ -->
		<div id="contents">

			<!-- 確認フォーム -->
			<h3>以下の商品を登録します<br>よろしいですか？</h3>
			<p>読み込むファイル：<s:property value="filename"/></p>
			<p>(ファイルパス：WebContent/file/ItemList.xlsx)</p>
			<s:form action="ItemCreateFileReadCompleteAction"  name="s">
				<table>
					<tr>
						<td><input type="button" value="はい" onclick="submitAction('ItemCreateFileReadCompleteAction')"/></td>
						<td><input type="button" value="キャンセル" onclick="submitAction('ItemCreateAction')"/></td>
					</tr>
				</table>
			</s:form>

			<!-- 商品リスト -->
			<table border="1">
				<tr>
					<th>商品名</th>
					<th>ジャンル</th>
					<th>価格</th>
					<th>ストック数</th>
				</tr>
				<s:iterator value="itemList">
					<tr>
						<td><s:property value="itemName"/></td>
						<td><s:property value="genre"/></td>
						<td><s:property value="price"/><span>円</span></td>
						<td><s:property value="stock"/><span>個</span></td>
					</tr>
				</s:iterator>
			</table>
		</div>

	</div>

	<!-- フッター -->
	<jsp:include page="footer.jsp"/>

</body>

</html>