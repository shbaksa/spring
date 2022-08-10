<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="resources/test2.css">
	<link rel="stylesheet" href="etc/test.css">
	<script src="resources/test2.js"></script>
	<script src="etc/test.js"></script>
</head>
<body> 
   <!-- resources에 있는거 -->
    <img src="resources/1.jpg" width="100">
    <hr>
   <div id="cc"> 안녕하세요 </div>
   <div id="dd"> 안녕하세요 </div>
   <span onclick="view2()">클릭 </span>
   <hr>
   <!-- img폴더에 있는거 , etc 폴더 -->
    <img src="img/aa.jfif" width="100">
   <hr>
   <div id="aa"> 안녕하세요 </div>
   <div id="bb"> 안녕하세요 </div>
   <span onclick="view1()">클릭 </span>
</body>
</html>
