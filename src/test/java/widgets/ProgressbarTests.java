package widgets;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import start.TestBase;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class ProgressbarTests extends TestBase {
    @Test
    public void progressBarTest() {
        getDriver().get(seleniumui + "/progressbar.php");

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.withTimeout(Duration.ofSeconds(10));

        WebElement progressbar = getDriver().findElement(By.cssSelector(".progress-label"));

        wait.until(ExpectedConditions.textToBe((By.cssSelector(".progress-label")), "Complete!"));

        assertThat(progressbar.getText().equals("Complete!"));
    }
}
