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
<link rel="stylesheet" type="text/css" href="./css/style-admin.css">

<script>
// import = "com.internousdev.ecsite.dto.ItemInfoDTO";
// ArrayList<ItemInfoDTO> registrationItem = new ArrayList<ItemInfoDTO>();
// ItemInfoDTO dto = new ItemInfoDTO();
</script>


</head>
<body>
	<!-- ヘッダー -->
	<div id="header">
		<div id="pr">
		</div>
	</div>
	<!-- メイン -->
	<div id="main">
		<!-- トップ -->
		<div id="top">
			<p>ItemCreate</p>
		</div>
		<s:if test="errorMassage !=">
			<s:property value="errorMassage" escape="false"/>
		</s:if>


		<!-- 入力フォーム -->
		<table>
			<s:form action="ItemCreateConfirmAction">
				<tr>
					<th>商品名</th>
					<th>価格</th>
					<th>ストック数</th>
				</tr>
				<tr>

					<td><input type="text" name="itemName" value=""/></td>
					<td><input type="text" name="itemPrice" value=""/></td>
					<td><input type="text" name="itemStock" value=""/></td>

<%@ page import = "com.internousdev.ecsite.dto.ItemInfoDTO"%>
<%@ page import = "java.util.ArrayList" %>
<%
ArrayList<ItemInfoDTO> registrationItem = new ArrayList<ItemInfoDTO>();
ItemInfoDTO dto = new ItemInfoDTO();
/*dto.setItemName(itemName);*/
%>



				</tr>
				<s:submit value="登録"/>
			</s:form>
		</table>
		<div>
			<p><a href='<s:url action="ItemCreateFileReadAction"/>'>ファイルを読み込む</a></p>
			<span>前画面に戻る場合は</span>
			<a href='<s:url action="AdminAction"/>'>こちら</a>
		</div>
	</div>
	<!-- フッター -->
	<div id = "footer">
		<div id="pr">
		</div>
	</div>

</body>
</html>