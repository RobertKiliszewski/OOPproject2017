package ie.gmit.sw.Client.Configuration;

public class Context{
	public static final String CONF_FILE = "Conf.xml";
	private String username;
	private String hostAddress;
	private int portNumber;
	private String download;
	
	public Context(){
		super();
	}//Context
	
	public String getUsername(){
		return username;
	}//getUsername
	
	public void setUsername(String username){
		this.username = username;
	}//setUsername
	
	public String getServerHostAddress(){
		return hostAddress;
	}//getServerHost
	
	public void setServerHostAddress(String serverHost){
		this.hostAddress = serverHost;
	}//setServerHost
	
	public int getServerPortNumber(){
		return portNumber;
	}//getServerPortNumber
	
	public void setServerPortNumber(int serverPort){
		this.portNumber = serverPort;
	}//setServerPortNumber
	
	public String getDownloadDirectory(){
		return download;
	}//getDownloadDirectory
	
	public void setDownloadDirectory(String downloadDirectory){
		this.download = downloadDirectory;
	}//setDownloadDirectory
	
	@Override
	public String toString(){
		return "Context [Username: " + username 
				+ "|Address: " + hostAddress 
				+ "|Port Number: " + portNumber
				+ "|Directory: " + download + "]";
	}//toString
}//Context Class
