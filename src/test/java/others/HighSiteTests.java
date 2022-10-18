package others;

import start.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class HighSiteTests extends TestBase {
    @Test
    public void scrollTest() throws IOException {
        getDriver().get(seleniumui + "/high-site.php");
        Actions action = new Actions(driver);

        action.scrollToElement(getDriver().findElement(By.cssSelector(".show-button"))).perform();
        action.scrollByAmount(0,300).perform();

        File screenshot = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
        File destination = new File("src/main/resources/screen-" + new Date().getTime() + ".jpg");
        FileUtils.copyFile(screenshot, destination);
    }
}
