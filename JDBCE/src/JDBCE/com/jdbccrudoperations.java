package JDBCE.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbccrudoperations {
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
			
			//after creating the table
			String qry = "Insert into hello values(1,'Pavan')";
			stmt.executeUpdate(qry);
			System.out.println("Data inserted successfully");
			
			//Inserting multiple records
			
			stmt.executeUpdate("Insert into hello values(2,'Ram')");
			stmt.executeUpdate("Insert into hello values(3,'Kiran')");
//			
//			//Display data — SELECT
//			
		String qry1 = "SELECT * FROM hello";
//
			ResultSet rs = stmt.executeQuery(qry1);
//
			while (rs.next()) {
			    System.out.println(rs.getInt("did") + " " + rs.getString("dname"));
			}
//			
//			//Update Data
			String qry2="Update hello set dname='Rahul' where did=2";
			stmt.executeUpdate(qry2);
			System.out.println("Data updated successfully");
//			
//		
		String qry3 = "Delete from hello where did=3";
		stmt.executeUpdate(qry3);
//		
		System.out.println("Data deleted successfully");
	}
}


