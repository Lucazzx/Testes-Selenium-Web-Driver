package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamentoElementosBasicos extends DSLBaseTeste {
	
	
	
	
	@Test
	public void testeTextField() {
		String texto = "Teste de escrita";
		escrever(CAMPO_NOME, texto);
		assertEquals(texto, obterValorCampo(CAMPO_NOME));
	}
	
	@Test
	public void testeTextArea() {
		String texto = "TesteLinha1\nTesteLinha2\n\n\n\n\n\nTesteLinha8" ;
		escrever(CAMPO_SUGESTOES,texto);
		assertEquals(texto, obterValorCampo(CAMPO_SUGESTOES));
	}
	
	@Test
	public void testeRadioButton() {
		clicar(RADIO_SEXO_MASCULINO);
		assertTrue(estaMarcado(RADIO_SEXO_MASCULINO));
	}
	
	@Test
	public void testeCheckBox() {
		clicar(CHECKBOX_COMIDA_PIZZA);
		assertTrue(estaMarcado(CHECKBOX_COMIDA_PIZZA));
	}
	
	@Test
	public void testeComboBox() {
		String valor = "2o grau incompleto";
		selecionarCombo(COMBO_ESCOLARIDADE, valor);
		assertEquals(valor, obterValorCombo(COMBO_ESCOLARIDADE));		
	}
	
	
	@Test
	public void testeValoresComboBox() {
		assertTrue(procurarValorCombo(COMBO_ESCOLARIDADE, "Mestrado"));
	}
	
	@Test
	public void testeValoresComboMultiplo() {
		WebElement element = driver.findElement(By.id(COMBO_ESPORTE));
		Select combo = new Select(element);
		
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Corrida");
		combo.selectByVisibleText("O que eh esporte?");
		
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		assertEquals(3, allSelectedOptions.size());
	}
	
	@Test
	public void testeInteragirBotaoCliqueMe() {
		String id = BOTAO_SIMPLES;
		clicar(id);
		assertEquals("Obrigado!", obterValorCampo(id));
	}
	
	@Test
	public void testeInteragirLinkVoltar() {
		clicarLink("Voltar");
		assertEquals("Voltou!", obterValorCampo(RESULTADO));
	}
	
	@Test
	public void testeBuscarTexto() {
		assertEquals("Campo de Treinamento", obterTextoTag("h3"));
	}
	
	@Test
	public void testeCadastroCompleto() {
		
		String[] dadosTexto = {"Lucas", "Sousa", "Incluindo sugestões"};
		String[] idElementos = {CAMPO_NOME, CAMPO_SOBRENOME, CAMPO_SUGESTOES,
				RADIO_SEXO_MASCULINO, CHECKBOX_COMIDA_PIZZA, COMBO_ESCOLARIDADE,
				COMBO_ESPORTE, BOTAO_CADASTRAR, RESULTADO};
		escrever(idElementos[0], dadosTexto[0]);
		escrever(idElementos[1], dadosTexto[1]);
		escrever(idElementos[2], dadosTexto[2]);
		clicar(idElementos[3]);
		clicar(idElementos[4]);
		selecionarCombo(idElementos[5], "Superior");
		selecionarCombo(idElementos[6], "Corrida");
		clicar(idElementos[7]);
		
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
