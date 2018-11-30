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
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<title>UserDeleteConfirm画面</title>

<link rel="stylesheet" type="text/css" href="./css/style.css">

<script type="text/javascript">
	function submitAction(url){
		$('form').attr('action',url);
		$('form').submit();
	}
</script>
</head>
<body>

	<jsp:include page="header.jsp"/>

	<div id="main">
		<div id="top">
			<p>UserDeleteConfirm</p>
		</div>

		<div id="contents">
			<h3>退会すると<s:property value="session.login_user_id"/>に関するデータが全て削除されます。</h3>
			<h3>よろしいですか？</h3>

			<s:form>
					<tr>
						<td><input type="button" value="OK" onclick="submitAction('UserDeleteCompleteAction')"/></td>
						<td><input type="button" value="キャンセル" onclick="submitAction('MyPageAction')"/></td>
					</tr>
			</s:form>

		</div>
	</div>

	<jsp:include page="footer.jsp"/>

</body>
</html>