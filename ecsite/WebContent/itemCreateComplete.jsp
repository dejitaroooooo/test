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
<meta name="keyword" content=""/>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<title>ItemCreateComplete画面</title>

<link rel="stylesheet" type="text/css" href="./css/style.css">
<link rel="stylesheet" type="text/css" href="./css/style-admin.css">

<script type="text/javascript">
	function submitAction(url){
		$('form').attr('action',url);
		$('form').submit();
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
			<p>ItemCreateComplete</p>
		</div>
		<div>
			<h3>商品の登録が完了致しました。</h3>
			<h3>さらに追加しますか？</h3>

				<s:form>
					<td><input type="button" value="はい" onclick="submitAction('ItemCreateAction')"/></td>
					<td><input type="button" value="いいえ" onclick="submitAction('AdminAction')"/></td>
				</s:form>


			<div>
				<a href='<s:url action="ItemListAction"/>'>商品リスト</a>
			</div>
		</div>
	</div>
	<div id="footer">
		<div id="pr">
		</div>
	</div>
</body>
</html>