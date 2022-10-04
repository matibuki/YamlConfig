package interactions;

import start.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DroppableTests extends TestBase {
    @Test
    public void droppableTests() {
        getDriver().get("http://51.75.61.161:9102/droppable.php");
        WebElement elementStart = getDriver().findElement(By.cssSelector("#draggable"));
        WebElement elementEnd = getDriver().findElement(By.cssSelector("#droppable"));

        Actions action = new Actions(driver);
        action.dragAndDrop(elementStart, elementEnd).perform();

        System.out.println("Element was: " + getDriver().findElement(By.cssSelector("#droppable")).getText());
    }
}
