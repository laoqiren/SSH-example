<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理中心</title>
    <link rel="stylesheet" href="/trainBooking/assets/bootstrap.min.css">
    <script src="/trainBooking/assets/jquery-3.2.1.min.js"></script>
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
		<h1>管理中心</h1>
        <a type="button" class="btn btn-lg btn-primary" href="/trainBooking/queryStations">站点管理</a>
        <a type="button" class="btn btn-lg btn-primary" href="/trainBooking/queryTrains">列车管理</a>
     </div>
</body>
</html>