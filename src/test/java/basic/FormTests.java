package basic;

import org.junit.jupiter.api.Test;
import pages.FormPage;
import start.TestBase;

import static org.assertj.core.api.Assertions.assertThat;

public class FormTests extends TestBase {
    @Test
    public void formTest() throws InterruptedException {

        FormPage formPage = new FormPage(driver);

        formPage.fillFirstName(System.getProperty("firstName"));
        formPage.fillLastName(System.getProperty("lastName"));
//        formPage.fillEmail("mbukowski2@sii.pl");
//        formPage.chooseGender("male");
//        formPage.fillAge("31");
//        formPage.chooseRandomExperience().click();
//        formPage.chooseProfession().click(); // should be automatic ??????
//        formPage.selectContinent("Europe");
//        formPage.selectSeleniumCommands("switch-commands");
//        formPage.selectSeleniumCommands("wait-commands");
//        formPage.uploadFile();
//        formPage.clickButton();
//        assertThat(formPage.getValidationMessage().getText()).isEqualTo("Form send with success");

    }
}
