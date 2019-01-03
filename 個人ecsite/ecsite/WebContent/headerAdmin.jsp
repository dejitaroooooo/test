<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta http-equiv="Content-Script-Type" content="text/javascript">
<meta http-equiv="imagetoolbar" content="no"/>
<meta name="description" content="">
<meta name="keywords"content="">
<title>管理画面用ヘッダー</title>

<style type="text/css">
#header{
	width:100%;
	height:60px;
	background-color: lightblue;
	text-align: center;
	display:flex;
 	align-items: center;  /*子要素をflexboxにより中央に配置する */
}
	#btn{
		width:100px;
		height:40px;
		text-align:center;/*テキストを左右中央寄せ*/
		position:relative;	/*クリック範囲拡大用*/

	}
		#btn a{
			text-decoration: inherit;/*リンクの下線部を消去*/
			color:black; /*文字の色*/
			background-color: #20b2aa; /*背景色*/
			box-shadow: 0 6px 0 #047c71, 0 12px 0 rgba(0,0,0,.2); /*影を設定*/
			transition: color .3s, background .3s, box-shadow .3s, transform 0.3s;

			/*クリック範囲拡大用*/
			position:absolute;
			top:0;
			right:0;
			bottom:0;
			left:0;

			border-radius:4px; /*角を丸く*/
		}
		#btn a:hover{
			background:#3cc4bd;
			box-shadow: 0 3px 0 #12978d, 0 6px 0 rgba(0,0,0,.2);
			transform:translateY(3px)
		}
		#btn a:active{
			color: #ddd;
			background: #12978d;
			box-shadow: 0 0 0 #047c71, 0 0 0 rgba(0,0,0,.2);
			transform: translateY(6px);
			transition-duration: 0.1s;
		}

#header h1{

		margin-left: auto;
		margin-right: auto;
}

</style>

<script type="text/javascript" src="javascript/script.js">
</script>

</head>
<body>

	<div id="header">
		<div id="btn">
			<a href='<s:url action="AdminAction"/>'><b>管理画面Topへ</b></a>
		</div>
		<h1>管理者用画面</h1>
	</div>

</body>
</html>