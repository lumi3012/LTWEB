package loginRegister_bt02.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable {
	private int id;
	private String username;
	private String fullname;
	private String password;
	private String phone;
	private int roleid;
	private String email;
	

	public User() {}
	
	public User(int id, String username, String fullname, String password, String phone, int roleid, String email) {
		this.id = id;
		this.username = username;
		this.fullname = fullname;
		this.password = password;
		this.phone = phone;
		this.roleid = roleid;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	
	
}
