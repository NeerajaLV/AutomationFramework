package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBCExecuteUpdatePractice {

	public static void main(String[] args) throws SQLException {
		Driver driverref=new Driver();
		//register driver
		DriverManager.registerDriver(driverref);
		//establish connection
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdb", "root", "Mysql@123");
		//create statement
		Statement state=con.createStatement();
		//execute
		int result = state.executeUpdate("insert into candidate_info(name,id) values('Chaithra','304')");
		if(result==1) {
			System.out.println("Data updated");
		}
		ResultSet result1=state.executeQuery("select * from candidate_info");
		while(result1.next()) {
			System.out.println(result1.getString(1)+"|"+result1.getInt(2)+"|"+result1.getString(3));
		}
		//close
		con.close();
	}

}
