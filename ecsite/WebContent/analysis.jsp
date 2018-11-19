<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta http-equiv="Content-Script-Type" content="text/javascript">
<meta http-equiv="imagetoolbar" content="no">
<meta name="desctiption" content="">
<meta name="keywords" content="">
<title>Analysis画面</title>

<link rel="stylesheet" type="text/css" href="./css/style.css">
<link rel="stylesheet" type="text/css" href="./css/style-admin.css">

<script src="https://www.gstatic.com/charts/loader.js"></script>

<style type="text/css">
img{
	height:20px;
	width:auto;
}
</style>
<%@ page import = "com.internousdev.ecsite.dto.AnalysisDTO" %>
<script>
//必要なパッケージの読み込み
google.charts.load('current', {packages: ['corechart']});
google.charts.setOnLoadCallback(drawChart);

function drawChart() {
  //オプション設定
  var options = {
    'title': 'サンプルチャート',
    'width': window.innerWidth,
    'height': window.innerHeight
  };

  //月別データ
  var data = google.visualization.arrayToDataTable([
    ['月', '数量'],
    ['１月', 65],
    ['２月', 59],
    ['３月', 80],
    ['４月', 81],
    ['５月', 56],
    ['６月', 55],
    ['７月', 48]
  ]);

  var stage = document.getElementById('stage');

  //グラフの種類を設定
  var chart = new google.visualization.ColumnChart(stage);

  //データとオプションを設定
  chart.draw(data, options);
}

//var dto = request.getAttribute("analysisDTO[0]");
//ArrayList<AnalysisDTO> list = (ArrayList<AnalysisDTO>)request.getAttribute("analysisDTO");
	function adddata(){
		alert(dto);
//		alert("aaa");
		return false;
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
			<p>Analysis</p>
		</div>
		<div>
			<p>商品の購入状況</p>
			<table border="1">
				<tr>
					<th>商品名</th>
					<th>商品画像</th>
					<th>ジャンル</th>
					<th>売り上げ数</th>
				</tr>
				<s:iterator value="analysisDTO">
					<tr>
						<td><s:property value="itemName"/></td>
						<td><img src="img/item/<s:property value="itemName"/>.png"/></td>
						<td><s:property value="itemGenre"/></td>
						<td><s:property value="totalItemCount"/></td>
					</tr>
				</s:iterator>
			</table>

			<s:form action="AnalysisAction" onsubmit="return adddata();">
			<s:submit value="test"/>
			</s:form>

			<s:iterator value="analysisDTO">
			</s:iterator>

			<div id="stage"></div>

		</div>
	</div>
	<div id="footer">
		<div id="pr">
		</div>
	</div>
</body>
</html>