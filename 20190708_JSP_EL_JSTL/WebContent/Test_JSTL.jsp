<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTL 을 사용하려면 -->
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	/*
		JSTL(JSP Standard Tag Libary)
		: 기존 자바명령을 Tag형식의 간결한 명령으로 생성해놓은 라이브러리
		
		1.Core Library : 제어문(forEach,if,choose....)
		2.Fmt  Library : 날짜,숫자형식에 관련(날짜:2019년07월09일)
		3.Fn   Library : substring
		
	*/
	int money =123000000;
	Date today = new Date();
	//				  01234567890123456789012
	String str_date= "2019-07-09 10:56:50.005";
	
	System.out.println(str_date.substring(0,16));
	
	//JSTL내에서 표현되는 데이터는 EL형식을 쓴다.
	//EL형식을 사용할려면 Scope에 넣어야한다.
	pageContext.setAttribute("money", money);
	pageContext.setAttribute("today", today);
	pageContext.setAttribute("str_date", str_date);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- for와 동일 
	var="i"란 변수는 pagaScope에 저장된다.
	 -->
	<c:forEach var ="i" begin="1" end="5" step="1">
					<!-- pageScope 생략해도된다. -->
			<!-- i 짝수시 -->
		<c:if test="${ i mod 2 eq 0 }">		
			<font color=red><p>${ i }:안녕</p></font>
		</c:if>
		<!-- i 홀수시 -->
		<c:if test="${ i%2 eq 1 }">	
			<font color=aqua><p>${ i }:안녕</p></font>
		</c:if>
	</c:forEach>
	
	<hr>
	현재 소유한 현금:<fmt:formatNumber value="${ money }"/><br>
	현재 날짜 :<fmt:formatDate value="${ today }" pattern="YYYY년MM월dd일 HH:mm:ss"/><br>
	오늘 날짜 :${ str_date }<br>
	오늘 날짜 :${ fn:substring(str_date,0,10) }<br>
	
</body>
</html>





