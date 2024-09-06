package testes;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTeste {
    protected WebDriver driver;
    protected String idElemento;

    
    @Before
    public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().minimize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
    }

    @After
    public void tearDown() {
		//driver.quit();
    }
}
