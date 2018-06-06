package ac.yongin.cs.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import ac.yongin.cs.common.JDBCUtil;
import ac.yongin.cs.user.vo.UserVO;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	public UserVO getUser(UserVO vo) {
		String sql = "select * from users where id=? and password=?";
		UserVO user = null;
		System.out.println("==> JDBC로 getUser() : " + sql);
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,  vo.getId());
			stmt.setString(2,  vo.getPassword());
			rs = stmt.executeQuery();
			if(rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt);
		}
		return user;
	}
}
