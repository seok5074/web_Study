<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- contentType : 전송인코딩  -->

<%! 
	//선언부	
	//클래스의 멤버변수/메소드로 등록
	int count=0;
	int plus(int a, int b){
		return a+b;
	}
	
	%>
	

<%
	//jsp 내장겍체(jsp->servlet코드로 변환시 존재하는 객체)
	//_jspService(request, response) method 기록된다.

	//scriptlet : java code 작성할수있다.
	String ip =request.getRemoteAddr(); //요청자 ip
	count++;
	
%>  
    <!-- html 작성하기위 한 최적화 코드이다. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP연습</title>
</head>
<body>
<h1>[<%= ip %>]안녕 JSP야!(<%= count %>번째 방문자)</h1>
<%
	int a=10,b=5;
	int res =plus(a,b);
	String result =String.format("%d + %d = %d<br>", a, b,res);
	out.print(result);
%>
<%-- <%= result %>  => out.print(result); 로 변환이된다.--%>

</body>
</html>