package SeleniumInterviewCoding;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumAlertConcepts {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void Setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://demoqa.com/alerts");
    }

    @AfterClass
    public void TearDown() {

        if (driver != null) {
            driver.quit();
        }
    }

    // Simple Alert
    @Test(priority = 1)
    public void VerifyTheSimpleAlert() {

        WebElement clickMeSimpleAlert =
                driver.findElement(By.id("alertButton"));

        Assert.assertTrue(clickMeSimpleAlert.isDisplayed(),
                "Click Me button is not displayed");

        Assert.assertTrue(clickMeSimpleAlert.isEnabled(),
                "Click Me button is not enabled");

        clickMeSimpleAlert.click();

        Alert simpleAlert = wait.until(ExpectedConditions.alertIsPresent());

        System.out.println("Simple Alert Text: "+ simpleAlert.getText());

        simpleAlert.accept();
    }

    // Confirm Alert
    @Test(priority = 2)
    public void VerifyTheConfirmAlert() {

        WebElement clickMeConfirmAlert =
                driver.findElement(By.id("confirmButton"));

        clickMeConfirmAlert.click();

        Alert confirmAlert =
                wait.until(ExpectedConditions.alertIsPresent());

        System.out.println("Confirm Alert Text: "
                + confirmAlert.getText());

        confirmAlert.accept();

        WebElement result =
                driver.findElement(By.id("confirmResult"));

        Assert.assertEquals(
                result.getText(),
                "You selected Ok",
                "Confirmation result message mismatch");
    }

    // Prompt Alert
    @Test(priority = 3)
    public void VerifyThePromptAlert() {

        WebElement clickMePromptAlert =
                driver.findElement(By.id("promtButton"));

        clickMePromptAlert.click();

        Alert promptAlert =
                wait.until(ExpectedConditions.alertIsPresent());

        System.out.println("Prompt Alert Text: "
                + promptAlert.getText());

        promptAlert.sendKeys("Ujjwal Tyagi");

        promptAlert.accept();

        WebElement result =
                driver.findElement(By.id("promptResult"));

        Assert.assertTrue(
                result.getText().contains("Ujjwal Tyagi"),
                "Prompt alert result message mismatch");
    }
}