package Day4;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertAutomationPractice {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
        driver.manage().window().maximize();

        // Simple Alert
        WebElement simplealert = driver.findElement(By.id("alertBox"));
        simplealert.click();

        Alert alert = driver.switchTo().alert();
        System.out.println("Text message is on Simple Alert : " + alert.getText());
        alert.accept();
        System.out.println("Click on Ok button in simple alert.");

        // Confirm Alert
        WebElement confirmalert = driver.findElement(By.id("confirmBox"));
        confirmalert.click();
        Alert alert1 = driver.switchTo().alert();
        System.out.println("Text Message is on Confirm Alert is : " + alert1.getText());
        alert1.dismiss();  //  Fixed: was alert.dismiss() — should be alert1.dismiss()
        System.out.println("Click on Cancel button in Confirm Alert.");

        // Prompt Alert
        WebElement promptalert = driver.findElement(By.id("promptBox"));
        promptalert.click();

        Alert alert3 = driver.switchTo().alert();
        System.out.println("Text Message is on Prompt alert : " + alert3.getText());

        //  Clear existing text first, then type new text
        alert3.sendKeys("");           // clears pre-filled text
        alert3.sendKeys("Ujjwal Tyagi"); // enters new text
        Thread.sleep(3000);            // Fixed: 50000ms (50s) is too long, use 3000ms

        alert3.accept(); // ✅ Added: click OK to submit the prompt
        System.out.println("Entered name and clicked OK on Prompt Alert.");

        driver.quit(); // ✅ Added: close browser after test
    }
}