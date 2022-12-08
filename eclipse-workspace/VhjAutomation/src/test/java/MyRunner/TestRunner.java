package MyRunner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

// Cucumber.class error got fixed after adding cucumber junit and ctr+Shift+_O
@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/MyFeatures"
		,glue="stepDefinitions"
		,format = {
		                "pretty",
		                "html:target/cucumber-reports/cucumber-pretty",
		                "json:target/cucumber-reports/CucumberTestReport.json",
		                "rerun:target/cucumber-reports/rerun.txt"         
		                
		        },
			plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
		
		// ,plugin= {"pretty","html:target/site/cucumber-pretty","json:target/cucumber/cucumber.json"}
		,monochrome = true
		,dryRun=false
		)
public class TestRunner {
	
	
@AfterClass
public static void setup()
	{
	Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
	//Reporter.setSystemInfo("Test User", System.getProperty("user.name"));
	Reporter.setSystemInfo("User Name", "AJ");
	Reporter.setSystemInfo("Application Name", "Test App ");
	Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
	Reporter.setSystemInfo("Environment", "Production");
	Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
	}

}
