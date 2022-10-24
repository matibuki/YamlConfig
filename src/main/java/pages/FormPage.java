package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class FormPage extends BasePage{
    public FormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "inputFirstName3")
    private WebElement firstNameInput;

    @FindBy(id = "inputLastName3")
    private WebElement lastNameInput;

    @FindBy(id = "inputEmail3")
    private WebElement emailInput;

    @FindBy(css = "input[name='gridRadiosSex']")
    private List<WebElement> genders;

    @FindBy(id = "inputAge3")
    private WebElement ageInput;

    @FindBy(name = "gridRadiosExperience")
    private List<WebElement> experience;

    @FindBy(css = "#gridCheckAutomationTester")
    private WebElement profession;

    @FindBy(css = "#selectContinents")
    private WebElement continents;

    @FindBy(css = "#selectContinents option")
    private List<WebElement> continentsOptions;

    @FindBy(css = "#selectSeleniumCommands")
    private WebElement commands;

    @FindBy(css = ".btn-secondary")
    private WebElement downloadFileButton;

    @FindBy(css = "#chooseFile")
    private WebElement fileUploadInput;

    @FindBy(css = ".btn-primary")
    private WebElement sendButton;


    @FindBy(css = "#validator-message")
    private WebElement validationMessage;

//
//    public void selectContinent(String name) {
//        Select selectContinents = new Select(continents);
//        selectContinents.selectByVisibleText(name);
//    }
//
//    public void selectSeleniumCommands(String name) {
//        Select selectSeleniumCommands = new Select(commands);
//        selectSeleniumCommands.selectByValue(name);
//    }

//    public void fillFirstName(String firstName) {
//        this.firstNameInput.sendKeys(firstName);
//    }
    public void fillFirstName(Object firstName) {
        this.firstNameInput.sendKeys(((CharSequence) firstName));
    }

    public void fillLastName(Object lastName) {
        this.lastNameInput.sendKeys(((CharSequence) lastName));
    }

//    public void fillLastName(String lastName) {
//        this.lastNameInput.sendKeys(lastName);
//    }
//
//    public void fillEmail(String email) {
//        this.emailInput.sendKeys(email);
//    }
//
//    public void chooseGender(String gender) {
//        switch (gender) {
//            case "male":
//                this.genders.get(0).click();
//            case "female":
//                this.genders.get(1).click();
//            case "other":
//                this.genders.get(2).click();
//        }
//    }
//
//    public void fillAge(String age) {
//
//        this.ageInput.sendKeys(age);
//    }
//
//    public WebElement chooseRandomExperience() {
//        return this.experience.get(new Random().nextInt(this.experience.size()));
//    }
//
//    public WebElement chooseProfession() {
//        return this.profession;
//
//    }
//
//    public void uploadFile() throws InterruptedException {
//        File file = new File("C:\\SeleniumDownload\\test-file-to-download.xlsx");
//        File folder = new File("C:\\SeleniumDownload");
//
//        String[] fileList = folder.list();
//        System.out.println("Starting file count = " + fileList.length);
//
//        downloadFileButton.click();
//        Thread.sleep(500L);
//
//        String[] fileList2 = folder.list();
//        System.out.println("Final file count = " + fileList2.length);
//
//        if ((fileList.length + 1) == fileList2.length) {
//            System.out.println("File downloaded, file count is +1 :)");
//        }
//
//        for (String fileInList : fileList2) {
//            if (fileInList.equals("test-file-to-download.xlsx")) {
//                System.out.println("File found!");
//                break;
//            }
//        }
//
//        fileUploadInput.sendKeys(file.getAbsolutePath());
//    }
//
//    public void clickButton() {
//        sendButton.click();
//    }
//
//    public WebElement getValidationMessage() {
//        return validationMessage;
//    }
}
