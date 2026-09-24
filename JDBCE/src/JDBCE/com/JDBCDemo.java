package JDBCE.com;
import java.sql.*;
public class JDBCDemo {
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("register driver");
		
		String url="jdbc:mysql://localhost:3306/pavan";
		String uname = "root";
		
		String pwd = "root";
		Connection con = DriverManager.getConnection(url,uname,pwd);
		
		System.out.println("establish connection");
		Statement stmt = con.createStatement();
		
		System.out.println("Statement create successfully");
		String qry = "create table hello(did int,dname varchar(20))";
		
		stmt.execute(qry);
		System.out.println("table created successfully");
		
		stmt.close();
		con.close();
	}
}
