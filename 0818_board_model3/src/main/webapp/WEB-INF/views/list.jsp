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
	border-top:1px solid black;
	text-align:center;
}
</style>
</head>
<body>

	<table width="900" align="center">
	<caption><h2>게 시 판 목 록</h2></caption>
	<tr>
	<th>제목</th>
	<th width="80">아이디</th>
	<th width="60">조회수</th>
	<th width="100">작성일</th>
	</tr>
	<c:forEach items="${list}" var="bvo">
	<tr>
	<td style="text-align:left;"><a href="readnum?id=${bvo.id}">${bvo.title}</a></td>
	<td>${bvo.userid}</td>
	<td>${bvo.readnum}</td>
	<td>${bvo.writeday}</td>
	</tr>
	</c:forEach>
	<tr>
	<td colspan="4" align="center"><a href="write">글작성</a></td>
	</tr>
	
	
	</table>

</body>
</html>