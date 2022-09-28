package basic;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TableTests extends TestBase {
    Utils utils = new Utils();
    @Test
    public void tableTest() {
        getDriver().get(seleniumui+"/table.php");
        utils.mountainPrinting();


    }
}
