package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	private DriverFactory() {}

	private static WebDriver driver;
	
	public static WebDriver getDriver() {
		if (driver == null) {
			
			switch (Propriedades.browser) {
			case FIREFOX: driver = new FirefoxDriver();break;
			case CHROME: driver = new ChromeDriver();break;
			}
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
