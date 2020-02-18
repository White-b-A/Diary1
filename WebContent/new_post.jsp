<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="sgt.css" type="text/css" />
<meta charset="UTF-8">
<title>新規投稿</title>

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
	//今日の日時を表示
	window.onload = function() {
		//今日の日時を表示
		var date = new Date()
		var year = date.getFullYear()
		var month = date.getMonth() + 1
		var day = date.getDate()

		var toTwoDigits = function(num, digit) {
			num += ''
			if (num.length < digit) {
				num = '0' + num
			}
			return num
		}

		var yyyy = toTwoDigits(year, 4)
		var mm = toTwoDigits(month, 2)
		var dd = toTwoDigits(day, 2)
		var ymd = yyyy + "-" + mm + "-" + dd;

		document.getElementById("today").value = ymd;
	}
</script>

</head>
<body>

	<form action="New_postServlet" class="form1" method="post">


			日付:<input type="date" name="date">&nbsp;&nbsp;&nbsp;題名:<input type="text" name="title">


		<br>
		内容<textarea rows="20" cols="50" id="diary_content" name="diary_content"></textarea>

		<br>

		<button class="button" type="submit" name="posted" value="new_post"
			onclick="return posting()">投稿</button>
		<button class="button" type="button" name="back" onclick="location.href='/Diary/Testsql'">戻る</button>
	</form>


</body>
</html>