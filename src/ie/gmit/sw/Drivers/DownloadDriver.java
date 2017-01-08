package ie.gmit.sw.Drivers;

import java.io.*;

public class DownloadDriver extends RequestDriver{
	/**
	 * The serialVersionUID is a universal version identifier
	 * for a Serializable class. Deserialization uses this number
	 * to ensure that a loaded class corresponds exactly
	 * to a serialized object. If no match is found,
	 * then an InvalidClassException is thrown.
	 */
	private static final long serialVersionUID = 1L;
	private static final String query = "Download";
	private String filePath;
	private String fileName;
	
	public DownloadDriver(String clientIpAddress, String fileName){
		super(clientIpAddress);
		this.fileName = fileName;
	}//DownloadDriver Constructor

	@Override
	public void run(){
		File file = new File(filePath + "/" + fileName);
		byte[] byteArray = new byte[(int)file.length()];
		
		try{

			FileInputStream fileInput = new FileInputStream(file);
			BufferedInputStream bufferInputFile = new BufferedInputStream(fileInput);

			bufferInputFile.read(byteArray,0,byteArray.length);
			
			ObjectOutputStream output = new ObjectOutputStream(super.getSocketNumber().getOutputStream());
			output.writeObject(byteArray);

			output.flush();

			output.close();
		}//try
		
		catch (FileNotFoundException e){
			e.printStackTrace();
		}//catch
		
		catch(IOException e){
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
}//DownloadDriver Class
