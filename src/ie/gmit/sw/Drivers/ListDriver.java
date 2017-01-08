package ie.gmit.sw.Drivers;

import java.io.*;

public class ListDriver extends RequestDriver{
	//variables
	/**
	 * The serialVersionUID is a universal version identifier
	 * for a Serializable class. Deserialization uses this number
	 * to ensure that a loaded class corresponds exactly
	 * to a serialized object. If no match is found,
	 * then an InvalidClassException is thrown.
	 */
	private static final long serialVersionUID = 1L;
	private static final String query = "Listing";
	//variable
	private String filePath;
	
	public ListDriver(String clientIpAddress){
		super(clientIpAddress);
	}//Constructor

	@Override
	public void run(){
		try {
			//file path
			File folder = new File(filePath);
			//Creation of arrayList
			File[] files = folder.listFiles();
		
			ObjectOutputStream output = new ObjectOutputStream(super.getSocketNumber().getOutputStream());
			// Output
			output.writeObject(files);
			//flush
			output.flush();
			//close
			output.close();
		}//try
		
		catch (IOException e) {
			e.printStackTrace();
		}//catch
	}//run

	public String getFilePath(){
		return filePath;
	}//getFilePath

	public void setFilePath(String filePath){
		this.filePath = filePath;
	}//setFilePath
	
	@Override
	public String toString(){
		return "<" + query + "> " + " | Requested by: " + super.getClientIpAddress() + " | At: " + super.getDate().toString() + " |";
	}//toString
}//RequestDriver Class