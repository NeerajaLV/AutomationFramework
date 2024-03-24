package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBCExecuteQueryPractice {
	public static void main(String[] args) throws SQLException {
		Driver driverref=new Driver();
		//Step-1: Register the driver/database
		DriverManager.registerDriver(driverref);
		//Step-2: Establish connection with DB
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdb", "root", "Mysql@123");
		//Step-3: Issue create statement
		Statement state=con.createStatement();
		//Step-4: Execute a query
		ResultSet result=state.executeQuery("select * from candidate_info");
		while(result.next()) {
			System.out.println(result.getString(1)+"|"+result.getInt(2)+"|"+result.getString(3));
		}
		//Step-5: Close the DB
		con.close();
}
}
