<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
*{
	margin:0;
	margin:auto;
}

#loginForm{
	text-align: center;
	margin-top:300px;
	
}
input[type=text]{
	border:1px solid green;
	width:300px;
	height:60px;
	margin-bottom:10px;
}
input[type=password]{
	border:1px solid green;
	width:300px;
	height:60px;
	margin-bottom:10px;
}
input[type=submit]{
	border:1px solid green;
	width:308px;
	height:60px;
}
input[type=button]{
	border:1px solid green;
	width:308px;
	height:60px;
}
#useridBtn , #pwdBtn{
	display:inline-block;
	margin-top: 15px;
	border:1px solid green;
	width:150px;
	height: 25px;
	text-align: center;
	paddin-top:5px;
	
}

#searchText{
	margin-top:15px;
	text-align: center;
}

#useridForm , #pwdForm{
	margin-top:15px;
	text-align: center;
	display:none;
}

</style>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>

	$(function(){
		
		$("#useridBtn").click(function(){
			
			$("#useridForm").css("display","block");
			$("#pwdForm").css("display","none");
			$("#pwdForm input[type=text]").val("");
			$("#searchText").text("");
		});
		
		$("#pwdBtn").click(function(){
			
			$("#useridForm").css("display","none");
			$("#pwdForm").css("display","block");
			$("#useridForm input[type=text]").val("");
			$("#searchText").text("");
		});
		
	});
	
	function userid_search(){
		
		var name = document.pkc.name.value;
		var phone = document.pkc.phone.value;
		
		var ch = new XMLHttpRequest();
		
		ch.open("get","userid_search?name="+name+"&phone="+phone);
		ch.send();
		ch.onreadystatechange = function(){
			
			if(ch.readyState==4){
				
				if(ch.responseText != "0"){					
					document.getElementById("searchText").innerText="아이디는 : "+ch.responseText;
					document.getElementById("searchText").style.color="blue";
					document.getElementById("useridForm").style.display="none";
					document.getElementById("pwdForm").style.display="none";
				}
				else{
					document.getElementById("searchText").innerText="정보가 틀렸습니다"
					document.getElementById("searchText").style.color="red";
				}
					
			}
		}
	
		
	}
	
	function pwd_search(){
		
		var userid = document.chk.userid.value;
		var name = document.chk.name.value;
		var phone = document.chk.phone.value;
		
		var ck = new XMLHttpRequest();
		ck.open("get","pwd_search?userid="+userid+"&name="+name+"&phone="+phone);
		ck.send();
		
		ck.onreadystatechange = function(){
			
			if(ck.readyState == 4){
				
				if(ck.responseText != "0"){
					document.getElementById("searchText").innerText="비밀번호는 : "+ck.responseText;
					document.getElementById("searchText").style.color="blue";
					document.getElementById("useridForm").style.display="none";
					document.getElementById("pwdForm").style.display="none";
				}
				else{
					document.getElementById("searchText").innerText="정보가 틀렸습니다"
					document.getElementById("searchText").style.color="red";
				}
			}
		}
		
	}

</script>
</head>
<body>


	<div id="loginForm">
	
		<form method="post" action="login_ok">
			<input type="text" name="userid" placeholder="아이디입력">
			<p>
				<input type="password" name="pwd" placeholder="비밀번호입력">
			<p>
				<input type="submit" value="로그인">
			<p>
		</form>
	
		<div id="useridBtn">아이디 찾기</div> <div id="pwdBtn">비밀번호 찾기</div>
	</div>
	
	

	<div id="searchText"> 
	
	<%-- <c:if test="${ useridSearch != null }"> 아이디 : ${useridSearch} </c:if>
	<c:if test="${ pwdSearch != null }"> 비밀번호 : ${pwdSearch} </c:if>
	<c:if test="${ useridSearch == null && pwdSearch == null }"></c:if> --%>
	<c:if test="${ chk == 1 }"><span style="font-size:12px;color:red;"> 회원정보가 틀렸습니다 </span></c:if>
	
	</div>
	
	
	
	
		<!-- <div id="useridForm">
			<form method="post" action="userid_search">
				<input type="text" name="name" placeholder="이름입력"><p>
				<input type="text" name="phone" placeholder="전화번호 입력"><p>
				<input type="submit" value="아이디찾기">
			</form>
		</div>
		
		<div id="pwdForm">
			<form method="post" action="pwd_search">
				<input type="text" name="userid" placeholder="아이디 입력"><p>
				<input type="text" name="name" placeholder="이름입력"><p>
				<input type="text" name="phone" placeholder="전화번호 입력"><p>
				<input type="submit" value="비밀번호찾기">		
			</form>
		</div> -->
		
		<div id="useridForm">
			<form name="pkc">
				<input type="text" name="name" placeholder="이름입력"><p>
				<input type="text" name="phone" placeholder="전화번호 입력"><p>
				<input type="button" onclick="userid_search()" value="아이디찾기">
			</form>
		</div>
		
		<div id="pwdForm">
			<form name="chk">
				<input type="text" name="userid" placeholder="아이디 입력"><p>
				<input type="text" name="name" placeholder="이름입력"><p>
				<input type="text" name="phone" placeholder="전화번호 입력"><p>
				<input type="button" onclick="pwd_search()" value="비밀번호찾기">		
			</form>
		</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>