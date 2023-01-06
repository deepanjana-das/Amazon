package StepDef;


import Pages.AmazonLoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Steps {
	
	
	AmazonLoginPage amazonlogin = new AmazonLoginPage();

	
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


	/*
	 * @When("^User is on Amazon Home page with \"([^\"]*)\"$") public void
	 * user_is_on_Amazon_Home_page_with(String arg1) throws Throwable { // Write
	 * code here that turns the phrase above into concrete actions throw new
	 * PendingException(); }
	 * 
	 * @When("^User search by providing \"([^\"]*)\" in search bar$") public void
	 * user_search_by_providing_in_search_bar(String arg1) throws Throwable { //
	 * Write code here that turns the phrase above into concrete actions throw new
	 * PendingException(); }
	 * 
	 * @When("^User choose specific item$") public void user_choose_specific_item()
	 * throws Throwable { // Write code here that turns the phrase above into
	 * concrete actions throw new PendingException(); }
	 * 
	 * @When("^User clicks on Add to Cart option for that item$") public void
	 * user_clicks_on_Add_to_Cart_option_for_that_item() throws Throwable { // Write
	 * code here that turns the phrase above into concrete actions throw new
	 * PendingException(); }
	 * 
	 * @Then("^User validate that particular item with \"([^\"]*)\" quanitity in the cart$"
	 * ) public void
	 * user_validate_that_particular_item_with_quanitity_in_the_cart(String arg1)
	 * throws Throwable { // Write code here that turns the phrase above into
	 * concrete actions throw new PendingException(); }
	 * 
	 * @Then("^User click on Proceed to Buy option$") public void
	 * user_click_on_Proceed_to_Buy_option() throws Throwable { // Write code here
	 * that turns the phrase above into concrete actions throw new
	 * PendingException(); }
	 * 
	 * @Then("^User click on Deliver to the Address$") public void
	 * user_click_on_Deliver_to_the_Address() throws Throwable { // Write code here
	 * that turns the phrase above into concrete actions throw new
	 * PendingException(); }
	 * 
	 * @Then("^User now is on Payment page$") public void
	 * user_now_is_on_Payment_page() throws Throwable { // Write code here that
	 * turns the phrase above into concrete actions throw new PendingException(); }
	 */



}
