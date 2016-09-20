import java.util.HashMap;

public class ElizaApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interaction ic= new Interaction();
		Thread b= new Session(ic);
		Thread a= new InterruptEliza();
	
		b.start();
		a.start();
		
	}
}