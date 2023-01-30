package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ReusableMethods.CommonMethods;
import junit.framework.Assert;

public class AmazonPaymentPage extends CommonMethods {
	
	@FindBy(xpath= "//h1")
	WebElement checkout;
	
	@FindBy (xpath = "//span//h3[contains(text(),'Delivery address')]")
	WebElement DeliveryAddress;
	
	@FindBy (xpath="//div//h3[contains(text(),'Select a payment method')]")
	WebElement SelectedPaymentMethod;
	
	ExtentTest log1;
	
	  public void AmazonPaymentPage() throws Throwable { 
		  
		 AmazonPaymentPage amazonpayment = PageFactory.initElements(driver, AmazonPaymentPage.class);
		 log1=AmazonLoginPage.report.createTest("Amazon Payment Page");
		 if(amazonpayment.checkout.isDisplayed()==true)
		 {
			 log1.log(Status.PASS, "Welcome to Amazon Payment page for checkout");
			 screenCapture("D:\\Deepanjana\\AutomationProjects\\Screenshots\\AmazonPayment\\CheckoutForPaymentpage.jpg");
			 if (amazonpayment.DeliveryAddress.isDisplayed()==true)
			 {
				 log1.log(Status.PASS, "Delivery adress is present");
				 if (amazonpayment.SelectedPaymentMethod.isDisplayed()==true)
				 {
					 log1.log(Status.PASS, "Payment method options are displayed");
					 
				 }
			 }
			 else
			 {
				 log1.log(Status.FAIL, "Delivery adress is not present so not able to proceed");
				 Assert.assertEquals(true, false);
			 }
		 }
		 else
		 {
			 log1.log(Status.FAIL, "Failed to checkout to the payment page");
			 Assert.assertEquals(true, false);
		 }
		 
		 AmazonLoginPage.report.flush();
		 
	  }



}
