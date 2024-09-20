package testes;

import static core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import core.BaseTeste;
import core.DSL;

public class TestePrimeFaces extends BaseTeste{
	
	private DSL dsl;
	
	@Before
    public void setUp() {
		dsl = new DSL();
    }
    
    @Test
    public void testeInteragirRadioPrime(){
    	getDriver().get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml?jfwid=99033");
    	
    	dsl.clicarPorXpath("//div[@id='j_idt249:line']//label[@for='j_idt249:line:0']");
    	assertTrue(dsl.estaMarcado("j_idt249:line:0"));
    }
    
    @Test
    public void testeInteragirComboPrime(){
    	getDriver().get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml?jfwid=e2534");
    	
		dsl.clicar("j_idt248:option_label");
		dsl.aguardarPorXpath(10, "//ul[@id='j_idt248:option_items']");		
    	dsl.clicarPorXpath("//li[@data-label='Option2']");
    	assertEquals("Option2", dsl.obterTextoCampo("j_idt248:option_label"));
    }
	
    @Test
    public void testeInteragirAjax(){
    	getDriver().get("http://www.primefaces.org/showcase/ui/ajax/basic.xhtml?jfwid=64a06");
    	
		dsl.escrever("j_idt248:name", "Lucas");
		dsl.clicar("j_idt248:j_idt252");
		dsl.aguardarPorId(10, "j_idt248:display");
    	assertEquals("Lucas", dsl.obterTextoCampo("j_idt248:display"));
    }
    

}
