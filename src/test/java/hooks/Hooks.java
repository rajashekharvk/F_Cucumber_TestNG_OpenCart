package hooks;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.ConfigReader;

public class Hooks {

	static WebDriver driver;
	Properties p;
	ConfigReader config=new ConfigReader();

	@Before
	public void setup() throws IOException {
		
		String browser=config.getBrowserType();
		String os=config.getOperatingSystem();
		BaseClass.initilizeBrowser(browser,os);
		driver = BaseClass.getDriver();
		p = BaseClass.getProperties();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() {
		if(BaseClass.getDriver()!=null)
			BaseClass.getDriver().quit();
	}

	@AfterStep
	public void addScreenShot(Scenario scenario) {
		if (scenario.isFailed()) {
			BaseClass.getScreenShot(scenario);
		}
	}

}
