
public class Session extends Thread{
	Interaction ic;
	
	Session (Interaction ic){
		this.ic=ic;
	}
	
	public void run() {
		ic.UserResponse("Hello");
	}

}
