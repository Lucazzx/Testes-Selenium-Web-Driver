package testes;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Parameterized.class)
public class TesteCampoTreinamentoRegrasDeNegocio {
	
	private WebDriver driver;
	private CampoDeTreinamentoPage page;
	
	@Parameter
	public String nome;
	@Parameter(value=1)
	public String sobrenome;
	@Parameter(value=2)
	public String sexo;
	@Parameter(value=3)
	public List<String> comidas;
	@Parameter(value=4)
	public String [] esportes;
	@Parameter(value=5)
	public String mensagens;
	
	
	@Before
    public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().minimize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		page = new CampoDeTreinamentoPage();
    }

    @After
    public void tearDown() {
		driver.quit();
    }
		
    @Parameters
    public static Collection<Object[]> getCollection(){
    	return Arrays.asList(new Object[][]{
    		{"", "", "", Arrays.asList(), new String [] {}, "Nome eh obrigatorio"}, 
    		{"Nome", "", "", Arrays.asList(), new String [] {}, "Sobrenome eh obrigatorio"}, 
    		{"Nome", "Sobrenome", "", Arrays.asList(), new String [] {}, "Sexo eh obrigatorio"}, 
    		{"Nome", "Sobrenome", "Masculino", Arrays.asList("Carne", "Vegetariano"), new String [] {}, "Tem certeza que voce eh vegetariano?"}, 
    		{"Nome", "Sobrenome", "Masculino", Arrays.asList("Carne"), new String [] {"Futebol", "O que eh esporte?"}, "Voce faz esporte ou nao?"}, 
    	});
    }
    
	@Test
	public void testeRegrasDeNegocio() {
		page.setNome(nome);
		page.setSobrenome(sobrenome);
		if (sexo.equals("Masculino")) page.setSexoMasculino();
		if (sexo.equals("Feminino")) page.setSexoMasculino();
		if(comidas.contains("Carne")) page.setComidaCarne();
		if(comidas.contains("Frango")) page.setComidaFrango();
		if(comidas.contains("Pizza")) page.setComidaPizza();
		if(comidas.contains("Vegetariano")) page.setComidaVegetariano();
		page.setEsporte(esportes);
		page.setClickBotaoCadastrar();
		
		assertEquals(mensagens, page.getTextoAlerta());
	}	
}
