package com.fruit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fruit.vo.BuyerVO;

public class fruitDAO {
	private final String BUYER_INFO = "select * from buyer where id=?";
	private final String BUYER_MONEY_REG = "update buyer set money=money+? where id=?";
	private final String GET_APPLE_PRICE = "select applePrice from seller where id=?";
	private final String BUYER_BUY_FRUIT = 
	"update buyer set money=money-?*?, appleCount=appleCount+? where id=?";
	private final String SELLER_SELL_FRUIT = 
	"update seller set money=money+?*applePrice,appleCount=appleCount-? where id=?";

//	private static fruitDAO dao = new fruitDAO();
//	private fruitDAO() {};
	
//	public static fruitDAO getInstance() {
//		return dao;
//	}
	
	public Connection connect() {
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bootboard", "root", "cs1234");
		} catch (Exception e) {
			System.out.println("오류발생 : " + e);
			// TODO: handle exception
		} 
		return conn;
	}
	
	public void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (Exception e) {
				System.out.println("오류발생 : " + e);
			}
		}
		if(ps!=null) {
			try {
				ps.close();
			} catch (Exception e) {
				System.out.println("오류발생 : " + e);
			}
		}
		if(conn !=null) {
			try {
				conn.close();
			} catch (Exception e) {
				System.out.println("오류발생 : " + e);
			}
		}
	}

	public void close(Connection conn, PreparedStatement ps) {
		if(ps!=null) {
			try {
				ps.close();
			} catch (Exception e) {
				System.out.println("오류발생 : " + e);
			}
		}
		if(conn !=null) {
			try {
				conn.close();
			} catch (Exception e) {
				System.out.println("오류발생 : " + e);
			}
		}
	}
	
	public BuyerVO getBuyerInfo(String id) {
		BuyerVO bvo = null;
		Connection conn = null;
		PreparedStatement pstmt;
		try {
			conn = connect();
			pstmt = conn.prepareStatement(BUYER_INFO);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				// BuyerVO bvo = new BuyerVO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				bvo = new BuyerVO();
				bvo.setId(rs.getString(1));
				bvo.setPass(rs.getString(2));
				bvo.setMoney(rs.getInt(3));
				bvo.setAppleCount(rs.getInt(4));
			}
			close(conn, pstmt, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bvo;
	}
	public void regBuyerMoney(String id, int money) {
		BuyerVO bvo = null;
		Connection conn = null;
		PreparedStatement pstmt;
		try {
			conn = connect();
			pstmt = conn.prepareStatement(BUYER_MONEY_REG);
			pstmt.setInt(1, money);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
			close(conn, pstmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
