package basic;

import org.junit.jupiter.api.Test;
import start.TestBase;
import start.Utils;

public class TableTests extends TestBase {
    @Test
    public void tableTest() {
        Utils utils = new Utils();
        getDriver().get(seleniumui+"/table.php");
        utils.mountainPrinting();
    }
    }
