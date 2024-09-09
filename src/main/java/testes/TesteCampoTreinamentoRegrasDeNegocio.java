package testes;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamentoRegrasDeNegocio extends BaseTeste {
		
	@Test
	public void testeRegraDeNegocioNome() {
		idElemento = "elementosForm:cadastrar";
		WebElement botao = driver.findElement(By.id(idElemento));
		botao.click();
		
		Alert alert = driver.switchTo().alert();
		assertEquals("Nome eh obrigatorio", alert.getText());
	}
	
	@Test
	public void testeRegraDeNegocioSobrenome() {
		idElemento = "elementosForm:nome";
		WebElement texto = driver.findElement(By.id(idElemento));
		texto.sendKeys("ExemploNome");
		
		idElemento = "elementosForm:cadastrar";
		WebElement botao = driver.findElement(By.id(idElemento));
		botao.click();
		
		Alert alert = driver.switchTo().alert();
		assertEquals("Sobrenome eh obrigatorio", alert.getText());
	}
	
	@Test
	public void testeRegraDeNegocioSexo() {
		idElemento = "elementosForm:nome";
		WebElement texto = driver.findElement(By.id(idElemento));
		texto.sendKeys("ExemploNome");
		
		idElemento = "elementosForm:sobrenome";
		texto = driver.findElement(By.id(idElemento));
		texto.sendKeys("ExemploSobrenome");
		
		idElemento = "elementosForm:cadastrar";
		WebElement botao = driver.findElement(By.id(idElemento));
		botao.click();
		
		Alert alert = driver.switchTo().alert();
		assertEquals("Sexo eh obrigatorio", alert.getText());
	}
	
	@Test
	public void testeRegraDeNegocioComida() {
		idElemento = "elementosForm:nome";
		WebElement texto = driver.findElement(By.id(idElemento));
		texto.sendKeys("ExemploNome");
		
		idElemento = "elementosForm:sobrenome";
		texto = driver.findElement(By.id(idElemento));
		texto.sendKeys("ExemploSobrenome");
		
		idElemento = "elementosForm:sexo:0";
		driver.findElement(By.id(idElemento)).click();
		
		idElemento = "elementosForm:comidaFavorita:0";
		driver.findElement(By.id(idElemento)).click();
		idElemento = "elementosForm:comidaFavorita:3";
		driver.findElement(By.id(idElemento)).click();
		
		idElemento = "elementosForm:cadastrar";
		WebElement botao = driver.findElement(By.id(idElemento));
		botao.click();
		
		Alert alert = driver.switchTo().alert();
		assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());
	}
	
	@Test
	public void testeRegraDeNegocioEsporte() {
		idElemento = "elementosForm:nome";
		WebElement texto = driver.findElement(By.id(idElemento));
		texto.sendKeys("ExemploNome");
		
		idElemento = "elementosForm:sobrenome";
		texto = driver.findElement(By.id(idElemento));
		texto.sendKeys("ExemploSobrenome");
		
		idElemento = "elementosForm:sexo:0";
		driver.findElement(By.id(idElemento)).click();
		
		idElemento = "elementosForm:comidaFavorita:0";
		driver.findElement(By.id(idElemento)).click();
		
		idElemento = "elementosForm:esportes";
		WebElement element = driver.findElement(By.id(idElemento));
		Select combo = new Select(element);
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("O que eh esporte?");
		
		idElemento = "elementosForm:cadastrar";
		WebElement botao = driver.findElement(By.id(idElemento));
		botao.click();
		
		Alert alert = driver.switchTo().alert();
		assertEquals("Voce faz esporte ou nao?", alert.getText());
	}



	
	
}
