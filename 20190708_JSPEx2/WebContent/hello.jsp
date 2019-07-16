<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
		//jspEx2/hello.jsp?name=홍길동
		//0순위: 수신인코딩 처리
		request.setCharacterEncoding("utf-8");
		//1.parameter수신
		String name = request.getParameter("name");
		if(name==null)
			name="아무게";
%>    
<!-- 윗쪽 :business logic -->

<!-- ======================= -->
<!-- Model-1 Pattern : business logic + presetation code -->
<!-- 아랫쪽 : presentation logic -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%= name %>님 안녕하세요.
</body>
</html>