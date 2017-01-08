package ie.gmit.sw.Drivers;

import java.io.*;
import java.util.concurrent.BlockingQueue;

public class LogRequest implements Runnable{
	//variables
	private BlockingQueue<RequestDriver> queue;
	private FileWriter writer;
	private boolean running = true;
	
	public LogRequest(BlockingQueue<RequestDriver> queue) throws IOException {
		this.queue = queue;
		writer = new FileWriter(new File("log.txt"));
	}//Constructor
	
	@Override
	public void run(){
		//logs requests
		while(running){
			try{
				RequestDriver request = queue.take();
				System.out.println(request.toString());
				writer.write(request.toString() + "\n");
			}//try
			
			catch (InterruptedException e) {
				e.printStackTrace();
			}//catch
			
			catch (IOException e) {
				e.printStackTrace();
			}//catch
		}//while
	}//run	
}//LogRequest Class