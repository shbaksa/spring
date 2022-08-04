<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Home</title>
</head>
<body>  <!-- home.jsp -->
    <a href="data1?name=홍길동&age=23"> data1.jsp로 연결 </a> <p>
    <a href="data2?name=슈퍼먼&age=33"> data2.jsp로 연결 </a> <p>
    <a href="data3?name=배트맨&age=44"> data3요청으로 data2.jsp로 연결</a> <P>
    <a href="data4?name=뽀로로&age=20&phone=010&juso=고양">data4로연결</a> <p>
    <a href="data5/원더우먼/33"> data5로 연결 </a>
</body>
</html>




