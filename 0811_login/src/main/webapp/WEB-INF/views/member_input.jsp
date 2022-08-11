<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
* {
	margin: 0;
	margin: auto;
}

div {
	text-align: center;
	margin-top: 150px;
}

input[type=text] {
	border: 1px solid green;
	width: 300px;
	height: 60px;
	margin-bottom: 10px;
}

input[type=password] {
	border: 1px solid green;
	width: 300px;
	height: 60px;
	margin-bottom: 10px;
}

input[type=submit] {
	border: 1px solid green;
	width: 308px;
	height: 60px;
}
</style>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
	function userid_check(userid) {

		if (userid.trim().length >= 6) { // 요구되는 아이디의 조건을 충족할 경우

			var chk = new XMLHttpRequest();

			chk.open("get", "userid_check?userid=" + userid);
			chk.send();
			chk.onreadystatechange = function() {

				if (chk.readyState == 4) {
					
					if(chk.responseText=="1"){
						document.getElementById("useridCheck").innerText="사용불가능한 아이디입니다";
						document.getElementById("useridCheck").style.color="red";
						
					}
					else{
						document.getElementById("useridCheck").innerText="사용가능한 아이디입니다";
						document.getElementById("useridCheck").style.color="blue";
					}

				} // if

			} // chk.function
		} // if 
		else
			alert("아이디의 길이가 6자 미만입니다");

	} //function
	
	$(function(){
		
		$("input[name=pwd1]").blur(function(){
			
			var pwd = $("input[name=pwd]").val();
			var pwd1 = $("input[name=pwd1]").val();
			
			if(pwd==pwd1){
				
				$("#pwdErr").text("비밀번호 확인");
				$("#pwdErr").css("color","blue");	
			}
			else{
				
				$("#pwdErr").text("비밀번호 틀림");
				$("#pwdErr").css("color","red");
			}
				
			
		});
		
	});
</script>
</head>
<body>

	<div id="member">

		<form method="post" action="member_input_ok">

			<input type="text" name="userid" placeholder="아 이 디"
				onblur="userid_check(this.value)"><br>
				<span id="useridCheck" style="font-size:12px;"></span>
			<p>
				<input type="text" name="name" placeholder="이 름">
			<p>
				<input type="password" name="pwd" placeholder="비밀번호">
			<p>
				<input type="password" name="pwd1" placeholder="비밀번호확인"><br>
				<span id="pwdErr" style="font-size:12px"></span>
			<p>
				<input type="text" name="email" placeholder="이 메 일">
			<p>
				<input type="text" name="phone" placeholder="전화번호">
			<p>
				<input type="submit" value="회원가입">
		</form>






	</div>




</body>
</html>




















