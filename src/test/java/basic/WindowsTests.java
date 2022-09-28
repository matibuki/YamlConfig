package basic;

import com.google.common.collect.Table;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class WindowsTests extends TestBase{
    TableTests tableTests = new TableTests();

    @Test
    public void windowTest() {
        getDriver().get(seleniumui+"/windows-tabs.php");

        String winHandleBefore = driver.getWindowHandle();
        findElementByCss("#newBrowserWindow").click();
        for (String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        tableTests.tableTest();
        driver.close();

        driver.switchTo().window(winHandleBefore);
        findElementByCss("#newMessageWindow").click();
        for (String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        System.out.println(getDriver().findElement(By.tagName("body")).getText());
        //        assertThat(message.equals("Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization."));
        driver.close();

        findElementByCss("#newBrowserTab").click();
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        tableTests.tableTest();
        driver.close();


    }
}
