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
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<title>UserListDeleteConfirm画面</title>

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
			<p>UserListDeleteConfirm画面</p>
		</div>

		<!-- コンテンツ -->
		<div id="contents">
			<!-- 確認フォーム -->
			<h3>すべてのユーザを削除します。よろしいですか？</h3>
			<table>
				<s:form>
					<tr>
						<td><input type="button" value="OK" onclick="submitAction('UserListDeleteCompleteAction')"/></td>
						<td><input type="button" value="キャンセル" onclick="submitAction('UserListAction')"/></td>
					</tr>
				</s:form>
			</table>
		</div>

	</div>

	<!-- フッター -->
	<jsp:include page="footer.jsp"/>

</body>
</html>