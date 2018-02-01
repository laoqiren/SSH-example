<%@ page language="java" import="java.util.*,model.Train,model.Station" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理列车</title>
    <script src="/trainBooking/assets/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="/trainBooking/assets/bootstrap.min.css">
    <script src="/trainBooking/assets/bootstrap.min.js"></script> 
    <style>
        #container {
            width: 35%;
            margin: 10% auto;
            text-align: center;
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
		<h1>管理列车</h1>
		<button type="button" class="btn btn-primary" id="add_train">新增列车</button>
		<table class="table table-striped" id="trains_tbl">
			<thead>
				<tr>
					<th>列车号</th>
					<th>出发站</th>
					<th>终点站</th>
					<th>中间站信息</th>
					<th>经历时间</th>
					<th>管理</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${trains }" var="train">
				<tr>
					<td>${train.getNumber() }</td>
					<td>${train.getStartId().getStationName() }</td>
					<td>${train.getEndId().getStationName() }</td>
					<td>${train.getCenter() }</td>
					<td>${train.getTime() }</td>
					<td>
                       <button type="button" class="delete btn btn-sm btn-danger" id="${ train.getNumber()}">删除列车</button>
                    </td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	<script src="/trainBooking/assets/adminTrain.js"></script>
</body>
</html>