package testes;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DSLBaseTeste {
	
    protected static final String CAMPO_NOME = "elementosForm:nome";
    protected static final String CAMPO_SOBRENOME = "elementosForm:sobrenome";
    protected static final String CAMPO_SUGESTOES = "elementosForm:sugestoes";
    protected static final String RADIO_SEXO_MASCULINO = "elementosForm:sexo:0";
    protected static final String CHECKBOX_COMIDA_CARNE = "elementosForm:comidaFavorita:0";
    protected static final String CHECKBOX_COMIDA_PIZZA = "elementosForm:comidaFavorita:2";
    protected static final String CHECKBOX_COMIDA_VEGETARIANO = "elementosForm:comidaFavorita:3";
    protected static final String COMBO_ESCOLARIDADE = "elementosForm:escolaridade";
    protected static final String COMBO_ESPORTE = "elementosForm:esportes";
    protected static final String BOTAO_CADASTRAR = "elementosForm:cadastrar";
    protected static final String RESULTADO = "resultado";
    protected static final String BOTAO_SIMPLES = "buttonSimple";
    protected static final String LINK_VOLTAR = "Voltar";
    protected static final String ALERTA = "Alert";
    protected static final String CONFIRMA = "Confirm";
    protected static final String PROMPT = "prompt";
    protected static final String BOTAO_FRAME = "frameButton";
    protected static final String FRAME_1 = "frame1";
    protected static final String BOTAO_POPUP_COM_NOME = "buttonPopUpEasy";
    protected static final String BOTAO_POPUP_SEM_NOME = "buttonPopUpHard";
	
    protected WebDriver driver;
    //protected String idElemento;

    
    @Before
    public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().minimize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
    }

    @After
    public void tearDown() {
		driver.quit();
    }
    
    public void escrever(String id, String texto) {
    	driver.findElement(By.id(id)).clear();
    	driver.findElement(By.id(id)).sendKeys(texto);
    }
    
    public void escreverTag(String tag, String texto) {
    	driver.findElement(By.tagName(tag)).clear();
    	driver.findElement(By.tagName(tag)).sendKeys(texto);
    }
    
    public String obterValorCampo (String id) {
    	return driver.findElement(By.id(id)).getAttribute("value");
    }
    
    public String obterTextoCampo (String id) {
    	return driver.findElement(By.id(id)).getText();
    }
    
    public String obterTextoTag (String tag) {
    	return driver.findElement(By.tagName(tag)).getText();
    }
    
    public void clicar(String id) {
    	driver.findElement(By.id(id)).click();
    }
    
    public void clicarLink(String textoLink) {
    	driver.findElement(By.linkText(textoLink)).click();
    }
    
    public Boolean estaMarcado (String id) {
    	return driver.findElement(By.id(id)).isSelected();
    }
    
    public void selecionarCombo(String id, String valor) {
    	WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		//combo.selectByIndex(2);
		//combo.selectByValue("2grauincomp");
		combo.selectByVisibleText(valor);
    }
    
    public String obterValorCombo(String id) {
    	WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		//combo.selectByIndex(2);
		//combo.selectByValue("2grauincomp");
		return combo.getFirstSelectedOption().getText();
    }
    
    public Boolean procurarValorCombo (String id, String valorProcurado) {
    	boolean encontrouElemento = false;
		
    	WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		for(WebElement option : options) {
			if (option.getText().equals(valorProcurado)) {
				encontrouElemento = true;
				break;
			}
		}
    	return encontrouElemento;
    }
    
    public void trocaParaAlerta () {
    	driver.switchTo().alert();
    }
    
    public void trocaEAceitaAlerta () {
    	driver.switchTo().alert().accept();
    }
    
    public void trocaENegaAlerta () {
    	driver.switchTo().alert().dismiss();
    }
     
    public String obterTextoAlerta () {
    	return driver.switchTo().alert().getText();
    }
    
    public void escreverAlerta (String texto) {
    	driver.switchTo().alert().sendKeys(texto);
    	driver.switchTo().alert().accept();
    }
    
    public void trocaParaFrame (String frame) {
    	driver.switchTo().frame(frame);
    }
    
    public void trocaParaJanela (String janela) {
    	driver.switchTo().window(janela);
    }
    
    
}
