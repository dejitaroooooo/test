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
<link rel="stylesheet" type="text/css" href="./css/style-admin.css">

</head>
<body>
	<!-- ヘッダー -->
	<div id="header">
		<div id="pr">
		</div>
	</div>
	<!-- メイン -->
	<div id="main">
		<div id="top">
			<p>ItemCreateConfirm</p>
		</div>
		<div>
			<h3>登録する内容は以下でよろしいですか？</h3>
			<table>
				<s:form action="ItemCreateCompleteAction">
					<tr id="box">
						<td>
							<label>商品名：</label>
						</td>
						<td>
							<s:property value="itemName" escape="false"/>
						</td>
					</tr>
					<tr id="box">
						<td>
							<label>価格：</label>
						</td>
						<td>
							<s:property value="itemPrice" escape="false"/>
						</td>
						<td>
							<label>円</label>
						</td>
					</tr>
					<tr id="box">
						<td>
							<label>ストック数：</label>
						</td>
						<td>
							<s:property value="itemStock" escape="false"/>
						</td>
						<td>
							<label>個</label>
						</td>
					</tr>
					<tr>
						<td>
							<s:submit value="完了"/>
						</td>
					</tr>
				</s:form>
			</table>
		</div>
	</div>
	<!-- フッター -->
	<div id="footer">
		<div id="pr">
		</div>
	</div>

</body>
</html>