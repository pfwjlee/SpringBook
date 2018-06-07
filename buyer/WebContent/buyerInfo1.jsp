<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.fruit.service.FruitService" %>
<%@ page import="com.fruit.dao.FruitDAO" %>
<%@ page import="com.fruit.vo.BuyerVO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h2>과일 판매 사이트 - 바이어정보</h2>
<hr>
<%
	String bid = request.getParameter("bid");
	System.out.println("====" + bid + "====<br>");
	FruitDAO dao = new FruitDAO();
	BuyerVO bvo = dao.getBuyerInfo(bid);
%>
바이어 ID : <%= bvo.getId() %><br>
바이어 머니 : <%= bvo.getMoney() %><br>
바이어 ID : <%= bvo.getAppleCount() %><br>
</div>
</body>
</html>