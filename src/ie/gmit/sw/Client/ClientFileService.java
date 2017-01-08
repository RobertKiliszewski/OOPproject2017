package ie.gmit.sw.Client;

import java.io.*;
import java.net.*;
import java.util.*;
import ie.gmit.sw.Drivers.*;
import ie.gmit.sw.Client.Configuration.Context;

public class ClientFileService implements DrivableClient{
	//variables
	private Socket conn;
	private String host;
	private int port;
	private String directory;
	private String ipAddress;
	private File[] fileList;
	
	public ClientFileService(Context ctx){
		this.host = ctx.getServerHostAddress();
		this.port = ctx.getServerPortNumber();
		this.directory = ctx.getDownloadDirectory();
	}//Constructor
	
	@Override
	public void serverConncect(){
		try{
			//Socket Object
			conn = new Socket(host, port);
			//get client IP
			ipAddress = conn.getLocalAddress().getHostAddress();
			//Request
			ObjectOutputStream out = new ObjectOutputStream(conn.getOutputStream());
			//Output of stream
			out.writeObject(new ConnectionDriver(ipAddress));
			//Flush the buffer
			out.flush();
			//Makes the thread pause 
			Thread.yield();
			//response
			ObjectInputStream serverResponse = new ObjectInputStream(conn.getInputStream());
			//object desorialization 
	        String response = (String)serverResponse.readObject();
			
	        //information of client
	        System.out.println(response);
		}//try
		
		catch(Exception e){
			e.printStackTrace();
		}//catch
	}//connectToServer

	@Override
	public void requestListOfFiles(){
		try {
			conn = new Socket(host, port);
			ipAddress = conn.getLocalAddress().getHostAddress();
			
			//request
	        ObjectOutputStream out = new ObjectOutputStream(conn.getOutputStream());
	        //Output 
	        out.writeObject(new ListDriver(ipAddress));
			//flush the buffer
	        out.flush();
	        //pause
	        Thread.yield();
	        
	        //response handling
	        ObjectInputStream serverResponse = new ObjectInputStream(conn.getInputStream());
	        //object deserialization
	        fileList = (File[]) serverResponse.readObject();
	        //loop for array in list
	        for(int i = 0; i < fileList.length; i++){
	        	//display
	        	System.out.println(fileList[i].getName());
	        }//for
		}//try
		
		catch(Exception e){
			e.printStackTrace();
		}//catch
	}//requestListOfFiles

	@Override
	public void requestDownload(){
		//variables
		Scanner console = new Scanner(System.in);
		//instructions for the user
		System.out.print("\nPlease enter name of the file you wish to download: ");
		//user input 
		String fileName = console.nextLine();
		
		//this loops through the array list of files	
		for(int i = 0; i < fileList.length; i++){
			//name search if there is a match 
			if(fileName.equals(fileList[i].getName())){
				try {
					conn = new Socket(host, port);
					ipAddress = conn.getLocalAddress().getHostAddress();
					
					//request 
			        ObjectOutputStream out = new ObjectOutputStream(conn.getOutputStream());
			        //output
			        out.writeObject(new DownloadDriver(ipAddress, fileName));
					//flush the buffer
			        out.flush();
			        //pause
			        Thread.yield();
			        
			        //response
			        ObjectInputStream serverResponse = new ObjectInputStream(conn.getInputStream());
			        //bytearray -> arraylist
			        byte[] byteArray = (byte[])serverResponse.readObject();
			        
			        FileOutputStream output = new FileOutputStream(directory + "/" + fileName);
		
			        output.write(byteArray);
			      
			        output.close();
				}// End of try
				
				catch(Exception e){
					e.printStackTrace();
				}//catch
			}//if
		}//for
	}//requestDownload

	@Override
	public boolean quit(){
		//variables
		boolean confirmation = true;
		String userInput;
		Scanner console = new Scanner(System.in);
		
		do{
			//warning message
			System.out.println("\tDo you want to Terminate[y/n]");
			userInput = console.nextLine().toLowerCase();
			
			if(userInput.equals("n")){
			}//if
			
			else if(userInput.equals("y")){
				//Termination message
				System.out.println("\tTerminating...");
				confirmation = false;
			}//else if
					
			else{
				System.out.println("\n\ty/Y-confirm | n/N-decline \n\tPlease try again");
			}//else
		}while(userInput.equals('y') || userInput.equals('n')); // End of do/while
		
		//returns boolean value
		return confirmation;
	}//quit
}//FileServer Class
