<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
a{
	text-decoration: none;
	color:black;
}
table{
	border-collapse: collapse;
}

table td{
	border:1px solid black;
	text-align:center;
}
div {
	text-align:center;
}
#del {
	display: none;
}
#pwdErr{
	font-size:8px;
	color:red;
}
</style>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
$(function(){
	
	$("#btn").click(function(){
		
		$("#del").css("display","block");
		$("#btn").css("display","none");
		
		
	});
	
	
});

</script>
</head>
<body>
	
		<table width="700" align="center">
		<caption><h2>게 시 판</h2></caption>
	
	<tr>
	<td width="50">제목</td>
	<td width="300">${bdto.title}</td>
	

	<td width="50">조회수</td>
	<td width="50">${bdto.readnum}</td>
	</tr>
	<tr>
	<td>작성자</td>
	<td>${bdto.userid}</td>
	
	
	<td>작성일</td>
	<td width="100">${bdto.writeday}</td>
	</tr>
	<tr>
	<td height="400" width="50">내용</td>
	<td colspan="3">${bdto.content}</td>
	</tr>
	
	<tr>
	<td colspan="4">
	<a href="update?id=${bdto.id}">수정</a>
	
	<%-- <a href="delete?id=${bdto.id}">삭제</a> --%>
	<span id="btn">삭제</span>
	
	<a href="list">목록</a></td>
	</tr>
	
	</table>
			<c:if test="${chk==1}">
			<div id="pwdErr">비밀번호 오류입니다</div>
			</c:if>

	<div id="del">
		<form method="post" action="delete">
			<input type="hidden" name="id" value="${bdto.id}">
			<input type="password" name="pwd" placeholder="비밀번호 입력">
			<input type="submit" value="삭제">		
		</form>
	</div>


	
</body>
</html>