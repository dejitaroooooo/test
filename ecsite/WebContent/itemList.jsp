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
<title>ItemList画面</title>

<link rel="stylesheet" type="text/css" href="./css/style.css">
<link rel="stylesheet" type="text/css" href="./css/style-admin.css">

<style type="text/css">

img{
	height:20px;
	width:auto;
}

</style>

<script type="text/javascript">
	function deleteCheck(itemName){
// 		https://www.ipentec.com/document/javascript-get-textbox-value
<%-- var hoge = '<%=request.getAttribute("item")%>'; --%>
var hoge = document.forms.deleteItem.item.value;

		if(confirm("[" + hoge + "]を削除します。\nよろしいですか？")){
			alert("削除します");
	    	return true;
	    }
	    else {
	    	return false;
	    }
	}
</script>
</head>
<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>ItemList</p>
		</div>
		<div>
			<s:if test="ret == -1">
				<h3><font color="red"><s:property value="message"/></font></h3>
			</s:if>
			<s:elseif test="ret == 1">
				<h3><s:property value="message"/></h3>
			</s:elseif>

			<h3>商品一覧</h3>
				<table border="1">
					<tr>
						<th>商品名</th>
						<th>画像</th>
						<th>ジャンル</th>
						<th>価格</th>
						<th>ストック数</th>
						<th>登録日</th>
						<th>編集</th>
						<th>削除</th>
					</tr>
					<s:iterator value="itemList">
						<tr>
							<td><s:property value="itemName"/></td>
							<td><img src="img/item/<s:property value="itemName"/>.png"></td>
							<td><s:property value="itemGenre"/></td>
							<td><s:property value="itemPrice"/><span>円</span></td>
							<td><s:property value="itemStock"/><span>個</span></td>
							<td><s:property value="insertDate"/></td>
							<td>
								<s:form action="OneItemEditAction">
									<input type="hidden" name="id" value="<s:property value="id"/>"/>
									<input type="hidden" name="itemName" value="<s:property value="itemName"/>"/>
									<input type="hidden" name="itemPrice" value="<s:property value="itemPrice"/>"/>
									<input type="hidden" name="itemStock" value="<s:property value="itemStock"/>"/>
									<s:submit value="編集"/>
								</s:form>
							</td>
							<td>
								<s:form action="ItemListAction" name="deleteItem" indexId="idx">
									<input type="hidden" name="id" value="<s:property value="id"/>"/>
									<input type="hidden" name="item" id="id_item" value="<s:property value="itemName"/>"/>
									<input type="hidden" name="deleteFlg" value="1">
									<input type="submit" value="削除" onClick="return deleteCheck();">
								</s:form>
							</td>
						</tr>
					</s:iterator>
				</table>
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