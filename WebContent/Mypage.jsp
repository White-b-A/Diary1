<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="diary.MypageBean1"
    import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マイページ</title>
</head>
<body>
<jsp:useBean id="myBean2" class="diary.MypageBean2"
scope="session"	/>

<%
ArrayList<MypageBean1> getDiaryArray = myBean2.getDiaryArray();
for(MypageBean1 obj : getDiaryArray){
	out.print(obj.getDay()+":");
	out.println("<a href=Blog_stringServlet?titile="+obj.getTitle()+">"+obj.getTitle()+"</a>"+"<br>");
}
%>



<form action="sinki_toukou.html" method="get">
	<input type="submit" value="新規投稿">
</form>
</body>
</html>