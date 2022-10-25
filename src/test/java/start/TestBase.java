package start;

import configuration.factory.BrowserFactory;
import configuration.factory.EnvironmentFactory;
import configuration.models.Browser;
import configuration.models.Environment;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class TestBase {
    private static Logger logger = LoggerFactory.getLogger(TestBase.class);
    protected static WebDriver driver;

//    private static Browser browser;
    private static BrowserFactory browserFactory;
    public static Environment environment;
    private static EnvironmentFactory environmentFactory;



    @BeforeAll
    static void setupDriver() {
        environment = EnvironmentFactory.getInstance();
        browserFactory = new BrowserFactory(environment.getBrowser());
        driver = browserFactory.getDriver();
        logger.info("Webdriver started successfully");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
        logger.info("WebDriver closed properly");
    }
    protected HashMap<String, Object> testData = environment.getData();
//    public static EnvironmentFactory getEnvironment() {
//        return environment;
//    }
}
