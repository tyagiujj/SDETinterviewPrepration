package Day3;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * CONCEPT 4: WebElement Interactions
 * ─────────────────────────────────────────────────────────────────
 * All actions you can perform on a WebElement after locating it.
 *
 * PAGE USED: https://www.selenium.dev/selenium/web/web-form.html
 */
public class _04_WebElementInteractions {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // ── 1. click() ─────────────────────────────────────────────
        WebElement checkbox = driver.findElement(By.id("my-check-1"));
        checkbox.click();
        System.out.println("1. Clicked checkbox. Selected: " + checkbox.isSelected());

        // ── 2. sendKeys() – Type into input fields ─────────────────
        WebElement textInput = driver.findElement(By.id("my-text-id"));
        textInput.sendKeys("Selenium Practice");
        System.out.println("2. Typed text into input.");

        // ── 3. clear() – Erase existing text ──────────────────────
        textInput.clear();
        System.out.println("3. Cleared the text field.");
        textInput.sendKeys("New Value After Clear");

        // ── 4. getText() – Get visible text of element ─────────────
        WebElement label = driver.findElement(By.cssSelector("h1"));
        System.out.println("4. getText()  → \"" + label.getText() + "\"");

        // ── 5. getAttribute() – Get HTML attribute value ───────────
        WebElement emailInput = driver.findElement(By.name("my-email"));
        System.out.println("5a. getAttribute('type')        → " + emailInput.getAttribute("type"));
        System.out.println("5b. getAttribute('placeholder') → " + emailInput.getAttribute("placeholder"));
        System.out.println("5c. getAttribute('name')        → " + emailInput.getAttribute("name"));
        // getAttribute("value") gives the CURRENT typed value
        emailInput.sendKeys("test@example.com");
        System.out.println("5d. getAttribute('value')       → " + emailInput.getAttribute("value"));

        // ── 6. getCssValue() – Read computed CSS property ──────────
        System.out.println("6. getCssValue('color') → " + label.getCssValue("color"));

        // ── 7. isDisplayed() – Is the element visible? ─────────────
        System.out.println("7. isDisplayed() → " + textInput.isDisplayed());

        // ── 8. isEnabled() – Can the user interact with it? ────────
        System.out.println("8. isEnabled()   → " + textInput.isEnabled());

        // ── 9. isSelected() – Checkbox / radio selected? ───────────
        System.out.println("9. isSelected()  → " + checkbox.isSelected());

        // ── 10. getTagName() – HTML tag of element ─────────────────
        System.out.println("10. getTagName() → " + textInput.getTagName());

        // ── 11. getRect() / getLocation() / getSize() ─────────────
        System.out.println("11a. Location → " + textInput.getLocation());
        System.out.println("11b. Size     → " + textInput.getSize());
        System.out.println("11c. Rect     → " + textInput.getRect());

        // ── 12. submit() – Submit a form ───────────────────────────
        // Equivalent to clicking the submit button
        WebElement form = driver.findElement(By.tagName("form"));
        // form.submit();  // Uncomment to test – it will navigate away
        System.out.println("12. submit() is available (commented out to stay on page).");

        // ── 13. Working with Radio Buttons ─────────────────────────
        WebElement radio1 = driver.findElement(By.id("my-radio-1"));
        WebElement radio2 = driver.findElement(By.id("my-radio-2"));
        radio1.click();
        System.out.println("13a. Radio1 selected: " + radio1.isSelected());
        radio2.click();
        System.out.println("13b. Radio2 selected: " + radio2.isSelected());
        System.out.println("13c. Radio1 now:      " + radio1.isSelected());

        // ── 14. Working with Textarea ─────────────────────────────
        WebElement textarea = driver.findElement(By.name("my-textarea"));
        textarea.sendKeys("Line 1\nLine 2\nLine 3");
        System.out.println("14. Textarea value: " + textarea.getAttribute("value"));

        // ── 15. Working with Range Slider ─────────────────────────
        WebElement range = driver.findElement(By.name("my-range"));
        System.out.println("15. Range default value: " + range.getAttribute("value"));

        Thread.sleep(2000);
        driver.quit();
        System.out.println("\n✅ WebElement Interactions concept DONE.");
    }
}
