package start;

import configuration.factory.BrowserFactory;
import configuration.factory.EnvironmentFactory;
import configuration.factory.PropertyStore;
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
    public static WebDriver driver;
    private static BrowserFactory browserFactory;
    private static PropertyStore propertyStore;



    @BeforeAll
    static void setupDriver() {
        propertyStore = PropertyStore.getInstance();
        browserFactory = new BrowserFactory();
        driver = browserFactory.getDriver();
        driver.get(System.getProperty("url"));
        logger.info("Webdriver started successfully");
    }
    @BeforeEach
    void beforeEach() {

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
        logger.info("WebDriver closed properly");
    }
}
