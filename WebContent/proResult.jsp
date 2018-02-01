<%@ page language="java" import="java.util.*,model.Train" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询结果</title>
	<script src="/trainBooking/assets/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="/trainBooking/assets/bootstrap.min.css">
    <script src="/trainBooking/assets/bootstrap.min.js"></script> 
    <style>
        #container {
            width: 50%;
            margin: 10% auto;
        }
        #header {
            text-align: center;
        }
        #teacher_info {
            margin-top: 20%;
        }
    </style>
</head>
<body>
	<div id="container">
		<h1>查询<span style="color:red">石柱县</span>到<span style="color:red">北京</span>最短路径</h1>
		<h2>车次1</h2>
		<table class="table table-striped" id="trains_tbl">
			<thead>
				<tr>
					<th>车次</th>
					<th>出发站点</th>
					<th>目的站点</th>
					
					<th>经历时间</th>
					<th>商务座</th>
					<th>一等座</th>
					<th>二等座</th>
					<th>高级软卧</th>
					<th>软卧</th>
					<th>动卧</th>
					<th>硬卧</th>
					<th>无座</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>D2222</td>
					<td>石柱县</td>
					<td>杭州</td>
					
					<td>33</td>
					<td>--</td>
					<td>100</td>
					<td>464</td>
					<td>--</td>
					<td>20</td>
					<td>--</td>
					<td>有</td>
					<td>有</td>
				</tr>
			</tbody>
				
			
		</table>
		<h2>车次2</h2>
		<table class="table table-striped" id="trains_tbl">
			<thead>
				<tr>
					<th>车次</th>
					<th>出发站点</th>
					<th>目的站点</th>
					
					<th>经历时间</th>
					<th>商务座</th>
					<th>一等座</th>
					<th>二等座</th>
					<th>高级软卧</th>
					<th>软卧</th>
					<th>动卧</th>
					<th>硬卧</th>
					<th>无座</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>D3317</td>
					<td>杭州</td>
					<td>北京</td>
					
					<td>45</td>
					<td>--</td>
					<td>100</td>
					<td>464</td>
					<td>--</td>
					<td>20</td>
					<td>--</td>
					<td>有</td>
					<td>有</td>
				</tr>
			</tbody>
				
			
		</table>
	</div>
</body>
</html>