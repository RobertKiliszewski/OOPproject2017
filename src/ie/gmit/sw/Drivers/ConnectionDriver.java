package ie.gmit.sw.Drivers;

import java.io.IOException;
import java.io.ObjectOutputStream;

public class ConnectionDriver extends RequestDriver{
	/**
	 * The serialVersionUID is a universal version identifier
	 * for a Serializable class. Deserialization uses this number
	 * to ensure that a loaded class corresponds exactly
	 * to a serialized object. If no match is found,
	 * then an InvalidClassException is thrown.
	 */
	private static final long serialVersionUID = 1L;
	private static final String query = "Connection";
	
	public ConnectionDriver(String clientIpAddress) {
		super(clientIpAddress);
	}//Constructor

	@Override
	public void run() {
		try{
			//variables
			String message = "Connection Successful";
			ObjectOutputStream output = new ObjectOutputStream(super.getSocketNumber().getOutputStream());
			// Output
			output.writeObject(message);
			//flush
			output.flush();
			// Close
			output.close();
		}//try
		
		catch(IOException e){
			e.printStackTrace();
		}//catch
	}//run
	
	@Override
	public String toString(){
		return "<" + query + "> " + " | Requested by: " + super.getClientIpAddress() + " | At: " + super.getDate().toString() + " |";
	}//toString
}//RequestDriver Class