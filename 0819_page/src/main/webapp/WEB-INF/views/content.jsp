<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<div> ${pvo.pcnt}  /// ${pvo.page}  /// ${pvo.sel} /// ${pvo.sword}  </div>
<table width="900" align="center">
	<tr>
	<td>제목</td>
	<td>${pvo.title}</td>
	<td>조회수</td>
	<td>${pvo.readnum}</td>
	</tr>
	<tr>
	<td>이름</td>
	<td>${pvo.name}</td>
	<td>작성일</td>
	<td>${pvo.writeday}</td>
	</tr>
	<tr>
	<td>내용</td>
	<td colspan="3">${pvo.content}</td>
	</tr>
	<tr>
	<td colspan="4">
	<a href="update?id=${pvo.id}&page=${pvo.page}&pcnt=${pvo.pcnt}&sel=${pvo.sel}&sword=${pvo.sword}">수정</a>
	<a href="list?page=${pvo.page}&pcnt=${pvo.pcnt}&sel=${pvo.sel}&sword=${pvo.sword}">목록</a>
	<%-- <a href="delete?id=${pvo.id}&page=${pvo.page}&pcnt=${pvo.pcnt}&sel=${pvo.sel}&sword=${pvo.sword}">삭제</a> --%>
	<input type="button" id="btn" value="삭제">
	</td>
	

</table>

		<c:if test="${chk==1}">
			<div id="pwdErr">비밀번호 오류입니다</div>
			</c:if>

	<div id="del">
		<form method="post" action="delete">
		<input type="hidden" name="id" value="${pvo.id}">
		<input type="hidden" name="pcnt" value="${pvo.pcnt}">
		<input type="hidden" name="sel" value="${pvo.sel}">
		<input type="hidden" name="sword" value="${pvo.sword}">
		<input type="hidden" name="page" value="${pvo.page}">		
			<input type="password" name="pwd" placeholder="비밀번호 입력">
			<input type="submit" value="삭제">		
		</form>
	</div>



</body>
</html>