package ie.gmit.sw.Server;

public class ServerRunner{
	public static void main(String[] args) {

		int portNumber;
		String filePath;
		

		try{

			System.out.println("\nPlease Enter:" 
					+ "\nPort Number[Integer] & File Path[String]");
			portNumber = 7777;
			filePath = "./downloads/";
		}//try
		
		catch(Exception e) {
			
			System.out.println("\nSorry,incorrect data,"
					+ "\nPlease provide the following:" 
					+ "\nPort Number[Integer] & File Path[String]");
			return;
		}//catch
		
		/**
		 * Calling upon a FileServer Class &
		 * feeding it with user input 
		 */
		new FileServer(portNumber, filePath);
	}//main
}//ServerRunner Class