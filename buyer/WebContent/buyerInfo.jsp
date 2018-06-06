<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.sql.*" %>
<%
	Connection conn=null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String bid = request.getParameter("bid");
	String url = "jdbc:mysql://localhost:3306/fruit";
	String id = "root";
	String pw = "cs1234";
	
	Class.forName("com.mysql.jdbc.Driver");
	conn = DriverManager.getConnection(url,id,pw);
	if(conn != null) {
		out.print("Connection Success!!");
	}
	String sql = "select * from buyer where id=?";
//	id, pass, money, apple_count
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, bid);
	rs = pstmt.executeQuery();
	if(rs.next()) {
		out.print("<br>");
		out.print("id : " + rs.getString(1) + ","+ rs.getString(3) +","+ rs.getString(4));
	}
	rs.close();
	pstmt.close();
	conn.close();
	
%>
</body>
</html>