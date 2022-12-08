package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	
	public 	String congigFilePath="src/test/resources/Configs/config.properties";
	public static Properties prop;
	public FileInputStream ip;
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	public BaseClass() throws IOException { 
		
		try {		
			
			prop=new Properties();
			 ip= new FileInputStream(congigFilePath);		
			prop.load(ip);	
		}
		catch(IOException e) {
			e.printStackTrace();		
			
		}
		
	} 
	public static void browserInitialization() throws InterruptedException {
		String browsername=prop.getProperty("browser");
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","src/test/resources/MyDrivers/chromedriver.exe"); 
			driver=new ChromeDriver();
			Thread.sleep(3000);
			
		}
		else if(browsername.equals("ie")) {
			System.setProperty("webdriver.ie.driver","D:\\Vinod\\Eclipse\\IEDriverServer.exe"); 
			driver=new InternetExplorerDriver();  
			Thread.sleep(5000);
			
		}

		wait=new WebDriverWait(driver,30);
		driver.manage().window().maximize();
		
		driver.get(prop.getProperty("url"));
	
	}


}
