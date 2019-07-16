<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//값을 El 로 출력
	String name ="홍길동";

	//위에 자바변수를 EL로 출력하려면 4개 영역중에 저장을해야한다.
	pageContext.setAttribute("name", name);
	request.setAttribute("name", "request영역에 저장된 이름");
	session.setAttribute("name", "session영역에 저장된 이름");
	application.setAttribute("name", "application영역에 저장된 이름");

	application.setAttribute("name1", "app name");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 				&{ 영역이름       .변수명} -->
pageScope :			${ pageScope.name }<br>
requestScope : 		${ requestScope.name }<br>
sessionScope : 		${ sessionScope.name }<br>
applicationScope : 	${ applicationScope.name }<br>

이표현은 어느영역이지? : ${ name1 }<br>

</body>
</html>