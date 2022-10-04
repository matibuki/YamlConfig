package widgets;

import basic.Utils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import start.TestBase;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class AccordionTests extends TestBase {
    @Test
    public void accordionTest() {
        getDriver().get(seleniumui+"/accordion.php");

        System.out.println(findElementByCss("#ui-id-2").getText() + "\n");
        findElementByCss("#ui-id-1").click();

        findElementByCss("#ui-id-3").click();
        System.out.println(findElementByCss("#ui-id-4").getText() + "\n");
        findElementByCss("#ui-id-3").click();

        findElementByCss("#ui-id-5").click();
        WebElement sectionThreeText = getDriver().findElement(By.cssSelector("#ui-id-6 p"));
        List<WebElement> sectionThreeBullletPoints = getDriver().findElements(By.cssSelector("#ui-id-6 ul li"));
        WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(10));
        wait.withTimeout(Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(sectionThreeBullletPoints.get(1)));
        System.out.println(sectionThreeText.getText() + "\n");
        for (WebElement text : sectionThreeBullletPoints) {
            System.out.println("* " + text.getText());
        }
        System.out.println(" ");
        findElementByCss("#ui-id-5").click();

        findElementByCss("#ui-id-7").click();
        List<WebElement> sectionFour = getDriver().findElements(By.cssSelector("#ui-id-8 p"));
        wait.withTimeout(Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(sectionFour.get(1)));
        for (WebElement text : sectionFour) {
            System.out.println(text.getText());
        }

    }
}
