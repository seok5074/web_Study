<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	/*
		EL(Express Language):표현언어
		1.JSP에서 사용
		2.형식 :${ 상수 또는 수식 또는 객체 }
			   ${ 값				   }
		3.EL에서 표현할 수 있는값
		1)상수
		2)각 Scope에 기록된 값
			(pageScope,requestScope,sessionScope,applicationScope)
		3)parameter변수 : hello.do?name=홍길동
					  ${ param.name }
	*/

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- /Test_EL1.jsp?name= -->
[${ param.name }] 님 EL를 사용하신걸 환영
</body>
</html>