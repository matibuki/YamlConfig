package basic;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import start.TestBase;

import java.util.ArrayList;

public class WindowsTests extends TestBase {

    @Test
    public void windowTest() {
        TableTests tableTests = new TableTests();
        getDriver().get(seleniumui + "/windows-tabs.php");

        String winHandleBefore = driver.getWindowHandle();
        findElementByCss("#newBrowserWindow").click();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        tableTests.tableTest();
        driver.close();

        driver.switchTo().window(winHandleBefore);
        findElementByCss("#newMessageWindow").click();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        System.out.println(getDriver().findElement(By.tagName("body")).getText());
        driver.close();

        driver.switchTo().window(winHandleBefore);
        findElementByCss("#newBrowserTab").click();
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        tableTests.tableTest();
        driver.close();
    }
}
