<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <script>
   function move() 
   {
	   var name="홍길동";
	   name=encodeURI(name);
	   location="test?name="+name;
   }
   function check()
   {
	   var chk=new XMLHttpRequest();
	   chk.open("get","target");
	   chk.send();
	   chk.onreadystatechange=function()
	   {
		   if(chk.readyState==4)
		   {
			   document.getElementById("aa").innerText=decodeURI(chk.responseText);
		   }
	   }
   }
 </script>
</head> <!-- aa.jsp -->
<body>
   <a href="javascript:move()"> test로 이동 </a>
   
   <!-- ajax를 통해 한글 처리부분 테스트 -->
   <input type="button" onclick="check()" value="테스트">
   <span id="aa"></span>
</body>
</html>





