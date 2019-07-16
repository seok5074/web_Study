<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
	request.setCharacterEncoding("utf-8");
 	String name =request.getParameter("name");
	String id =request.getParameter("id");
	String pwd =request.getParameter("pwd");
	String gender =request.getParameter("gender");
	String [] hobby_array=request.getParameterValues("hobby");
	String hobby_list="취미없음";
	if(hobby_array !=null) { //null 아니라는건 취미가 있을경우
		StringBuffer sb = new StringBuffer();
		for(String hobby: hobby_array) {
			sb.append(hobby);
			sb.append(" ");
		}
		hobby_list=sb.toString();
	} 

		String [] friend_array = request.getParameterValues("friend");
		//String [] friend_array={"개똥이","말자","홀리"};
		String friend_list="";
		
		StringBuffer sb1 = new StringBuffer();

		for(String friend : friend_array) {
				sb1.append(friend);
				sb1.append(" ");
		}
		friend_list =sb1.toString().trim();//값이 없을경우 공백이 3개들어왔다. trim을 사용 공백도 없어짐  
		if(friend_list.isEmpty())
			friend_list="친구없음";
		
		String blood =request.getParameter("blood");
		String profile =request.getParameter("profile");
		response.setCharacterEncoding("text/html;charset=utf-8;");
	%>
	<!-- 화면출력logic -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet'  href='css/table.css'>

</head>
<body>
	<table border='1'>
	<caption>::입력정보::</caption>
	<tr>
	<th>이름</th>
	<td><%= name %></td>
	</tr>
	<tr>
	<th>아이디</th>
	<td><%= id %></td>
	</tr>
	<tr>
	<th>비밀번호</th>
	<td><%= pwd %></td>
	</tr>
	<tr>
	<th>성별</th>
	<td><%= gender %></td>
	</tr>
	<tr>
	<th>취미</th>
	<td><%= hobby_list %></td>
	</tr>
	<tr>
	<th>친구</th>
	<td><%= friend_list %></td>
	</tr>
	<tr>
	<th>혈액형</th>
	<td><%= blood %></td>
	</tr>
	<tr>
	<th>자기소개</th>
	<td><%= profile %></td>
	</tr>
	</table>
	<a href="member_register_form.html">다시하기</a>
	
</body>
</html>