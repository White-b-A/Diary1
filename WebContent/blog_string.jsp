<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ブログ内容</title>
</head>
<body>
<% String date = (String)request.getAttribute("date"); %>
<% String title = (String)request.getAttribute("title"); %>
<% String blog = (String)request.getAttribute("blog"); %>
	日付:<%=date %>題名<%=title %><br>
	内容:<%=blog%><br>
	<input type="submit" value="変更" onclick="location.href='./diarycontent.jsp'">
	<button type="button" name="back" onclick="location.href='/Diary/Testsql'">戻る</button>
<% session.setAttribute("date",date); %>
<% session.setAttribute("title",title); %>
<% session.setAttribute("blog",blog); %>
</body>
</html>