package loginRegister_bt02.connect;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	private final String serverName = "LUMI3012";
	private final String dbName = "LTWEB";
	private final String portNumber = "1433";
	private final String instance = "SQLEXPRESS01";
	private final String userID = "sa";
	private final String password = "Lumi010205#";

	public Connection getConnection() throws Exception {
		String url = "jdbc:sqlserver://" + serverName + "\\" + instance + ":" + portNumber + ";encrypt=true;trustServerCertificate=true;databaseName=" + dbName;
		if (instance == null || instance.trim().isEmpty())
			url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";encrypt=true;trustServerCertificate=true;databaseName=" + dbName;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url, userID, password);
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(new DBConnect().getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
