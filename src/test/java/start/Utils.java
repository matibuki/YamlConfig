package start;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;

public class Utils {
    TestBase new1 = new TestBase();
    DataProvider dataProvider = new DataProvider();
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

    public void resize(WebElement element, int offsetX, int offsetY)
    {
        Dimension dimension = element.getSize();
        System.out.println(dimension.getHeight());
        System.out.println(dimension.getWidth());
//        int width = element.getSize();
        Actions action = new Actions(new1.getDriver());
//        action.MoveToElement(element, width, 1);
        action.clickAndHold().moveByOffset(offsetX, offsetY).release().perform();
        System.out.println(dimension.getHeight());
        System.out.println(dimension.getWidth());
    }


    public void createNewUser() {
        String name = dataProvider.setName();
        String email = dataProvider.setEmail();
        String password = dataProvider.setPassword();

    }

    public WebElement getRandomElement(List<WebElement> elements) {
        return elements.get(new Random().nextInt(elements.size()));
    }


}
