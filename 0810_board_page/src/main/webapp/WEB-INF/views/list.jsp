<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
a {
	text-decoration: none;
	color: black;
}

a:hover {
	text-decoration: underline;
}

table {
	border-collapse: collapse;
}

table th {
	height: 30px;
	border-bottom: 1px solid black;
}

table td {
	height: 30px;
	border-bottom: 1px solid black;
	text-align: center;
	border-bottom: 1px solid black;
}

li {
	display: inline;
	list-style-type: none;
	width: 35px;
	border-left: 1px solid #cccccc;
}
</style>

<script>
	function move(my) {
		location = "list?pcnt=" + my.value + "&sel=${sel}&sword=${sword}" ;
	}
	function move1(my){
		location = "list?sel=" + my.value + "&pcnt=${pcnt}&sword=${sword}&page=${page}" ;
	}
	

	window.onload = function() {

		document.getElementById("pkc").value = "${pcnt}";
		
		// 검색필드를 보여주기
		document.getElementById("sel").value = "${sel}";
	}
	
	function check(my){
		// select 태그에서 첫번째 option태그는 X , sword입력칸은 값이 비어있으면 안된다.
		
		var chk = my.sel.value;
		var ck = my.sel.selectedIndex;
		
		if(chk == 0){
			alert("X");
			return false;
		}
		else if(my.sword.value.trim() == ""){
			alert("빈칸");
			return false;
		}
		else
			return true;
		
	}
</script>
</head>
<body>

	<div style="text-align: center">
		<b> 시작페이지 : ${pstart} // 마지막페이지 : ${pend} // 총페이지 : ${chong} //
			현재페이지 : ${page} </b>
			<b> <a href="test">테스트하기</a></b>
	</div>
	<table width="900" align="center">
		<caption>
			<h2>

				<div id="left" style="float:left">
					<form method="post" action="list?sel=${sel}&pcnt=${pcnt}&page=${page}" onsubmit="return check(this)">
						<select name="sel" id="sel" onchange="move1(this)">
							<option value="0">선택</option>
							<option value="title">제목</option>
							<option value="content">내용</option>
							<option value="name">작성자</option>
						</select> <input type="text" name="sword" size="10" value="${sword}"> <input
							type="submit" value="검색">
					</form>
				</div>



				<div id="right" style="float:right">
					<select id="pkc" onchange="move(this)">
						<option value="10">10</option>
						<option value="20">20</option>
						<option value="30">30</option>
						<option value="50">50</option>
					</select>
				</div>
			</h2>
		</caption>
		<tr>
			<th>제목</th>
			<th>이름</th>
			<th>조회수</th>
			<th>작성일</th>
		</tr>
		<c:forEach items="${list}" var="bdto">
			<tr>
				<td style="text-align: left">${bdto.title }</td>
				<td>${bdto.name }</td>
				<td>${bdto.readnum }</td>
				<td>${bdto.writeday }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="4" align="center"
				style="border-left: none; border-right: none; border-bottom: none;"
				height="60"><c:if test="${ page != 0 && page > 1 }">
					<!-- 첫페이지로 이동 -->
					<li><a href="list?page=1&pcnt=${pcnt}&sel=${sel}&sword=${sword}">&nbsp;처음&nbsp;</a></li>
				</c:if> <c:if test="${ pstart != 1 }">
					<!-- 10페이지씩 이동 -->
					<li><a href="list?page=${pstart-1}&pcnt=${pcnt}&sel=${sel}&sword=${sword}">&nbsp;10쪽&nbsp;</a></li>
				</c:if> <c:if test="${ page != 1 }">
					<!-- 1페이지씩 이동 -->
					<li><a href="list?page=${page-1}&pcnt=${pcnt}&sel=${sel}&sword=${sword}">&nbsp;←&nbsp;</a></li>
				</c:if> <c:forEach begin="${pstart}" end="${pend}" var="i">
					<!-- 페이지 출력하기 -->

					<c:if test="${ page == i }">
						<c:set var="str" value="style='color:red;'" />
					</c:if>

					<c:if test="${ page != i }">
						<c:set var="str" value="" />
					</c:if>

					<li><a href="list?page=${i}&pcnt=${pcnt}&sel=${sel}&sword=${sword}" ${str}>&nbsp;${i}&nbsp;</a></li>

				</c:forEach> <c:if test="${ page != chong }">
					<!-- 1페이지로 이동 -->
					<li><a href="list?page=${page+1}&pcnt=${pcnt}&sel=${sel}&sword=${sword}">&nbsp;→&nbsp;</a></li>
				</c:if> <c:if test="${ chong != pend }">
					<!-- 10페이지로 이동 -->
					<li><a href="list?page=${pend+1}&pcnt=${pcnt}&sel=${sel}&sword=${sword}">&nbsp;10쪽&nbsp;</a></li>
				</c:if> <c:if test="${ page < chong }">
					<!-- 마지막페이지로 이동 -->
					<li style="border-right: 1px solid #cccccc;"><a
						href="list?page=${chong}&pcnt=${pcnt}&sel=${sel}&sword=${sword}">&nbsp;마지막&nbsp;</a></li>
				</c:if></td>
		</tr>
	</table>

</body>
</html>