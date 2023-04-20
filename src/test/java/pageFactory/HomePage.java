package pageFactory;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Driverfactory.DriverFactory;
import junit.framework.Assert;
import utilities.ConfigReader;
import utilities.TestUtill; 
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class HomePage {
	public static  WebDriver driver=DriverFactory.getdriver();
	private String URL = ConfigReader.getdsAlgourl();
	private String homePageurl=ConfigReader.getHomePageurl();
	
	@FindBy(xpath = "//a/button[contains(text(),'Get Started')]")
	WebElement clickgetstarted;
	@FindBy(linkText = "Register")
	WebElement clickonregisterlink;
	@FindBy(linkText = "Sign in")
	WebElement clickonsignin;
	@FindBy(xpath = "//*[@class ='nav-link dropdown-toggle']")
	WebElement datastrDropdown;
	@FindBy(xpath = ("//div[@class='dropdown-menu show']"))
	//(//div[@class='dropdown-menu show'])[1]
	List<WebElement> DropdownList;
	@FindBy(xpath = "//div[@role='alert']")
	WebElement Alertmessage;
	@FindBy(xpath= "//a[@class='dropdown-item' and @href='/array']")
	WebElement dropdownarray;
//	@FindBy(xpath= "//a[@class='dropdown-item' and @href='/stack']")
//	WebElement dropdownstack;
	
	

	// GETSTARTED-CLICKS
	@FindBy(xpath = "//a[@href='data-structures-introduction']")
	WebElement getstarteddatastrintro;
	@FindBy(xpath = "//a[@href ='array']")
	WebElement getstartedArray;
	@FindBy(xpath = "//a[@href ='linked-list']")
	WebElement getstartedLinkedlist;
	@FindBy(xpath = "//a[@href ='stack']")
	WebElement getstartedStack;
	@FindBy(xpath = "//a[@href ='graph']")
	WebElement getstartedgraph;
	@FindBy(xpath = "//a[@href ='tree']")
	WebElement getstartedTree;
	@FindBy(xpath = "//a[@href ='queue']")
	WebElement getstartedQueue;
	@FindBy(xpath ="//div[@role='alert']")
	WebElement alertmessage;

	// ACTIONS
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	public void getdsalgourl() {
		 
			driver.get(URL);
	}
	public String GetPageTitle() {
		return driver.getTitle();
	}
	public void clickongetstarted(String str) {
		clickgetstarted.click();
	
	}
	public void gethomePageurl() {
		homePageurl= ConfigReader.getHomePageurl();
		driver.get(homePageurl);
}

	public void registerlink() {
		clickonregisterlink.click();
	}
	
	public String Getregisterpagetitle() {
		RegisterPage registerPage = new RegisterPage();
		String title = registerPage.GetPageTitle();
		return title;
	}
	public void Signinlink() {
		clickonsignin.click();
	}

	public String GetSigninpagetitle() {
		SigninPage signinPage = new SigninPage();
		String title = signinPage.GetPageTitle();
		return title;
	}
//	 DATASTRUCTURE DROP DOWN IS PRESENT AND CLICKED
//	 SHOULD DISPLAY LIST OF DROPDOWN
	public void datastrdropdown() {
		 datastrDropdown.click();
		
	}
	
	public List<WebElement> displaydropdwownlist() {
		List<WebElement> list = DropdownList;
		return list;
		
	}
	public HomePage clickgetstartedArray() {
		getstartedArray.click();
		return new HomePage();
	}
	public HomePage clickgetstartedStack() {
		getstartedStack.click();
		return new HomePage();
	}
	public String displayalertmessage() {
		return alertmessage.getText();
		
	}
	
	public void clickondropdownarray() {
		dropdownarray.click();
		
	}
//	public void clickondropdownstack() {
//		dropdownstack.click();
//	}
//	// DRPODOWN LIST SELECTION
	public void clickondatastrDropdown() {
		for (WebElement list : DropdownList) {
			if (list.getText().contains("Array")) {
				list.click();
				return;
			} else if (list.getText().contains("Tree")) {
				list.click();
				return;
			}
		}
	}
}

