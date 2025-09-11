package decorator.service;

import decorator.entity.User;

public interface UserService {
	User login(String username, String password);
	User findById(int id);
	boolean register(User user);
    boolean existByUsername(String username);
    boolean existByEmail(String email);
}
