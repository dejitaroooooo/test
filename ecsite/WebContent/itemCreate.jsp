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
<title>ItemCreate画面</title>

<link rel="stylesheet" type="text/css" href="./css/style.css">

</head>
<body>
	<!-- ヘッダー -->
	<jsp:include page="headerAdmin.jsp"/>

	<!-- メイン -->
	<div id="main">

		<!-- トップ -->
		<div id="top">
			<p>ItemCreate</p>
		</div>

			<!-- エラーメッセージの表示 -->
			<s:if test="errorMessage != ''">
				<h3><font color = "red"><s:property value="errorMessage" escape="false"/></font></h3>
			</s:if>

		<!-- コンテンツ -->
		<div id="contents">
			<!-- 入力フォーム -->
			<s:form action="ItemCreateConfirmAction">
				<table>
					<tr>
						<td>商品名</td>
						<td><input type="text" name="itemName" value=""/></td>
					</tr>
					<tr>
						<td>ジャンル</td>
						<td><select name="itemGenre" style="float:left">
								<option value="文房具">文房具</option>
								<option value="家具">家具</option>
								<option value="家電">家電</option>
								<option value="食材">食材</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>価格</td>
						<td><input type="text" name="itemPrice" value=""/></td>
					</tr>
					<tr>
						<td>ストック数</td>
						<td><input type="text" name="itemStock" value=""/></td>
					</tr>
					<s:submit value="登録"/>
				</table>
			</s:form>
		</div>

		<!-- ボトム -->
		<div id ="bottom">
			<p><a href='<s:url action="ItemCreateFileReadAction"/>'>ファイルを読み込む</a></p>
		</div>

	</div>

	<!-- フッター -->
	<jsp:include page="footer.jsp"/>

</body>
</html>