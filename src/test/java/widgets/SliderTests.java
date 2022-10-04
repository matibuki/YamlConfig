package widgets;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import start.TestBase;

public class SliderTests extends TestBase {
    @Test
    public void sliderTest() {
        getDriver().get(seleniumui + "/slider.php");
        WebElement slider = getDriver().findElement(By.cssSelector("#custom-handle"));
        int sliderPosition = Integer.parseInt(slider.getText());
        System.out.println(sliderPosition);

        for (int i =sliderPosition; i < 50; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }

        slider = getDriver().findElement(By.cssSelector("#custom-handle"));
        sliderPosition = Integer.parseInt(slider.getText());
        System.out.println(sliderPosition);


        for (int i = sliderPosition; i < 80; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
        slider = getDriver().findElement(By.cssSelector("#custom-handle"));
        sliderPosition = Integer.parseInt(slider.getText());
        System.out.println(sliderPosition);

        for (int i = sliderPosition; i < 80; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
        slider = getDriver().findElement(By.cssSelector("#custom-handle"));
        sliderPosition = Integer.parseInt(slider.getText());
        System.out.println(sliderPosition);

        for (int i = sliderPosition; i > 20; i--) {
            slider.sendKeys(Keys.ARROW_LEFT);
        }
        slider = getDriver().findElement(By.cssSelector("#custom-handle"));
        sliderPosition = Integer.parseInt(slider.getText());
        System.out.println(sliderPosition);

        for (int i = sliderPosition; i > 0; i--) {
            slider.sendKeys(Keys.ARROW_LEFT);
        }
        slider = getDriver().findElement(By.cssSelector("#custom-handle"));
        sliderPosition = Integer.parseInt(slider.getText());
        System.out.println(sliderPosition);
    }
}
