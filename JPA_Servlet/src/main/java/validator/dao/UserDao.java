package validator.dao;

import validator.entity.User;

public interface UserDao {
	User findByUsernameAndPassword(String username, String password);
	User findById(int id);
	User findByEmail(String email);
	void insert(User user);
	boolean existByUsername(String username);
	boolean existByEmail(String email);
}
