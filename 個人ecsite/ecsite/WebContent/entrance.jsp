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
<title>Entrance画面</title>

<link rel="stylesheet" type="text/css" href="./css/style.css">

<style type="text/css">

#menue{
	float:left;
	height:30px;
}
#menue img{
	height:30px;
	width:auto;
}
#menue input{
	height:30px;
}
#menue s:submit{
}


#main{
}

</style>

<script type="text/javascript" src="javascript/script.js">
</script>

</head>
<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>Entrance</p>
		</div>
		<div>
			<p><a href='<s:url action="GoHomeAction"/>'>ようこそ！</a></p>
		</div>
	</div>
	<div id="footer">
		<div id="pr">
		</div>
	</div>
</body>
</html>

