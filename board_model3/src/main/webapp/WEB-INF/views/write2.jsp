<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body> <!-- write.jsp -->
   <form method="post" action="write_ok2">
     <table width="600" align="center">
     <tr>
       <td> 제목 </td>
       <td> <input type="text" name="title" size="50"> </td>
     </tr>
     <tr>
       <td> 아이디 </td>
       <td> <input type="text" name="userid"> </td>
     </tr>
       <tr>
       <td> 비밀번호 </td>
       <td> <input type="password" name="pwd"> </td>
     </tr>
     <tr>
       <td> 내용 </td>
       <td> <textarea cols="50" rows="6" name="content"></textarea> </td>
     </tr>
     <tr>
       <td align="center" colspan="2"> <input type="submit" value="저장">  </td>
     </tr>
   </table>
   </form>
</body>
</html>