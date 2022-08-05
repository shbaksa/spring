<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>	<!-- list.jsp -->

	<table width="700" align="center">
	<tr>
	<td>제목</td>
	<td>작성자</td>
	<td>조회수</td>
	<td>작성일</td>
	</tr>
	<c:forEach items="${blist}" var="bdto">
	<tr>
	<td><a href="readnum?id=${bdto.id}">${bdto.title}</a></td>
	<td>${bdto.name}</td>
	<td>${bdto.readnum }</td>
	<td>${bdto.writeday}</td>
	</tr>
	</c:forEach>
	<tr>
	<td colspan="4" align="center"><a href="write">글작성</a></td>
	</tr>
	
	
	</table>
	
</body>
</html>