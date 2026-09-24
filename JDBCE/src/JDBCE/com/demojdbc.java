package JDBCE.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class demojdbc {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("register driver");
		
		String url="jdbc:mysql://localhost:3306/pavan";
		String uname="root";
		String pwd="root";
		
		Connection con = DriverManager.getConnection(url,uname,pwd);
		System.out.println("Database connection successfully");
		
		Statement stmt = con.createStatement();
		System.out.println("statement create successfully");
		
		String qry = "select * from department";
		
		ResultSet res = stmt.executeQuery(qry);
		
		while(res.next()) {
		System.out.println(res.getInt("dept_id")+" "+res.getString("dept_name")+" "+res.getString("location"));
		}
		
		stmt.close();
		con.close();
		
		
	}

}
