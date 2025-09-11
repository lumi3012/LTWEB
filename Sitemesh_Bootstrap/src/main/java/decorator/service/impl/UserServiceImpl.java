package decorator.service.impl;

import decorator.dao.UserDao;
import decorator.dao.impl.UserDaoImpl;
import decorator.entity.User;
import decorator.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();
	
	@Override
	public User login(String username, String password) {
		return userDao.findByUsernameAndPassword(username, password);
	}
	
	@Override
    public boolean register(User user) {
        if (userDao.existByUsername(user.getUsername())) return false;
        if (userDao.existByEmail(user.getEmail())) return false;

        // Hash mật khẩu trước khi lưu
        //String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12));
        //user.setPassword(hashed);

        userDao.insert(user);
        return true;
    }
	
	@Override
    public boolean existByUsername(String username) {
		return userDao.existByUsername(username);
    }

    private Object findByUsernameAndPassword(String username, String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
    public boolean existByEmail(String email) {
        return userDao.existByEmail(email);
    }
    
	@Override
	public User findById(int id) {
		return userDao.findById(id);
	}
}
