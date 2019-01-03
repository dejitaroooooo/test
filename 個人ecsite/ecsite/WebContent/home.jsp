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
<link rel="stylesheet" type="text/css" href="./css/slide.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">

<style type="text/css">
#contents{
 	display:flex;
}
#genre-menue{
	width:20%;
	float:left;
	background-color:yellowgreen;
	padding: 5px;
	border-radius:10px;
}
#right-content{
	width:300px;
	margin: 0 auto;
}
#right-content img{
	width:200px;
	height:100%;
}
#attention{
/* 	backgroundcolor:red; */
}
</style>
</head>
<body>

	<!-- ヘッダー -->
	<jsp:include page="header.jsp"/>

	<!-- メイン -->
	<div id="main">

		<!-- トップ -->
		<div id="top">
			<p>Home</p>
		</div>

		<!-- コンテンツ -->
		<div id="contents">

			<!-- 画面左側 -->
			<!--商品ジャンルメニュー -->
			<div id="genre-menue">
				<h3>ジャンルから探す</h3>
				<ul>
					<li><b><a href='<s:url action="BuyItemAction?selectedGenre=文房具"/>'>文房具</a></b></li>
					<li><b><a href='<s:url action="BuyItemAction?selectedGenre=家具"/>'>家具</a></b></li>
					<li><b><a href='<s:url action="BuyItemAction?selectedGenre=家電"/>'>家電</a></b></li>
					<li><b><a href='<s:url action="BuyItemAction?selectedGenre=食材"/>'>食材</a></b></li>
				</ul>
			</div>

			<!-- 画面右側 -->
			<div id="right-content">
				<!-- 商品一覧ボタン -->
				<s:form action="BuyItemAction">
					<s:submit value="商品一覧を見る" id="onmouse" />
				</s:form>

				<!-- スライドショー -->
				<div class="slideshow">
					<p><b>今月の注目商品!</b></p>
					<input type="radio" name="slideshow" id="switch1" checked>
					<input type="radio" name="slideshow" id="switch2">
					<input type="radio" name="slideshow" id="switch3">
					<input type="radio" name="slideshow" id="switch4">
					<input type="radio" name="slideshow" id="switch5">
					<div class="slideContents">
						<s:iterator value="itemList" begin="1" end="5" status="pageNo">
							<section id="slide<s:property value='%{#pageNo.count}'/>">
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

		<!-- ボトム -->
		<div id="bottom">
			<s:if test="#session.login_user_id != null">
				<p>ログアウトする場合は<a href='<s:url action="LogoutAction"/>'>こちら</a></p>
			</s:if>
			<p>管理者用ページは<a href='<s:url action="AdminAction"/>'>こちら</a></p>
		</div>

	</div>

	<!-- フッター -->
	<jsp:include page="footer.jsp"/>

</body>
</html>

