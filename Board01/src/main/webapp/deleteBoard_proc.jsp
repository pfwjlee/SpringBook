<%@ page import="ac.yongin.cs.board.dao.BoardDao" %>
<%@ page import="ac.yongin.cs.board.dao.BoardDaoImpl" %>
<%@ page import="ac.yongin.cs.board.vo.BoardVO" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
	String seq = request.getParameter("seq");
		
	BoardVO vo = new BoardVO();
	vo.setSeq(Integer.parseInt(seq));
	
	BoardDao dao = new BoardDaoImpl();
	dao.deleteBoard(vo);
	
	response.sendRedirect("getBoardList.jsp");
%>