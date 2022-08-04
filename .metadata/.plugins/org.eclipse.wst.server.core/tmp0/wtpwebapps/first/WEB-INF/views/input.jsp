<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>

div{
	text-align: center;
	margin-top:30px;
}

input[type=text]{
	width:200px;
	height: 50px;
	border:1px solid green;
}
input[type=submit]{
	width:200px;
	height:50px;
	border:1px solid green;
}


</style>
</head>
<body>

<div>
	<form mothod="post" action="sungview">	
		<input type="text" name="name" placeholder="이름입력"> <p>
		<input type="text" name="kor" placeholder="국어성적"> <p>
		<input type="text" name="eng" placeholder="영어성적"> <p>
		<input type="text" name="mat" placeholder="수학성적"> <p>
		<input type="submit" value="성적입력">	
	</form>
</div>

</body>
</html>