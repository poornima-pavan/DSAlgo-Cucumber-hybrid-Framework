package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static Properties properties;
	private static String Filepath = "C:\\Users\\poorn\\eclipse-workspace\\DsAlgoProject\\src\\test\\resources\\Config\\config.properties";
	
	public static void intializeConfigProperties() throws Throwable {

		try {
			FileInputStream input;

			input = new FileInputStream(Filepath);
			properties = new Properties();
			
			try {
				properties.load(input);
				input.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Confi.properties not found" + Filepath);
		}
	}

	public static String getBrowserType() {
		String browser = properties.getProperty("browser");
		System.out.println("test line"+browser);
		return browser;
	}

	public static String getdsAlgourl() {
		String url = properties.getProperty("url");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	public static String getHomePageurl() {
		String homepageurl = properties.getProperty("HomePageurl");
		return homepageurl;
	}
	public static String getRegisterPageurl() {
		String registerpageurl = properties.getProperty("RegisterPageurl");
		return registerpageurl;
	}
	public static String getSigninPageurl() {
		String signinpageurl = properties.getProperty("SigninPageurl");
		return signinpageurl;
	}
	
	public static String getExcelPageurl() {
		String ExcelPageurl = properties.getProperty("ExcelPageurl");
		return ExcelPageurl;
	}
}
