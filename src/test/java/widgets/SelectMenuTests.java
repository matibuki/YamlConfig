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

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(3));
        wait.withTimeout(Duration.ofSeconds(3));

        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.cssSelector("#ui-id-1"))));

        List<WebElement> speedList = getDriver().findElements(By.cssSelector("li.ui-menu-item"));

        Random random = new Random();
        int randomOption = random.nextInt(speedList.size());
        speedList.get(randomOption).click();

        WebElement filesDropdown = getDriver().findElement(By.cssSelector("#files-button"));
        filesDropdown.click();
        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.cssSelector("#ui-id-8"))));

        List<WebElement> fileList = getDriver().findElements(By.cssSelector(".ui-menu-item-wrapper"));
        for (WebElement elementToClick : fileList) {
            if (elementToClick.getText().equals("Some unknown file")) {
                elementToClick.click();
            }
        }

        WebElement numberDropdown = getDriver().findElement(By.cssSelector("#number-button"));
        numberDropdown.click();
        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.cssSelector("#ui-id-10"))));

        List<WebElement> numberList = getDriver().findElements(By.cssSelector(".ui-menu-item-wrapper"));
        numberList.get(11).click();

        WebElement titleDropdown = getDriver().findElement(By.cssSelector("#salutation-button"));
        titleDropdown.click();
        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.cssSelector("#salutation-menu li[class='ui-menu-item'] div"))));

        List<WebElement> titleList = getDriver().findElements(By.cssSelector("#salutation-button span[class='ui-selectmenu-text']"));
        int randomOptionTitle = random.nextInt(titleList.size());

        titleList.get(randomOptionTitle).click();

    }
}
