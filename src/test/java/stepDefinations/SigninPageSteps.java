package stepDefinations;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import Driverfactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.HomePage;
import pageFactory.SigninPage;
import utilities.ConfigReader;
import utilities.ExcelReader;

public class SigninPageSteps {
	
	SigninPage signpage = new SigninPage();
	static String username;
	static String password;
	static String message;
	Boolean isRequired;
	String path = "/Users/poorn/eclipse-workspace/DsAlgoProject/Testdata/loginexcel.xlsx";
			
	@Given("user is on sign in page.")
	public void user_is_on_sign_in_page() {
		signpage.getSigninPageurl();
	}

//	@When("user enters {string} and {int}")
//	public void user_enters_and(String String, Integer rownumber)
//			throws InvalidFormatException, IOException {
//		ExcelReader reader = new ExcelReader();
//		//String path = signpage.getexcelpath();
//		List<Map<String, String>> testdata = reader.getData("C:\\Users\\poorn\\eclipse-workspace\\DsAlgoProject\\Testdata\\loginexcel.xlsx", "Sheet1");
//		String username = testdata.get(rownumber).get("username");
//		String password = testdata.get(rownumber).get("password");
//		String message = testdata.get(rownumber).get("expectedmessage");
//		signpage.enterdetails(username, password, message);
//		signpage.clickonloginbutton();
////		if (username != null || password != null)
////			signpage.Loginpage(username, password);
////	}
//	}
	
	@When("user enters {string} and  {int}")
	public void user_enters_and(String SheetName, Integer rownumber) throws InvalidFormatException, IOException, InterruptedException {
		ExcelReader reader = new ExcelReader();
		//String excelpath = signpage.getexcelpath();
		List<Map<String, String>> testdata = reader.getData("C:/Users/poorn/eclipse-workspace/DsAlgoProject/Testdata/loginexcel.xlsx",SheetName);
		String username = testdata.get(rownumber).get("username");
		String password = testdata.get(rownumber).get("password");
		String message = testdata.get(rownumber).get("expectedmessage");
		signpage.enterdetails(username, password, message);
		signpage.clickonloginbutton();
		Thread.sleep(1000);
	}
	@Then("user gets message {string}.")
	public void user_gets_message(String string) throws InterruptedException {
		//Thread.sleep(5000);
		String Alertmessage = signpage.alertmsg();
			Assert.assertEquals(string,Alertmessage);
		//signpage.clickonloginbutton();
		
	}
//	@Then("user gets message {string}")
//	public void user_gets_message(String String) throws InterruptedException {
//		
//		Thread.sleep(2000);
//		String Alertmessage = signpage.alertmsg();
//		Assert.assertEquals(Alertmessage, String);
//		
//	}
		
//	@Then("user clicks on {string} button.")
//	public void user_clicks_on_button(String string) {
//		signpage.clickonloginbutton();
//	}
	
	@When("user clicks on {string} link.")
	public void user_clicks_on_link(String string) {
		signpage.registerlink();
		
	}

	@Then("user should land in register page.")
	public void user_should_land_in_register_page() {
		signpage.registerpage();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	
//	//String Excelpath = ConfigReader.getExcelPageurl();
//
//	// User is on Sigin page
//	@Given("The user is on signin page")
//	public void the_user_is_on_signin_page() {
//
//		sign.getSigninPageurl();
//	}
//	
//	@When("The user enter sheet {string} and {int}")
//
//	public void the_user_enter_sheet_and(String sheetname, Integer rownumber)
//
//			throws InvalidFormatException, IOException {
//
//
//		ExcelReader reader = new ExcelReader();
//
//
//		List<Map<String, String>> testdata = reader.getData("C:\\Users\\poorn\\eclipse-workspace\\DsAlgoProject\\Testdata\\loginexcel.xlsx", sheetname);
//
//		username = testdata.get(rownumber).get("username");
//
//		password = testdata.get(rownumber).get("password");
//
//		message = testdata.get(rownumber).get("expectedmessage");
//
//
//
//		if (username != null || password != null)
//
//			sign.Loginpage(username, password);
//
//
//	}
//
//	@Then("click login button")
//	public void click_login_button() {
//
//		sign.clickonloginbutton();
//
//	}
//
//	

	
	

	
	

}
