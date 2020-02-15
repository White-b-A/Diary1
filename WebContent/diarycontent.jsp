<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>日記内容</title>


<script type="text/javascript">
	function posting() {

		var flag = confirm('投稿しますか？');

		if (flag) {

			window.alert('投稿しました');

		} else {

			return false;

		}

	}
</script>

<script type="text/javascript">
	function deletion() {

		var flag = confirm('削除しますか？');

		if (flag) {

			window.alert('削除しました');

		} else {

			return false;

		}

	}
</script>



</head>

<body>

	<form action="DiaryContent" method="post">

		日付:<%=request.getAttribute("date")%>
		題名:<%=request.getAttribute("title")%>

		<input type="hidden" id="title" name="dairy_title" value="<%=request.getAttribute("title")%>">

		<br> 内容
		<textarea rows="20" cols="50" id="diary_content" name="diary_content"></textarea>

		<button type="submit" name="posted" value="diary_post"
			onclick="return posting()">投稿</button>

		<button type="submit" name="posted" value="diary_delete"
			onclick="return deletion()">削除</button>

		<br>

		<button type="submit" name="back" onclick="Mypage.jsp">戻る</button>
	</form>
</body>
</html>








<!-- name="posted" id="diary_post" -->