package suites;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import core.DriverFactory;
import testes.TesteCampoTreinamentoAlerts;
import testes.TesteCampoTreinamentoElementosBasicos;
import testes.TesteCampoTreinamentoFramesEJanelas;
import testes.TesteCampoTreinamentoRegrasDeNegocio;

@RunWith(Suite.class)
@SuiteClasses({
	TesteCampoTreinamentoElementosBasicos.class,
	TesteCampoTreinamentoRegrasDeNegocio.class,
	TesteCampoTreinamentoAlerts.class,
	TesteCampoTreinamentoFramesEJanelas.class,
})

public class SuiteDeTestes {
	
	@AfterClass
	public static void tearDownAll  () {
		DriverFactory.killDriver();
	}
	
}
