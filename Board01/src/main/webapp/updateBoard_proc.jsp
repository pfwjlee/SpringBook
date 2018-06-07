<%@ page import="ac.yongin.cs.board.dao.BoardDao" %>
<%@ page import="ac.yongin.cs.board.dao.BoardDaoImpl" %>
<%@ page import="ac.yongin.cs.board.vo.BoardVO" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
	String title = request.getParameter("title");
	String seq = request.getParameter("seq");
	String content = request.getParameter("content");
	
	BoardVO vo = new BoardVO();
	vo.setTitle(title);
	vo.setSeq(Integer.parseInt(seq));
	vo.setContent(content);
	
	BoardDao dao = new BoardDaoImpl();
	dao.updateBoard(vo);
	
	response.sendRedirect("getBoardList.jsp");
%>