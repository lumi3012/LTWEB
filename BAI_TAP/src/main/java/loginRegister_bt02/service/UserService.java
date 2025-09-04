package loginRegister_bt02.service;
import loginRegister_bt02.model.User;

public interface UserService {
	
	User login(String username, String password);
    void insert(User user);
    boolean register(User user);
    boolean checkExistEmail(String email);
    boolean checkExistUsername(String username);
    boolean checkExistPhone(String phone);
    
    User findByEmail(String email);
}
