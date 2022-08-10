<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <style>
  a {
    text-decoration:none;
    color:black;
  }
  a:hover {
    text-decoration:underline;
  }
 </style>
 <script>
   function move(my)
   {
	   location="list?pcnt="+my.value;
   }
   window.onload=function()
   {
	   document.getElementById("pcnt").value="${pcnt}";
   }
 </script>
</head>
<body>
   <table width="800" align="center">
     <caption> <h3 align="right"> 
       <select onchange="move(this)" id="pcnt">
         <option value="10"> 10개 </option>
         <option value="20"> 20개 </option>
         <option value="30"> 30개 </option>
         <option value="50"> 50개 </option>
       </select>
     
     </h3> </caption>
     <tr>
       <td> 제 목 </td>
       <td> 이 름 </td>
       <td> 조회수 </td>
       <td> 작성일 </td>
     </tr>
   <c:forEach items="${list}" var="bdto">
     <tr>
       <td> <a href="readnum?id=${bdto.id}"> ${bdto.title} </a> </td>
       <td> ${bdto.name} </td>
       <td> ${bdto.readnum} </td>
       <td> ${bdto.writeday} </td>
     </tr>
   </c:forEach>
     <tr>
       <td colspan="4" align="center">
        <!-- 10페이지 단위로 이전 이동하기  :  -->
       <c:if test="${pstart != 1}"> <!-- 첫번재 그룹이 아닐때는  -->
        <a href="list?page=${pstart-1}&pcnt=${pcnt}"> ◁◁ </a>
       </c:if>
       <c:if test="${pstart == 1}"> <!-- 첫번째 그룹일때(1~10)는 이전 10페이지 이동 X -->
                     ◁◁
       </c:if>
       
        <!-- 1페이지 단위로 이전으로 가기 => 현재페이지에서 1을 뺀 페이지로 이동 --> 
       <c:if test="${page != 1}"> <!-- 현재 페이지가 1이 아닌경우 -->
        <a href="list?page=${page-1}&pcnt=${pcnt}"> ◁  </a>
       </c:if>
       <c:if test="${page == 1}"> <!-- 현재페이지가 1인경우 -->
                     ◁
       </c:if>
       
         <c:forEach begin="${pstart}" end="${pend}" var="i">  <!-- 페이지 출력하기 -->
           <!-- 현재 페이지의 색을 빨강 -->
            <c:if test="${page == i}"> <!-- 출력되는 페이지가 현재페이지와 같다면 -->
              <c:set var="st" value="style='color:red;'"/>
            </c:if>
            <c:if test="${page != i}"> <!-- 출력되는 페이지가 현재페이지와 다르다면 -->
              <c:set var="st" value=""/>
            </c:if>
            <a href="list?page=${i}&pcnt=${pcnt}" ${st}> ${i} </a>
         </c:forEach>
         
       <!-- 1페이지 단위로 다음 이동하기 -->
       <c:if test="${page != chong}"> <!-- 현재 페이지가 마지막 페이지가 아니라면 -->
        <a href="list?page=${page+1}&pcnt=${pcnt}"> ▷  </a>
       </c:if>
       <c:if test="${page == chong}"> <!-- 현재 페이지가 마지막 페이지라면 -->
                     ▷
       </c:if>
        
       <!-- 10페이지 단위로 다음 이동하기 -->
       <c:if test="${chong != pend}"> <!-- 현재 출력되는 페이지 그룹이 마지막이 아닐겨우 -->
         <a href="list?page=${pend+1}&pcnt=${pcnt}"> ▷▷ </a>
       </c:if>
       <c:if test="${chong == pend}"> <!-- 현재 출력되는 페이지 그룹이 마지막일 경우 -->
                         ▷▷
       </c:if>
       </td>
     </tr>
     <tr>
       <td colspan="4"> <a href="write"> 글쓰기 </a> </td>
     </tr>
   </table>
</body>
</html>





