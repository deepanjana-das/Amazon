package Pages;

import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ReusableMethods.CommonMethods;
import io.cucumber.java.en.Then;
import junit.framework.Assert;

public class AmazonCartPage extends CommonMethods {

	@FindBy(xpath = "//h1")
	WebElement AddedtoCart_message;

	@FindBy(xpath = "(//div[@data-name='Active Items']//span[@class='a-truncate-cut'])[1]")
	WebElement Cart_Item;

	@FindBy(xpath = "(//span[@class='a-truncate-cut'])[1]//ancestor::ul/following-sibling::div//select/option")
	WebElement Cart_Item_Quantity;

	@FindBy(xpath = "//input[@value='Proceed to checkout']")
	WebElement ProceedToBuy_button;

	String numberOfItemsInCart = "//div[@data-name='Active Items']//div[@data-itemtype='active']//ul//a [contains(@href,'product')]/span[contains(@class,'a-size')]";

	@FindBy(xpath = "(//div[@data-name='Active Items']//span[@class='a-truncate-cut'])[1]//ancestor::ul/following-sibling::div/span[@class='sc-action-quantity']")
	WebElement quantityButton;

	@FindBy(xpath = "//select[@name='quantity']")
	WebElement quantityDropdown;

	String listOfQuantity = "//div[@aria-hidden='false']//li/a";

	String Active_Itemlist_with_DeleteButton = "(//*[@data-name='Active Items']//input[@value='Delete'])";

	String ActiveItems = "//*[@data-name='Active Items']//div[@data-itemtype='active']";

	ExtentTest log1;

	public void AmazonCartpageItemValidationIncludingQuantityInCart(String itemCount) throws Throwable {
		log1 = AmazonLoginPage.report.createTest("Amazon Cart Page");
		AmazonCartPage amazoncart = PageFactory.initElements(driver, AmazonCartPage.class);
		String Cartpage = "Shopping Cart";
		Thread.sleep(2000);
		String itemtext = amazoncart.Cart_Item.getText();
		itemtext = itemtext.substring(0, itemtext.length() - 30);

		if (amazoncart.AddedtoCart_message.getText().contains(Cartpage)) {
			log1.log(Status.PASS, "welcome to Cart page");

			if (AmazonHomePage.s.contains(itemtext)) {
				log1.log(Status.PASS, "Selected item has been added in the cart");
				Thread.sleep(1000);
				clicking(amazoncart.quantityButton);
				log1.info("User clicked arrow to modify quantity for the selected item");
				Thread.sleep(1000);
				selectItemQuantityFromBootstrapDropdown(listOfQuantity, itemCount);
				log1.info("User selected quantity for the selected item");
				Thread.sleep(500);
			} else {
				log1.log(Status.FAIL, "Selected item was not added in the cart");
			}
			// Delete the remaining items from shopping cart
			if (getElements(ActiveItems).size() > 1) {
				for (int i = getElements(ActiveItems).size(); i > 1; i--) {

					clicking(specificElement(Active_Itemlist_with_DeleteButton + "[" + i + "]"));
					Thread.sleep(1000);
				}
				log1.info("User deleted pre exisitng item");
			} else {
				log1.info("No such pre exisiting items are there to delete.");
			}

		} else {
			log1.log(Status.FAIL, "Failed to open Cart page");
			Assert.assertEquals(true, false);
		}
		

	}

	
	  public void AmazoncartpageProceedtoBuyoption() throws Throwable {
			AmazonCartPage amazoncart = PageFactory.initElements(driver, AmazonCartPage.class);
			clicking(amazoncart.ProceedToBuy_button);
			log1.info("User clicked on Proceed to Buy Button");
			AmazonLoginPage.report.flush();
	  }
	 

}
