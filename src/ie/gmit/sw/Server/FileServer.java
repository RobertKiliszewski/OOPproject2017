package ie.gmit.sw.Server;

import java.io.*;
import java.net.*;
import ie.gmit.sw.Drivers.*;
import java.util.concurrent.*;

public class FileServer{
	
	private static final int SIZE = 6;

	private ServerSocket socket;
	private int port;
	private String path;
	/**
	 * The boolean value keepRunning is used to control the while loop
	 * in the inner class called Listener. The volatile keyword tells  
	 * the JVM not to cache the value of keepRunning during Optimization,
	 * but to check it's value in memory before using it.
	 */
	private volatile boolean running = true;
	//Blocking Queue
	BlockingQueue<RequestDriver> queue = new ArrayBlockingQueue<>(SIZE);
	
	public FileServer(int portNumber, String filePath){
		/**Try the following. If anything goes wrong,
		 * the error will be passed to the catch block
		 */	
		try{
			//user input
			this.port = portNumber;
			this.path = filePath;
			
			//server socket
			//user specification 
			socket = new ServerSocket(portNumber);
			
			// Launch of a server thread
			Thread server = new Thread(new Listener(), "File Server Listener Launching...");
			//Priority
			server.setPriority(Thread.MAX_PRIORITY);
			
			server.start();

			new Thread(new LogRequest(queue), "Log Request").start();
			
			// Shows the server port
			System.out.println("Server: started successfully,listening on port:" + portNumber);
		}//try
		
		catch(IOException e) {
			System.out.println("Error!: " + e.getMessage());
		}//catch
	}//FileServer Constructor
	
	/* The inner class Listener is a Runnable, i.e. a job that can be given to a Thread. The job that
	 * the class has been given is to intercept incoming client requests and farm them out to other
	 * threads. Each client request is in the form of a socket and will be handled by a separate new thread.
	 * This Listener class IS-A Runnable
	 */
	private class Listener implements Runnable{
		
		public void run(){
			//variables
			int counter = 0;
			
			//loop to valiate to true 
			while(running){
				try{

					Socket soc = socket.accept();

	            	ObjectInputStream in = new ObjectInputStream(soc.getInputStream());

	                RequestDriver request = (RequestDriver)in.readObject();
	                

	                if(request instanceof ListDriver){
	                	((ListDriver) request).setFilePath(path);
	                }//if
	                
	                else if (request instanceof DownloadDriver){
	                	((DownloadDriver) request).setFilePath(path);
	                }//else
	                
	                //Run Thread
	                request.setSocketNumber(soc);
	                //giving thread a number
	                new Thread(request, "RequestNo-" + counter).start();
	      
					queue.put(request);
							
					counter++;
				}//try
				
				catch(Exception e){
					//ERROR
					System.out.println("ERROR:" + e.getMessage());
				}//catch
			}//while
		}//run
	}//Listener Class
}//FileServer Class