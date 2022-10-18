package widgets;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import start.TestBase;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

public class DatePickerTests extends TestBase {
    LocalDate today = LocalDate.now();
    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("d");
    DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy");
    String todayYear = today.format(formatter3);
    String todayDay = today.format(formatter2);

    @Test
    public void todayDateTest() {
        getDriver().get(seleniumui + "/datepicker.php");

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.cssSelector("#datepicker"))));

        WebElement input = findElementByCss("#datepicker");
        input.click();

        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.cssSelector("#ui-datepicker-div"))));

        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.linkText(todayDay))));
        WebElement day = getDriver().findElement(By.linkText(todayDay));
        day.click();
        System.out.println("Today date is: " + input.getAttribute("value"));
    }

    @Test
    public void nextMonthFirstDayTest() {
        getDriver().get(seleniumui + "/datepicker.php");

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        WebElement input = findElementByCss("#datepicker");
        input.click();
        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.cssSelector("#ui-datepicker-div"))));

        getDriver().findElement(By.cssSelector(".ui-datepicker-next")).click();

        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.cssSelector("#ui-datepicker-div"))));

        WebElement day = getDriver().findElement(By.linkText("1"));
        day.click();
        System.out.println("First day of next month is: " + input.getAttribute("value"));
    }

    @Test
    public void lastJanNextYear() {
        getDriver().get(seleniumui + "/datepicker.php");

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        WebElement input = findElementByCss("#datepicker");
        input.click();
        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.cssSelector("#ui-datepicker-div"))));

        String currentYear = findElementByCss(".ui-datepicker-year").getText();
        while (currentYear.equals(getDriver().findElement(By.cssSelector(".ui-datepicker-year")).getText())) {
            getDriver().findElement(By.cssSelector(".ui-datepicker-next")).click();
        }

        if ((Integer.parseInt(currentYear) + 1) == Integer.parseInt(getDriver().findElement(By.cssSelector(".ui-datepicker-year")).getText())) {
            wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.linkText("31"))));
            WebElement firstDay = getDriver().findElement(By.linkText("1"));
            firstDay.click();
        }
        System.out.println("Last day of January next year: " + input.getAttribute("value"));

        input.click();
        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.cssSelector("#ui-datepicker-div"))));
        getDriver().findElement(By.cssSelector(".ui-state-active")).click();

        System.out.println("The same date again is: " + input.getAttribute("value"));
    }

    @Test
    public void randomDayFromPreviousMonthTest() {
        getDriver().get(seleniumui + "/datepicker.php");

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        WebElement input = findElementByCss("#datepicker");
        input.click();
        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.cssSelector("#ui-datepicker-div"))));
        getDriver().findElement(By.cssSelector(".ui-datepicker-prev")).click();

        List<WebElement> days = getDriver().findElements(By.xpath("//*[@data-handler='selectDay' and not(contains(@class,'ui-datepicker-other-month'))]"));

        Random random = new Random();

        getDriver().findElement(By.linkText(days.get(random.nextInt(days.size())).getText())).click();

        System.out.println("Random day from previous month is: " + input.getAttribute("value"));
    }

    @Test
    public void randomDayFromLastYearTest() {
        getDriver().get(seleniumui + "/datepicker.php");

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        WebElement input = findElementByCss("#datepicker");
        input.click();
        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.cssSelector("#ui-datepicker-div"))));

        String currentYear = findElementByCss(".ui-datepicker-year").getText();
        while (currentYear.equals(getDriver().findElement(By.cssSelector(".ui-datepicker-year")).getText())) {
            getDriver().findElement(By.cssSelector(".ui-datepicker-prev")).click();
        }

        Random random = new Random();

        for (int i = 1; i < random.nextInt(0, 11); i++) {
            getDriver().findElement(By.cssSelector(".ui-datepicker-prev")).click();
        }
        List<WebElement> days = getDriver().findElements(By.xpath("//*[@data-handler='selectDay' and not(contains(@class,'ui-datepicker-other-month'))]"));
        getDriver().findElement(By.linkText(days.get(random.nextInt(days.size())).getText())).click();

        System.out.println("Random day from previous year is: " + input.getAttribute("value"));
    }
}