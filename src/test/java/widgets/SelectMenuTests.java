package widgets;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import start.TestBase;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class SelectMenuTests extends TestBase {
    @Test
    public void selectMenuTest() {
        getDriver().get(seleniumui + "/selectmenu.php");
        WebElement speedDropdown = getDriver().findElement(By.cssSelector("#speed-button"));
        speedDropdown.click();

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.withTimeout(Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeSelected(By.cssSelector("#ui-id-1")));

        List<WebElement> speedList = getDriver().findElements(By.cssSelector("#speed-button span[class='ui-selectmenu-text"));

        Random random = new Random();
        int randomOption = random.nextInt(speedList.size());
        String selector = "ui-id-" + randomOption;
        getDriver().findElement(By.cssSelector(selector)).click();

        WebElement filesDropdown = getDriver().findElement(By.cssSelector(".#files-button"));
        filesDropdown.click();

        wait.until(ExpectedConditions.elementToBeSelected(By.cssSelector("#ui-id-8")));
        List<WebElement> fileList = getDriver().findElements(By.cssSelector("#files-button span[class='ui-selectmenu-text"));
//        for (WebElement option : fileList) {
//            clickOnOptionByText(option,"jQuery.js");
//        }


    }
}
