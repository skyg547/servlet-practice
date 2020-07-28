<%@page import="com.bit2020.guestbook01.dao.Guestbook01Dao"%>
<%@page import="com.bit2020.guestbook01.vo.GuestBook01Vo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String firstName = request.getParameter("fn");
	String lastName = request.getParameter("ln");
	String email = request.getParameter("email");
	
	GuestBook01Vo vo = new GuestBook01Vo();
	vo.setFirstName(firstName);
	vo.setLastName(lastName);
	vo.setEmail(email);
	
	new Guestbook01Dao().insert(vo);
	
	response.sendRedirect("index.jsp");
%>