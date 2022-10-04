package widgets;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import start.TestBase;

import java.time.Duration;

public class MenuTests extends TestBase {
    @Test
    public void menuTest() {
        getDriver().get(seleniumui + "/menu-item.php");

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.withTimeout(Duration.ofSeconds(10));

        WebElement menuItemMusic = getDriver().findElement(By.cssSelector("#ui-id-9"));
        WebElement menuItemJazz = getDriver().findElement(By.cssSelector("#ui-id-13"));
        WebElement menuItemModern = getDriver().findElement(By.cssSelector("#ui-id-16"));

        menuItemMusic.click();
        wait.until(ExpectedConditions.elementToBeClickable(menuItemJazz));
        menuItemJazz.click();
        wait.until(ExpectedConditions.elementToBeClickable(menuItemModern));
        menuItemModern.click();

    }
}
