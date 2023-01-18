package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import ReusableMethods.CommonMethods;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class AmazonHomePage extends CommonMethods {

	@FindBy(xpath = "//h2[contains(text(),'Hi')]")
	WebElement Hi_message;

	@FindBy(xpath = "//span[contains(text(),'Hello')]")
	WebElement helloUser;

	@FindBy(xpath = "//input[@id = 'twotabsearchtextbox']")
	WebElement Search_Box;

	@FindBy(xpath = "//span[contains(text(),'Go')]")
	WebElement searchIcon;

	@FindBy(xpath = "(//span[@class= 'a-size-base-plus a-color-base a-text-normal'])[1]")
	public WebElement item;
	
	@FindBy(xpath = "//span[@id='productTitle']")
	public WebElement selectedItem;

	@FindBy(xpath = "//a[@title='See All Buying Options']")
	WebElement SeeAllbuyOption_button;

	@FindBy(xpath = "//input[@value='Add to Cart']")
	WebElement AddTocart_button;

	@FindBy(xpath = "//span [contains(text(), 'Added to Cart')]")
	WebElement addedToCart_Successful_Message;

	@FindBy(xpath = "//span [contains(text(), 'Cart')]")
	WebElement cart;
	
	public static String s;

	ExtentTest testlog;

	public void AmazonHomePageValidatesUsername(String userName) {

		testlog = AmazonLoginPage.report.createTest("Amazon Home Page");
		AmazonHomePage amazonhome = PageFactory.initElements(driver, AmazonHomePage.class);
		String name = amazonhome.helloUser.getText().substring(7).toLowerCase();
		if (userName.contains(name)) {
			testlog.log(Status.PASS, "Login successful...Success");

		}

		else {
			testlog.log(Status.FAIL, "Login fail...Failed");
			Assert.assertEquals(false, true);
		}

	}

	public void AmazonHomePageSearchItem(String item) {
		AmazonHomePage amazonhome = PageFactory.initElements(driver, AmazonHomePage.class);
		passingText(amazonhome.Search_Box, item);
		testlog.info("user searched for an item in search box");
		enterAction();
		testlog.info("user pressed enter");
		amazonhome.scrollDown();
		testlog.info("user scrolled down the page");

	}
	
	

	public void AmazonHomePageChooseItem() {
		AmazonHomePage amazonhome = PageFactory.initElements(driver, AmazonHomePage.class);
		if (amazonhome.item.isDisplayed()) {
			testlog.log(Status.PASS, "Searched item is present in outlet");
			//s=amazonhome.item.getText();
			clicking(amazonhome.item);
			testlog.info("user clicked on one saree");
		} else {
			testlog.log(Status.FAIL, "Searched item is not present in outlet");
			Assert.assertEquals(true, false);
		}

	}
	
	

	public void AmazonHomePageItemAddtoCart() {
		AmazonHomePage amazonhome = PageFactory.initElements(driver, AmazonHomePage.class);
		window_handles();
		testlog.info("another page is opened");
		waiting(amazonhome.AddTocart_button);
		testlog.info("Add to Cart button is visible");
		s=amazonhome.selectedItem.getText().trim();
		clicking(amazonhome.AddTocart_button);
		testlog.info("user clicked on Add to Cart button");
		if (amazonhome.addedToCart_Successful_Message.isDisplayed() == true) {
			testlog.log(Status.PASS, "Searched item was added successfully to the cart");
		} else {
			testlog.log(Status.FAIL, "Searched item is not added in cart");
			Assert.assertEquals(true, false);
		}
		clicking(amazonhome.cart);
		testlog.info("User opened Cart");

		AmazonLoginPage.report.flush();

	}

}
