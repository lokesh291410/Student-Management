package CRUDapplication;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	static Connection con;
	public static Connection createDB() {
		try {
			String url = "jdbc:mysql://localhost:3306/DB";
			String username = "root";
			String password = "meninblack291410@";
			
			con = DriverManager.getConnection(url, username, password);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return con;
	}
}
