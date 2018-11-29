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
<title>Home画面</title>

<link rel="stylesheet" type="text/css" href="./css/style.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">

<style type="text/css">
#content{
 	text-align:center;
 	display:flex;
}

#left-menue{
width:20%;
	float:left;
	background-color:yellowgreen;
	padding: 5px;
	border-radius:10px;
	z-index:10;
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
/*  	float:left; */
/* 	width:80%; */
	width:300px;
/* 	margin-left: 0 auto; */
/* 	margin-right: 0 auto; */
	margin: 0 auto;
}
#right-content img{
	width:200px;
	height:100%;
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
<div class="slideshow">
	<input type="radio" name="slideshow" id="switch1" checked>
	<input type="radio" name="slideshow" id="switch2">
	<input type="radio" name="slideshow" id="switch3">
	<input type="radio" name="slideshow" id="switch4">
	<input type="radio" name="slideshow" id="switch5">
	<div class="slideContents">

		<s:iterator value="itemList" begin="1" end="5" status="pageNo">
			<section id="slide<s:property value='%{#pageNo.count}'/>">
<%-- 				<img src="img/jQuery_image<s:property value='%{#pageNo.count}'/>.jpg"> --%>
				<img src="img/item/<s:property value="itemName"/>.png">
			</section>
		</s:iterator>
	</div>

	<p class="arrow prev">
		<i class="ico"></i>
		<label for="switch1"></label>
		<label for="switch2"></label>
		<label for="switch3"></label>
		<label for="switch4"></label>
		<label for="switch5"></label>
	</p>
	<p class="arrow next">
		<i class="ico"></i>
		<label for="switch1"></label>
		<label for="switch2"></label>
		<label for="switch3"></label>
		<label for="switch4"></label>
		<label for="switch5"></label>
	</p>
</div>
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

