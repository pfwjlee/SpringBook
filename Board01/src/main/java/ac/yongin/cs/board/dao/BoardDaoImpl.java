package ac.yongin.cs.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import ac.yongin.cs.board.vo.BoardVO;
import ac.yongin.cs.common.JDBCUtil;

@Repository("boardDAO")
public class BoardDaoImpl implements BoardDao {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	public void insertBoard(BoardVO vo) {
		String sql = "insert into board(title, writer, content) values(?, ?, ?)";
		System.out.println("==> JDBC로 insertBoard() : " + sql);
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,  vo.getTitle());
			stmt.setString(2,  vo.getWriter());
			stmt.setString(3,  vo.getContent());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt);
		}
	}
	
	public void updateBoard(BoardVO vo) {
		String sql = "update board set title=?, content=? where seq=?";
		System.out.println("==> JDBC로 updateBoard() : " + sql);
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,  vo.getTitle());
			stmt.setString(2,  vo.getContent());
			stmt.setInt(3,  vo.getSeq());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt);
		}
	}

	public void deleteBoard(BoardVO vo) {
		String sql = "delete from board where seq=?";
		System.out.println("==> JDBC로 deleteBoard() : " + sql);
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,  vo.getSeq());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt);
		}
	}

	public BoardVO getBoard(BoardVO vo) {
		String sql = "select * from board where seq=?";
		BoardVO board = null;
		System.out.println("==> JDBC로 getBoard() : " + sql);
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,  vo.getSeq());
			rs = stmt.executeQuery();
			if(rs.next()) {
				board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt);
		}
		return board;
	}

	public List<BoardVO> getBoardList(BoardVO vo) {
		String sql = "select * from board";
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		System.out.println("==> JDBC로 getBoardList() : " + sql);
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
				boardList.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt);
		}
		return boardList;
	}

	
}
