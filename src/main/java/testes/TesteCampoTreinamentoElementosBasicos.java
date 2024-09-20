package testes;

import static core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import core.BaseTeste;
import core.DSL;
import pages.CampoDeTreinamentoPage;

public class TesteCampoTreinamentoElementosBasicos extends BaseTeste {
	
	private DSL dsl;
	private CampoDeTreinamentoPage page;
	
	@Before
    public void setUp() {
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL();
		page = new CampoDeTreinamentoPage();
    }

	
	@Test
	public void testeTextField() {
		String texto = "Teste de escrita";
		page.setNome(texto);
		assertEquals(texto, page.getNome());
	}
	
	@Test
	public void testeTextArea() {
		String texto = "TesteLinha1\nTesteLinha2\n\n\n\n\n\nTesteLinha8" ;
		page.setSugestoes(texto);
		assertEquals(texto, page.getSugestoes());
	}
	
	@Test
	public void testeRadioButton() {
		page.setSexoMasculino();
		assertTrue(page.getSexoMasculino());
	}
	
	@Test
	public void testeCheckBox() {
		page.setComidaPizza();
		assertTrue(page.getComidaPizza());
	}
	
	@Test
	public void testeComboBox() {
		String [] valor = {"2o grau incompleto"};
		page.setEscolaridade(valor);
		assertEquals(valor[0], page.getEscolaridade());		
	}
	
	@Test
	public void testeValoresComboBox() {
		assertTrue(page.getDaListaEscolaridade("Mestrado"));
	}
	
	@Test
	public void testeValoresComboMultiplo() {
		WebElement element = getDriver().findElement(By.id(CampoDeTreinamentoPage.COMBO_ESPORTE));
		Select combo = new Select(element);
		
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Corrida");
		combo.selectByVisibleText("O que eh esporte?");
		
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		assertEquals(3, allSelectedOptions.size());
	}
	
	@Test
	public void testeInteragirBotaoCliqueMe() {
		page.setClickBotaoCliqueMe();
		assertEquals("Obrigado!", page.getBotaoCliqueMe());
	}
	
	@Test
	public void testeInteragirLinkVoltar() {
		page.setClickLinkVoltar();
		assertEquals("Voltou!", page.getResultado());
	}
	
	@Test
	public void testeBuscarTexto() {
		assertEquals("Campo de Treinamento", dsl.obterTextoTag("h3"));
	}
	
	@Test
	public void testeCadastroCompleto() {
		page.setNome("Lucas");
		page.setSobrenome("Sousa");
		page.setSugestoes("Incluindo sugestões");
		page.setSexoMasculino();
		page.setComidaPizza();
		page.setEscolaridade("Superior");
		page.setEsporte("Corrida");
		page.setClickBotaoCadastrar();

		WebElement divResultado = getDriver().findElement(By.id(CampoDeTreinamentoPage.RESULTADO));
		
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
	
	@Test
	@Ignore
	// exemplo de uso de js no selenium
	public void testeJavascript() {
		dsl.executarJS("arguments[0].style.border = arguments[1]", 
				getDriver().findElement(By.id("elementosForm:nome")), 
				"solid 4px red");
		
	}
	
	@Test
	public void testeClicarBotaotabela() {
		String coluna = "Escolaridade";
		String valor = "Mestrado";
		String nome = "Usuario A";
		
		dsl.clicarBotaoTabela(coluna, valor, "Botao", "elementosForm:tableUsuarios");
		dsl.trocaParaAlerta();
		assertEquals(nome, page.getTextoAlerta());
	}
}
