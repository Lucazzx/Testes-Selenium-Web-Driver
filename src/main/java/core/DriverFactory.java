package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	private DriverFactory() {}

	private static WebDriver driver;
	
	public static WebDriver getDriver() {
		if (driver == null) {
			driver = new FirefoxDriver();
			driver.manage().window().minimize();
		}		
		return driver;
	}
	
	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}		
	}

}
