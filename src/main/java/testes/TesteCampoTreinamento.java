package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {
	
	WebDriver driver;
	String idElemento;
	
	@Before
	public void setUp () {
		driver = new FirefoxDriver();
		driver.manage().window().minimize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	}
	
	@Test
	public void testeTextField() {
		idElemento = "elementosForm:nome";

		driver.findElement(By.id(idElemento)).sendKeys("Teste de escrita");
		assertEquals("Teste de escrita", driver.findElement(By.id(idElemento)).getAttribute("value"));
	}
	
	@Test
	public void testeTextArea() {
		idElemento = "elementosForm:sugestoes";

		driver.findElement(By.id(idElemento)).sendKeys("TesteLinha1\nTesteLinha2\n\n\n\n\n\nTesteLinha8");
		assertEquals("TesteLinha1\nTesteLinha2\n\n\n\n\n\nTesteLinha8", driver.findElement(By.id(idElemento)).getAttribute("value"));
	}
	
	@Test
	public void testeRadioButton() {
		idElemento = "elementosForm:sexo:0";

		driver.findElement(By.id(idElemento)).click();
		assertTrue(driver.findElement(By.id(idElemento)).isSelected());
	}
	
	@Test
	public void testeCheckBox() {
		idElemento = "elementosForm:comidaFavorita:2";

		driver.findElement(By.id(idElemento)).click();
		assertTrue(driver.findElement(By.id(idElemento)).isSelected());
	}
	
	@Test
	public void testeComboBox() {
		idElemento = "elementosForm:escolaridade";

		WebElement element = driver.findElement(By.id(idElemento));
		Select combo = new Select(element);
		//combo.selectByIndex(2);
		//combo.selectByValue("2grauincomp");
		combo.selectByVisibleText("2o grau incompleto");
		assertEquals("2o grau incompleto", combo.getFirstSelectedOption().getText());		
	}
	
	
	@Test
	public void testeValoresComboBox() {
		idElemento = "elementosForm:escolaridade";

		WebElement element = driver.findElement(By.id(idElemento));
		Select combo = new Select(element);

		List<WebElement> options = combo.getOptions();
		assertEquals(8, options.size());
		
		boolean encontrouElemento = false;
		for(WebElement option : options) {
			if (option.getText().equals("Mestrado")) {
				encontrouElemento = true;
				break;
			}
		}
		assertTrue(encontrouElemento);
	}
	
	@Test
	public void testeValoresComboMultiplo() {
		idElemento = "elementosForm:esportes";

		WebElement element = driver.findElement(By.id(idElemento));
		Select combo = new Select(element);
		
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Corrida");
		combo.selectByVisibleText("O que eh esporte?");
		
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		assertEquals(3, allSelectedOptions.size());
	}
	
	
	@After
	public void TearDown() {
		driver.quit();
	}

}
