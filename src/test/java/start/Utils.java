package start;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
public class Utils {
    DataProvider dataProvider = new DataProvider();

    public void mountainPrinting() {
        List<WebElement> rows = TestBase.getDriver().findElements(By.cssSelector("tbody tr"));

        for (WebElement row : rows) {
            String rank = row.findElements(By.cssSelector("th")).get(0).getText();

            String peak = row.findElements(By.cssSelector("td")).get(0).getText();
            String range = row.findElements(By.cssSelector("td")).get(1).getText();
            String state = row.findElements(By.cssSelector("td")).get(2).getText();
            String height = row.findElements(By.cssSelector("td")).get(3).getText();

            if (Integer.parseInt(height) > 4000 && state.contains("Switzerland")) {
                System.out.println(rank + " " + peak + " " + range);
            }
        }
    }

    public void resize(WebElement element, int offsetX, int offsetY) {
        Dimension dimension = element.getSize();
        System.out.println(dimension.getHeight());
        System.out.println(dimension.getWidth());
        Actions action = new Actions(TestBase.getDriver());
        action.clickAndHold().moveByOffset(offsetX, offsetY).release().perform();
        System.out.println(dimension.getHeight());
        System.out.println(dimension.getWidth());
    }

    public void createNewUser() {
        String name = dataProvider.setName();
        String email = dataProvider.setEmail();
        String password = dataProvider.setPassword();

    }
}
