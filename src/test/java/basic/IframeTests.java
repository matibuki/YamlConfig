package basic;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import start.TestBase;

import static org.assertj.core.api.Assertions.assertThat;

public class IframeTests extends TestBase {

    @Test
    public void iframeTest() {
        getDriver().get(seleniumui + "/iframes.php");
        getDriver().switchTo().frame("iframe1");
        findElementByCss("#inputFirstName3").sendKeys("Mateusz");
        findElementByCss("#inputSurname3").sendKeys("Bukowski");
        findElementByCss(".btn").click();

        getDriver().switchTo().parentFrame();
        getDriver().switchTo().frame("iframe2");
        findElementByCss("#inputLogin").sendKeys("mat");
        findElementByCss("#inputPassword").sendKeys("password");
        WebElement radioButton = findElementByCss("#gridRadios6");
        radioButton.click();
        findElementByCss(".btn").click();

        getDriver().switchTo().defaultContent();
        findElementByCss(".nav-ite").click();
    }
}

