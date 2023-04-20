package pageFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Driverfactory.DriverFactory;
import utilities.ConfigReader;
import utilities.TestUtill;

public class RegisterPage {
	private WebDriver driver = DriverFactory.getdriver();
	private String RegisterPageurl = ConfigReader.getRegisterPageurl();
	private String homepageurl = ConfigReader.getHomePageurl();

	@FindBy(xpath = "(//div[@role='alert'])[1]")
	WebElement errormsg;
	@FindBy(id = "id_username")
	WebElement user;
	@FindBy(name = "password1")
	WebElement pass1;
	@FindBy(name = "password2")
	WebElement pass2;
	@FindBy(xpath = "//form/input[@type='submit']")
	WebElement submitregister;

	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}

	public void getRegisterPageurl() {
		driver.get(RegisterPageurl);
	}

	public String GetPageTitle() {
		String title = driver.getTitle();
		System.out.println(title);
		return title;
	}

	public void enterusername(String username) {
		user.sendKeys(username);
	}

	public void enterpassword(String password1) {
		pass1.sendKeys(password1);
	}

	public void enterconfirmationpassword(String password1) {
		pass2.sendKeys(password1);
	}

	public void clickonregister() {
		submitregister.click();

	}
	 public String geterrormessage() {
		 String actual = errormsg.getText();
		 return actual;
	 }
}
