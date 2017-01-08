package ie.gmit.sw.Client;

import java.util.Scanner;
import ie.gmit.sw.Client.Configuration.*;

public class ClientRunner{
	public static void main(String[] args) throws Throwable{
		//variables
		Scanner console = new Scanner(System.in);
		int selection;
		
		//XML Configuration
		Context ctx = new Context();
		ContextParser cp = new ContextParser(ctx);
		cp.parse();
		
		//user interface object
		UserInterface UI = new UserInterface();
		
		ClientFileService clientService = new ClientFileService(ctx);
		while(UI.isRunning()){
			//Menu
			UI.userMenu();
			//UserInput
			selection = console.nextInt();
		
			switch(selection){
				case 1:
					clientService.serverConncect();
					break;
				case 2:
					clientService.requestListOfFiles();
					break;
				case 3:
					clientService.requestDownload();
					break;
				case 4:
					UI.quit(clientService.quit());
					break;
				default:
					System.out.println("\n\tInvalid input\n\tPlease try again");
					break;
			}//switch
		}//while
		//termination
		console.close();
	}//main
}//ClientRunner Class
