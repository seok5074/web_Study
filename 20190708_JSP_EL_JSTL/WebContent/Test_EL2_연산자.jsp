<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
EL 산술연산자 : + - * / %
<hr>
\${ 2 + 3 } : ${ 2 + 3 }<br>
\${ 2 - 3 } : ${ 2 - 3 }<br>
\${ 2 * 3 } : ${ 2 * 3 }<br>
\${ 10 / 3 } : ${ 10 / 3 }  <%-- or ${ 10 div 3 } --%><br>
\${ 10 % 3 } : ${ 10 % 3 }  or ${ 10 mod 3 }<br>

<hr>
EL 관계연산자 :<!--  >(gt) >=(ge) <(lt) <= =(동일) != -->
<hr>
\${ 3 > 2 } : ${ 3 > 2 } or ${ 3 gt 2 }<br>
\${ 3 >= 2 } : ${ 3 >= 2 } or ${ 3 ge 2 }<br>
\${ 3 < 2 } : ${ 3 <= 2 } or ${ 3 lt 2 }<br>
\${ 3 <= 2 } : ${ 3 <= 2 } or ${ 3 le 2 }<br>
\${ 3 == 2 } : ${ 3 == 2 } or ${ 3 eq 2 }<br>
\${ 3 != 2 } : ${ 3 != 2 } <%-- or ${ 3 ne 2 } --%><br>
<hr>
EL 논리 연산자 : &&(and) ||(or) !(not)
<hr>
\${ true && true } : ${ true && true } or ${ true and true }<br>
\${ true || false } : ${ true || false } or ${ true or false }<br>
\${ !(3>2) } : ${ !(3>2) } or ${ not(3>2) }<br>

<hr>
EL 3항연산자 : empty(비어있냐?)
<hr>
\${ empty param.name ? '아무게' : param.name} : ${ empty param.name ? '아무게' : param.name}<br>

</body>
</html>