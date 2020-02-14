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
	<jsp:useBean id="myBean2" class="diary.MypageBean2" scope="session" />

	<%
		ArrayList<MypageBean1> getDiaryArray = myBean2.getDiaryArray();

		for (MypageBean1 rcd : getDiaryArray) {
			out.println(rcd.getDay() + ":" + rcd.getTitle() + "<br>");
		}
	%>

	<%=myBean2.getArraySize()%>


<br>
		<button type="button" name="新規投稿" onclick="location.href='sinki_toukou.html'">新規投稿</button>

</body>
</html>