package loginRegister_bt02.service;
import loginRegister_bt02.model.User;

public interface UserService {
	boolean register(User user);
	User login(String username, String password);
	//User get(String username);
}
