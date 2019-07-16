<%@page import="service.DBService"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" width='600'>
		<tr>
			<th>사원번호</th>
			<th>사원명</th>
			<th>직위</th>
			<th>부서번호</th>
			<th>성별</th>
			<th>입사일자</th>
			<th>상사번호</th>
			<th>연봉</th>
		</tr>
		<c:forEach var="sawon" items="${ requestScope.list }">
			<tr>
				<td>${ sawon.sabun  }</td>
				<td>${ sawon.saname }</td>
				<td>${ sawon.sajob  }</td>
				<td>${ sawon.deptno }</td>
				<td>${ sawon.sasex  }</td>
				<td>${ sawon.sahire }</td>
				<td>${ sawon.samgr  }</td>
				<td>${ sawon.sapay  }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>