<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<table width="900" align="center">
	<tr>
	<td>제목</td>
	<td>작성자</td>
	<td>조회수</td>
	<td>작성일</td>
	</tr>
	<c:forEach items="${list}" var="tdto">
	<tr>
	<td><a href="readnum?id=${tdto.id}">${tdto.title}</a></td>
	<td>${tdto.userid}</td>
	<td>${tdto.readnum}</td>
	<td>${tdto.writeday}</td>
	</tr>
	</c:forEach>
	</table>
	
	
	<a href="write">글작성</a>
</body>
</html>