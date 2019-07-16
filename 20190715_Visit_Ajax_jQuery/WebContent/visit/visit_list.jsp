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

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<script type="text/javascript">
	function del(f){
		//var pwd = f.pwd.value;//원래 비밀번호
		var c_pwd = f.c_pwd.value.trim(); //내가 입력한 비밀번호
		var idx   = f.idx.value;//hidden 으로 숨겨놓은 idx
		//전역변수로 idx저장
		
		if(c_pwd==''){
			alert("삭제게시물에 비밀번호 입력");
			f.c_pwd.value="";
			f.c_pwd.focus();
			return;
		}
		//jQuery이용한 Ajax요청
		$.ajax({
			url 	: 'check_pwd.do',
			data	: { 'idx': idx, 'c_pwd': c_pwd }, //<=전송데이터(parameter)
			dataType: 'json',                         //<=수신타입
			success	: function(res_data){
				// var p = {"name":"일길동","age":"30","addr":"서울시 관악 신림"};
				// 
		        // res_data = {"result","yes"};    
				if(res_data.result=='no'){
					alert('비밀번호가 틀립니다');
					return;
				}
				//삭제확인
				if(confirm('정말삭제하시겠습니까?')==false)return;
				
				//삭제
				location.href="delete.do?idx=" + idx;
			}
		});
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
		//jQuery이용한 Ajax요청
		$.ajax({
			url 	: 'check_pwd.do',
			data	: { 'idx': idx, 'c_pwd': c_pwd }, //<=전송데이터(parameter)
			dataType: 'json',                         //<=수신타입
			success	: function(res_data){
				// var p = {"name":"일길동","age":"30","addr":"서울시 관악 신림"};
				// 
		        // res_data = {"result","yes"};    
				if(res_data.result=='no'){
					alert('비밀번호가 틀립니다');
					return;
				}
				//삭제확인
				if(confirm('정말수정하시겠습니까?')==false)return;
				
				//삭제
				location.href="modify_form.do?idx=" + idx;
			}
		});
		
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
							<input type="button" value="수정" onclick="modify(this.form);">
							<input type="button" value="삭제" onclick="del(this.form);">
						</div>
					</div>
				</form>
			</c:forEach>
		</div>
	</div>

</body>
</html>