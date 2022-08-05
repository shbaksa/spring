<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <table width="700" align="center">
     <tr>
       <td> 제 목 </td>
       <td> ${bdto.title} </td>
     </tr>
     <tr>
       <td> 이름 </td>
       <td> ${bdto.name} </td>
     </tr>
     <tr>
       <td> 조회수 </td>
       <td> ${bdto.readnum} </td>
     </tr>
     <tr>
       <td> 작성일 </td>
       <td> ${bdto.writeday} </td>
     </tr>
     <tr>
       <td> 내용 </td>
       <td> ${bdto.content} </td>
     </tr>
     <tr>
       <td colspan="2" align="center">
         <a href="update?id=${bdto.id}"> 수정 </a>
         <a href="delete?id=${bdto.id}"> 삭제 </a>
        <a href="list"> 목록 </a>
     
       </td>
     </tr>
   </table>
</body>
</html>


