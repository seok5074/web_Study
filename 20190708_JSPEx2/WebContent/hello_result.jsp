<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	//HelloAction에서 request binding시킨 데이터를 읽어오기
	String name = (String)request.getAttribute("name");
%>
<!-- 디자인 영역 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

HelloAciton(hello.do)로부터 forward된 page입니다.
<hr>
<%-- <%= name %>님 안녕하세요!! --%>
${ requestScope.name} 님 안녕하세요!
</body>
</html>