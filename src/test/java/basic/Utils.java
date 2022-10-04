package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import start.TestBase;

import java.util.List;

public class Utils {
    TestBase new1 = new TestBase();
    public void mountainPrinting() {
        List<WebElement> rows = new1.getDriver().findElements(By.cssSelector("tbody tr"));

        for (WebElement row : rows) {
            String rank = row.findElements(By.cssSelector("th")).get(0).getText();

            String peak = row.findElements(By.cssSelector("td")).get(0).getText();
            String range = row.findElements(By.cssSelector("td")).get(1).getText();
            String state = row.findElements(By.cssSelector("td")).get(2).getText();
            String height = row.findElements(By.cssSelector("td")).get(3).getText();

            if (Integer.parseInt(height) > 4000 && state.contains("Switzerland")) {
                System.out.println(rank +" "+ peak +" "+ range);
            }

        }
    }
}
