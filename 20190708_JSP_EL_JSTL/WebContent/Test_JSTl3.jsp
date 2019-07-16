<%@page import="java.util.ArrayList"%>
<%@page import="jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator"%>
<%@page import="vo.PersonVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% 
	List<PersonVo> p_list = new ArrayList<PersonVo>();

	p_list.add(new PersonVo("길동1",31,"010-111-1111"));
	p_list.add(new PersonVo("길동2",32,"010-111-1112"));
	p_list.add(new PersonVo("길동3",33,"010-111-1113"));
	p_list.add(new PersonVo("길동4",34,"010-111-1114"));
	p_list.add(new PersonVo("길동5",35,"010-111-1115"));
	
	//JSTL + EL 이용하려고
	//							key   value
	pageContext.setAttribute("p_list",p_list);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1" width="400">
	<!-- 타이틀 -->
	<tr>
		<th>순번</th>
		<th>이름</th>
		<th>나이</th>
		<th>전화</th>
	</tr>
	<!-- 데이터 -->
	<!-- varStatus ="i" <= 순서를 관리하는 객체
						<= 반복시의 index관리 =>i.index
	 -->
	<c:forEach var="p" items="${ p_list }" varStatus="i">
		<tr>
			<td>${ i.index +1 }</td>
			<td>${ p.name }</td>
			<td>${ p.age  }</td>
			<td>${ p.tel  }</td>
		</tr>
	</c:forEach>
	
</table>

</body>
</html>