<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.bit2020.guestbook01.dao.Guestbook01Dao"%>
<%@page import="com.bit2020.guestbook01.vo.GuestBook01Vo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<GuestBook01Vo> list = new Guestbook01Dao().findAll();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="add.jsp" method="post">
		<table border=1 width=500>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
				<td>비밀번호</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan=4><textarea name="message" cols=60 rows=5></textarea></td>
			</tr>
			<tr>
				<td colspan=4 align=right><input type="submit" VALUE="등록 "></td>
			</tr>
		</table>
	</form>
	<%
		int count = list.size();
	int index = 0;
	for (GuestBook01Vo vo : list) {
	%>
	<br>
	<table width=510 border=1>
		<tr>
			<td><%=count - index++%></td>
			<td><%=vo.getName()%></td>
			<td><%=vo.getReg_date()%></td>
			<td><a href="deleteform.jsp?no=<%= vo.getNo()%>">삭제</a></td>
		</tr>
		<tr>
			<td colspan=4><%=vo.getMessage().replaceAll("\n", "<br>")%></td>
		</tr>
	</table>
	<%
		}
	%>
</body>
</html>
