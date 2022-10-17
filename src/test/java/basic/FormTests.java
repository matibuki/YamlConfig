package basic;

import org.junit.jupiter.api.Test;
import pages.FormPage;
import start.TestBase;

import static org.assertj.core.api.Assertions.assertThat;

public class FormTests extends TestBase {
    @Test
    public void formTest() throws InterruptedException {
        getDriver().get(seleniumui + "/form.php");

        FormPage formPage = new FormPage(getDriver());

        formPage.fillFirstName("Mateusz");
        formPage.fillLastName("Bukowski");
        formPage.fillEmail("mbukowski2@sii.pl");
        formPage.chooseGender("male");
        formPage.fillAge("31");
        formPage.chooseRandomExperience().click();
        formPage.chooseProfession().click(); // should be automatic ??????
        formPage.selectContinent("Europe");
        formPage.selectSeleniumCommands("switch-commands");
        formPage.selectSeleniumCommands("wait-commands");
        formPage.uploadFile();
        formPage.clickButton();
        assertThat(formPage.getValidationMessage().getText()).isEqualTo("Form send with success");

    }
}
