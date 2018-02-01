<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登陆</title>
<script src="/trainBooking/assets/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="/trainBooking/assets/bootstrap.min.css">
    <script src="/trainBooking/assets/bootstrap.min.js"></script> 
    <style>
        #container {
            width: 35%;
            margin: 10% auto;
        }
        #header {
        	margin-bottom: 30px;
        }
    </style>
</head>
<body>
	<div id="container">
		<h1 id="header">管理员登陆</h1>
		<form role="form" class="form-horizontal" id="loginForm" name="loginForm" action="/trainBooking/loginAdmin" method="post">
			<div class="form-group">
              <label for="adminName" class="col-sm-2">账号：</label>
              <div class="col-sm-10">
                  <input type="text" name="adminName" class="form-control " id="adminName" placeholder="请输入账号">
              </div>
            </div>
            <div class="form-group">
              <label for="adminPwd" class="col-sm-2">密码：</label>
              <div class="col-sm-10">
                  <input type="password" name="adminPwd" class="form-control " id="adminPwd" placeholder="请输入密码">
              </div>
            </div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">登陆</button>
		</form>
	</div>
</body>
</html>