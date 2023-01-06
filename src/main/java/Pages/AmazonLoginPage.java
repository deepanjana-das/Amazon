package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ReusableMethods.CommonMethods;
import Utility.utility;

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
	
	
	
	public void AmazonLanding(String url)
	{
		util.openBrowser();
		driver.get(url);
	}
	
	  public void AmazonSignIn() throws Throwable {
		  
		  AmazonLoginPage login = PageFactory.initElements(driver, AmazonLoginPage.class);
		  clicking(login.SignIn_Button);
		  
	  }

		 public void UserProvidesCredential(String userName, String password) throws Throwable
		  {
		
			AmazonLoginPage login = PageFactory.initElements(driver, AmazonLoginPage.class);
			passingText(login.UserEmail, userName);
			clicking(login.Continue_button);
			passingText(login.Password, password);
			clicking(login.Login_button);
			 
			 
		  }

}
