<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>店铺注册</title>
<script>
	function check() {
		var username = document.getElementById("rname").value;
		var password = document.getElementById("rcode").value;
		var password2 = document.getElementById("rcode2").value;
		var store = document.getElementById("store").value;
		if (username.length > 0 && password.length > 0 && password2.length > 0 && store.length > 0) {
			if(password==password2){
				return true;
			}else{
				alert("两次输入密码不同");
				return false;
			}
		} else {
			alert("用户名和密码不能为空");
			return false;
		}
	}
</script>
<link type="text/css" rel="stylesheet" href="../css/style.css">
</head>
<body>
	<div id="form2">
<form action="/GreenGarden/MainServlet?action=2" method="post">
    帐&nbsp;&nbsp;&nbsp;&nbsp;号：<input type="text" name="rname" id="rname" />
		<span style="color:red"><%if(request.getAttribute("notregister")!=null){
	out.println(request.getAttribute("notregister"));
	}%></span><br><br>
    密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="rcode" id="rcode" /><br><br>
    确认密码：<input type="password" name="rcode2" id="rcode2" /><br><br>
    店铺编号：<input type="text" name="store" id="store"/>
		<span style="color:red"><%if(request.getAttribute("stores")!=null){
	out.println(request.getAttribute("stores"));
	}%></span>
    <br><br>
    <input type="submit" value="注册" onclick="return check()" id="btn2"/>
</form>
</div>

</body>
</html>