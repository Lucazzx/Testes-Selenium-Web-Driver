package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamentoAlerts {
	
	WebDriver driver;
	String idElemento;
	
	@Before
	public void setUp () {
		driver = new FirefoxDriver();
		driver.manage().window().minimize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	}
	
	@Test
	public void testeInteragirAlert() {
		idElemento = "alert";

		WebElement botao = driver.findElement(By.id(idElemento));
		botao.click();
		Alert alert = driver.switchTo().alert();
		assertEquals("Alert Simples", alert.getText());
	}
	
	
	@After
	public void TearDown() {
		driver.quit();
	}

}
