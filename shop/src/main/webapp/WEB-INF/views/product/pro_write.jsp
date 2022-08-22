<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <script>
   function getjung(daecode)
   {
	   var chk=new XMLHttpRequest();
	   chk.open("get","getjung?daecode="+daecode);
	   chk.send();
	   chk.onreadystatechange=function()
	   {
		   if(chk.readyState==4)
		   {
		      // alert(chk.responseText);
		      document.inpro.jung.innerHTML=decodeURI(chk.responseText.trim());
		   }
	   }
   }
   function getso(jung)
   {
	   var dae=document.inpro.dae.value;
	   var daejung=dae+jung;
	   //alert(daejung);
	   var chk=new XMLHttpRequest();
	   chk.open("get","getso?daejung="+daejung);
	   chk.send();
	   chk.onreadystatechange=function()
	   {
		   if(chk.readyState==4)
		   {
		      //alert(chk.responseText);
			   document.inpro.so.innerHTML=decodeURI(chk.responseText.trim());
		   }
	   }
   }
 </script>
</head>
<body>  <!-- pro_write.jsp : 상품 입력 폼 -->
  <form name="inpro">
   <table width="600" align="center">
     <caption> <h2>상품 등록 </h2> </caption>
     <tr>
       <td> 상품 코드 </td>
       <td> <input type="text" name="pcode"> </td>
       <td> <!-- 대,중,소 -->
         <select name="dae" onchange="getjung(this.value)">
          <option> 선택 </option>
          <c:forEach items="${list}" var="dvo">
            <option value="${dvo.code}"> ${dvo.title} </option>
          </c:forEach>
         </select>
         <select name="jung" onchange="getso(this.value)">
         
         </select>
         <select name="so">
         
         </select>
       </td>
     </tr>
   </table>
  </form>
</body>
</html>