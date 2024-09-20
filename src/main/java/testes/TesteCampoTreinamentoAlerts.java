package testes;

import static core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import core.BaseTeste;
import core.DSL;
import pages.CampoDeTreinamentoPage;

public class TesteCampoTreinamentoAlerts extends BaseTeste{
		
	private DSL dsl;
	private CampoDeTreinamentoPage page;
	
	@Before
    public void setUp() {
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL();
		page = new CampoDeTreinamentoPage();
    }
	
	@Test
	public void testeInteragirAlertSimples() {
		page.setClickBotaoAlerta();
		assertEquals("Alert Simples", page.getTextoAlerta());
	}
	
	@Test
	public void testeInteragirAlertConfirmAccept() {
		page.setClickBotaoConfirma();
		dsl.trocaEAceitaAlerta();
		assertEquals("Confirmado", page.getTextoAlerta());
	}
	
	@Test
	public void testeInteragirAlertConfirmDismiss() {
		page.setClickBotaoConfirma();
		dsl.trocaENegaAlerta();
		assertEquals("Negado", page.getTextoAlerta());
	}
	
	@Test
	public void testeInteragirPromptTexto1() {
		page.setClickBotaoPrompt();
		assertEquals("Digite um numero", page.getTextoAlerta());
	}
	
	@Test
	public void testeInteragirPromptTexto2() {
		page.setClickBotaoPrompt();
		dsl.escreverAlerta("1");
		assertEquals("Era 1?", page.getTextoAlerta());
	}
	
	@Test
	public void testeInteragirPromptTexto3() {
		page.setClickBotaoPrompt();
		dsl.trocaEAceitaAlerta();
		dsl.trocaEAceitaAlerta();
		assertEquals(":D",  page.getTextoAlerta());
	}
}
