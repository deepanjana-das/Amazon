package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import ReusableMethods.CommonMethods;
import Utility.utility;
import junit.framework.Assert;

public class AmazonLoginPage extends CommonMethods {
	
	

	@FindBy (xpath = "//span[text() = 'Account & Lists']")
	WebElement SignIn_Button;
	
	@FindBy (xpath = "//input[@type = 'email']")
	WebElement UserEmail;
	
	@FindBy (xpath = "//input[@id = 'continue']")
	WebElement Continue_button;

	@FindBy (xpath = "//input[@type = 'password']")
	WebElement Password;
	
	@FindBy (xpath = "//input[@name='rememberMe']")
	WebElement KeepmeSignedIn_checkbox;
	
	@FindBy (xpath = "//input[@id = 'signInSubmit']")
	WebElement Login_button;
	
	utility util = new utility();
	
	public static ExtentHtmlReporter reporter;
	public static ExtentReports report;
	ExtentTest logger;
	
	
	public void AmazonLanding(String url)
	{
		util.openBrowser();
		reporter= new ExtentHtmlReporter(".//Report//Shopping.html");
		report = new ExtentReports();
		report.attachReporter(reporter);
		logger=report.createTest("Login to Amazon");
		driver.get(url);
		logger.info("User provided the url");
	}
	
	  public void AmazonSignIn() throws Throwable {
		  
		  AmazonLoginPage login = PageFactory.initElements(driver, AmazonLoginPage.class);
		  clicking(login.SignIn_Button);
		  logger.info("User clicked on sign in button");
	  }

		 public void UserProvidesCredential(String userName, String password) throws Throwable
		  {
		
			AmazonLoginPage login = PageFactory.initElements(driver, AmazonLoginPage.class);
			if(login.UserEmail.isDisplayed())
			{
				logger.log(Status.PASS, "Username field is displayed");
			}
			else{
				logger.log(Status.FAIL, "Username field is not displayed");
				Assert.assertEquals(false, true);
			}
			passingText(login.UserEmail, userName);
			logger.info("User provided username");
			clicking(login.Continue_button);
			passingText(login.Password, password);
			logger.info("User provided password");
			clicking(login.Login_button);
			logger.info("User clicked on submit button"); 
			report.flush();
			 
		  }

}
