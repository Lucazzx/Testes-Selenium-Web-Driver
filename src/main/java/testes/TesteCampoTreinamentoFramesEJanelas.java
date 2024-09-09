package testes;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class TesteCampoTreinamentoFramesEJanelas extends DSLBaseTeste {
		
	@Test
	public void testeInteragirFrame() {
		trocaParaFrame(FRAME_1);
		clicar(BOTAO_FRAME);
		assertEquals("Frame OK!", obterTextoAlerta());
	}
	
	@Test
	public void testeInteragirJanelasComtitulo() {
		String janelaPrincipal = driver.getWindowHandle();
		clicar(BOTAO_POPUP_COM_NOME);
		trocaParaJanela("Popup");
		escreverTag("textarea", "Teste de escrita");
		driver.close();
		trocaParaJanela(janelaPrincipal);
		assertEquals("Campo de Treinamento", driver.getTitle());
	}
	
	@Test
	public void testeInteragirJanelasSemtitulo() {
		clicar(BOTAO_POPUP_SEM_NOME);
		Set<String> idJanelas = driver.getWindowHandles();
		List<String> janelas = new ArrayList<>(idJanelas);
		trocaParaJanela(janelas.get(1));
		escreverTag("textarea", "Teste de escrita");
		driver.close();
		trocaParaJanela(janelas.get(0));
		assertEquals("Campo de Treinamento", driver.getTitle());
	}
	
	
}
