<%-- <%@page import="service.DBService"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" width='400'>
		<!-- 타이틀  -->
		<tr>
			<th>부서번호</th>
			<th>부서명</th>
			<th>위치</th>
		</tr>
		<!-- 데이터 : 어디에 있지? requestScope.list -->
		<!-- for(DeptVo dept : list) 동일-->
		<c:forEach var="dept" items="${ requestScope.list1}">
			<tr>
				<td>${ dept.deptno }</td>
				<td>${ dept.dname }</td>
				<td>${ dept.loc }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html> --%>