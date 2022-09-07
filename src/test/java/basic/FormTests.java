package basic;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FormTests extends TestBase {
    @Test
    public void formTest() throws InterruptedException {
        getDriver().get("https://seleniumui.moderntester.pl/form.php");
        findElementByCss("#inputFirstName3").sendKeys("Mateusz");
        findElementByCss("#inputLastName3").sendKeys("Bukowski");
        findElementByCss("#inputEmail3").sendKeys("mbukowski2@sii.pl");

        List<WebElement> sex = getDriver().findElements(By.name("gridRadiosSex"));
        getRandomElement(sex).click();

        findElementByCss("#inputAge3").sendKeys("mbukowski2@sii.pl");

        List<WebElement> experience = getDriver().findElements(By.name("gridRadiosExperience"));
        getRandomElement(experience).click();

        WebElement radioButtonProfession = findElementByCss("#gridCheckAutomationTester");
        radioButtonProfession.click();

        Select continentsDropdown = new Select(findElementByCss("#selectContinents"));
        List<WebElement> continents = continentsDropdown.getOptions();
        getRandomElement(continents).click();

        Select seleniumCommands = new Select(findElementByCss("#selectSeleniumCommands"));
        seleniumCommands.selectByValue("switch-commands");
        seleniumCommands.selectByValue("wait-commands");

        File file = new File("C:\\SeleniumDownload\\test-file-to-download.xlsx");
        File folder = new File("C:\\SeleniumDownload");
        folder.mkdir();

        String[] fileList = folder.list();
        System.out.println("Starting file count = " + fileList.length);

        findElementByCss(".btn-secondary").click();
        Thread.sleep(500L);

        String[] fileList2 = folder.list();
        System.out.println("Final file count = " + fileList2.length);

        if ((fileList.length + 1) == fileList2.length) {
            System.out.println("File downloaded, file count is +1 :)");
        }

        for (String fileInList : fileList2) {
            if (fileInList.equals("test-file-to-download.xlsx")) {
                System.out.println("File found!");
                break;
            }
        }

        findElementByCss("#chooseFile").sendKeys(file.getAbsolutePath());

        findElementByCss(".btn-primary").click();
        WebElement message = findElementByCss("#validator-message");
        assertThat(message.getText()).isEqualTo("Form send with success");

    }
}
