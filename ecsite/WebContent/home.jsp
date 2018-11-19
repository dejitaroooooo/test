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
<title>Home画面</title>

<link rel="stylesheet" type="text/css" href="./css/style.css">

<style type="text/css">
#content{;
 	text-align:center;
}

#left-menue{
	float:left;
	background-color:yellowgreen;
	padding: 5px;
	border-radius:10px;
	display:inline;
}
#left-menue ul{
/* 	list-style:none; */
}
#left-menue ul li{
}
#slide{
/*  	float:right; */
	display:inline;
}
#slide img{
	height:10px;
	width:auto;
}
#right-content{
/* 	float:right; */
}

</style>

<!-- スライド関係 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<script>
	$(document).ready(function(){
		$('#slide').bxSlider({
		auto:true,
		mode:'horizontal',
		speed:2000,
		pause:5000,
		slideWidth:100});
	});
</script>


</head>
<body>

	<jsp:include page="header.jsp"/>

	<div id="main">
		<div id="top">
			<p>Home</p>
		</div>

		<div id="content">
			<div id="left-menue">
				<h3>ジャンルから探す</h3>
				<ul>
					<li><b><a href='<s:url action="HomeAction?selectedGenre=文房具"/>'>文房具</a></b></li>
					<li><b><a href='<s:url action="HomeAction?selectedGenre=家具"/>'>家具</a></b></li>
					<li><b><a href='<s:url action="HomeAction?selectedGenre=家電"/>'>家電</a></b></li>
					<li><b><a href='<s:url action="HomeAction?selectedGenre=食材"/>'>食材</a></b></li>
				</ul>
			</div>
			<div id="right-content">
<!-- 				<div id="slide"> -->
<!-- 					<div><img src="img/jQuery_image1.jpg"></div> -->
<!-- 					<div><img src="img/jQuery_image2.jpg"></div> -->
<!-- 					<div><img src="img/jQuery_image3.jpg"></div> -->
<!-- 					<div><img src="img/jQuery_image4.jpg"></div> -->
<!-- 					<div><img src="img/jQuery_image5.jpg"></div> -->
<!-- 				</div> -->
			</div>
		</div>

		<div id="text-center">
			<s:form action="HomeAction">
				<s:submit value="商品購入" id="onmouse" />
			</s:form>
			<s:if test="#session.login_user_id != null">
				<p>ログアウトする場合は<a href='<s:url action="LogoutAction"/>'>こちら</a></p>
			</s:if>
			<p>管理者用ページは<a href='<s:url action="AdminAction"/>'>こちら</a></p>
		</div>
	</div>

	<jsp:include page="footer.jsp"/>

</body>
</html>

