<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	Set<String> set = new HashSet<String>();
	set.add("빨강구슬");
	set.add("파랑구슬");
	set.add("녹색구슬");
	set.add("하얀구슬");
	set.add("검정구슬");
	
	//JSTL이용해서 ul tag출력해보기
	pageContext.setAttribute("set", set);

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul>
	<c:forEach var ="set" items="${ pageScope.set}">
	<li>${ set }</li>
	</c:forEach>
</ul>
</body>
</html>