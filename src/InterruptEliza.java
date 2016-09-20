import java.util.HashMap;
import java.util.Random;

public class InterruptEliza extends Thread{
	
	public HashMap<Integer,String> InterruptSet;
//	
//	public InterruptEliza(){
//		InterruptSet= new HashMap<Integer,String>();
//		InterruptSet.put(1, "Hey Hang  on , I got a call");
//		InterruptSet.put(2, "wait , we gotta take a break");
//		InterruptSet.put(3, "Ok , I am done");
//	
//		
//	}
	
	
	public void run () {
		
			for (int i=0; i<100;i++){
		
		InterruptSet= new HashMap<Integer,String>();
		InterruptSet.put(1, "Hey Hang  on , I got a call");
		InterruptSet.put(2, "wait , we gotta take a break");
		InterruptSet.put(3, "Ok , I am done");
		
		String value=null;
		Random rn = new Random();
		int index = 1+ rn.nextInt(InterruptSet.size());
		value= InterruptSet.get(index);
		System.out.println(value);
		
		try {
			this.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
}
	


