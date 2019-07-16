<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="vo.PersonVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
 <% 
 	PersonVo p =new PersonVo("홍길동",30,"010-1111-1111");
 
 	//EL표현
 	pageContext.setAttribute("p", p);
 	
 	Map<String,String> map = new HashMap<String,String>();
 	//			key		 value
 	map.put("driver","oracle.jdbc.driver.OracleDriver");
 	map.put("url","jdbc:oracle:thin:@localhost:1521:xe");
 	map.put("user","scott");
 	map.put("pwd","tiger");
 	
 	//scope영역에는 자바의 모든객체를 저장
 	pageContext.setAttribute("map", map);
 	
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
이름 : ${ pageScope.p.name }<br>
나이 : ${ p.age }<br>
전화 : ${ p.tel }<br>
<hr>
Map정보 EL로 출력
<hr>
<!-- 		영역이름.객체명(map).KEY		 -->
driver:	 ${ pageScope.map.driver }<br>
url   :	 ${ map.url }<br>
user  :  ${ map['user'] }<br>
pwd   :  ${ map['pwd'] }<br>

</body>
</html>