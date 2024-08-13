package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteCampoTreinamento {
	
	WebDriver driver;
	String idElemento;
	
	@Before
	public void setup () {
		driver = new FirefoxDriver();
		driver.manage().window().minimize();
	}
	
	@Test
	public void testeTextField() {
		idElemento = "elementosForm:nome";
		
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id(idElemento)).sendKeys("Teste de escrita");
		assertEquals("Teste de escrita", driver.findElement(By.id(idElemento)).getAttribute("value"));
		
	}
	
	@Test
	public void testeTextArea() {
		idElemento = "elementosForm:sugestoes";
		
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id(idElemento)).sendKeys("TesteLinha1\nTesteLinha2\n\n\n\n\n\nTesteLinha8");
		assertEquals("TesteLinha1\nTesteLinha2\n\n\n\n\n\nTesteLinha8", driver.findElement(By.id(idElemento)).getAttribute("value"));
		driver.quit();	
	}
	
	@Test
	public void testeRadioButton() {
		idElemento = "elementosForm:sexo:0";
		
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id(idElemento)).click();
		assertTrue(driver.findElement(By.id(idElemento)).isSelected());
		driver.quit();	
	}
	
	@Test
	public void testeCheckBox() {
		idElemento = "elementosForm:comidaFavorita:2";
		
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id(idElemento)).click();
		assertTrue(driver.findElement(By.id(idElemento)).isSelected());
		driver.quit();	
	}
	
	@After
	public void TearDown() {
		driver.quit();
	}

}
