<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>	<!-- update.jsp -->

	<form method="post" action="update_ok">
	<input type="hidden" name="id" value="${bdto.id}">
		<table width="700" align="center">
			<caption>
				<h2>글 수 정</h2>
			</caption>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" value="${bdto.title}"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="${bdto.name}"></td>
			</tr>
		
			<tr>
				<td>내용</td>
				<td><textarea rows="6" cols="80" name="content">${bdto.content}</textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="글수정"></td>
			</tr>
		</table>
	</form>
	
</body>
</html>