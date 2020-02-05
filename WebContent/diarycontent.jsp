<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>日記内容</title>
</head>
<body>
	<form action="DiaryContent" method="get">
	日付:<input type="date" name="diary_date">
	題名:<input type="text" name="diary_title">
	<br>
	内容<textarea rows="20" cols="50" name="diary_content"></textarea>
	<button type="submit" name="post">投稿</button>
	<button type="submit" name="delete">削除</button>
	<br>
	<button type="submit" name="back">戻る</button>
	</form>
</body>
</html>