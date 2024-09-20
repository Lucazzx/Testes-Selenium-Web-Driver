package core;

import static core.DriverFactory.killDriver;

import org.junit.After;

public class BaseTeste {
	

    @After
    public void tearDown() {
		killDriver();
    }

}
