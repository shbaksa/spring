<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <!-- pro_write.jsp : 상품 입력 폼 -->
    <style>
    li{
    	list-style-type: none;
    }
    </style>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script>
    			// 중분류 구할때는 대분류 코드만 가져오면 된다
    	function getJung(daecode){// <- 대분류 코드
    		
    		var chk = new XMLHttpRequest();
    		chk.open("get","getJung?daecode="+daecode);
    		chk.send();
    		
    		chk.onreadystatechange = function(){
    			
    			if(chk.readyState == 4){
    				
    				//alert(chk.responseText);
    				
    				document.inpro.jung.innerHTML=decodeURI(chk.responseText.trim());
    				
    				
    			}
    		}
    	}
    			// 소분류 코드 구할때는 대분류 중분류 코드를 다가져와야한다
    	function getSo(daejung){ // <- 중분류코드
    		
    		var daecode = document.inpro.dae.value; // 대분류 코드
    		//alert(daejung+daecode);
    		
    		var chk = new XMLHttpRequest();
    		chk.open("get","getSo?daejung="+daecode+daejung);
    		chk.send();
    		
    		chk.onreadystatechange = function(){
    			
    			if(chk.readyState == 4){
    				
    				//alert(chk.responseText);
    				
    				document.inpro.so.innerHTML=decodeURI(chk.responseText.trim());
    			}
    		}
    	}
 
    	$(function(){

    		$("select[name=so]").blur(function(){
    			
    			var daecode = $("select[name=dae]").val();
    			var jung = $("select[name=jung]").val();
    			var so = $("select[name=so]").val();
    			
    			$("input[name=pcode]").val("p"+daecode+jung+so);
    		})
    		
    	});
    </script>
    
    
    <form method="post" name="inpro">
    <table width="600" align="center">
    	<caption><h2>상품 등록</h2></caption>
    	
    	<tr>
    	<td>상품 코드</td>
    	<td><input type="text" name="pcode"></td>
    	<td><!-- 대,중,소-->
    		<select name="dae" onchange="getJung(this.value)">
    				<option> 선택 </option>
    			<c:forEach items="${list}" var="dvo">
    				<option value="${dvo.code}">${dvo.title}</option>    			
    			</c:forEach>
    			
    		</select>
    		
    		<select name="jung" onchange="getSo(this.value)">
    			
    		</select>
    		
    		<select name="so">
    			
    		</select>
    	</td>
    	<td></td>
    </table>
    </form>
    
    
    <!-- 
    	<select>
    	
    	option 태그의 길이 => length
    	option 태그에 나타낼 글자 => text
    	option 태그에 값을 서버로 => value
    	
    	</select>
    
    
    	dae 01 농산물
    		02 수산물
    		03 축산물
    		04 가공품
    
     -->