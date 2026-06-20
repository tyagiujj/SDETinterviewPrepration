package SeleniumInterviewCoding;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumWindowHandling {

    WebDriver driver;

    @BeforeClass
    public void Setup() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts()
              .implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");
    }

    @AfterClass
    public void TearDown() {

        driver.quit();
    }

    @Test
    public void VerifyWindowHandling() {

        // Step 1: Store Parent Window ID
        String parentWindow = driver.getWindowHandle();

        System.out.println("Parent Window ID : " + parentWindow);

        // Step 2: Click New Tab button
        driver.findElement(By.id("PopUp")).click();

        // Step 3: Get All Window IDs
        Set<String> allWindows = driver.getWindowHandles();

        System.out.println("All Window IDs : " + allWindows);

        // Step 4: Switch to Child Window
        for (String window : allWindows) {

            if (!window.equals(parentWindow)) {

                driver.switchTo().window(window);

                System.out.println("Switched To Child Window");

                break;
            }
        }

        // Step 5: Print Child Window Title
        System.out.println("Child Window Title : " + driver.getTitle());

        // Step 6: Close Child Window
        driver.close();

        // Step 7: Switch Back To Parent Window
        driver.switchTo().window(parentWindow);

        System.out.println("Back To Parent Window");

        // Step 8: Print Parent Window Title
        System.out.println("Parent Window Title : " + driver.getTitle());
    }
}