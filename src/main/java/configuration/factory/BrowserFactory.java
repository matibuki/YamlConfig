package configuration.factory;

import configuration.models.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserFactory extends Browser {
    // logger

    private String browserName;
    private String appUrl;
    private WebDriver driver;

    public BrowserFactory(Browser browser) {

        try {
            browserName = browser.getBrowserName();
            appUrl = browser.getAppUrl();
        } catch (WebDriverException exception) {
            return;
        }
    }

    public WebDriver getDriver() {
        WebDriver driver;
        switch (this.browserName) {
            case "chrome":
                ChromeOptions optionsChrome = new ChromeOptions();
                WebDriverManager.chromedriver().setup();
                optionsChrome.addArguments("start-maximized");
                driver = new ChromeDriver(optionsChrome);
                driver.get(appUrl);
                break;


}
