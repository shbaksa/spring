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
	margin: 0px;
}
#first{
	width:900px;
	height: 40px;
	background: #cccccc;
	margin: auto;
}
#second{
	width: 900px;
	height: 50px;
	margin: auto;
}
#third{
	width: 900px;
	height: 200px;
	background: lightblue;
	margin: auto;
}

</style>

</head>
<body>

<div id="first">

<c:if test="${ userid == null}">
 <a href="login">로그인</a> <a href="member_input">회원가입</a> 
</c:if>
<c:if test="${ userid != null }">
	${name}님 <a href="logout">로그아웃</a> 회원정보
</c:if>

</div>
<div id="second"></div>
<div id="third"></div>



</body>
</html>