<%@ page import="ac.yongin.cs.user.dao.UserDao" %>
<%@ page import="ac.yongin.cs.user.dao.UserDaoImpl" %>
<%@ page import="ac.yongin.cs.user.vo.UserVO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	UserVO vo = new UserVO();
	vo.setId(id);
	vo.setPassword(password);
	
	UserDao dao = new UserDaoImpl();
	UserVO user = dao.getUser(vo);
	
	if(user != null) {
		response.sendRedirect("getBoardList.jsp");
	}
	else {
		response.sendRedirect("login.jsp");
	}
%>
