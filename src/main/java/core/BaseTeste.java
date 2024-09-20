package core;

import static core.DriverFactory.killDriver;

import org.junit.After;

public class BaseTeste {
	

    @After
    public void tearDown() {
		if(Propriedades.FECHAR_BROWSER) {
			killDriver();
		}
    	
    }

}
