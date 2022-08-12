<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>

/* var size = 1;

	function add_file(){
		
		size++;
		
		var outer = document.getElementById("outer");
		var inner = "<p class='fname'><input type='file' name='fname"+size+"'></p>";
		
		outer.innerHTML = outer.innerHTML + inner;
	}
	
	function del_file(){
		
		if(size > 1){
			
			document.getElementsByClassName("fname")[size-1].remove();
			size--;
		}
	} */
	
	function add_file(){
		
		var outer = document.getElementById("outer");
		var fname = document.getElementsByClassName("fname");
		var len = fname.length;
		len++;
		var inner = "<p class='fname'><input type='file' name='fname"+len+"'></p>";
		// $("#outer").html($("#outer").html()+inner);
		
		outer.innerHTML = outer.innerHTML + inner;
	}
	
	function del_file(){
		
		var len = document.getElementsByClassName("fname").length;
	
	
		if(len > 1){
			
			document.getElementsByClassName("fname")[len-1].remove();
			len--;
		}
	}
</script>
</head>
<body>

	<form method="post" action="write_ok" enctype="multipart/form-data">	
	<table width="900" align="center">	
	<caption> <h2>글 작 성</h2></caption>	
	<tr>
	<td>제목</td>
	<td><input type="text" name="title"></td>
	</tr>	
	<tr>
	<td>내용</td>
	<td><textarea rows="6" cols="80" name="content"></textarea> </td>
	</tr>		
	<tr>	
	<td>파일</td>
	<td id="outer">
	<input type="button" onclick="add_file()" value="추가">
	<input type="button" onclick="del_file()" value="삭제">	
	<p class="fname"><input type="file" name="fname1"></p>		
	</td>
	</tr>				
	<tr>
	<td colspan="2"><input type="submit" value="저장"></td>
	</tr>
	</table>
	
	
	</form>


</body>
</html>