package testes;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteGoogle {
	
	@Test
	public void teste() {
		WebDriver driver = new FirefoxDriver();
		//driver.manage().window().setPosition(new Point(100, 100));
		//driver.manage().window().setSize(new Dimension(800, 600));
		driver.manage().window().minimize();
		driver.get("https://www.google.com");
		Assert.assertEquals("Google", driver.getTitle());
		driver.quit();
	}

}
