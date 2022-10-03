package interactions;

import basic.TestBase;
import basic.Utils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ResizableTests extends TestBase {
    @Test
    public void resizableTests() {
        Utils utils = new Utils();
        getDriver().get("http://51.75.61.161:9102/resizable.php");
        WebElement elementToBeResized = getDriver().findElement(By.cssSelector(".ui-resizable-se"));
//        utils.resize(elementToBeResized, 10, 0);

        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));


        action.dragAndDropBy(elementToBeResized, 100, 0).perform();

        action.dragAndDropBy(elementToBeResized, 0, 100).perform();

        action.dragAndDropBy(elementToBeResized, 100, 100).perform();



    }
}


