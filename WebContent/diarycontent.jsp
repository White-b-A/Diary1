<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>日記内容</title>
			<script>
				function posting(){
					var post = confirm('投稿しますか？');

					if(post){
						window.alert('投稿しました');
						//この後DB更新コード記述↓
					}
						window.alert('キャンセルしました');
				}

				function deletion(){
					var deleted = confirm('削除しますか？');

					if(deleted){
						window.alert('削除しました');
						//この後DB削除コード記述↓
					}
						window.alert('キャンセルしました');
				}
			</script>
	</head>

	<body>
		<form action="DiaryContent" method="get">
		日付:<input type="date" name="diary_date">
		題名:<input type="text" name="diary_title">
		<br>
		内容<textarea rows="20" cols="50" name="diary_content"></textarea>
		<button type="submit" name="post"  onclick="posting();">投稿</button>
		<button type="submit" name="delete" onclick="deletion();">削除</button>
		<br>
		<button type="submit" name="back" onclick="">戻る</button>
		</form>
	</body>
</html>