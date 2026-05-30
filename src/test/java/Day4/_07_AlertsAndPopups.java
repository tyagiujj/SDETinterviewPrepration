package Day4;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * CONCEPT 7: Alerts & Popups
 * ─────────────────────────────────────────────────────────────────
 * JavaScript has 3 types of native dialog boxes:
 *
 *  1. Alert  – displays a message with OK button only
 *  2. Confirm – displays a message with OK and Cancel
 *  3. Prompt  – displays an input box + OK + Cancel
 *
 * Selenium switches to the Alert context using driver.switchTo().alert()
 *
 * KEY METHODS on Alert object:
 *  accept()     – click OK
 *  dismiss()    – click Cancel (or close for alert)
 *  getText()    – read message shown in dialog
 *  sendKeys()   – type into prompt input
 *
 * PAGE USED: https://www.selenium.dev/selenium/web/alerts.html
 */
public class _07_AlertsAndPopups {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // ════════════════════════════════════════════════════════════
        // 1. ALERT (Simple Alert – OK only)
        // ════════════════════════════════════════════════════════════
        System.out.println("=== 1. Simple Alert ===");
        driver.get("https://www.selenium.dev/selenium/web/alerts.html");
        Thread.sleep(1000);

        // Click button that triggers a simple alert
        driver.findElement(By.id("alert")).click();

        // Wait for alert to appear and switch to it
        wait.until(ExpectedConditions.alertIsPresent());
        Alert simpleAlert = driver.switchTo().alert();

        // Read the alert message
        System.out.println("Alert text: " + simpleAlert.getText());

        // Accept (click OK)
        simpleAlert.accept();
        System.out.println("Alert accepted (OK clicked).");
        Thread.sleep(1000);

        // ════════════════════════════════════════════════════════════
        // 2. CONFIRM DIALOG (OK + Cancel)
        // ════════════════════════════════════════════════════════════
        System.out.println("\n=== 2. Confirm Dialog ===");

        // Click button that triggers a confirm dialog
        driver.findElement(By.id("confirm")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert confirmAlert = driver.switchTo().alert();

        System.out.println("Confirm text: " + confirmAlert.getText());

        // Accept (click OK)
        confirmAlert.accept();
        System.out.println("Confirm accepted (OK).");

        // Verify result
        String confirmResult = driver.findElement(By.id("confirm-phrase")).getText();
        System.out.println("Result on page: " + confirmResult);
        Thread.sleep(1000);

        // -- Try dismiss (Cancel) on confirm --
        driver.findElement(By.id("confirm")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert confirmAlert2 = driver.switchTo().alert();
        confirmAlert2.dismiss();  // Click Cancel
        System.out.println("Confirm dismissed (Cancel).");

        confirmResult = driver.findElement(By.id("confirm-phrase")).getText();
        System.out.println("Result after Cancel: " + confirmResult);
        Thread.sleep(1000);

        // ════════════════════════════════════════════════════════════
        // 3. PROMPT DIALOG (Input + OK + Cancel)
        // ════════════════════════════════════════════════════════════
        System.out.println("\n=== 3. Prompt Dialog ===");

        // Click button that triggers a prompt
        driver.findElement(By.id("prompt")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert promptAlert = driver.switchTo().alert();

        System.out.println("Prompt text: " + promptAlert.getText());

        // Type text into the prompt input field
        promptAlert.sendKeys("Selenium Tester");
        System.out.println("Typed 'Selenium Tester' into prompt.");

        // Accept (click OK)
        promptAlert.accept();

        // Verify typed value appears on page
        String promptResult = driver.findElement(By.id("prompt-phrase")).getText();
        System.out.println("Result on page: " + promptResult);
        Thread.sleep(1000);

        // -- Try dismiss on prompt (Cancel) --
        driver.findElement(By.id("prompt")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert promptAlert2 = driver.switchTo().alert();
        promptAlert2.sendKeys("This text will be lost");
        promptAlert2.dismiss();  // Cancel – input is discarded
        System.out.println("Prompt dismissed (Cancel).");

        String promptResult2 = driver.findElement(By.id("prompt-phrase")).getText();
        System.out.println("Result after Cancel: " + promptResult2);

        // ════════════════════════════════════════════════════════════
        // 4. AUTO-CLOSE ALERT (appears and disappears quickly)
        // ════════════════════════════════════════════════════════════
        System.out.println("\n=== 4. Safe Alert Handling with Try-Catch ===");

        // Best practice: always wrap alert handling in try-catch
        try {
            // This alert may or may not exist
            Alert maybeAlert = driver.switchTo().alert();
            System.out.println("Unexpected alert text: " + maybeAlert.getText());
            maybeAlert.accept();
        } catch (org.openqa.selenium.NoAlertPresentException e) {
            System.out.println("No alert present – that's fine.");
        }

        Thread.sleep(2000);
        driver.quit();
        System.out.println("\n✅ Alerts & Popups concept DONE.");
    }
}
