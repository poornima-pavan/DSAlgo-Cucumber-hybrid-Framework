package testRunner;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\poorn\\eclipse-workspace\\DsAlgoProject\\src\\test\\resources\\Features\\Signin.feature"
		,glue={"stepDefinations", "hooks"}
		,dryRun= false
		,monochrome = true
		,plugin = {"pretty" ,"json:target/cucumber.json","html:target/site/cucumber-pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
			     "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
				//output in html /xml/json format

public class TestRunner {
	public static void main(String[] args) {
		
	}

}
