package utilities;

public class ConfigReader {
	
	public static String BrowserType;
	public static String OperatingSystem;
	
	
	public static String getBrowserType() {
		
		if(BrowserType!=null)
			return BrowserType;
		else
			throw new RuntimeException("Browser not specified in the testng.xml");
	}
	public static void setBrowserType(String browserType) {
		ConfigReader.BrowserType = browserType;
	}
	
	public static String getOperatingSystem() {
		if(OperatingSystem !=null)
			return OperatingSystem;
		else
			throw new RuntimeException("OperatingSystem not specified in the teng.xml");
	}
	
	public static void setOperatingSystem(String operatingSystem) {
		ConfigReader.OperatingSystem = operatingSystem;
	}
	
	
	

	
}
