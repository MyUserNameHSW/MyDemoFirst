<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>店铺登录</title>
<link type="text/css" rel="stylesheet" href="../css/style.css">
<script>
	function check() {
		var username = document.getElementById("name").value;
		var password = document.getElementById("code").value;
		if (username.length > 0 && password.length > 0) {
			return true;
		} else {
			alert("用户名和密码不能为空");
			return false;
		}
	}
</script>
</head>
<body>
    <p style="color:red"><%if(request.getAttribute("isregister")!=null){
	out.println(request.getAttribute("isregister"));
	}%></p>
<div id="form1">
<form action="/GreenGarden/MainServlet?action=1" method="post" >
    帐号：<input type="text" name="name" id="name" class="t"/><br>
    <br> 密码：<input type="password" name="code" id="code" class="t"/><br>
    <br> <input type="submit" value="登录" onclick="return check()" id="btn1"/>
    &nbsp;&nbsp;<a href="/GreenGarden/jsp/Register.jsp" id="he1">注册</a>
</form>
</div>
	<p style="color:red"><%if(request.getAttribute("msg")!=null){
	out.println(request.getAttribute("msg"));
	}%></p>
</body>
</html>