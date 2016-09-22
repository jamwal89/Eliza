import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.sql.PreparedStatement;



	public class ElizaDB {
		

	ResultSet rs = null;
	PreparedStatement pstmt;


	
	
	public HashMap<String,String> rm;
	
	public  ElizaDB(){
		
	rm = new HashMap<String,String>();
	rm.put("i", "you");
	rm.put("am", "are");
	rm.put("my", "your");
	rm.put("me","you");
	}
	
	
	
	public String Hedge( Connection con) throws ClassNotFoundException {
		String Hedge="";
		try {
			
			
		pstmt=con.prepareStatement("Select * from (SELECT * FROM   Eliza  ORDER BY DBMS_RANDOM.RANDOM) WHERE  rownum=1");
		
		rs=pstmt.executeQuery();
		
		
		while (rs.next()){
			
			 Hedge=rs.getString("Hedge");
		
		}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Hedge;

	}

	
	public String Qualifier( Connection con){
		String Qualifier="";
		try {
			pstmt=con.prepareStatement("Select * from (SELECT * FROM   Eliza  ORDER BY DBMS_RANDOM.RANDOM) WHERE  rownum=1");
		
		rs=pstmt.executeQuery();
		
		while(rs.next()){
			 Qualifier=rs.getString("Qualifier");
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return Qualifier;
	}
	
	
	
	
	public  String Replace( String answer) {
		String response=" ";
		String ans="";
		String [] word= answer.split(" ");
		for (int i=0; i<word.length;i++ ){
				for(String value: rm.keySet()){
					if(word[i].equalsIgnoreCase(value)) {
						word[i]=rm.get(value);
						
				}
				}
				response=response+" "+word[i];	
				
		}
		
		
		return response;
	}
	
	
	
	
	
	
	 public String UserResponse(String x, Connection con) throws ClassNotFoundException {
		  String res="";

		  System.out.println("Hello,How may I help you");
		  Scanner scan= new Scanner(System.in);
		  String answer = scan.nextLine();
		 while  (!answer.equalsIgnoreCase("quit")){
		
		 
		 
				Random rn = new Random();
				int index = 1+ rn.nextInt(2);
				if(index==1){
					res=Replace(answer);
				
					System.out.println(Qualifier(con)+res);
				}
				else {
					System.out.println(Hedge(con));
				}
		  answer = scan.nextLine();
		 }
		 
		 
		  if (answer.equalsIgnoreCase("quit")){
			 	
				 System.out.println("Bye Bye");
		 }
		 
		  return res;
	  }
}