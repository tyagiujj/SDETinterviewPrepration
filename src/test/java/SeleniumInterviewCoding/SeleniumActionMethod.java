package SeleniumInterviewCoding;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumActionMethod {

    WebDriver driver;
    WebDriverWait wait;
    Actions action;

    @BeforeClass
    public void Setup() {

        driver = new ChromeDriver();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        action = new Actions(driver);

        driver.manage().window().maximize();

        driver.get("https://testautomationpractice.blogspot.com/");
    }

    @AfterClass
    public void TearDown() {

        if (driver != null) {
            driver.quit();
        }
    }

    // Drag and Drop
    @Test(priority = 1)
    public void VerifyTheDragAndDropFunctionality() {

        WebElement drag =
                driver.findElement(By.id("draggable"));

        WebElement drop =
                driver.findElement(By.id("droppable"));

        action.dragAndDrop(drag, drop).perform();

        String actualText = drop.getText();

        Assert.assertEquals(actualText,
                "Dropped!",
                "Drag and Drop failed");

        System.out.println("Drag and Drop Successful");
    }

    // Double Click
    @Test(priority = 2)
    public void VerifyTheDoubleClickFunctionality() {

        WebElement copyText =
                driver.findElement(By.xpath("//button[text()='Copy Text']"));

        action.doubleClick(copyText).perform();

        System.out.println("Double Click Successful");
    }

    // Mouse Hover
    @Test(priority = 3)
    public void VerifyMouseHoverAction() {

        WebElement pointMe =
                driver.findElement(By.xpath("//button[text()='Point Me']"));

        WebElement mobiles =
                driver.findElement(By.xpath("//a[text()='Mobiles']"));

        action.moveToElement(pointMe)
              .moveToElement(mobiles)
              .click()
              .perform();

        System.out.println("Mouse Hover Successful");
    }

    // Click and Hold
    @Test(priority = 4)
    public void VerifyClickAndHold() {

        WebElement drag =
                driver.findElement(By.id("draggable"));

        action.clickAndHold(drag)
              .pause(Duration.ofSeconds(2))
              .release()
              .perform();

        System.out.println("Click and Hold Successful");
    }

    // Release
    @Test(priority = 5)
    public void VerifyReleaseMethod() {

        WebElement drag =
                driver.findElement(By.id("draggable"));

        action.clickAndHold(drag)
              .pause(Duration.ofSeconds(2))
              .release(drag)
              .perform();

        System.out.println("Release Method Successful");
    }

    // Right Click
    @Test(priority = 6)
    public void VerifyTheRightClickFunctionality() {

        driver.navigate().to(
                "https://practice.expandtesting.com/context-menu");

        WebElement rightClick =
                driver.findElement(By.id("hot-spot"));

        action.contextClick(rightClick).perform();

        Alert alert = driver.switchTo().alert();

        System.out.println("Alert Message : "
                + alert.getText());

        alert.accept();

        System.out.println("Right Click Successful");
    }
}