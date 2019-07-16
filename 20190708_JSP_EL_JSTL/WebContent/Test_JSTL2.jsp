<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	//배열
	String [] fruit_array ={"사과","배","참외","수박"};
	// EL
	pageContext.setAttribute("fruit_array", fruit_array);
	//ArrayList
	List<String> sido_list= new ArrayList<String>();
	sido_list.add("서울");
	sido_list.add("부산");
	sido_list.add("대구");
	sido_list.add("광주");
	sido_list.add("목포");
	
	pageContext.setAttribute("sido_list", sido_list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
	JSTL이용해서 배열 출력
<hr>
	<ul>
		<!-- for(string fruit : fruit_array)와 동일 -->
		<c:forEach var="fruit" items="${ pageScope.fruit_array }">
			<li>${ fruit }</li>
		</c:forEach>
	</ul>

<hr>
	JSTL이용해서 ArrayList 출력
<hr>
	<ul>
		<c:foEach var ="sido" items="&{ pageScope.sido_list}">
		<li>  pagScopesid.sido</li>
		</c:foEach>
	</ul>

</body>
</html>