<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	<form method="post" action="write_ok">
	<input type="hidden" name="pcnt" value="${pvo.pcnt}">
	<input type="hidden" name="sel" value="${pvo.sel}">
	<input type="hidden" name="sword" value="${pvo.sword}">
	<input type="hidden" name="page" value="${pvo.page}">
	<table width="900" align="center">
	<tr>
	<td>제목</td>
	<td><input type="text" name="title"></td>
	</tr>
	<tr>
	<td>이름</td>
	<td><input type="text" name="name"></td>
	</tr>
	<tr>
	<td>비밀번호</td>
	<td><input type="password" name="pwd"></td><td></td>
	</tr>
	<tr>
	<td>내용</td>
	<td><textarea rows="6" cols="80" name="content"></textarea> </td>
	</tr>
	<tr>
	<td colspan="2"><input type="submit" value="글작성"></td>
	</tr>

	</table>
</form>



</body>
</html>