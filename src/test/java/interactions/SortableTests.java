package interactions;

import start.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SortableTests extends TestBase {
    @Test
    public void sortableTests() {
        getDriver().get("http://51.75.61.161:9102/sortable.php");

        Integer[] array = {1, 2, 3, 4, 5, 6, 7};
        Random rand = new Random();

        List<Integer> arrayShuffle = Arrays.asList(array);

        Collections.shuffle(arrayShuffle);
        System.out.println(Arrays.toString(array));

        List<WebElement> list = getDriver().findElements(By.cssSelector(".ui-sortable-handle"));
        Actions action = new Actions(driver);

//        action.dragAndDrop(elementStart, elementEnd).perform();
        WebElement element1 = getDriver().findElement(By.xpath("//*[contains(text(), '1')]"));
        for (WebElement item : list) {
            int i = 0;
            int newPos = Integer.parseInt(item.getText().substring(5, 6));
            System.out.println(newPos);
            if (array[i] == newPos ) {
                String newXpath = "//*[contains(text(), '" + newPos + "')]";
//                action.clickAndHold(item.moveToElement getDriver().findElement(By.xpath(newXpath)));
//                action.clickAndHold(item.)
                action.dragAndDrop(item, getDriver().findElement(By.xpath(newXpath)));
                i++;
            }
        }
        List<WebElement> list2 = getDriver().findElements(By.cssSelector(".ui-sortable-handle"));
        for (WebElement item : list2) {
            System.out.println(item.getText());
        }


        //*[ text() = ‘Get started free’ ]
    }


}
