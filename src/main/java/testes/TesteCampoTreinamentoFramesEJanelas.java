package testes;

import static core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import core.BaseTeste;
import core.DSL;
import pages.CampoDeTreinamentoPage;

public class TesteCampoTreinamentoFramesEJanelas extends BaseTeste{
	
	private WebDriver driver;
	private DSL dsl;
	private CampoDeTreinamentoPage page;
	
	@Before
    public void setUp() {
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL();
		page = new CampoDeTreinamentoPage();
    }
		
	@Test
	public void testeInteragirFrame() {
		page.setFrame1();
		page.setClickBotaoFrame();
		assertEquals("Frame OK!", page.getTextoAlerta());
	}
	
	@Test
	public void testeInteragirJanelasComtitulo() {
		String janelaPrincipal = driver.getWindowHandle();
		page.setClickPopUpComNome();
		dsl.trocaParaJanela("Popup");
		dsl.escreverTag("textarea", "Teste de escrita");
		driver.close();
		dsl.trocaParaJanela(janelaPrincipal);
		assertEquals("Campo de Treinamento", driver.getTitle());
	}
	
	@Test
	public void testeInteragirJanelasSemtitulo() {
		page.setClickPopUpSemNome();
		Set<String> idJanelas = driver.getWindowHandles();
		List<String> janelas = new ArrayList<>(idJanelas);
		dsl.trocaParaJanela(janelas.get(1));
		dsl.escreverTag("textarea", "Teste de escrita");
		driver.close();
		dsl.trocaParaJanela(janelas.get(0));
		assertEquals("Campo de Treinamento", driver.getTitle());
	}
	
	
}
