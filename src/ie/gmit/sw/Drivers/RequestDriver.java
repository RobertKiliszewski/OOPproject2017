package ie.gmit.sw.Drivers;

import java.net.*;
import java.util.Date;
import java.io.Serializable;

public abstract class RequestDriver implements Serializable, Runnable{
	// Declaration of a private static variable
	/**
	 * The serialVersionUID is a universal version identifier
	 * for a Serializable class. Deserialization uses this number
	 * to ensure that a loaded class corresponds exactly
	 * to a serialized object. If no match is found,
	 * then an InvalidClassException is thrown.
	 */
	private static final long serialVersionUID = 1L;
	// Declaration of private variables
	private Date date;
	private Socket number;
	private String username;
	private String query;
	private String ipAddress;
	private String hostAddress;
	private int portNumber;
	
	public RequestDriver(String clientIpAddress){
		date = new Date();
		this.ipAddress = clientIpAddress;
	}//RequestDriver Constructor
	
	public Date getDate(){
		return date;
	}//getDate
	
	public void setDate(Date date){
		this.date = date;
	}//setDate
	
	public Socket getSocketNumber(){
		return number;
	}//getSocketNumber
	
	public void setSocketNumber(Socket number){
		this.number = number;
	}//setSocketNumber
	
	public String getUsername(){
		return username;
	}//getUsername
	
	public void setUsername(String username){
		this.username = username;
	}//setUsername
	
	public String getQuery(){
		return query;
	}//getQuery
	
	public void setQuery(String query){
		this.query = query;
	}//setQuery
	
	public String getClientIpAddress(){
		return ipAddress;
	}//getClientIpAddress
	
	public void setClientIpAddress(String ipAddress){
		this.ipAddress = ipAddress;
	}//setClientIpAddress
	
	public String getHostAddress(){
		return hostAddress;
	}//getHostAddress
	
	public void setHostAddress(String hostAddress){
		this.hostAddress = hostAddress;
	}//setHostAddress
	
	public int getPortNumber(){
		return portNumber;
	}//getPortNumber
	
	public void setPortNumber(int portNumber){
		this.portNumber = portNumber;
	}//setPortNumber
}//Abstract Request Class