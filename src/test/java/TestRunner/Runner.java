package TestRunner;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import factory.BaseClass;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utilities.ConfigReader;

@CucumberOptions(
		// features= {".//Features/"},
		 features= {".//src//test//resources//Features/Login.feature"},
		// features= {".//Features/Registration.feature"},

		//features = { ".//Features/LoginDDTExcel.feature" },
		// features= {".//Features/Login.feature",".//Features/Registration.feature"},
		// features= {"@target/rerun.txt"},
		glue = { "StepDefinitions", "hooks" }, 
		plugin = { "pretty", "html:Reports/CucumberReport.html",
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
					"rerun:target/rerun.txt"},

		dryRun = false, // checks mapping between scenario steps and step definition methods
		monochrome = false // to avoid junk characters in output report link
// publish=true // to publish report in cucumber server
// tags="@sanity" // this will execute scenarios tagged with @sanity
// tags="@regression"
// tags="@sanity and @regression" //Scenarios tagged with both @sanity and
// @regression
// tags="@sanity and not @regression" //Scenarios tagged with @sanity but not
// tagged with @regression
// tags="@sanity or @regression" //Scenarios tagged with either @sanity or
// @regression
)

public class Runner extends AbstractTestNGCucumberTests  {
	
	@BeforeTest
	@Parameters({"Browser","OS"})
	public void defineBrowser(String browser,String os) throws IOException {
		ConfigReader.setBrowserType(browser);
		ConfigReader.setOperatingSystem(os);
		System.out.println(browser);
		System.out.println(os);
	}

	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
