package loginRegister_bt02.dao;
import loginRegister_bt02.model.User;

public interface UserDao {
	
	boolean register(User user);
	
	User findByUserName(String username);
	
	User login(String username, String password);
	
	void insert(User user);
	
	boolean checkExistEmail(String email);
	
	boolean checkExistUsername(String username);
	
	boolean checkExistPhone(String phone);
	
	User findByEmail(String email);
}
