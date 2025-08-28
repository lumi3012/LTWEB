package loginRegister_bt02.dao;
import loginRegister_bt02.model.User;

public interface UserDao {
	boolean register(User user);
	User login(String username, String password);
}
