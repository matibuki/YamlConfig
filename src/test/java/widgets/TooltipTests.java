package widgets;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import start.TestBase;
import static org.assertj.core.api.Assertions.assertThat;

public class TooltipTests extends TestBase {
    @Test
    public void tooltipTest() {
        getDriver().get(seleniumui + "/tooltip.php");
        WebElement input = getDriver().findElement(By.cssSelector("#age"));
        input.click();
        WebElement tooltip = getDriver().findElement(By.cssSelector("div[role='tooltip'] div"));

        System.out.println(tooltip.getText());
        assertThat(tooltip.getText()).isEqualTo("We ask for your age only for statistical purposes.");
    }
}
