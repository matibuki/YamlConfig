package widgets;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import start.TestBase;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class DatePickerTests extends TestBase {
    LocalDate today = LocalDate.now();
    //        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("d");
    DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy");
    String todayYear = today.format(formatter3);
    String todayDay = today.format(formatter2);

    @Test
    public void todayDateTest() {
        getDriver().get(seleniumui + "/datepicker.php");

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
//        wait.withTimeout(Duration.ofSeconds(10));
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
        System.out.println("First day of next month is: + " + input.getAttribute("value"));
    }

    @Test
    public void lastJanNextYear() {
        getDriver().get(seleniumui + "/datepicker.php");

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        WebElement input = findElementByCss("#datepicker");
        input.click();
        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.cssSelector("#ui-datepicker-div"))));

        String currentYear = findElementByCss(".ui-datepicker-year").getText();

//        boolean condition = false;
////        while (!currentYear.equals(todayYear)) {
//        while (!condition) {
//            do {
//                getDriver().findElement(By.cssSelector(".ui-datepicker-next")).click();
//                currentYear = findElementByCss(".ui-datepicker-year").getText();
//            }
//
//            getDriver().findElement(By.cssSelector(".ui-datepicker-next")).click();
////            String currentYear = findElementByCss(".ui-datepicker-year").getText();
//
//        }


        boolean condition = false;
        while (condition) {
            getDriver().findElement(By.cssSelector(".ui-datepicker-next")).click();
            currentYear = findElementByCss(".ui-datepicker-year").getText();
            System.out.println(currentYear);
            if (currentYear.equals("2023")) {
                condition = true;
                WebElement day = getDriver().findElement(By.linkText("31"));
                day.click();
                System.out.println("Last day of January next year: + " + input.getAttribute("value"));
//
//            }

            }


        }

    }
}
