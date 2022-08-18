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
       <td> ${bvo.title} </td>
     </tr>
     <tr>
       <td> 아이디 </td>
       <td> ${bvo.userid} </td>
     </tr>
     <tr>
       <td> 조회수 </td>
       <td> ${bvo.readnum} </td>
     </tr>
     <tr>
       <td> 작성일 </td>
       <td> ${bvo.writeday} </td>
     </tr>
     <tr>
       <td> 내용 </td>
       <td> ${bvo.content} </td>
     </tr>
     <tr>
       <td colspan="2" align="center">
         <a href="update?id=${bvo.id}"> 수정 </a>
         <a href="javascript:del_view()"> 삭제 </a>
        <a href="list"> 목록 </a>
       </td>
     </tr>
     <tr id="del" style="display:none;"> <!-- 삭제폼 -->
       <td colspan="2" align="center">
         <form method="post" action="delete">
          <input type="hidden" name="id" value="${bvo.id}">
          <input type="password" name="pwd">
          <input type="submit" value="삭제">
         </form>
       </td>
     </tr>
   </table>
   <script>
     function del_view()
     {
    	 document.getElementById("del").style.display="table-row";
     }
   </script>
   
</body>
</html>


