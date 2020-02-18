<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="sgt.css" type="text/css" />
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

		<form  action="DiaryContent" class="form1" method="get">
			<%
				String date = (String) session.getAttribute("date");
			%>
			<%
				String title = (String) session.getAttribute("title");
			%>
			<%
				String blog = (String) session.getAttribute("blog");
			%>
			<%
				System.out.println(date);
			%>
			<%
				System.out.println(title);
			%>
			<%
				System.out.println(blog);
			%>


			<h1>更新画面</h1>


			<div class="box17">
				日付:<%=date%>&nbsp;&nbsp;&nbsp;題名:<%=title%>
			</div>




			<input type="hidden" id="title" name="diary_title" value="<%=title%>">
			<input type="hidden" id="date" name="diary_date" value="<%=date%>">
			<br>
			<p>
			内容
			<br>
			<textarea  class="textlines" rows="20" cols="50" name="diary_content"><%=blog%></textarea>
			</p>
			<br>
			<button class ="button" type="submit" name="posted" value="diary_post"
				onclick="return posting()">投稿</button>

			<button  class ="button" type="submit"  name="posted" value="diary_delete"
				onclick="return deletion()">削除</button>



			<button class ="button" type="button" name="back"
				onclick="location.href='./Testsql'">戻る</button>
		</form>
</body>
</html>


