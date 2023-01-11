package Pages;

import java.sql.Driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ReusableMethods.CommonMethods;
import io.cucumber.java.en.Then;
import junit.framework.Assert;

public class AmazonCartPage extends CommonMethods {

	@FindBy(xpath = "//h1")
	WebElement AddedtoCart_message;

	@FindBy(xpath = "(//span[@class='a-truncate-cut'])[1]")
	WebElement Cart_Item;

	@FindBy(xpath = "(//span[@class='a-truncate-cut'])[1]")
	WebElement Cart_Item_Quatity;

	@FindBy(xpath = "//input[@value='Proceed to checkout']")
	WebElement ProceedToBuy_button;

	String numberOfItemsInCart = "//div[@data-name='Active Items']//div[@data-itemtype='active']//ul//a [contains(@href,'product')]/span[contains(@class,'a-size')]";

	@FindBy(xpath = "//div[@data-name='Active Items']//div[@data-itemtype='active']//ul/following-sibling::div//span[@data-action='delete']")
	WebElement delete;

	String deletePath = "(//div[@data-name='Active Items']//div[@data-itemtype='active']//ul/following-sibling::div//span[@data-action='delete'])";

	@FindBy(xpath = "//span[@role='button']//span[@class='a-dropdown-prompt']")
	WebElement quantities;

	@FindBy(xpath = "//select[@name='quantity']")
	WebElement quantityDropdown;

	ExtentTest log1;

	public void AmazonCartpageItemValidationIncludingQuantityInCart(String arg1) throws Throwable {
		log1 = AmazonLoginPage.report.createTest("Amazon Cart Page");
		AmazonCartPage amazoncart = PageFactory.initElements(driver, AmazonCartPage.class);
		String Cartpage = "Shopping Cart";

		if (amazoncart.AddedtoCart_message.getText().contains(Cartpage)) {
			log1.log(Status.PASS, "welcome to Cart page");

		} else {
			log1.log(Status.FAIL, "Failed to open Cart page");
			Assert.assertEquals(true, false);
		}
		AmazonLoginPage.report.flush();
	}

	/*
	 * public void AmazoncartpageProceedtoBuyoptionStep() throws Throwable {
	 * 
	 * }
	 */

}
