package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class TestJdbc {

	public static void main(String[] args) throws SQLException {


		String jdbcUrl="jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
		String user="hbstudent";
		String pass="hbstudent";
		Connection mycon=null;
		
		try {
			System.out.println("Connecting to Database: "+jdbcUrl);
			mycon=DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println(mycon);
			System.out.println("Connection succesful");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			mycon.close();
		}

	}

}
