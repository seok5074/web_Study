<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
a.jsp!!
<% 
//요청 전송 인터페이스
RequestDispatcher disp = request.getRequestDispatcher("b.jsp");

//forward(request.response)=> 현재의 request.response를 그대로 전달.
disp.forward(request, response);

%>
</body>
</html>