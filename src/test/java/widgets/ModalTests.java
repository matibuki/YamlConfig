package widgets;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import start.DataProvider;
import start.TestBase;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ModalTests extends TestBase {
    @Test
    public void addNewUserTest() {
        getDriver().get(seleniumui + "/modal-dialog.php");

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.withTimeout(Duration.ofSeconds(10));

        getDriver().findElement(By.cssSelector("#create-user")).click();
        WebElement newWindow = getDriver().findElement(By.cssSelector(".ui-dialog"));
        wait.until(ExpectedConditions.visibilityOf(newWindow));

        getDriver().findElement(By.cssSelector("#name")).clear();
        getDriver().findElement(By.cssSelector("#name")).sendKeys("Elon Musk");
        getDriver().findElement(By.cssSelector("#email")).clear();
        getDriver().findElement(By.cssSelector("#email")).sendKeys("emusk@tesla.com");
        getDriver().findElement(By.cssSelector("#password")).clear();
        getDriver().findElement(By.cssSelector("#password")).sendKeys("TESTPASSWORD1");

        getDriver().findElement(By.xpath("//*[text() = 'Create an account']")).click();

        List<WebElement> newDataInTable = getDriver().findElements((By.xpath("//*/tbody")));
        for (WebElement data : newDataInTable) {
            System.out.println(data.getText());
        }

        assertThat(getDriver().findElement(By.xpath("//*/tbody/tr[2]")).getText().contains("Elon Musk emusk@tesla.com TESTPASSWORD1"));
    }
}
