package Day5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        Actions action = new Actions(driver);

        // Drag and Drop
        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));
        action.dragAndDrop(drag, drop).perform();

        // Double Click
        WebElement doubleClick = driver.findElement(By.xpath("//button[text()='Copy Text']"));
        action.doubleClick(doubleClick).perform();

        // Mouse Hover
        WebElement pointMe = driver.findElement(By.xpath("//button[text()='Point Me']"));
        WebElement mobile = driver.findElement(By.xpath("//a[text()='Mobiles']"));

        action.moveToElement(pointMe)
              .moveToElement(mobile)
              .click()
              .perform();

        driver.quit();
    }
}