<%@page import="com.bit2020.guestbook01.dao.Guestbook01Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
request.setCharacterEncoding("utf-8");

	String no = request.getParameter("hiddenno");
	String password = request.getParameter("password"); 
	log(no);
	log(password);
	new Guestbook01Dao().delete(Long.parseLong(no), password);

	response.sendRedirect("index.jsp");
%>