package factory;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
//import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.Scenario;

public class BaseClass {

//	static WebDriver driver;
	static Logger logger;
	static Properties p;
	public static ChromeOptions co=new ChromeOptions();
	public static EdgeOptions ed=new EdgeOptions();
	
 private static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();

	// "os", "browser"
	public static void initilizeBrowser(String browser,String os) throws IOException {
		
		p = getProperties();
			
		String executionEnv =p.getProperty("execution_env");
//		String browser = p.getProperty("browser").toLowerCase();
//		String os = p.getProperty("os").toLowerCase();

		if (executionEnv.equals("remote")) {
			
		//	DesiredCapabilities cap = new DesiredCapabilities();
			
			
			// os
			switch (os.toLowerCase()) {
//			case "windows":
//				//cap.setPlatform(Platform.WIN10);
//				co.setPlatformName(os);
//				break;
//			case "mac":
//				cap.setPlatform(Platform.MAC);
//				break;
//			case "linux":
//				cap.setPlatform(Platform.LINUX);
//				break;
//			default:
//				System.out.println("No Match OS");
//				//return null;
			}
			
			// browser
			switch (browser.toLowerCase()) {
//			case "chrome":
//				cap.setBrowserName("chrome");
//				break;
//			case "edge":
//				cap.setBrowserName("MicrosoftEdge");
//				break;
//			case "firefox":
//				cap.setBrowserName("firefox");
//				break;
//			default:
//				System.out.println("No Matching browser");
//				//return null;

			}
//			driver = new RemoteWebDriver(URI.create("http://localhost:4444/wd/hub").toURL(), cap);
			 //new URL("http://localhost:4444/wd/hub")
			
		} else if (executionEnv.equalsIgnoreCase("local")) {
			switch (browser.toLowerCase()) {
			case "chrome":
				co.setPageLoadStrategy(PageLoadStrategy.EAGER);
				driver.set(new ChromeDriver());
				//driver = new ChromeDriver();
				break;
//			case "firefox":
//				driver = new FirefoxDriver();
//				break;
			case "edge":
				ed.setPageLoadStrategy(PageLoadStrategy.EAGER);
				driver.set(new EdgeDriver());
//				driver = new EdgeDriver();
				break;
			default:
				System.out.println("No Matching Browser");
				//return null;
			}

		}
//		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		

//		return driver;
	}
	

	public static WebDriver getDriver() {
		return driver.get();
	}

	
	public static Properties getProperties() throws IOException {
		FileReader file = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\config\\config.properties");
		p = new Properties();
		p.load(file);

		return p;
	}

	
	public static Logger getLogger() {
		logger = LogManager.getLogger(); // Log4j
		return logger;
	}

	public String randomString() {
		String randmString = RandomStringUtils.randomAlphabetic(5);
		return randmString;
	}

	public String randomNumber() {
		String randmNumber = RandomStringUtils.randomNumeric(10);
		return randmNumber;
	}

	public static String randomAlphaNumeric() {
		String randmString = RandomStringUtils.randomAlphabetic(3);
		String randmNumber = RandomStringUtils.randomNumeric(2);
		return (randmString + randmNumber);
	}
	
	public static void getScreenShot(Scenario scenario) {
		TakesScreenshot ts=(TakesScreenshot)driver;
		byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", scenario.getName());  
	}

}
