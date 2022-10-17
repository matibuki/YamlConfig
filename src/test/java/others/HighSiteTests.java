package others;

import start.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.util.Date;

public class HighSiteTests extends TestBase {
    @Test
    public void scrollTest() {
        getDriver().get("http://51.75.61.161:9102/high-site.php");
        Actions action = new Actions(driver);
        action.scrollToElement(getDriver().findElement(By.cssSelector("#scroll-button"))).perform();
        action.scrollByAmount(0,300).perform();
//
//        TakesScreenshot prntscrn = (TakesScreenshot) getDriver();
//        File screen = prntscrn.getScreenshotAs(OutputType.FILE);
//        File destination = new File("src/main/resources/screenshot");
//        FileUtils.copyFile(screen, destination);
//
//        prntscrn(driver, "src/main/resources/screenshot" + new Date().getTime() +".png");
//
//


    }
}
