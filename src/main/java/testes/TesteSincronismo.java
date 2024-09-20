package testes;

import static core.DriverFactory.getDriver;

import org.junit.Before;
import org.junit.Test;

import core.BaseTeste;
import core.DSL;

public class TesteSincronismo extends BaseTeste{

	private DSL dsl;

	@Before
    public void setUp() {
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL();
    }
    
    @Test
    public void interagirRespostaDemorada () {
    	dsl.clicar("buttonDelay");
    	dsl.aguardarPorId(10, "novoCampo");
    	dsl.escrever("novoCampo", "escrevendo");
    	//assertEquals("escrevendo", dsl.obterTextoCampo("novoCampo"));
    }
}
