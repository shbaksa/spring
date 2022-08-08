<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
table{
	border-collapse: collapse;
}
table td{
	border:1px solid black;
}
</style>
</head>
<body>
<table width="900" align="center">
<caption> <h2>게 시 판</h2></caption>
<tr>
<th width="300">제목</th>
<th width="100">작성자</th>
<th width="80">조회수</th>
<th width="120">작성일</th>
</tr>

	<c:forEach items="${list}" var="bdto">
		<tr>
		<td><a href="readnum?id=${bdto.id}">${bdto.title}</a></td>
		<td>${bdto.name}</td>
		<td>${bdto.readnum}</td>
		<td>${bdto.writeday}</td>
		</tr>
	</c:forEach>
	
	<tr>
	<td colspan="4" align="center" style="border-bottom:none;border-left:none;border-right:none;"> <a href="write">글쓰기</a></td>
	</tr>
	</table>
</body>
</html>