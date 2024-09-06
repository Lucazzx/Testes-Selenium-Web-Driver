package testes;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TesteCampoTreinamentoFramesEJanelas extends BaseTeste {
		
	@Test
	public void testeInteragirFrame() {
		idElemento = "frameButton";
		driver.switchTo().frame("frame1");
		WebElement botao = driver.findElement(By.id(idElemento));
		botao.click();
		Alert alert = driver.switchTo().alert();
		assertEquals("Frame OK!", alert.getText());
	}
	
	@Test
	public void testeInteragirJanelasComtitulo() {
		idElemento = "buttonPopUpEasy";
		String janelaPrincipal = driver.getWindowHandle();
		WebElement botao = driver.findElement(By.id(idElemento));
		botao.click();
		driver.switchTo().window("Popup");
		driver.findElement(By.tagName("textarea")).sendKeys("Teste de escrita");
		driver.close();
		driver.switchTo().window(janelaPrincipal);
		assertEquals("Campo de Treinamento", driver.getTitle());
	}
	
	@Test
	public void testeInteragirJanelasSemtitulo() {
		idElemento = "buttonPopUpHard";
		WebElement botao = driver.findElement(By.id(idElemento));
		botao.click();
		Set<String> idJanelas = driver.getWindowHandles();
		List<String> janelas = new ArrayList<>(idJanelas);
		driver.switchTo().window(janelas.get(1));
		driver.findElement(By.tagName("textarea")).sendKeys("Teste de escrita");
		driver.close();
		driver.switchTo().window(janelas.get(0));
		assertEquals("Campo de Treinamento", driver.getTitle());
	}
	
	
}
