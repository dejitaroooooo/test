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

<style type="text/css">
/* TAG LAYOUT */
	body{
		margin:0;
		padding:0;
		line-height:1.6;
		letter-spacing:1px;
		font-family:Verdana, Helvetica, sans-serif;
		font-size:12px;
		color:#333;
		background:#fff;
	}
	table{
		text-align:center;
		margin:0 auto;
	}
/* 	ID LAYOUT */
	#top{
		width:780px;
		margin:30px auto;
		border:1px solid #333;
	}
	#header{
		width:100%;
		height:80px;
		background-color:black;
	}
	#main{
		width:100%;
		height:500px;
		text-align:center;
	}
	#footer{
		width:100%;
		height:80px;
		background-color:black;
		clear:both;
	}
	#text-right{
		display:inline-block;
		text-align:right;
	}
</style>
<script type="text/javascript">
	function deleteCheck(){
//		String name = request.getAttribute("itemName").toString();
//		var name = document.getElementById("tmp_value").value;
//		String name = getElementById('itemName').value;
//	    if( confirm( "次の商品を削除します。\nよろしいですか？\n[" + name + "]") ) {
		if(confirm("商品を削除します。\nよろしいですか？")){
			alert("削除します");
//	    	document.deleteItem.submit();
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
						<th>価格</th>
						<th>ストック数</th>
						<th>登録日</th>
						<th>編集</th>
						<th>削除</th>
					</tr>
					<s:iterator value="itemList">
						<tr>
							<td><s:property value="itemName"/></td>
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
								<s:form action="ItemListAction" name="deleteItem" onsubmit="return deleteCheck();">
<!-- 								<form name="deleteItem"> -->
									<input type="hidden" name="id" value="<s:property value="id"/>"/>
									<input type="hidden" name="itemName" value="<s:property value="itemName"/>"/>
<%-- 									<input type="hidden" name="itemPrice" value="<s:property value="itemPrice"/>"/> --%>
<%-- 									<input type="hidden" name="itemStock" value="<s:property value="itemStock"/>"/> --%>
									<input type="hidden" name="deleteFlg" value="1">
									<input type="submit" value="削除" >
<%-- 									<s:submit value="削除"/> --%>
<!-- 								</form> -->
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