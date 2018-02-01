<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>高级查询</title>
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
		<h1>高级查询</h1>
        <form action="/trainBooking/queryPro" method="post">
        	<div class="form-group">
              <label for="startStation" class="col-sm-2">出发地</label>
              <div class="col-sm-10">
                  <input type="text" name="startStation" class="form-control " id="startStation" placeholder="请输入出发地">
              </div>
            </div>
            <br/>
            
            <div class="form-group">
              <label for="centerStation" class="col-sm-2">中转站</label>
              <div class="col-sm-10">
                  <input type="text" name="centerStation" class="form-control " id="centerStation" placeholder="请输入中转站">
              </div>
            </div>
            <br/>
            <div class="form-group">
              <label for="endStation" class="col-sm-2">目的地</label>
              <div class="col-sm-10">
                  <input type="text" name="endStation" class="form-control " id="endStation" placeholder="请输入目的地">
              </div>
            </div>
            <div class="form-group">
              <label for="date" class="col-sm-2">出发日期</label>
              <div class="col-sm-10">
                  <input type="date" name="date" class="form-control " id="date">
              </div>
            </div>
            <div class="form-group">
			   <label class="checkbox-inline">
			      <input type="radio" name="condition" id="short" 
			         value="short" checked>最短路径
			   </label>
			   <label class="checkbox-inline">
			      <input type="radio" name="condition" id="cheap" 
			         value="cheap"> 最便宜路径
			   </label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">查询</button>
		</form>
     </div>
</body>
</html>