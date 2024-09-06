package testes;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TesteCampoTreinamentoAlerts extends BaseTeste {
		
	@Test
	public void testeInteragirAlertSimples() {
		idElemento = "alert";

		WebElement botao = driver.findElement(By.id(idElemento));
		botao.click();
		Alert alert = driver.switchTo().alert();
		assertEquals("Alert Simples", alert.getText());
	}
	
	@Test
	public void testeInteragirAlertConfirmAccept() {
		idElemento = "confirm";

		WebElement botao = driver.findElement(By.id(idElemento));
		botao.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		assertEquals("Confirmado", alert.getText());
	}
	
	@Test
	public void testeInteragirAlertConfirmDismiss() {
		idElemento = "confirm";

		WebElement botao = driver.findElement(By.id(idElemento));
		botao.click();
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		assertEquals("Negado", alert.getText());
	}
	
	@Test
	public void testeInteragirPromptTexto1() {
		idElemento = "prompt";

		WebElement botao = driver.findElement(By.id(idElemento));
		botao.click();
		Alert alert = driver.switchTo().alert();
		assertEquals("Digite um numero", alert.getText());
	}
	
	@Test
	public void testeInteragirPromptTexto2() {
		idElemento = "prompt";

		WebElement botao = driver.findElement(By.id(idElemento));
		botao.click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("1");
		alert.accept();
		assertEquals("Era 1?", alert.getText());
	}
	
	@Test
	public void testeInteragirPromptTexto3() {
		idElemento = "prompt";

		WebElement botao = driver.findElement(By.id(idElemento));
		botao.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		alert.accept();
		assertEquals(":D", alert.getText());
	}
}
