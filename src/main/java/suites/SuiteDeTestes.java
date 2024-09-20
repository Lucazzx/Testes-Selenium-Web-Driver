package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

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
}
