package hooks;

import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Driverfactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import utilities.ConfigReader;
import utilities.TestUtill;

public class Hooks {
	private static WebDriver driver;
	private static DriverFactory driverFactory;
	@BeforeAll
	public static void  before() throws Throwable {
		ConfigReader.intializeConfigProperties();
		String browser = ConfigReader.getBrowserType();
		driverFactory = new DriverFactory();
		driver = driverFactory.intializeBrowser(browser);
		System.out.println("intializing "+browser);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtill.IMPLICITWAIT));
	}
	
	@AfterStep
	public void afterstep(Scenario scenario) throws InterruptedException {
		if (scenario.isFailed()) {
			 Allure.addAttachment("failed test case", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
			 Thread.sleep(5000);
		}
	}
    @AfterAll 

public static void close() throws Exception{
    if (driver == null) {
        return;
    }
    driver.quit();
    driver = null;
}
	
}
