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

<style type="text/css">
#header{
	width:100%;
	height:60px;
	background-color: lightblue;
	display: -webkit-flex; /*Chrome, Safari用*/
	display:flex;
 	align-items: center;  /*子要素をflexboxにより中央に配置する */

}
	#header #logo{
		margin-right: auto;/*左寄せにする*/
	}
		#header #logo a{
			display: inline-block;
	 		background: url(../img/logoclick.png) center / cover no-repeat; /*背景に画像を設置*/
	 		border-radius:10px;
		}
			#header #logo a img{
			verticl-align: middle;
			transition: opacity 0.3s;
			border-radius:10px;
			}
			#header #logo a:hover img{
				opacity: 0;
			}

	#search{
		margin: auto; /*中央寄せにする*/
	}
		#search #search-select{
			height:30px;
			border:none;
			background-color:aliceblue;
			color:green;
		}
			#search #search-select option{
				color: blue;
			}
		#search #search-text{
			height:30px;
			border:none;
		}
		#search #search-button{
			height:30px;
			border:none;
			background-color:darkseagreen;
			color:#666;
			border-radius:0px 50px 50px 0px;
		}
			#search #search-button:hover{
				color:hotpink;
				cursor:pointer;
			}

	#login{
		width:100px;
		height:40px;
		text-align:center;/*テキストを左右中央寄せ*/
		position:relative;	/*クリック範囲拡大用*/

	}
		#login a{
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
		#login a:hover{
			background:#3cc4bd;
			box-shadow: 0 3px 0 #12978d, 0 6px 0 rgba(0,0,0,.2);
			transform:translateY(3px)
		}
		#login a:active{
			color: #ddd;
			background: #12978d;
			box-shadow: 0 0 0 #047c71, 0 0 0 rgba(0,0,0,.2);
			transform: translateY(6px);
			transition-duration: 0.1s;
		}
</style>

</head>
<body>

	<div id="header">

		<div id="logo">
			<a href='<s:url action="GoHomeAction"/>' ><img src="img/logo.png"/></a>
		</div>

		<div id="search">
			<s:form action="BuyItemAction" >
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