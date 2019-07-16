<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	// 20190705_JSPEx/gugudan_test.jsp?dan=6
	// 20190705_JSPEx/gugudan_test.jsp	    => str_dan=null		
	// 20190705_JSPEx/gugudan_test.jsp?dan= => str_dan=" "
	int dan = 2;
	String str_dan = request.getParameter("dan");
	//값이 정상대로 들어왔으면...문자열->정수로 변환해라
	if (str_dan != null && str_dan.isEmpty()) {
		dan = Integer.parseInt(str_dan);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" width=100>
		<tr>
			<th><%= dan %>단 보기</th>
		</tr>
		<% 
			for(int i=1;i<=9;i++){
			
		%>
			<tr>
				<td><%= String.format("%2d X %2d = %2d", dan, i,dan*i) %>
			</tr>
		<%
			}//end -for
		%>
	</table>

</body>
</html>