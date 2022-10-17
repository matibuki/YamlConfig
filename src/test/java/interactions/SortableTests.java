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
        for (int i=0; i<list.size(); i++) {
            action.clickAndHold(list.get(i)).moveToElement(listShuffled.get(i), 0, 5).release().perform();
        }

        List<WebElement> listUpdated = getDriver().findElements(By.cssSelector(".ui-sortable-handle"));
        System.out.println("New list: ");
        for (WebElement elements : listUpdated) {
            System.out.println(elements.getText());
        }
//
//
//        WebElement el1 = getDriver().findElement(By.xpath("//*[contains(text(),'Item 1')]"));
//        WebElement el2 = getDriver().findElement(By.xpath("//*[contains(text(),'Item 3')]"));
////        action.dragAndDrop(el1, el2).perform();
////        action.clickAndHold((el1).moveToElement(el2)).release().perform();
//        action.clickAndHold(el1).moveToElement(el2, 0, 5).release().perform();


//
//        List<WebElement> list = getDriver().findElements(By.cssSelector(".ui-sortable-handle"));
//        Integer[] array = {1, 2, 3, 4, 5, 6, 7};
//        List<Integer> arrayShuffle = Arrays.asList(array);
//        Collections.shuffle(arrayShuffle);
//        System.out.println(Arrays.toString(array));
//
//        Map<Integer, WebElement> data = new HashMap<>();
//        for (int i = 0; i < list.size(); i++) {
//            data.put(array[i], (list.get(i)));
//        }
//
//        for (int i = 1; i <= data.size(); i++) {
//            int numberIndex = arrayShuffle.indexOf(i);
//            action.clickAndHold(data.get(i)).moveToElement(list.get(numberIndex), 0, 5).release().perform();
//        }
//        list = getDriver().findElements(By.cssSelector(".ui-sortable-handle"));
//        for (WebElement item : list) {
//            System.out.println(item.getText());
//
//        Integer[] array = {1, 2, 3, 4, 5, 6, 7};
//        List<Integer> arrayShuffle = Arrays.asList(array);
//        Collections.shuffle(arrayShuffle);
//        System.out.println(Arrays.toString(array));
//
//        List<WebElement> list = getDriver().findElements(By.cssSelector(".ui-sortable-handle"));
////        List<WebElement> list = getDriver().findElements(By.xpath("//*[contains(text(), 'Item')]"));
//        Actions action = new Actions(driver);
//
////        WebElement element1 = getDriver().findElement(By.xpath("//*[contains(text(), '1')]"));
//        for (int i = 1; i <= list.size(); i++) {
//            action.dragAndDrop(list.get(i), list.get(Arrays.asList(array).get(i)));
//
//        }
////
////        for (WebElement item : list) {
////            int i = 0;
////            int newPos = Integer.parseInt(item.getText().substring(5, 6));
////            System.out.println(newPos);
////            if (array[i] == newPos ) {
////                String newXpath = "//*[contains(text(), '" + newPos + "')]";
//////                action.clickAndHold(item.moveToElement getDriver().findElement(By.xpath(newXpath)));
//////                action.clickAndHold(item.)
////                action.dragAndDrop(item, getDriver().findElement(By.xpath(newXpath)));
////                i++;
////            }
////        }
//        List<WebElement> list2 = getDriver().findElements(By.cssSelector(".ui-sortable-handle"));
//        for (WebElement item : list2) {
//            System.out.println(item.getText());
//        }
//
//
////            *[ text() = ‘Get started free’ ]
//    }
    }
}

