<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css"/>
<meta http-equiv="Content-Script-Type" content="text/javascript"/>
<meta name="description" content=""/>
<meta name="keywords" content=""/>
<title>BuyItem画面</title>

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
	border: 1px solid black;
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
/* 	height:500px; */
	height:100%;
	text-align:center;
	}
	#push{
	height:50px;
	}
	#footer{
	width:100%;
	height:80px;
	margin-bttom: -50px;
	background-color:black;
	clear:both;
	}
	</style>
</head>
<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>BuyItem</p>
		</div>
		<div>
			<s:iterator value="session.itemList">
				<s:form action="BuyItemAction">
					<input type="hidden" name="id" value="<s:property value="id"/>">
					<table>
						<tr>
							<td>
								<span>商品名</span>
							</td>
							<td>
								<s:property value="itemName"/><br>
								<input type="hidden" name="itemName" value="<s:property value="itemName"/>">
							</td>
						</tr>
						<tr>
							<td>
								<span>値段</span>
							</td>
							<td>
								<s:property value="itemPrice" /><span>円</span>
								<input type="hidden" name="itemPrice" value="<s:property value="itemPrice"/>">
							</td>
						</tr>
						<tr>
							<td>
								<span>購入個数</span>
							</td>
							<td>

<script type="text/css">




</script>

<select name="count">
<%
String StringStock = request.getAttribute("itemStock").toString();
int stock = 100;
for(int i=1;i<=stock;i++){%>
<option value="<%=i%>"><%=i%></option>
<%}%>
</select>


<%-- 								<select name="count" > --%>
<!-- 									<option value="1" selected="selected">1</option> -->
<!-- 									<option value="2">2</option> -->
<!-- 									<option value="3">3</option> -->
<!-- 									<option value="4">4</option> -->
<!-- 									<option value="5">5</option> -->
<%-- 								</select> --%>




							</td>
						</tr>
						<tr>
							<td>
								<span>支払い方法</span>
							</td>
							<td>
								<input type="radio" name="pay" value="1" checked="checked">現金払い
								<input type="radio" name="pay" value="2">クレジットカード
							</td>
						</tr>
						<tr>
							<td>
								<s:submit value="購入"/>
							</td>
						</tr>
					</table>
				</s:form>
			</s:iterator>
			<div>
				<p>前画面に戻る場合は<a href='<s:url action="GoHomeAction"/>'>こちら</a></p>
				<p>マイページは<a href='<s:url action="MyPageAction"/>'>こちら</a></p>
			</div>
		</div>

		<div id = "push">
		</div>

	</div>
	<div id="footer">
		<div id="pr">
		</div>
	</div>

</body>
</html>