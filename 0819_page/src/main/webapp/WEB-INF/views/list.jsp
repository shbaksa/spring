<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script>
	function move(my) {

		location = "list?pcnt=" +my.value+"&sel=${sel}&sword=${sword}";
	}
	
	/* function move1(my){
		
		if(my.value != 0)
		location = "list?pcnt=${pcnt}&sword=${sword}&page=${page}&sel="+my.value;
		
			
	} 
 */
	window.onload = function() {

		document.getElementById("pkc").value = "${pcnt}";

		document.cho.sel.value="${sel}";
	}
	
	function check(my){
		
		/* var chk = my.sel.value;
		
		if(chk == 0 ){
			
			alert("X");
			return false;
		}
		else if (my.sword.trim()==""){
			
			alert("빈칸");
			return false;
		}
		else			
			return true;
		 */
			
		if(  my.sel.selectedIndex != 0 && my.sword.value.trim().length != 0  )
			return true;
		else
			return false;
	}
	
	
	
</script>
<style>
#pcntRight {
	float: right;
}
#search{
	float:left;
}
a {
	text-decoration:none;
	color:black;
}

</style>
</head>
<body>

	<div style="text-align: center">
		<b> 시작페이지 : ${pstart} // 마지막페이지 : ${pend} // 총페이지 : ${chong} //
			현재페이지 : ${page} </b>

	</div><br>

	<table width="900" align="center">
		<caption><b style="font-size:36px">게 시 판</b><br>
		<div id="search">
		
		<form method="post" name="cho" action="list" onsubmit="return check(this)">	
		<input type="hidden" name="page" value="${page}">
		<input type="hidden" name="pcnt" value="${pcnt}">
			<!-- <select id="chk" name="sel" onchange="move1(this)"> -->
			<select id="chk" name="sel" >
				<option value="0">선택</option>
				<option value="title">제목</option>
				<option value="content">내용</option>
				<option value="name">이름</option>
			</select>
			<input type="text" name="sword" placeholder="검색어 입력" value="${sword}">
			<input type="submit" value="검색">
			<c:if test="${sel != '0'}">
			<input type="button" onclick="location='list?page=1'" value="초기화">
			</c:if>
		</form>
		</div>
		
		

			<div id="pcntRight">

				<select id="pkc" onchange="move(this)">
					<option value="10">10</option>
					<option value="20">20</option>
					<option value="30">30</option>
					<option value="50">50</option>
				</select>

			</div>

		</caption>
		<tr>
			<td>제목</td>
			<td>이름</td>
			<td>조회수</td>
			<td>작성일</td>
		</tr>
		<c:forEach items="${list}" var="pvo">
			<tr>
				<td><a href="readnum?id=${pvo.id}&page=${page}&pcnt=${pcnt}&sel=${sel}&sword=${sword}">${pvo.title}</a></td>
				<td>${pvo.name}</td>
				<td>${pvo.readnum}</td>
				<td>${pvo.writeday}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="4" align="center">
		
		
				<c:if test="${page!=0 && page>1 }">
					<a href="list?page=1&pcnt=${pcnt}&sel=${sel}&sword=${sword}">처음</a>
				</c:if> 
				<c:if test="${pstart != 1 }">
					<a href="list?page=${pstart-1}&pcnt=${pcnt}&sel=${sel}&sword=${sword}">10쪽</a>
				</c:if> 
				<c:if test="${page != 1 }">
					<a href="list?page=${page-1}&pcnt=${pcnt}&sel=${sel}&sword=${sword}"> ← </a>		
				</c:if> 
			
				<c:forEach var="i" begin="${pstart}" end="${pend}">
				
					<c:if test="${page==i}">
						<c:set var="str" value="style='color:red;'"/>
					</c:if>
					<c:if test="${page!=i}">
						<c:set var="str" value=""/>
					</c:if>
					<a ${str} href = "list?page=${i}&pcnt=${pcnt}&sel=${sel}&sword=${sword}">${i}</a>

				</c:forEach> 
				
				<c:if test="${ page != chong }">
					<a href="list?page=${page+1}&pcnt=${pcnt}&sel=${sel}&sword=${sword}"> → </a>
				</c:if> 
				<c:if test="${ pend != chong }">
					<a href="list?page=${pend+1}&pcnt=${pcnt}&sel=${sel}&sword=${sword}">10쪽</a>
				</c:if>
				 <c:if test="${ page < chong }">
					<a href="list?page=${chong}&pcnt=${pcnt}&sel=${sel}&sword=${sword}">마지막</a>
				</c:if>
				
			</td>
		</tr>

	<tr>
	<td colspan="4"><a href="write?page=${page}&pcnt=${pcnt}&sel=${sel}&sword=${sword}">글작성</a></td>
	</tr>
	

	</table>


</body>
</html>