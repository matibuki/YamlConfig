package basic;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TableTests extends TestBase {
    @Test
    public void tableTest() {
        getDriver().get("https://seleniumui.moderntester.pl/table.php");
        WebElement table = findElementByCss(".table");
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        List<WebElement> columns = table.findElements(By.tagName("td"));
        List<String> value = new ArrayList<>();

        System.out.println(rows.size());

//        for (WebElement data : rows) {
        for (int i = 0; i < columns.size(); i++) {
            System.out.println(columns.get(i).getText());
            value.add(columns.get(i).getText());

        }
        System.out.println("test");
        System.out.println("test");
        System.out.println("test");

    }
}
