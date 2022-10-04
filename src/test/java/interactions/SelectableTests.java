package interactions;

import start.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;

public class SelectableTests extends TestBase {
    @Test
    public void selectableTests() {
        getDriver().get("http://51.75.61.161:9102/selectable.php");
        getDriver().findElement(By.xpath("//*[text() = 'Item 1']")).click();
        System.out.println(findElementByCss("#feedback").getText());
        getDriver().findElement(By.xpath("//*[text() = 'Item 3']")).click();
        System.out.println(findElementByCss("#feedback").getText());
        getDriver().findElement(By.xpath("//*[text() = 'Item 4']")).click();
        System.out.println(findElementByCss("#feedback").getText());
    }
}
