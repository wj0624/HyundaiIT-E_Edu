package step5;

import java.sql.Connection;
import java.sql.DriverManager;

public class NaverConnectionMaker implements ConnectionMaker{
	@Override
	public Connection getConnection() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String id = "root";
		String pw = "test1234";
		String JDBC_URL = "jdbc:mysql://localhost:3306/library?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
		Connection con = DriverManager.getConnection(JDBC_URL, id, pw);
		return con;
	}
}
