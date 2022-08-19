<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
</head>
<body>
    <!-- student -->
    이름 : ${student.name} <p>
    학번 : ${student.hakbun} <p>
    나이 : ${student.age} 
    <hr>
    <!-- student1 -->
    이름 : ${student1.name} <p>
    학번 : ${student1.hakbun} <p>
    나이 : ${student1.age} 
     <hr>
    <!-- student2 -->
    이름 : ${student2.name} <p>
    학번 : ${student2.hakbun} <p>
    나이 : ${student2.age} 
</body>
</html>
