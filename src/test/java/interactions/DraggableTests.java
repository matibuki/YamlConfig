package interactions;

import start.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class DraggableTests extends TestBase {
    @Test
    public void draggTest() {
        getDriver().get("http://51.75.61.161:9102/draggable.php");
        WebElement elementStart = getDriver().findElement(By.cssSelector("#draggable"));

        Actions action = new Actions(driver);
        action.dragAndDropBy(elementStart, 1300, -150).perform();

        action.dragAndDropBy(elementStart, 0, 700).perform();

        action.dragAndDropBy(elementStart, -800, -300).perform();

        action.dragAndDropBy(elementStart, -800, 300).perform();

    }

}
