import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Interaction {

	public HashMap<Integer,String> HedgeSet ;
	public HashMap<String,String> rm;
	public HashMap<Integer,String> qf;



	public Interaction() {


		HedgeSet= new HashMap<Integer,String>();
		rm = new HashMap<String,String>();
		qf = new HashMap<Integer,String>();


		HedgeSet.put(1, "Please tell me more");
		HedgeSet.put(2, "Many of my patients tell me the same thing");
		HedgeSet.put(3,"It is getting late, maybe we better quit");

		rm.put("i", "you");
		rm.put("am", "are");
		rm.put("my", "your");
		rm.put("me","you");


		qf.put(1,"Why do you say that");
		qf.put(2, "you seem to think that");
		qf.put(3, "your concern is ");


	}
	public String Intro ( HashMap<Integer,String>  map) {
		String value=null;
		Random rn = new Random();
		int index = 1+ rn.nextInt(map.size());
		value= map.get(index);
	//	System.out.println(value);
		return value;
	}
	
	public  String Replace( String answer) {
		String response=" ";
		String ans="";
		String [] word= answer.split("-");
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
	
  public String UserResponse(String x) {
	  String res="";
	  boolean response=false;
	  System.out.println("Hello");
	  Scanner scan= new Scanner(System.in);
	  String answer = scan.next();
	 if  (!answer.equalsIgnoreCase("q")){
		response =true;
	 
	 while(response){
			Random rn = new Random();
			int index = 1+ rn.nextInt(2);
			if(index==1){
	  res=Replace(answer);
	  System.out.println(Intro(qf)+res);
			}
			else {
				System.out.println(Intro(HedgeSet));
			}
	  answer = scan.next();
	 }
	 
	 }
	 else {
		 
			 System.out.println("Bye Bye");
	 }
	 
	  return res;
  }
  
		
		
		
		
		
	}