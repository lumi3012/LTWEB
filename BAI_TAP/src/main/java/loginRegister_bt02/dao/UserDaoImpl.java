package loginRegister_bt02.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import loginRegister_bt02.connect.DBConnect;
import loginRegister_bt02.model.User;

public class UserDaoImpl implements UserDao {
	
	@Override
	public boolean register(User user) {
		String sql = "INSERT INTO Users(username, fullname, password, phone, roleid, email) VALUES(?, ?, ?, ?, ?, ?)";
		try (Connection conn = new DBConnect().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getFullname());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getPhone());
			ps.setInt(5, user.getRoleid());
			ps.setString(6, user.getEmail());
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public User login(String username, String password) {
		String sql = "SELECT * FROM Users WHERE username=? AND password=?";
		try (Connection conn = new DBConnect().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new User(
						rs.getInt("id"),
						rs.getString("username"),
						rs.getString("fullname"),
						rs.getString("password"),
						rs.getString("phone"),
						rs.getInt("roleid"),
						rs.getString("email")				
				);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
