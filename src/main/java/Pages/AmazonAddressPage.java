package Pages;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ReusableMethods.CommonMethods;
import junit.framework.Assert;

public class AmazonAddressPage extends CommonMethods{
	
	@FindBy(xpath= "//h1")
	WebElement checkout;
	
	@FindBy(xpath = "//h3[contains(text(),'Select a delivery address')]")
	WebElement SelectedAddressMSG;
	
	@FindBy(xpath = "//span[contains(text(),'BARASAT')]/../../input[@type='radio']")
	WebElement RadioForDefaultAddress;
	
	@FindBy(xpath="//span[contains(text(),'MEDINIPUR')]/../../input[@type='radio']")
	WebElement RadioButtonForSelectedAddress;
	
	@FindBy(xpath ="//span[@id='orderSummaryPrimaryActionBtn']//input")
	WebElement ButtonForUseThisAddress;
	
	ExtentTest logtest;
	
	  public void AmazonAddressPage() throws Throwable { 
		  
		  AmazonAddressPage amazonaddress = PageFactory.initElements(driver, AmazonAddressPage.class);
		  logtest = AmazonLoginPage.report.createTest("Amazon Address Page");
		  Thread.sleep(4000);
		  if(amazonaddress.checkout.isDisplayed()==true)
		  {
			  logtest.log(Status.PASS, "Welcome to the Address page for checkout");
			  screenCapture("D:\\Deepanjana\\AutomationProjects\\Screenshots\\AmazonAddress\\CheckoutForAddresspage.jpg");
			  if (amazonaddress.SelectedAddressMSG.isDisplayed()==true)
			  {
				  clicking(amazonaddress.RadioButtonForSelectedAddress);
				  logtest.info("User selected radio button for selected address");
				  screenCapture("D:\\Deepanjana\\AutomationProjects\\Screenshots\\AmazonAddress\\selectedAddress.jpg");
			  }
			  else 
			  {
				  clicking(amazonaddress.RadioForDefaultAddress);
			      logtest.info("User selected radio button for default address");
			      screenCapture("D:\\Deepanjana\\AutomationProjects\\Screenshots\\AmazonAddress\\address.jpg");
		      }
			  
			  clicking(amazonaddress.ButtonForUseThisAddress);
			  logtest.info("User clicked on button");
			  
		  }
		  
		  else
		  {
			  logtest.log(Status.FAIL, "Failed to checkout to the address page");
			  Assert.assertEquals(true, false);
		  }
		  
		  AmazonLoginPage.report.flush();
		  
	  }

}
