package testes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {
	
	private WebDriver driver;

    public DSL(WebDriver driver) {
		this.driver = driver;
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
    
    public void selecionarCombo(String id, String[] esportes) {
        WebElement element = driver.findElement(By.id(id));
        Select combo = new Select(element);
        
        // Obtém todos os itens disponíveis no combo
        List<WebElement> todasOpcoes = combo.getOptions();
        
        // Loop para percorrer as opções e selecionar aquelas presentes no array "esportes"
        for (WebElement opcao : todasOpcoes) {
            String textoOpcao = opcao.getText(); // Obtém o texto visível da opção
            
            // Verifica se a opção está no array "esportes" e a seleciona
            for (String esporte : esportes) {
                if (textoOpcao.equalsIgnoreCase(esporte)) {
                    combo.selectByVisibleText(esporte);
                }
            }
        }
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
    
    public void executarJS (String comando, Object... parametros) {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript(comando, parametros);
    }
    
}
