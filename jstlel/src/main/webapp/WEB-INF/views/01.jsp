<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>값 받아보기</h1>
	${ival }
	<br> ${lval }
	<br> ${fval }
	<br> ${bval }
	<br> ${sval }
	<br>
	<h1>산술연산</h1>


	${3+10*20 }
	<br> ${ival+20 }
	<br>

	<h1>곤꼐연산</h1>
	${ival == 10 }
	<br> ${ival < 10 }
	<br> ${object == null }
	<br> ${vo != 10 }
	<br> ${not empty obj }
	<br>

	</h1>
	논리연산
	<h1>
	
	${ival + 10 == 10 || lval <1234567891 }<br>
	${ival + 10 == 10 && lval <1234567891 }<br>
	
	<h1>요청 파라미터</h1>
	
	${param.
	a }
</body>
</html>