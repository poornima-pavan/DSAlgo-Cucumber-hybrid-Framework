package stepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import Driverfactory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.HomePage;
import pageFactory.RegisterPage;
import pageFactory.SigninPage;
import utilities.ConfigReader;

import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import org.junit.Assert;

public class RegisterPageSteps {
	RegisterPage registerPage = new RegisterPage();
	
	@Given("User launches Register Page.")
	public void user_launches_register_page() {
		registerPage.getRegisterPageurl();
	}

	@When("User enters username {string} ,{string} and {string}.")
	public void user_enters_username_and(String username, String password, String password_confirmation,
			io.cucumber.datatable.DataTable dataTable) {
		registerPage.enterusername(username);
		registerPage.enterpassword(password);
		registerPage.enterconfirmationpassword(password_confirmation);

	}

	@Then("clicks on register button and should land in homepage.")
	public void clicks_on_register_button_and_should_land_in_homepage() {
		registerPage.clickonregister();
		String message = registerPage.GetPageTitle();
		Assert.assertEquals("NumpyNinja", message);
	}

	@When("User enters partial  data {string} {string} {string}")
	public void user_enters_partial_data(String username, String password, String password_confirmation) {
		registerPage.enterusername(username);
		registerPage.enterpassword(password);
		registerPage.enterconfirmationpassword(password_confirmation);

	}

	@Then("It should display an error {string}")
	public void it_should_display_an_error(String string) {
		registerPage.clickonregister();
		String message = registerPage.geterrormessage();
		Assert.assertEquals("password_mismatch:The two password fields didn’t match.", message);
	}

}