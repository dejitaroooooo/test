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

<link rel="stylesheet" type="text/css" href="./css/style.css">


<style type="text/css">
	#table{
	display:flex;
	flex-direction:row;
	margin:10px;
	}

	#content{
		text-align: center;
	}
	#bottom{
		clear:both;
	}
	img{
		width: 50px;
		height:50px;
		border:1px solid black;
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
		<div id="content">
			<s:form action="HomeAction">
				<table>
					<tr>
						<td>
							ジャンル：
						</td>
						<td>
							<select name="selectedGenre">
								<option value="全て">全て</option>
								<option value="文房具">文房具</option>
								<option value="家具">家具</option>
								<option value="家電">家電</option>
								<option value="食材">食材</option>
							</select>
						</td>
						<td>
							<input type="submit" value="検索"/>
						</td>
					</tr>
				</table>
			</s:form>

			<h3>商品リスト(ジャンル：<s:property value="selectedGenre"/>)</h3>

			<s:iterator value="session.itemList">
				<s:form action="BuyItemAction">
					<input type="hidden" name="id" value="<s:property value="id"/>">
<%-- 					<s:if test='itemGenre == "<s:property value="selectedGenre"/>"'> --%>
						<table border="1" style="float:left;">
							<tr>
								<td>
								</td>
								<td>
									<img src="img/item/<s:property value="itemName"/>.png">
								</td>
							</tr>
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
									<select name="count">
									<%
									String StringStock = request.getAttribute("itemStock").toString();
									int stock = Integer.parseInt(StringStock);
									for(int i=1;i<=stock;i++){%>
									<option value="<%=i%>"><%=i%></option>
									<%}%>
									</select>
									<input type="hidden" name="itemStock" value="<s:property value="itemStock"/>">
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
<%-- 					</s:if> --%>
				</s:form>
			</s:iterator>
			<div id= "bottom">
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