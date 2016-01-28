<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function jump(){
	var s1 = document.getElementById("s1").value;
	var s2 = document.getElementById("s2").value;
	var s3 = document.getElementById("s3").value;
	var s4 = document.getElementById("s4").value;
	var s5 = document.getElementById("s5").value;
	var s6 = document.getElementById("s6").value;
	var s7 = document.getElementById("s7").value;
	if(s1.length >0&& s2.length >0&&s3.length >0&&s4.length >0&&s6.length >0&&s7.length>0){
		return true;
	}else{
		alert("请完整填写信息");
		return false;
	}
}
</script>
</head>
<body>
<%  
   //request.setCharacterEncoding("utf-8");
   //response.setCharacterEncoding("utf-8");
   String P_id = request.getParameter("P_id");
   String name = request.getParameter("E_name");
   name = new String(name.getBytes("ISO-8859-1"),"utf-8");	
   String depict = request.getParameter("depict");
   depict = new String(depict.getBytes("ISO-8859-1"),"utf-8");	
   String type = request.getParameter("type");
   type = new String(type.getBytes("ISO-8859-1"),"utf-8");	
   String price1 = request.getParameter("price");
   double price = Double.valueOf(price1);
   String img = request.getParameter("img");
   img = new String(img.getBytes("ISO-8859-1"),"utf-8");
   String phone = request.getParameter("phone");
   String PS2_id1 = request.getParameter("ps2_id");
   int PS2_id = Integer.parseInt(PS2_id1);
%>
<form action="/GreenGarden/MainServlet?action=6&P_id=<%=P_id %>&imgs=<%=img %>" method="post" enctype="multipart/form-data">
商品名称<input type="text" name="uname" value="<%=name %>" id="s1"/>&nbsp;&nbsp;<br/><br/>
物品描述<input type="text" name="udepict" value="<%=depict %> " id="s2"/>&nbsp;&nbsp;<br/><br/>
商品类型<input type="text" name="utype" value="<%=type %>" id="s3"/>&nbsp;&nbsp;<br/><br/>
单价<input type="text" name="uprice" value="<%=price %>" id="s4"/>&nbsp;&nbsp;<br/><br/>
当前图片<img src="<%=img %>" />
<input type="file" name="uimg" value="<%=img %>" id="s5"/>&nbsp;&nbsp;<br/><br/>
电话号码<input type="text" name="uphone" value="<%=phone %>" id="s6"/>&nbsp;&nbsp;<br/><br/>
分类<input type="text" name="uPS2_id" value="<%=PS2_id %>" id="s7"/>&nbsp;&nbsp;<br/><br/>
<input type="submit" value="保存"/>
</form>
<br/><br/>
<form action="/GreenGarden/MainServlet?action=3" method="post">
<input type="submit" value="取消"/>
</form>
</body>
</html>