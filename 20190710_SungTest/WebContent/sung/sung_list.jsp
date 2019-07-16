<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<link rel="stylesheet"  href="../css/main.css">
  
<script type="text/javascript">
	
	function sung_del(no){
	    
		if(confirm('정말 삭제하시겠습니까?')==false)return;
		
		//삭제
		location.href = "delete.do?no=" + no; // SungDeleteAction
		
	}
	
</script>  
  
</head>
<body>
	
	<div id="main_box">
	    <h1>::::성적관리::::</h1> 
	    
	    <div style="text-align: right; margin-bottom: 10px; margin-right: 40px;">
	       <input class="btn-primary" type="button" value="성적추가"
	              onclick="location.href='insert_form.do';">
	    </div>
	    
		<table  class="table">
			<!-- title -->
			<tr class="success">
				<th>번호</th>
				<th>이름</th>
				<th>국어</th>
				<th>영어</th>
				<th>수학</th>
				<th>총점</th>
				<th>평균</th>
				<th>등수</th>
				<th>편집</th>
			</tr>
			
			<!-- data -->
			<!--      for(SungVo sung : list) 동일         -->
			<c:forEach var="sung"  items="${ requestScope.list }">
				<tr>
					<td>${ sung.no }</td>
					<td>${ sung.name }</td>
					<td>${ sung.kor }</td>
					<td>${ sung.eng }</td>
					<td>${ sung.mat }</td>
					<td>${ sung.tot }</td>
					<td>${ sung.avg }</td>
					<td>${ sung.rank }</td>
					<td>
						<input class="btn-success" type="button"  value="수정"
						       onclick="location.href='modify_form.do?no=${ sung.no }'" >
						<input class="btn-success" type="button"  value="삭제"
						       onclick="sung_del('${ sung.no }');" 
						>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>


</body>
</html>