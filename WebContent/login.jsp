<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="javax.servlet.http.HttpSession,javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta name="viewport" content="width=device-width,initial-scale=1.0" charset="UTF-8">
<title>ログイン</title>
<link href="https://fonts.googleapis.com/css?family=Lato:400,700|Noto+Sans+JP:400,700" rel="stylesheet">
<style>
body {
	height: 100%;
	font-weight: 100;
}

body,p,form,input {
	margin: 0
}

#form {
	width: 400px;
    margin: 30px auto;
    padding: 300px;
    border: 1px solid #555;
    font-family: 'Lato', 'Noto Sans JP', '游ゴシック Medium', '游ゴシック体', 'Yu Gothic Medium', YuGothic, 'ヒラギノ角ゴ ProN', 'Hiragino Kaku Gothic ProN', 'メイリオ', Meiryo, 'ＭＳ Ｐゴシック', 'MS PGothic', sans-serif;
}

form p {
	font-size: 24px;
}

.form-title {
	font-size: 50px;
	text-align: center;
	padding-bottom: 50px;
}

.pass {
    margin-bottom: 20px;
}

input[type="password"] {
	width: 300px;
	padding: 4px;
	font-size: 14px;
}

.submit {

}

input[type="submit"] {
	margin-left: 5px;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 14px;
	color: #000000;
	padding: 10px 20px;
	background: -webkit-gradient(
		linear, left top, left bottom,
		from(#ffffff),
		to(#ffffff));
	background: linear-gradient(
		top,
		#ffffff 0%,
		#ffffff);
	border-radius: 21px;
	border: 1px solid #000000;
	box-shadow:
		0px 1px 3px rgba(000,000,000,0.5),
		inset 0px 0px 3px rgba(255,255,255,1);
	text-shadow:
		0px -1px 0px rgba(000,000,000,0.1),
		0px 1px 0px rgba(255,255,255,1);
}

</style>
</head>

<body>




    	<form action="LoginServlet" method="post">
    	<div id="form">
    		<p class="form-title">Login</p>

    		<div class="content">
    		<p>Pass</p>
    		<p class="pass"><input type="password" name="password" id="diary_pass"  maxlength="32" autocomplete="OFF">
    		<input type="submit"  name="pass" value="Login" ><!-- onclick="location.href='LoginSessoin.java?url=Mypage.jsp'"  -->
    		</div>
    	</div>
    	</form>

</body>
</html>