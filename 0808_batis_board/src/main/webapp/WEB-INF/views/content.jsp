<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<title>Insert title here</title>
</head>
<style>
table{
	border-collapse: collapse;
}
table td{
	border:1px solid black;
}
div {
	text-align: center;
	display:none;
}
</style>
<script>
 $(function(){
	
	$("#btn").click(function(){
		
		if($("#del").css("display")=="none"){
			$("#del").css("display","block");	
			$("#up").css("display","none");
		}
		else{
			$("#del").css("display","none");
		}
	});
	$("#btn1").click(function(){
		
		if($("#up").css("display")=="none"){
			$("#up").css("display","block");	
			$("#del").css("display","none");
		}
		else{
			$("#up").css("display","none");
		}
	});
	
	
	
	
});
 


</script>
<body>	<!-- content.jsp -->

	<table width="700" align="center">
	
	<tr>
	<td>제목</td>
	<td>${bdto.title}</td>
	</tr>
	<tr>
	<td>이름</td>
	<td>${bdto.name}</td>
	</tr>
	<tr>
	<td>조회수</td>
	<td>${bdto.readnum}</td>
	</tr>
	<tr>
	<td>작성일</td>
	<td>${bdto.writeday}</td>
	</tr>
	<tr>
	<td>내용</td>
	<td>${bdto.content}</td>
	</tr>
	
	<tr>
	<td colspan="2">
	<a href="update?id=${bdto.id}">수정</a><!-- <input type="button" id="btn1" value="수정"> -->
	<%-- <a href="delete?id=${bdto.id}">삭제</a> --%><input type="button" id="btn" value="삭제">
	<a href="list">목록</a></td>
	</tr>
	
	</table>
	
	<form method="post" action="delete" >
	<input type="hidden" name="id" value="${bdto.id}">
	<div id="del">
	비밀번호 : <input type="password" name="pwd"> <input type="submit" value="삭제" >
	</div>
	</form>
	<form method="post" action="update">
	<input type="hidden" name="id" value="${bdto.id}">
	<div id="up">
	비밀번호 : <input type="password" name="pwd"> <input type="submit" value="수정" >
	</div>
	</form>

</body>
</html>