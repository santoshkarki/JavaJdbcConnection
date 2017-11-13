
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcConnection {

	public static void main(String[] args) {
		try{
			
			//Define Driver class
			Class.forName("com.mysql.jdbc.Driver");
			
			//Define required parameters
			String url= "jdbc:mysql://localhost:3306/jdbcmysql";
			String userName = "root";
			String password = "root";
			
			//Create connection using the parameters
			Connection con = DriverManager.getConnection(url, userName, password);
			System.out.println("Connection Created");
			
			//create statement and execute query
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from emp");
			System.out.println("Query executed");
			
			while(rs.next())  
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
				con.close();
			
		} catch(Exception e){ System.out.println(e);} 

	}

	
	/*
	create database jdbcmysql;  
	use jdbcmysql;  
	create table emp(id int(10),name varchar(40),age int(3));
	insert into emp (id,name,age) value(3,"Mike",35);
	*/
}
