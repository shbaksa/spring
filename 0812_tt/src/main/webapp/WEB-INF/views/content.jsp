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
	<caption><h2>게 시 판</h2></caption>
	<tr>
	<td>제목</td>
	<td>${tdto.title}</td>
	</tr>
	<tr>
	<td>내용</td>
	<td>${tdto.content}</td>
	</tr>
	<tr>
	<td>사진</td>
	
	
	<td>
	<c:forEach items="${tdto.temp}" var="my">
	<img src="resources/img/${my}" width="200">	
	</c:forEach>
	</td>
	
	<tr>
	<td colspan="2">
	
	<a href="list">목록</a>
	<a href="update?id=${tdto.id}">수정</a>
	<a href="delete?id=${tdto.id}&fname=${tdto.temp2}">삭제</a>
	
	</td>
	</tr>
	
	</table>

</body>
</html>