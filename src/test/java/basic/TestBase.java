package start;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBase {
    private static Logger logger = LoggerFactory.getLogger(TestBase.class);
    WebDriver driver;

    WebDriver getDriver() {
        return driver;
    }

    @BeforeAll
    static void setupDriver() {
        WebDriverManager.chromedriver().setup();
        logger.info("WebDriver started successfully");
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        logger.info("Browser has been opened");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        logger.info("WebDriver closed properly");
    }
}
