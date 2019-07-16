<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function send(f) {
		var name 	=f.name.value.trim();
		var content =f.content.value.trim();
		var pwd	 	=f.pwd.value.trim();
		if(name==''){
			alert('이름입력');
			f.name.value="";
			f.name.focus();
			return;
		}
		if(content==''){
			alert('내용입력');
			f.content.value="";
			f.content.focus();
			return;
		}
		if(pwd==''){
			alert('비밀번호입력');
			f.pwd.value="";
			f.pwd.focus();
			return;
		}
		
	    f.action="modify.do"; //VisitModifyAciton 으로 전송
		f.submit();				//전송 
		
	}
</script>
</head>
<body>
	<form>
		<input type="hidden" name="idx" value="${ vo.idx }">
		<table border="1" align='center'>
			<caption>:::방명록수정:::</caption>
			<tr>
				<th>이름</th>
				<td><input name="name" value="${ vo.name }"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content" rows="5" cols="50">${ vo.content }</textarea></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pwd" value="${ vo.pwd }"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="button"
					value="수정하기" onclick="send(this.form);"> <input
					type="button" value="목록보기" onclick="location.href='list.do'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>