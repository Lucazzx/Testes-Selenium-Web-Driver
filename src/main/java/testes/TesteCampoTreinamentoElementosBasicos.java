package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamentoElementosBasicos extends BaseTeste {
	
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
	
	@Test
	public void testeInteragirBotaoCliqueMe() {
		idElemento = "buttonSimple";

		WebElement botao = driver.findElement(By.id(idElemento));
		botao.click();
		assertEquals("Obrigado!", botao.getAttribute("value"));
	}
	
	@Test
	public void testeInteragirLinkVoltar() {
		WebElement link = driver.findElement(By.linkText("Voltar"));
		link.click();
		WebElement texto = driver.findElement(By.id("resultado"));
		assertEquals("Voltou!", texto.getText());
	}
	
	@Test
	public void testeBuscarTexto() {
		WebElement texto = driver.findElement(By.tagName("h3"));
		assertEquals("Campo de Treinamento", texto.getText());
	}
	
	@Test
	public void testeCadastroCompleto() {
		
		String[] dadosTexto = {"Lucas", "Sousa", "Incluindo sugestões"};
		String[] idElementos = {"elementosForm:nome", "elementosForm:sobrenome", "elementosForm:sugestoes",
				"elementosForm:sexo:0", "elementosForm:comidaFavorita:2", "elementosForm:escolaridade",
				"elementosForm:esportes", "elementosForm:cadastrar", "resultado"};
		
		driver.findElement(By.id(idElementos[0])).sendKeys(dadosTexto[0]);
		driver.findElement(By.id(idElementos[1])).sendKeys(dadosTexto[1]);
		driver.findElement(By.id(idElementos[2])).sendKeys(dadosTexto[2]);
		driver.findElement(By.id(idElementos[3])).click();
		driver.findElement(By.id(idElementos[4])).click();
		Select combo = new Select(driver.findElement(By.id(idElementos[5])));
		combo.selectByVisibleText("Superior");
		combo = new Select(driver.findElement(By.id(idElementos[6])));
		combo.selectByVisibleText("Corrida");
		driver.findElement(By.id(idElementos[7])).click();
		
		WebElement divResultado = driver.findElement(By.id(idElementos[8]));
		
		assertEquals("Cadastrado! " 
		+ "Nome: Lucas "
		+ "Sobrenome: Sousa "
		+ "Sexo: Masculino "
		+ "Comida: Pizza "
		+ "Escolaridade: superior "
		+ "Esportes: Corrida "
		+ "Sugestoes: Incluindo sugestões", 
		divResultado.getText().replaceAll("\\s+", " ").trim());
		
	}
}
