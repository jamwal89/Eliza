import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.sql.Connection;
import java.sql.DriverManager;

public class ElizaApp {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		//Interaction ic= new Interaction();
		
		ElizaDB db= new ElizaDB();
		Connection con = null;
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:ora1/ora1@localhost:1521:orcl");
		db.UserResponse("hi", con);

		
		
		
		
		
		
		
		
	//	Thread b= new Session(ic);  Thread created for Eliza to interrupt the conversation
	//	Thread a= new InterruptEliza();
//		b.start();
	//	a.start();
		
		
		
	}
}