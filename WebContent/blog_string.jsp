<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="sgt2.css" type="text/css" />
<meta charset="UTF-8">
<title>ブログ内容</title>

</head>
<body>
<div class="form1">
<% String date = (String)request.getAttribute("date"); %>
<% String title = (String)request.getAttribute("title"); %>
<% String blog = (String)request.getAttribute("blog"); %>
	<div class ="box17">
	日付:<%=date %>&nbsp;&nbsp;&nbsp;題名:<%=title %>
	</div>
	<br>
	<div class="box28">
	<span class="box-title">内容</span>
	<p><%=blog%></p>
	</div>
	<br>
	<button class ="button" type="submit" onclick="location.href='./diarycontent.jsp'">変更</button>
	<button class ="button" type="button" name="back" onclick="location.href='/Diary/Testsql'">戻る</button>
<% session.setAttribute("date",date); %>
<% session.setAttribute("title",title); %>
<% session.setAttribute("blog",blog); %>
</div>
</body>
</html>