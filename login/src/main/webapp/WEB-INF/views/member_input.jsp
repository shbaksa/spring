<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <script>
   function userid_check(userid)  //  this => userid(태그)  ,  this.value=>값
   {
	   if(userid.trim().length >= 6) // 요구되는 아이디의 조건을 충족할 경우
	   {
	       var chk=new XMLHttpRequest();
	       chk.open("get","userid_check?userid="+userid);
	       chk.send();
	       chk.onreadystatechange=function()
	       {
		      if(chk.readyState==4)
		      {
			      alert(chk.responseText);
		      }
	       } // 주석
	    }
	    else
	    {
	    	alert("아이디의 길이가 6자 미만입니다");	
	    }
   }
 </script>
</head>
<body> <!-- member_input.jsp -->
  <div id="member" align="center">
    <form method="post" action="member_input_ok">
      <input type="text" name="userid" placeholder="아 이 디" onblur="userid_check(this.value)"> <p>
      <input type="text" name="name" placeholder="이 름"> <p>
      <input type="text" name="pwd" placeholder="비밀번호"> <p>
      <input type="text" name="pwd1" placeholder="비밀번호확인"> <p>
      <input type="text" name="email" placeholder="이 메 일"> <p>
      <input type="text" name="phone" placeholder="전화번호"> <p>
      <input type="submit" value="회원가입">
    </form>
  </div>
</body>
</html>