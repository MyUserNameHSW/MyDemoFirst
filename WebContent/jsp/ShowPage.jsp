<%@page import="com.lyy.daoimp.getId1"%>
<%@page import="com.lyy.util.PageNums"%>
<%@page import="com.lyy.action.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <script src="/GreenGarden/js/jquery-1.11.3.min.js"></script>
    <script src="/GreenGarden/js/js1.js"></script>
    <script>
    $(document).ready(function(){
        $("#btn1").click(function(){
           $("#form3").show(300);
            $("#btn1").hide();
        });
        $("#cancel").click(function(){
            $("#form3").hide(300);
            $("#btn1").show();
        });
    });
    function jump(){
    	var s1 = document.getElementById("s1").value;
    	var s2 = document.getElementById("s2").value;
    	var s3 = document.getElementById("s3").value;
    	var s4 = document.getElementById("s4").value;
    	var s5 = document.getElementById("s5").value;
    	var s6 = document.getElementById("s6").value;
    	var s7 = document.getElementById("s7").value;
    	if(s1.length >0&& s2.length >0&&s3.length >0&&s4.length >0&&s5.length >0&&s6.length >0&&s7.length>0){
    		return true;
    	}else{
    		alert("请完整填写信息");
    		return false;
    	}
    }
    </script>
</head>
<body>
<%-- <% request.setCharacterEncoding("utf-8");
   response.setCharacterEncoding("utf-8"); %> --%>
<% List<Product> list = (List<Product>)request.getAttribute("array"); %>
<% String username = (String)request.getSession().getAttribute("name"); %>
<div style="width: 1000px;margin-left: 50px">
    <img src="/GreenGarden/img/top.png" style="width: 1300px"/><br>
    <hr style="text-align: center" width="1200">
</div>
<button id="btn1" style="margin-left: 100px">添加</button>&nbsp;&nbsp;&nbsp;&nbsp;
<form action="/GreenGarden/MainServlet?action=9" method="post" style="margin-left: 1040px">
<select name="select1">  
  <option>请选择</option>
  <option value ="热门推荐">热门推荐</option>  
  <option value ="节日送礼">节日送礼</option>  
  <option value ="养眼办公">养眼办公</option>  
  <option value ="养花工具">养花工具</option>  
</select>

<input type="submit" value="查找"/>
</form>&nbsp;&nbsp;&nbsp;&nbsp;
<div id="form3" style="display: none;margin-left: 100px;background-color: aliceblue;width: 750px;">
<form action="/GreenGarden/MainServlet?action=4" method="post" enctype="multipart/form-data">
    商品名称<input type="text" name="names" id="s1"/>&nbsp;&nbsp;&nbsp;&nbsp;
    物品描述<input type="text" name="depict" id="s2"/>&nbsp;&nbsp;&nbsp;&nbsp;
    商品类型<input type="text" name="type" id="s3"/><br/><br/>
    单&nbsp;&nbsp;&nbsp;&nbsp;价<input id="s4" type="text" name="price"/>&nbsp;&nbsp;&nbsp;&nbsp;
    电话号码<input id="s5" type="text" name="phone"/>&nbsp;&nbsp;&nbsp;&nbsp;
    分&nbsp;&nbsp;&nbsp;&nbsp;类<input id="s6" type="text" name="PS2_id"/><br/><br/>
     图&nbsp;&nbsp;&nbsp;&nbsp;片<input id="s7" type="file" name="img" value="image"/><br/><br/>
    <input type="submit" value="确定" onclick="return jump()"/>&nbsp;&nbsp;
    <input type="button" value="取消" id="cancel"/><br/><br/>
</form>
</div>
<br><br>
<div style="text-align: right;">
<form action="/GreenGarden/MainServlet?action=7" method="post">
<input type="text" name="likename">&nbsp;&nbsp;
<input type="submit" value="查询" style="margin-right: 180px">
</form>
</div>
<br><br>
<div style="text-align: center;margin: auto;">
<table border="1px" cellpadding="0" width="80%" style="margin-left: 100px">
<tr>
<td align="center">商品编号</td>
<td align="center">商品名称</td>
<td align="center">物品描述</td>
<td align="center">商品类型</td>
<td align="center">单价</td>
<td align="center">图片</td>
<td align="center">购买次数</td>
<td align="center">收藏次数</td>
<td align="center">电话号码</td>
<td align="center">分类</td>
<td align="center">编辑</td>
<td align="center">删除</td>
</tr>
<%
for(int i=0;i<list.size();i++){
	Product product = list.get(i);
	int p_id = product.getP_id();
	String name = product.getName();
	String depict = product.getDepict();
	String type = product.getType();
	double price = product.getPrice();
	String img = product.getImg();
	int buy_num = product.getBuy_num();
	int col_num = product.getCol_num();
	String phone = product.getPhone();
	int PS2_id = product.getPS2_id();
	getId1 gId1 = new getId1();
	String ps2_name = gId1.PS2_Name(PS2_id);
  %>
<tr>
<td align="center"><%=p_id %></td>
<td align="center"><%=name %></td>
<td align="center"><%=depict %></td>
<td align="center"><%=type %></td>
<td align="center"><%=price %></td>
<td align="center"><%=img %></td>
<td align="center"><%=buy_num %></td>
<td align="center"><%=col_num %></td>
<td align="center"><%=phone %></td>
<td align="center"><%=ps2_name %></td>
<td align="center"><a href="/GreenGarden/jsp/PEdit.jsp?P_id=<%=p_id %>&E_name=<%=name %>
&depict=<%=depict %>&type=<%=type %>&price=<%=price %>&img=<%=img %>&phone=<%=phone %>&ps2_id=<%=PS2_id %>
">编辑</a></td>
<td align="center"><a href="/GreenGarden/MainServlet?action=5&P_id=<%=p_id %>">删除</a></td>
</tr>
<% } %>
</table>

<%
int sum = (Integer)request.getAttribute("sum");
int each = PageNums.PAGENUM;
int r = sum/each;
int number = 0;
if(sum%each==0){
	 number = r;
}else{
	   number =r+1;
}
%>
<% String actions = (String)request.getAttribute("xxx"); %>
<% String likename = (String)request.getAttribute("likename"); %>
<% String item = (String)request.getAttribute("item");%>
<% 
	 for(int i=1;i<=number;i++){
	%>
		<a href="/GreenGarden/MainServlet?action=<%=actions %>&pageNum=<%=i %>&likename=<%=likename %>&select1=<%=item %>"><%=i %></a> 
	<%} %>
</div><br><br>
<div style="text-align: right;">
<form action="/GreenGarden/MainServlet?action=8" method="post">
<span style="font-size: 10px">当前用户 ：<%=username %></span>
<input type="submit" value="退出" style="margin-right: 180px;background-color: red;"/>
</form>
</div>
</body>
</html>