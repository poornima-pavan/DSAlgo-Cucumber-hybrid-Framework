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

	@When("User enters details.")
	public void user_enters_details(DataTable dataTable) {
		registerPage.enterusername(dataTable.cell(1, 0));
		registerPage.enterpassword(dataTable.cell(1, 1));
		registerPage.enterconfirmationpassword(dataTable.cell(1, 2));
		registerPage.clickonregister();

	}

	@Then("clicks on register button and should land in homepage.")
	public void clicks_on_register_button_and_should_land_in_homepage() throws InterruptedException {
		Thread.sleep(1000);
		String message = registerPage.GetPageTitle();
		Assert.assertEquals("NumpyNinja", message);
	}

	@When("User enters partial  data (.*) , (.*) and (.*)$")
	public void user_enters_partial_data(String username, String password, String password_confirmation) {
		registerPage.enterusername(username);
		registerPage.enterpassword(password);
		registerPage.enterconfirmationpassword(password_confirmation);

	}

	@Then("user should not be allowed to register.")
	public void user_should_not_be_allowed_to_register() {
		registerPage.clickonregister();
		String message = registerPage.GetPageTitle();
		Assert.assertEquals("Registration", message);
	}

}