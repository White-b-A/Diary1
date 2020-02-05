<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>日記内容</title>
			<script>

	function posting(){

		// 「OK」時の処理開始 ＋ 確認ダイアログの表示
		if(window.confirm('投稿しますか？')){

			window.alert('投稿しました')
			//location.href = "example_confirm.html"; // example_confirm.html へジャンプ

		}
		// 「OK」時の処理終了

		// 「キャンセル」時の処理開始
		else{

			window.alert('キャンセルされました'); // 警告ダイアログを表示

		}
		// 「キャンセル」時の処理終了

	}

	function deletion(){

		// 「OK」時の処理開始 ＋ 確認ダイアログの表示
		if(window.confirm('削除しますか？')){

			window.aleret('削除しました')
			//location.href = "example_confirm.html"; // example_confirm.html へジャンプ

		}
		// 「OK」時の処理終了

		// 「キャンセル」時の処理開始
		else{

			window.alert('キャンセルされました'); // 警告ダイアログを表示

		}
		// 「キャンセル」時の処理終了

	}

	</script>
	</head>

	<body>
		<form action="DiaryContent" method="get">
		日付:<input type="date" name="diary_date">
		題名:<input type="text" name="diary_title">
		<br>
		内容<textarea rows="20" cols="50" name="diary_content"></textarea>
		<button type="submit" name="post" value="test" onclick="posting()">投稿</button>
		<button type="submit" name="delete" onclick="deletion()">削除</button>
		<br>
		<button type="submit" name="back" onclick="">戻る</button>
		</form>
	</body>
</html>