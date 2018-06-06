package ac.yongin.cs.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac.yongin.cs.user.dao.UserDao;
import ac.yongin.cs.user.vo.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public UserVO getUser(UserVO vo) {
		return userDao.getUser(vo);
	}

}
