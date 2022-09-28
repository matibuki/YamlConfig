package basic;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TableTests extends TestBase {
    @Test
    public void tableTest() {
        Utils utils = new Utils();
        getDriver().get(seleniumui+"/table.php");
        utils.mountainPrinting();


    }
    }
