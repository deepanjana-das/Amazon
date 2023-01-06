package Utility;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class utility {
	
	public static WebDriver driver;
	
	
	public void openBrowser()
	{
		//System.out.println("Inside before");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + ".//Chrome//chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
    
	public void closeBrowser()
	{
		driver.quit();
	}

}
