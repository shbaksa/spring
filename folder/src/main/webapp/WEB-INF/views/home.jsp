<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body> <!-- home.jsp -->
   <h2> board폴더의 문서</h2>
   <a href="board/list">board/list.jsp</a> <p>
   <a href="board/content">board/content.jsp</a> <p>
   <a href="board/update">board/update.jsp</a> <p>
   <a href="board/write">board/write.jsp</a> <p>
   
   <hr>
   <h2> reserve폴더의 문서</h2>
   <a href="reserve/reserve"> reserve/reserve.jsp</a> <p>
   <a href="reserve/reserve_next"> reserve/reserve_next.jsp</a> <p>
   <a href="reserve/reserve_view"> reserve/reserve_view.jsp</a> <p>
   
   <hr>
   <h2> tour폴더의 문서</h2>
   <a href="tour/list">tour/list.jsp</a>
   <a href="tour/content">tour/content.jsp</a>
   <a href="tour/update">tour/update.jsp</a>
   <a href="tour/write">tour/write.jsp</a>
</body>
</html>
