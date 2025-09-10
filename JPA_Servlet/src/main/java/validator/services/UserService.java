package validator.services;

import validator.entity.User;

public interface UserService {
	User login(String username, String password);
	User findById(int id);
}
