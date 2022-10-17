package widgets;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import start.TestBase;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class AutocompleteTests extends TestBase {
    @Test
    public void autocompleteTest() {
        Random random = new Random();
        getDriver().get(seleniumui + "/autocomplete.php");
        WebElement input = findElementByCss("#search");
        input.sendKeys("a");

        List<WebElement> suggestions = getDriver().findElements(By.cssSelector(".ui-menu-item"));

        for (WebElement suggestion : suggestions) {
            System.out.println(suggestion.getText());
        }

        int randomOption = random.nextInt(suggestions.size());
        WebElement selectedElement = suggestions.get(randomOption);
        String chosenSuggestion = selectedElement.getText();

        selectedElement.click();

        System.out.println("input=" + input.getAttribute("value"));
        System.out.println("dropdown = " + chosenSuggestion);
        assertThat(input.getAttribute("value")).isEqualTo(chosenSuggestion);


    }
}
