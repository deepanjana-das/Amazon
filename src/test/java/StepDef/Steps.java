package StepDef;


import Pages.AmazonCartPage;
import Pages.AmazonHomePage;
import Pages.AmazonLoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {
	
	
	AmazonLoginPage amazonlogin = new AmazonLoginPage();
    AmazonHomePage amazonhome = new AmazonHomePage();
    AmazonCartPage amazoncart = new AmazonCartPage();
	
	@Given("^User is on Amazon landing page on hitting \"([^\"]*)\"$")
	public void AmazonLandingStep(String url) throws Throwable {
	   amazonlogin.AmazonLanding(url);
	}

	
	  @When("^User clicks on sign in tab$") 
	  public void AmazonSignInStep() throws Throwable {
	  
		  amazonlogin.AmazonSignIn();
	  }
	 
	 @When("^User logs in by providing \"([^\"]*)\" and \"([^\"]*)\"$") 
	 public void UserProvidesCredentialStep(String userName, String password) throws Throwable
	  {
	      amazonlogin.UserProvidesCredential(userName, password);
	  }


	
	  @When("^User is on Amazon Home page with \"([^\"]*)\"$") 
	  public void AmazonHomePageValidatesUsernameStep(String user) throws Throwable { 
		  
		  amazonhome.AmazonHomePageValidatesUsername(user);
		  
	  }
	  
		
		  @When("^User search by providing \"([^\"]*)\" in search bar$")
		  public void AmazonHomePageSearchItemStep(String item) throws Throwable
		  {
		  amazonhome.AmazonHomePageSearchItem(item);
		  }
		  
			
	@When("^User choose specific item$") 
	public void AmazonHomePageChooseItemStep() throws Throwable {
		
		amazonhome.AmazonHomePageChooseItem();
			  
	}
			  
	@When("^User clicks on Add to Cart option for that item$") 
	public void AmazonHomePageItemAddtoCartStep()throws Throwable
	{
		amazonhome.AmazonHomePageItemAddtoCart();
	}
			 
		 
	  
	 @Then("^User validate that particular item with \"([^\"]*)\" quanitity in the cart$"
	 ) 
	 public void AmazonCartpageItemValidationIncludingQuantityInCartStep(String itemcount)
	 throws Throwable {
		 amazoncart.AmazonCartpageItemValidationIncludingQuantityInCart(itemcount);
		 
	 }
	 
		
		  @Then("^User click on Proceed to Buy option$") public void
		  AmazoncartpageProceedtoBuyoptionStep() throws Throwable {
		  
			  amazoncart.AmazoncartpageProceedtoBuyoption();
		  }
		 
	 
	 /* @Then("^User click on Deliver to the Address$") public void
	 * user_click_on_Deliver_to_the_Address() throws Throwable { // Write code here
	 * that turns the phrase above into concrete actions throw new
	 * PendingException(); }
	 * 
	 * @Then("^User now is on Payment page$") public void
	 * user_now_is_on_Payment_page() throws Throwable { // Write code here that
	 * turns the phrase above into concrete actions throw new PendingException(); }
	 */



}
