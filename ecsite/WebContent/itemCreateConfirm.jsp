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
<title>ItemCreateConfirm画面</title>

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
			<p>ItemCreateConfirm</p>
		</div>

		<!-- コンテンツ -->
		<div id="contents">
			<h3>以下の内容で登録登録します。<br>よろしいですか？</h3>
			<table>
				<!-- 確認フォーム -->
				<s:form action="ItemCreateCompleteAction" name="s">
					<tr>
						<td><label>商品名：</label></td>
						<td><s:property value="itemName" escape="false"/></td>
					</tr>
					<tr>
						<td><label>価格：</label></td>
						<td><s:property value="itemPrice" escape="false"/></td>
						<td><label>円</label></td>
					</tr>
					<tr>
						<td><label>ストック数：</label></td>
						<td><s:property value="itemStock" escape="false"/></td>
						<td><label>個</label></td>
					</tr>
					<tr>
						<td><input type="button" value="戻る" onclick="submitAction('ItemCreateAction')"/><td>
						<td><input type="button" value="登録" onclick="submitAction('ItemCreateCompleteAction')"/><td>
					</tr>
				</s:form>
			</table>
		</div>

	</div>

	<!-- フッター -->
	<jsp:include page="footer.jsp"/>

</body>
</html>