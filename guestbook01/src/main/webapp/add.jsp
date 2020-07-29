<%@page import="com.bit2020.guestbook01.vo.GuestBook01Vo"%>
<%@page import="com.bit2020.guestbook01.dao.Guestbook01Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

GuestBook01Vo vo = new GuestBook01Vo();
vo.setName(request.getParameter("name"));
vo.setPassword(request.getParameter("password"));
vo.setMessage(request.getParameter("message"));

new Guestbook01Dao().insert(vo);

response.sendRedirect("index.jsp");
%>