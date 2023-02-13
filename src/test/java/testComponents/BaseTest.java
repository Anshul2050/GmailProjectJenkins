package testComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;

public class BaseTest {
	
	public WebDriver driver;
	public LoginPage loginObj;
	
	public WebDriver initialiseBrowser() throws IOException {
		
		Properties prop = new Properties();
		
		FileInputStream fis = new FileInputStream("E:\\software testing notes\\manual testing notes\\Eclipsce Worksspace\\Gmail_Project\\src\\main\\java\\globalProp.properties");
		prop.load(fis);
		
		//String browserName = "edge";
		// for maven cmd running we are providing system level System.getProperty variable
		String browserName =	System.getProperty("browser")!=null? System.getProperty("browser"): prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("edge")) {
			
			WebDriver driver = new EdgeDriver();
			// passing driver to global driver
			this.driver=driver;
			
			
		}else if(browserName.equalsIgnoreCase("chrome")) {
			
			WebDriver driver = new ChromeDriver();
			this.driver=driver;
			
			
		}
        else if(browserName.equalsIgnoreCase("firefox")) {
			
			WebDriver driver = new FirefoxDriver();
			this.driver=driver;
			
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
    @BeforeMethod
	public LoginPage launchApplication() throws IOException {
		driver = initialiseBrowser();
		loginObj = new LoginPage(driver); 
		loginObj.goTo();
		return loginObj;
	}
	
    @AfterMethod 
    public void CloseApplication() throws IOException, InterruptedException {
    	
    	
		driver.quit();
		
	}
    @Test
    public static String getScreeenshot(String testCasename,WebDriver driver) throws IOException {
    	String des =System.getProperty("user.dir")+"\\ExtentReports\\"+testCasename+".png";
    	TakesScreenshot ts = (TakesScreenshot) driver ;
    	
    	File src  = ts.getScreenshotAs(OutputType.FILE);
    	
    	File desp = new File(des);
    	FileUtils.copyFile(src, desp);
    	return des;
    	
    }

}










