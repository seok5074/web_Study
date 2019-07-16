<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

    var regular_jumsu = /^[0-9]{3}$/;

    //무효성체크(틀렸냐?)
    function invalid_check100(jumsu){
    	
    	return (regular_jumsu.test(jumsu)==false) || (jumsu < 0) || (jumsu>100) ;
    }
    
    
    
	function send(f){
		
		//입력값 체크...
		var name = f.name.value.trim();
		var kor  = f.kor.value.trim();
		var eng  = f.eng.value.trim();
		var mat  = f.mat.value.trim();
		
		
		if(name==''){
			alert('이름을 입력하세요!!');
			f.name.value='';
			f.name.focus();
			return;
		}
		//국어/영어/수학 : 0~100사이의 숫자 체크
		if(invalid_check100(kor)==true){
			alert("0~100사이의 정수만 입력하세요!!");
			f.kor.value='';
			f.kor.focus();
			return;
		}
		
		if(invalid_check100(eng)==true){
			alert("0~100사이의 정수만 입력하세요!!");
			f.eng.value='';
			f.eng.focus();
			return;
		}
		
		if(invalid_check100(mat)==true){
			alert("0~100사이의 정수만 입력하세요!!");
			f.mat.value='';
			f.mat.focus();
			return;
		}
		
		
			
		//전송
		f.action='insert.do';
		f.submit();//전송
	}

</script>

</head>
<body>

<div>
	<form>
		<table border="1" align="center">
		    <caption>::::성적입력::::</caption>
			<tr>
				<th>이름</th>
				<td><input name="name"></td>
			</tr>
			<tr>
				<th>국어</th>
				<td><input name="kor"></td>
			</tr>
			<tr>
				<th>영어</th>
				<td><input name="eng"></td>
			</tr>
			<tr>
				<th>수학</th>
				<td><input name="mat"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				    <input type="button"  value="등록하기"  
				           onclick="send(this.form);" >
				           
				    <input type="button"  value="목록보기"  
				           onclick="location.href='list.do'" >
				</td>
			</tr>
		</table>
	</form>
</div>

</body>
</html>