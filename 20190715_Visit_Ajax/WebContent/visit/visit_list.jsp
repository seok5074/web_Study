<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/main.css">
<!-- ajax 추가 -->
<script type="text/javascript" src="../js/httpRequest.js"></script>

<script type="text/javascript">

	var g_idx;
	function del(f){
		//var pwd = f.pwd.value;//원래 비밀번호
		var c_pwd = f.c_pwd.value.trim(); //내가 입력한 비밀번호
		var idx   = f.idx.value;//hidden 으로 숨겨놓은 idx
		//전역변수로 idx저장
		g_idx= idx;
		
		if(c_pwd==''){
			alert("삭제게시물에 비밀번호 입력");
			f.c_pwd.value="";
			f.c_pwd.focus();
			return;
		}
		//Ajax요청
		//		CheckPwdAction servlet
		var url= "check_pwd.do"; //check_pwd.do?idx=10&c_pwd=1234
		var param= "idx="+idx+"&c_pwd="+ c_pwd;
		
		sendRequest(url,param,resultFn_Del,"GET");
	}
	
	//삭제 비번결과를 Callback(자동호출)받을 함수
	function resultFn_Del(){
		if(xhr.readyState==4 && xhr.status==200){
			var data = xhr.responseText;
			//alert(data);
			//	    012345678910123
			//data='i am a boy no '
			
			//if(data=='no'){ //data ="no\n" -> "no\n"=="no"
			if(data.indexOf('no') != -1){
				alert("비밀번호가 틀립니다.");
				return ;
			}
			if(confirm('정말삭제하')==false)return;
			//삭제
			location.href="delete.do?idx="+g_idx;
		}
	}
	function modify(f){
		var c_pwd = f.c_pwd.value.trim(); //내가 입력한 비밀번호
		var idx   = f.idx.value;//hidden 으로 숨겨놓은 idx
		if(c_pwd==''){
			alert("수정게시물에 비밀번호 입력");
			f.c_pwd.value="";
			f.c_pwd.focus();
			return;
		}
		//var pwd = f.pwd.value;//원래 비밀번호
		var c_pwd = f.c_pwd.value.trim(); //내가 입력한 비밀번호
		var idx   = f.idx.value;//hidden 으로 숨겨놓은 idx
		//전역변수로 idx저장
		g_idx= idx;
		
		if(c_pwd==''){
			alert("수정게시물에 비밀번호 입력");
			f.c_pwd.value="";
			f.c_pwd.focus();
			return;
		}
		//Ajax요청
		//		CheckPwdAction servlet
		var url= "check_pwd.do"; //check_pwd.do?idx=10&c_pwd=1234
		var param= "idx="+idx+"&c_pwd="+ c_pwd;
		
		sendRequest(url,param,resultFn_Del,"GET");
	}
	
	//삭제 비번결과를 Callback(자동호출)받을 함수
	function resultFn_Del(){
		if(xhr.readyState==4 && xhr.status==200){
			var data = xhr.responseText;
			//alert(data);
			//	    012345678910123
			//data='i am a boy no '
			
			//if(data=='no'){ //data ="no\n" -> "no\n"=="no"
			if(data.indexOf('no') != -1){
				alert("비밀번호가 틀립니다.");
				return ;
			}
			if(confirm('정말수정')==false)return;
			//삭제
			location.href="modify_form.do?idx="+g_idx;
		}
		//수정폼 띄우로가기
		/* f.action ="modify_form.do"; //VisitModifyAciont
		f.submit(); */
		//자바스크립트 location객체를 이용해서 호출
		//location.href="modify_form.do?idx="+ f.idx.value;
	}
</script>
</head>
<body>
	<div id="main_box">
		<h1 id="title">:::방명록 리스트:::</h1>
		<div style="text-align: right;">
			<input type="button" value="방명록 쓰기"
				onclick="location.href='insert_form.do'">
		</div>
		<hr>
		<div>
			<!-- 내용이 없으면 -->
			<c:if test="${ empty list }">
				<div>작성된 내용이 없습니다.</div>
			</c:if>
			<!-- 내용채우기 -->
			<!-- for(Visit visit : list 동일 -->
			<c:forEach var="visit" items="${ list }">
				<form>
				<!-- hiddentag 감춰진 form parameter -->
					<input type="hidden" name="idx" value="${ visit.idx }">
					
					<div class="visit_type">
						<div class="content_type">${ visit.content }</div>
						<div class="name_type">
							<span>작 성 자 :</span> ${ visit.name } (${ visit.ip })
						</div>
						<div class="regdate_type">
							<span>작성일자 :</span> ${ visit.regdate }
						</div>
						<div>
							<span>비밀번호:</span> <input type="password" name="c_pwd">(${ visit.pwd })
							<input type="button"  value="수정" onclick="modify(this.form);">
							<input	type="button" value="삭제" onclick="del(this.form);">
						</div>
					</div>
				</form>
			</c:forEach>
		</div>
	</div>

</body>
</html>