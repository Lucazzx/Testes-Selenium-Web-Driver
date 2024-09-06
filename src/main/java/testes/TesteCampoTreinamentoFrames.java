package testes;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TesteCampoTreinamentoFrames extends BaseTeste {
		
	@Test
	public void testeInteragirFrame() {
		idElemento = "frameButton";
		driver.switchTo().frame("frame1");
		WebElement botao = driver.findElement(By.id(idElemento));
		botao.click();
		Alert alert = driver.switchTo().alert();
		assertEquals("Frame OK!", alert.getText());
	}
}
