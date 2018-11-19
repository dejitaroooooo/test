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
<title>OneItemEdit画面</title>

<link rel="stylesheet" type="text/css" href="./css/style.css">
<link rel="stylesheet" type="text/css" href="./css/style-admin.css">

</head>
<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>OneItemEdit</p>
		</div>
		<div>
			<h3>商品情報の編集</h3>
			<s:form action="OneItemEditCompleteAction">
			<table>
				<tr>
					<td>
						<label>商品名</label>
					</td>
					<td>
						<s:property value="itemName"/>
					</td>
				</tr>
				<tr>
					<td>
						<label>価格</label>
					</td>
					<td>
						<input type="text" name="editItemPrice" placeholder="<s:property value="itemPrice"/>">
					</td>
				</tr>
				<tr>
					<td>
						<label>ストック数</label>
					</td>
					<td>
						<input type="text" name="editItemStock" placeholder="<s:property value="itemStock"/>">
					</td>
				</tr>
				<s:submit value="変更"/>
			</table>
			</s:form>
			<div id="text-right">
				<p>やめる場合は<a href='<s:url action="ItemListAction"/>'>こちら</a></p>
			</div>
		</div>
	</div>
	<div id="footer">
		<div id="pr">
		</div>
	</div>


</body>
</html>