package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ReusableMethods.CommonMethods;
import io.cucumber.java.en.When;

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
	WebElement item;
	
	@FindBy(xpath = "//a[@title='See All Buying Options']")
	WebElement SeeAllbuyOption_button;

	@FindBy(xpath = "//input[@value='Add to Cart']")
	WebElement AddTocart_button;

	//String xgh = "//input[@id='add-to-cart-button']";
	

	
	  
	  public void AmazonHomePageValidatesUsername(String userName)
	  { 
		  AmazonHomePage amazonhome = PageFactory.initElements(driver, AmazonHomePage.class);
		  String name = amazonhome.helloUser.getText().substring(7).toLowerCase();
 		  if (userName.contains(name))
		  {
			  System.out.println("Login successful...Success");
		  }
		  
		  else
		  {
			  System.out.println("Login fail...Failed");
		  }
		  
		  
	  }
 
  public void AmazonHomePageSearchItem(String item) 
  {
	  AmazonHomePage amazonhome = PageFactory.initElements(driver, AmazonHomePage.class);
	  passingText(amazonhome.Search_Box, item);
	  enterAction();
	  amazonhome.scrollDown();
	  
  }
  
  
  public void AmazonHomePageChooseItem()
  {
	  AmazonHomePage amazonhome = PageFactory.initElements(driver, AmazonHomePage.class);
	  clicking(amazonhome.item);
	  
  }
  
  
  public void AmazonHomePageItemAddtoCart()
  {
	  AmazonHomePage amazonhome = PageFactory.initElements(driver, AmazonHomePage.class);
	  window_handles();
	  waiting(amazonhome.AddTocart_button);
	  System.out.println("Add to Cart button is visible");
	  clicking(amazonhome.AddTocart_button);
  
  }
  
  
  }
 