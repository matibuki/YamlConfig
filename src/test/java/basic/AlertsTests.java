package basic;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.assertj.core.api.Assertions.assertThat;

public class AlertsTests extends TestBase {

    @Test
    public void simpleAlertPopupTest() {
        getDriver().get("https://seleniumui.moderntester.pl/alerts.php");

        WebElement button = findElementByCss("#simple-alert");
        button.click();
        getDriver().switchTo().alert().accept();

        WebElement message = findElementByCss("#simple-alert-label");
        assertThat(message.getText()).isEqualTo("OK button pressed");
    }

    @Test
    public void promptAlertBoxTest() {
        getDriver().get("https://seleniumui.moderntester.pl/alerts.php");

        WebElement button = findElementByCss("#prompt-alert");
        button.click();
        getDriver().switchTo().alert().sendKeys("Lord Vader");
        getDriver().switchTo().alert().accept();

        WebElement message = findElementByCss("#prompt-label");
        assertThat(message.getText()).isEqualTo("Hello Lord Vader! How are you today?");
    }

    @Test
    public void confirmAlertBoxTest() {
        getDriver().get("https://seleniumui.moderntester.pl/alerts.php");

        WebElement button = findElementByCss("#confirm-alert");

        button.click();
        getDriver().switchTo().alert().accept();
        assertThat(findElementByCss("#confirm-label").getText()).isEqualTo("You pressed OK!");

        button.click();
        getDriver().switchTo().alert().dismiss();
        assertThat(findElementByCss("#confirm-label").getText()).isEqualTo("You pressed Cancel!");
    }

    @Test
    public void delayedAlertBoxTest() {
        getDriver().get("https://seleniumui.moderntester.pl/alerts.php");

        WebElement button = findElementByCss("#delayed-alert");
        button.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        getDriver().switchTo().alert().accept();
        assertThat(findElementByCss("#delayed-alert-label").getText()).isEqualTo("OK button pressed");
    }
}
