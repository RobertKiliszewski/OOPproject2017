package ie.gmit.sw.Client;

public class UserInterface{
	//variables
	boolean running = true;
	
	public UserInterface(){
	}//Interface Constructor
	
	public boolean isRunning(){
		return running;
	}//isRunning
	
	public void userMenu(){
		//Menu
		System.out.println("\nPlease Select 1-4");
		System.out.println("\t1. Connect to Server");
		System.out.println("\t2. Print File Listing");
		System.out.println("\t3. Download File");
		System.out.println("\t4. Quit");
	}//Menu
	
	public void quit(boolean confirmation){
		this.running = confirmation;
	}//quit
}//UserInterface Class