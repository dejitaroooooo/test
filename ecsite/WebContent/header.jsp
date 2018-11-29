<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css"/>
<meta http-equiv="Content-Script-Type" content="text/javascript"/>
<meta http-equiv="imagetoolbar" content="no"/>
<meta name="description" content=""/>
<meta name="keywords" content=""/>
<title>ヘッダー</title>

<!-- Font Awesome -->
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" />

</head>
<body>

	<div id="header">

		<div id="logo">
			<a href='<s:url action="GoHomeAction"/>' ><img src="img/logo.png"/></a>
		</div>

		<div id="search">
			<s:form action="HomeAction" >
				<select name="selectedGenre" id="search-select">
					<option value="全て">(ジャンル選択)</option>
					<option value="全て">全て</option>
					<option value="文房具">文房具</option>
					<option value="家具">家具</option>
					<option value="家電">家電</option>
					<option value="食材">食材</option>
				</select>
				<input type="text" name="search" placeholder="フリーワードを入力" id="search-text"/>
				<button type="submit" id="search-button"><i class="fa fa-search">検索</i></button>
			</s:form>
		</div>

		<div id="login">
			<%if(session.getAttribute("login_user_id") == null){
				%><a href='<s:url action="LoginAction"/>'><b>ログイン</b></a><%
			}
			else if(session.getAttribute("login_user_id").equals("internous")){
				%><a href='<s:url action="AdminAction"/>'><b>管理者</b></a><%
			}
			else{
				%><a href='<s:url action="MyPageAction"/>' ><b>ようこそ<br><%=session.getAttribute("login_user_id")%> さん</b></a><%
			}%>
		</div>

	</div>

</body>
</html>