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
        WebElement webPageSize = getDriver().findElement(By.cssSelector("html"));

        Actions action = new Actions(driver);
        action.dragAndDropBy(elementStart, 1300, -150).perform();

        action.dragAndDropBy(elementStart, 0, 700).perform();

        action.dragAndDropBy(elementStart, -800, -300).perform();

        action.dragAndDropBy(elementStart, -800, 300).perform();

//        int screenWidth = webPageSize.getSize().getWidth();
//        int screenHeight = webPageSize.getSize().getHeight();
//
//        Actions action = new Actions(driver);
//        action.dragAndDropBy(elementStart, (screenWidth-elementStart.getLocation().getX()-150), (screenHeight-elementStart.getLocation().getY()-150)).perform();
//
////        action.dragAndDropBy(elementStart, 0,  300).perform();
//        System.out.println(screenHeight);
//        System.out.println(elementStart.getLocation().getY());
//        action.dragAndDropBy(elementStart, 0,  screenHeight-elementStart.getLocation().getY()).perform();
//
//        action.dragAndDropBy(elementStart, -(screenWidth/2), -(screenHeight/2)).perform();
//
//        action.dragAndDropBy(elementStart, -(screenWidth/2), (screenHeight/2)).perform();


    }

}
