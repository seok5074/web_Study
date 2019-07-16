<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!--  gugudan_maker.jsp?dan=5 -->

<ul>
	<c:forEach var="i" begin="1" end="9">
	    <li>${ param.dan } x ${ i } = ${ param.dan * i }</li>
	</c:forEach>
</ul>



</body>
</html>