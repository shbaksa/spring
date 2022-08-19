<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <style>
   .link td{
     padding-top:20px;
   }
   .link a {
     text-decoration:none;
     color:black;
     margin-left:10px;
     display:inline-block;
     width:30px;
     height:20px;
     border:1px solid #cccccc;
   }
   .link a:hover {
     background:#cccccc;
     color:white;
   }
 </style>
 <script>
  function check(my)
  {
	  if(my.sel.selectedIndex != 0 && my.sword.value.trim().length != 0)
      {
		  return true;
      }		  
	  else
		  return false;
  }
  
  function init()
  {
	  <c:if test="${sel != 'id'}">
	    document.search.sel.value="${sel}";
	  </c:if>
  }
 </script>
</head>
<body onload="init()">
  <table width="700" align="center">
    <caption>
      <form name="search" method="post" action="list" onsubmit="return check(this)">
        <input type="hidden" name="page" value="1">
        <select name="sel">
          <option> 선택 </option>
          <option value="title"> 제목 </option>
          <option value="content"> 내용 </option>
          <option value="name"> 작성자 </option>
        </select>
        <input type="text" name="sword" value="${sword}">
        <input type="submit" value="검색">
       <c:if test="${sel != 'id'}">
        <input type="button" onclick="location='list?page=1'" value="전부보기">
       </c:if>
      </form>
    </caption>
    <tr align="center">
      <td> 이름 </td>
      <td> 제목 </td>
      <td> 조회수 </td>
      <td> 작성일 </td>
    </tr>
  <c:forEach items="${list}" var="bvo">  
    <tr>
      <td align="center"> ${bvo.name} </td>
      <td> <a href="readnum?id=${bvo.id}&page=${page}&sel=${sel}&sword=${sword}">${bvo.title} </a></td>
      <td align="center"> ${bvo.readnum} </td>
      <td align="center"> ${bvo.writeday} </td>
    </tr>
  </c:forEach>
    <tr class="link">
      <td colspan="4" align="center">
      <!-- 페이지 이동, 현재페이지 링크의 색을 다르게 -->
       <!-- 10페이지 단위 이전 이동 시작-->
         <c:if test="${pstart != 1}">
          <a href="list?page=${pstart-1}&sel=${sel}&sword=${sword}"> << </a>
         </c:if>
         <c:if test="${pstart == 1}">
          <a href="#"> << </a>
         </c:if>
       <!-- 10페이지 단위 이전 이동 끝 -->
      
       <!-- 1페이지 단위 이전 이동 시작-->
         <c:if test="${page != 1}">
          <a href="list?page=${page-1}&sel=${sel}&sword=${sword}"> < </a>
         </c:if>
         <c:if test="${page == 1}">
          <a href="#"> < </a>
         </c:if>
       <!-- 1페이지 단위 이전 이동 끝 -->
      
        <c:forEach begin="${pstart}" end="${pend}" var="i">
         <c:if test="${page == i}">
           <a href="list?page=${i}&sel=${sel}&sword=${sword}" style="border-color:red;"> ${i} </a>
         </c:if>
         <c:if test="${page != i}">  
           <a href="list?page=${i}&sel=${sel}&sword=${sword}"> ${i} </a>
         </c:if>
        </c:forEach>
        
       <!-- 1페이지 단위 다음 이동 시작-->
         <c:if test="${page != chong}">
          <a href="list?page=${page+1}&sel=${sel}&sword=${sword}"> > </a>
         </c:if>
         <c:if test="${page == chong}">
          <a href="#"> > </a>
         </c:if>
       <!-- 1페이지 단위 다음 이동 끝 --> 
        
       <!-- 10페이지 단위 다음 이동 시작-->
         <c:if test="${pend != chong}">
          <a href="list?page=${pend+1}&sel=${sel}&sword=${sword}"> >> </a>
         </c:if>
         <c:if test="${pend == chong}">
          <a href="#"> >> </a>
         </c:if>
       <!-- 10페이지 단위 다음 이동 끝 -->
      </td>
    </tr>  
  </table>
</body>
</html>








