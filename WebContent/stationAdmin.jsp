<%@ page language="java" import="java.util.*,model.Station" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理站点</title>
	<script src="/trainBooking/assets/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="/trainBooking/assets/bootstrap.min.css">
    <script src="/trainBooking/assets/bootstrap.min.js"></script> 
    <style>
        #container {
            width: 45%;
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
		<h1>管理站点</h1>
		<button type="button" class="btn btn-primary" id="add_station">新增站点</button>
		<table class="table table-striped" id="stations_tbl">
			<thead>
				<tr>
					<th>站点编号</th>
					<th>站点名</th>
					<th>管理</th>
				</tr>
			</thead>
			<c:forEach items="${stations }" var="station">
				<tr>
					<td>${station.getStationId() }</td>
					<td>${station.getStationName() }</td>
					<td>
                       <button type="button" class="delete btn btn-sm btn-danger" id="${ station.getStationId()}">删除站点</button>
                    	<button type="button" class="update_station btn btn-sm btn-success" id="${ station.getStationId()}">修改站点</button>
                    </td>
                    <td>
                    
                    </td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<script type="text/javascript" src="/trainBooking/assets/adminStation.js">
	</script>
</body>
</html>