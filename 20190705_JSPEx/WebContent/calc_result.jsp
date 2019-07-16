<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%	//request.response 
	/*{
		여기에 기록
	  }
	*/
	//20190705_JSPEx/calc_result.jsp?su1=1&su2=2
	//무조건 string으로 들어온다.
	String str_su1 =request.getParameter("su1");
	String str_su2 =request.getParameter("su2");
	
	//string ->int 변환
	int su1 =Integer.parseInt(str_su1); //su1 = 1
	int su2 =Integer.parseInt(str_su2); //su2 = 2 
%>
<!-- 위쪽코드 : business logic : data처리하는 로직 -->

<!-- ##################################################### -->

<!-- 아래쪽코드 : presentatioin logic : 화면 출력 로직 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	div{
		width:200px;
		height:200px;
		border:2px solid blue;
		box-shadow: 2px 2px 2px black; 
		padding: 50px;
	}
</style>
</head>
<body>
<h1>연산결과</h1>
<div>
	<%= su1 %> + <%= su2 %> = <%= (su1+su2) %><br>
	<%= su1 %> - <%= su2 %> = <%= (su1-su2) %><br>
	<%= su1 %> * <%= su2 %> = <%= (su1*su2) %><br>
	<%= su1 %> / <%= su2 %> = <%= (su2==0? 0 : su1/su2) %><br>
	<%= su1 %> % <%= su2 %> = <%= (su2==0? 0 : su1%su2) %><br>
</div>
<a href="calc.html">다시하기</a>
</body>
</html>