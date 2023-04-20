package pageFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Driverfactory.DriverFactory;
import utilities.ConfigReader;
public class SigninPage {
	public  static WebDriver driver=DriverFactory.getdriver();
	String SigninURL=ConfigReader.getSigninPageurl();
	boolean isRequired;
	private String URL = ConfigReader.getdsAlgourl();

	@FindBy(xpath="//*[@id='id_username']")static WebElement  loginname;
	@FindBy(xpath="//*[@id='id_password']")static WebElement loginpassword;
	@FindBy(xpath="//input[@type='submit']")WebElement loginbutton;
	@FindBy(linkText = "Register!")WebElement registerlink;
	
	public SigninPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void getSigninPageurl() {
		driver.get(SigninURL);
}
	public void clickonloginbutton() {
		loginbutton.click();
	}
	
	public void registerlink() {
		registerlink.click();
	}
	//landing in register
	public void registerpage() {
		String Title =driver.getTitle();
		System.out.println(Title);
	}
	
	public String GetPageTitle() {
		return driver.getTitle();
		
	}
	
	public Boolean Loginpage(String username, String password) {
		loginname.clear();
		loginname.sendKeys(username);
		loginpassword.clear();
		loginpassword.sendKeys(password);
		if (username.isBlank()) {
			JavascriptExecutor js_user = (JavascriptExecutor) driver;
			isRequired = (Boolean) js_user.executeScript("return arguments[0].required;", loginname);
			return isRequired;
		} else if (password.isBlank()) {
			JavascriptExecutor js_password = (JavascriptExecutor) driver;
			isRequired = (Boolean) js_password.executeScript("return arguments[0].required;", loginpassword);
			return isRequired;
		}
		return isRequired;
	}

	

}
