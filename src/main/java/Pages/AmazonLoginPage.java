package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ReusableMethods.CommonMethods;
import Utility.utility;

public class AmazonLoginPage extends CommonMethods {

	@FindBy (xpath = "//span[text() = 'Hello, Sign in']")
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

}
