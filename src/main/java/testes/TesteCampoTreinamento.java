package testes;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteCampoTreinamento {
	
	@Test
	public void testeTextField() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().minimize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste de escrita");
		assertEquals("Teste de escrita", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		
		driver.quit();	
	}
	
	@Test
	public void testeTextArea() {
		WebDriver driver = new FirefoxDriver();
		//driver.manage().window().minimize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("TesteLinha1\nTesteLinha2\n\n\n\n\n\nTesteLinha8");
		assertEquals("TesteLinha1\nTesteLinha2\n\n\n\n\n\nTesteLinha8", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		
		//driver.quit();	
	}

}
