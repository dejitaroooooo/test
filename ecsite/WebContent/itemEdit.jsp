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
<title>ItemEdit画面</title>

<link rel="stylesheet" type="text/css" href="./css/style.css">
<link rel="stylesheet" type="text/css" href="./css/style-admin.css">

<script type="text/javascript">
// 	function delete(index){
// 		vor form = document.forms[0];
// 		form.editItemName.value = form.itemName[index].value;
// 		form.editItemPrice.value = form.itemPrice[index].value;
// 		form.editItemStock.value = form.itemStock[index].value;
// 		if( !(confirm(form.editName.value+"タグを編集しますか？"))){
// 			return;
// 		}
// 	}
</script>

</head>
<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>ItemEdit</p>
		</div>
		<div>
			<h3>商品一覧</h3>
			<s:form action="ItemEditAction">
			<table border="1">
				<tr>
					<th>商品名</th>
					<th>価格</th>
					<th>ストック数</th>
					<th>登録日</th>
					<th>編集</th>
					<th>削除</th>
				</tr>
				<s:iterator value="itemList" status="st">
					<tr>
						<td><s:property value="itemName"/></td>
						<td><s:property value="itemPrice"/></td>
						<td><s:property value="itemStock"/></td>
<%-- 						<td><s:textfield style="display: inline" name="itemName"/><s:hidden name="tagId"/></td> --%>
<%-- 						<td><s:textfield name="itemPrice"/></td> --%>
<%-- 						<td><s:textfield name="itemStock"/></td> --%>
<%-- 						<td><s:property value="insertDate"/></td> --%>
<%-- 						<td><input type="button" value="編集" name="btnDel" onclick="edittag('<s:property value="#st.index" />')"/></td> --%>
<%-- 						<td><input type="button" value="削除" name="btnDel" onclick="deletetag('<s:property value="#st.index" />')"/></td> --%>
					</tr>
				</s:iterator>
			</table>

<%-- 			<s:hidden name="editItemName"/> --%>
<%-- 			<s:hidden name="editItemPrice"/> --%>
<%-- 			<s:hidden name="editItemStock"/> --%>

			</s:form>
			<s:form action="ItemListDeleteConfirmAction">
				<s:submit value="削除"/>
			</s:form>
			<div id="text-right">
				<p>管理者画面TOPへ戻る場合は<a href='<s:url action="AdminAction"/>'>こちら</a></p>
			</div>
		</div>
	</div>
	<div id="footer">
		<div id="pr">
		</div>
	</div>


</body>
</html>