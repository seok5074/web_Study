<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
   table{
   	  width: 800px;
   }
   th{
   	  background-color: #333333;
   	  color: white;
   }
   td{
   	  text-align: center;
   }
</style>
</head>
<body>
	<table border="1">
		<caption><h2>구구단 출력해보기</h2></caption>
<%
		for(int i=0;i<=9;i++){
			out.write("<tr>");
			for(int dan=2;dan<=9;dan++){
				if(i==0){//타이틀 출력
					out.write("<th>");
					out.write(String.format("%d 단", dan));
					out.write("</th>");
				}else{//내용출력	
					out.write("<th>");
					out.write(String.format("%2d x %2d = %2d", dan,i,dan*i));
					out.write("</th>");
				}//end-if
			}//end-for(dan)
			out.write("</tr>");
		}//end-for(i)
%>		
	</table>
</body>
</html>