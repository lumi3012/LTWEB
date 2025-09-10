package validator.services;

import validator.dao.UserDao;
import validator.dao.impl.UserDaoImpl;
import validator.entity.User;

public class UserServiceImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();
	
	@Override
	public User login(String username, String password) {
		return userDao.findByUsernameAndPassword(username, password);
	}
	
	@Override
	public User findById(int id) {
		return userDao.findById(id);
	}
}
