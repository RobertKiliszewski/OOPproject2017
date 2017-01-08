package ie.gmit.sw.Client;

public interface DrivableClient {
	public void serverConncect();
	public void requestListOfFiles();
	public void requestDownload();
	public boolean quit();
}// End of DrivableFileServer Interface
