<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
function del_add(n,my){
	
	if(my.checked)
		document.getElementsByClassName("cimg")[n].style.opacity="0.3";
	else
		document.getElementsByClassName("cimg")[n].style.opacity="1.0";
}

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

function imgCheck(upform){
	
	var imgDel = document.getElementsByName("imgDel");
	var len = imgDel.length;
	var del = ""; // 삭제파일
	var str = ""; // 유지파일
	
	for(i=0;i<len;i++){
		
		if(imgDel[i].checked)
			del = del + imgDel[i].value + ",";
		else
			str = str + imgDel[i].value + ",";
		
	}
	
	upform.del.value=del;
	upform.str.value=str;
	//alert("del : "+del+"str : "+str);
	
	return true;
	
}

</script>
</head>
<body>

	<form method="post" action="update_ok" enctype="multipart/form-data" onsubmit="return imgCheck(this)">	
	<input type="hidden" value="${tdto.id}" name="id">
	<input type="hidden" name="str">
	<input type="hidden" name="del">
	<table width="900" align="center">	
	<caption> <h2>글 작 성</h2></caption>	
	<tr>
	<td>제목</td>
	<td><input type="text" name="title" value="${tdto.title}"></td>
	</tr>	
	<tr>
	<td>내용</td>
	<td><textarea rows="6" cols="80" name="content">${tdto.content}</textarea> </td>
	</tr>	
	<tr>
	<td>사진</td>
	<td>
	<c:set var="i" value="0"/>
	
	<c:forEach items="${tdto.temp}" var="img">
	
	<input type="checkbox" onclick="del_add(${i},this)" name="imgDel" value="${img}">
	<img src="resources/img/${img}" class="cimg" name="imgChk" width="50" height="50">
	
	<c:set var="i" value="${i+1}"/>
	</c:forEach><p>
	<span style="color:blue;font-size:10px;">삭제하고싶은 사진을 체크하세요</span>
	
	
	</td>
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
	<td colspan="2"><input type="submit" value="수정"></td>
	</tr>
	</table>
	
	
	</form>

</body>
</html>