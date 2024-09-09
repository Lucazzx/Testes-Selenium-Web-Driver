package testes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TesteCampoTreinamentoAlerts extends DSLBaseTeste {
		
	@Test
	public void testeInteragirAlertSimples() {
		clicar(ALERTA);
		assertEquals("Alert Simples", obterTextoAlerta());
	}
	
	@Test
	public void testeInteragirAlertConfirmAccept() {
		clicar(CONFIRMA);
		trocaEAceitaAlerta();
		assertEquals("Confirmado", obterTextoAlerta());
	}
	
	@Test
	public void testeInteragirAlertConfirmDismiss() {
		clicar(CONFIRMA);
		trocaENegaAlerta();
		assertEquals("Negado", obterTextoAlerta());
	}
	
	@Test
	public void testeInteragirPromptTexto1() {
		clicar(PROMPT);
		assertEquals("Digite um numero", obterTextoAlerta());
	}
	
	@Test
	public void testeInteragirPromptTexto2() {
		clicar(PROMPT);
		escreverAlerta("1");
		assertEquals("Era 1?", obterTextoAlerta());
	}
	
	@Test
	public void testeInteragirPromptTexto3() {
		clicar(PROMPT);
		trocaEAceitaAlerta();
		trocaEAceitaAlerta();
		assertEquals(":D",  obterTextoAlerta());
	}
}
