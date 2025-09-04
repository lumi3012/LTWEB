package loginRegister_bt02.service;

import loginRegister_bt02.dao.UserDao;
import loginRegister_bt02.dao.UserDaoImpl;
import loginRegister_bt02.model.User;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public User login(String username, String password) {
        User user = userDao.findByUserName(username);
        if (user != null && password.equals(user.getPassword())) {
            return user;
        }
        return null;
    }

    @Override
    public void insert(User user) {
        userDao.insert(user);
    }

    @Override
    public boolean register(User user) {
        if (userDao.checkExistUsername(user.getUsername()) || userDao.checkExistEmail(user.getEmail())) {
            return false;
        }
        userDao.insert(user);
        return true;
    }

    @Override
    public boolean checkExistEmail(String email) {
        return userDao.checkExistEmail(email);
    }

    @Override
    public boolean checkExistUsername(String username) {
        return userDao.checkExistUsername(username);
    }

    @Override
    public boolean checkExistPhone(String phone) {
        return userDao.checkExistPhone(phone);
    }
    
    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }
}
