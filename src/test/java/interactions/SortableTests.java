package interactions;

import start.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.*;

public class SortableTests extends TestBase {
    @Test
    public void sortableTests() {
        getDriver().get("http://51.75.61.161:9102/sortable.php");

        List<WebElement> list = getDriver().findElements(By.cssSelector(".ui-sortable-handle"));
        List<WebElement> listShuffled = getDriver().findElements(By.cssSelector(".ui-sortable-handle"));

        System.out.println("Old list: ");
        for (WebElement elements : list) {
            System.out.println(elements.getText());
        }

        Collections.shuffle(listShuffled);

        Actions action = new Actions(getDriver());
        for (int i = 0; i < list.size(); i++) {
            action.clickAndHold(list.get(i)).moveToElement(listShuffled.get(i), 0, 3).release().perform();
        }

        List<WebElement> listUpdated = getDriver().findElements(By.cssSelector(".ui-sortable-handle"));
        System.out.println("New list: ");
        for (WebElement elements : listUpdated) {
            System.out.println(elements.getText());
        }
    }
}

