package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FormPage {
    public FormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "inputFirstname3")
    private WebElement firstNameInput;

    @FindBy(id = "inputLastName3")
    private WebElement lastNameInput;

    @FindBy(id = "inputEmail3")
    private WebElement emailInput;

    @FindBy(id = "gridRadiosSex")
    private List<WebElement> genders;

    @FindBy(id = "inputAge3")
    private WebElement ageInput;

    public void fillFirstName(String firstName) {
        this.firstNameInput.sendKeys(firstName);
    }

    public void fillLastName(String lastName) {
        this.lastNameInput.sendKeys(lastName);
    }

    public void fillEmail(String email) {
        this.firstNameInput.sendKeys(email);
    }

    public void chooseGender(String gender) {
        switch(gender) {
            case "male":genders.get(0).click();
            case "female":genders.get(1).click();
            case "other":genders.get(2).click();
        }
    }

    public void fillAge(String age) {
        this.firstNameInput.sendKeys(age);
    }






}
