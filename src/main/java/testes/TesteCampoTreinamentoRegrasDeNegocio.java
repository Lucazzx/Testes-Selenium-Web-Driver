package testes;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteCampoTreinamentoRegrasDeNegocio {
	
	private WebDriver driver;
	private CampoDeTreinamentoPage page;
	
	@Before
    public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().minimize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		page = new CampoDeTreinamentoPage(driver);
    }

    @After
    public void tearDown() {
		driver.quit();
    }
		
	@Test
	public void testeRegraDeNegocioNome() {
		page.setClickBotaoCadastrar();
		
		assertEquals("Nome eh obrigatorio", page.getTextoAlerta());
	}
	
	@Test
	public void testeRegraDeNegocioSobrenome() {
		page.setNome("ExemploNome");
		page.setClickBotaoCadastrar();
		
		assertEquals("Sobrenome eh obrigatorio", page.getTextoAlerta());
	}
	
	@Test
	public void testeRegraDeNegocioSexo() {
		page.setNome("ExemploNome");
		page.setSobrenome("ExemploSobrenome");
		page.setClickBotaoCadastrar();
		
		assertEquals("Sexo eh obrigatorio", page.getTextoAlerta());
	}
	
	@Test
	public void testeRegraDeNegocioComida() {
		page.setNome("ExemploNome");
		page.setSobrenome("ExemploSobrenome");
		page.setSexoMasculino();
		page.setComidaCarne();
		page.setComidaVegetariano();
		page.setClickBotaoCadastrar();
		
		assertEquals("Tem certeza que voce eh vegetariano?", page.getTextoAlerta());
	}
	
	@Test
	public void testeRegraDeNegocioEsporte() {
		page.setNome("ExemploNome");
		page.setSobrenome("ExemploSobrenome");
		page.setSexoMasculino();
		page.setComidaCarne();
		page.setEsporte("Natacao");
		page.setEsporte("O que eh esporte?");
		page.setClickBotaoCadastrar();
		
		assertEquals("Voce faz esporte ou nao?", page.getTextoAlerta());
	}



	
	
}
