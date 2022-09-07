package basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        String filepath = "C:\\SeleniumDownload";
        prefs.put("download.default_directory", filepath);
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        logger.info("Browser has been opened");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
        logger.info("WebDriver closed properly");
    }

    public WebElement findElementByCss(String css) {
        return getDriver().findElement(By.cssSelector(css));
    }

    public WebElement getRandomElement(List<WebElement> elements) {
        return elements.get(new Random().nextInt(elements.size()));
    }

}
