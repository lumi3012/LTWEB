package loginRegister_bt02.service;
import loginRegister_bt02.dao.UserDao;
import loginRegister_bt02.dao.UserDaoImpl;
import loginRegister_bt02.model.User;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao = new UserDaoImpl();
	
	@Override
	public boolean register(User user) {
		return userDao.register(user);
	}
	
	@Override
	public User login(String username, String password) {
		return userDao.login(username, password);
	}
}
