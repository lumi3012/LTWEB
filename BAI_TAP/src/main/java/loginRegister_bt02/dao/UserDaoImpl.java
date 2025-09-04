package loginRegister_bt02.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import loginRegister_bt02.connect.DBConnect;
import loginRegister_bt02.model.User;

public class UserDaoImpl implements UserDao {
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
    public User findByUserName(String username) {
        String sql = "SELECT * FROM Users WHERE username = ?";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
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
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }

	@Override
	public void insert(User user) {
	    String sql = "INSERT INTO Users(username, fullname, password, phone, roleid, email) VALUES (?, ?, ?, ?, ?, ?)";
	    try (Connection conn1 = new DBConnect().getConnection();
	         PreparedStatement ps1 = conn1.prepareStatement(sql)) {

	        ps1.setString(1, user.getUsername());
	        ps1.setString(2, user.getFullname());
	        ps1.setString(3, user.getPassword());
	        ps1.setString(4, user.getPhone());
	        ps1.setInt(5, user.getRoleid());
	        ps1.setString(6, user.getEmail());

	        int rows = ps1.executeUpdate();
	        if (rows == 0) {
	            System.err.println("⚠️ Insert thất bại, không có dòng nào được thêm vào DB.");
	        } else {
	            System.out.println("✅ Insert thành công: " + rows + " row(s) affected.");
	        }
	    } catch (Exception e) {
	        System.err.println("❌ Lỗi khi insert User: " + e.getMessage());
	        e.printStackTrace();
	    }
	}


    @Override
    public boolean checkExistEmail(String email) {
        String sql = "SELECT * FROM Users WHERE email = ?";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    @Override
    public boolean checkExistUsername(String username) {
        String sql = "SELECT * FROM Users WHERE username = ?";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    @Override
    public boolean checkExistPhone(String phone) {
        String sql = "SELECT * FROM Users WHERE phone = ?";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, phone);
            rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }
	@Override
	public boolean register(User user) {
		String sql = "INSERT INTO Users(username, fullname, password, phone, roleid, email) VALUES(?, ?, ?, ?, ?, ?)";
		try {
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
		try {
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
	
	@Override
    public User findByEmail(String email) {
        String sql = "SELECT * FROM Users WHERE email = ?";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
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
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }
}
