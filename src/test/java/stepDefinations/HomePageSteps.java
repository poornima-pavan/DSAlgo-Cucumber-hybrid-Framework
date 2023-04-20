package stepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import Driverfactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.HomePage;
import utilities.ConfigReader;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

public class HomePageSteps {
	private static final Logger log = LogManager.getLogger(HomePageSteps.class);
	HomePage homepage = new HomePage();
	
	@Given("User is on  Dsportal Page.")
	public void user_is_on_dsportal_page() throws Exception{
		log.info("user launches DSportal page");
		homepage.getdsalgourl();
	}
	@When("User clicks on the {string} button.")
	public void user_clicks_on_the_button(String string) throws InterruptedException {
			homepage.clickongetstarted(string);
			log.info("user clicks on Get Started button to enter home page");
		}
	@Then("User should land in home page.")
	public void user_should_land_in_home_page() {
		String Title = homepage.GetPageTitle();
		System.out.println("Verifying Title of HomePage " + Title);
		Assert.assertEquals("NumpyNinja", Title);
	}
	
	 @Given("User on Home page.")
	 public void user_on_home_page() {
		 homepage.gethomePageurl();
	 }
	 @When("User clicks on Register link.")
	 public void user_clicks_on_register_link() {
	     homepage.registerlink();
	 }
	 @Then("user should land in Registration Page.")
		public void user_should_land_in_the_Registration_page() {
			String title = homepage.Getregisterpagetitle();
			Assert.assertEquals("Registration", title);
		}
		
	 @Given("User is on homepag.")
	 public void user_is_on_homepag() {
		 homepage.gethomePageurl();
	 }

	 @When("User clicks on Sign in link.")
	 public void user_clicks_on_sign_in_link() {
	     homepage.Signinlink();
	 }
	 
	 @Then("user should land in Login Page.")
		public void user_should_land_in_the_Login_page() {
			String title = homepage.GetSigninpagetitle();
			Assert.assertEquals("Login", title);
		}
	//=========working===============================# 
	 @Given("User is on home page.")
	 public void user_is_on_home_page() {
		 homepage.gethomePageurl();
	 }

	 @When("User clicks on Datastructure dropdown.")
	 public void user_clicks_on_datastructure_dropdown() {
		 homepage.datastrdropdown();
	 }

	 @Then("user should be able to see list all the options in the dropdown.")
	 public void user_should_be_able_to_see_list_all_the_options_in_the_dropdown() {
		 List<WebElement> listset = homepage. displaydropdwownlist();
		 System.out.println(listset);
		 return;
	 }
	 
//	 ===========working==============//
	 @Given("User is on homepage.")
	 public void user_is_on_homepage() {
		 homepage.gethomePageurl();
	 }

	 @When("User clicks on {string} button of  any datastructures {string} in the HomePage.")
	 public void user_clicks_on_button_of_any_datastructures_in_the_home_page(String string, String string2) {
		 homepage.clickgetstartedArray();
		 homepage.clickgetstartedStack();
	 }

	 @Then("user should get alert message.")
	 public void user_should_get_alert_message() {
		 String actualmessage = homepage.displayalertmessage();
		 Assert.assertEquals("You are not logged in", actualmessage);
	 }
	 
	 @Given("User enters home page.")
	 public void user_enters_home_page() {
		 
		 homepage.gethomePageurl();
	 }

	 @When("User clicks on Datastructure dropdown and click on {string} in the list.")
	 public void user_clicks_on_datastructure_dropdown_and_click_on_in_the_list(String string) {
		 homepage.datastrdropdown();
		 homepage.clickondropdownarray();
		
//		 homepage.clickondropdownstack();
	 }


	 
	 
}
	
	
