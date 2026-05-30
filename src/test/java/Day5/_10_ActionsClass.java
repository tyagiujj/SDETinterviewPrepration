package Day5;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * CONCEPT 10: Actions Class (Advanced User Interactions)
 * ─────────────────────────────────────────────────────────────────
 * The Actions class simulates complex user interactions like:
 *  - Mouse hover (move to element)
 *  - Click and hold / release
 *  - Double click
 *  - Right click (Context click)
 *  - Drag and Drop
 *  - Keyboard key combinations (Ctrl+A, Shift+Click, etc.)
 *  - Drawing / free-form mouse movement
 *
 * Actions builds an action chain; call perform() at the end to execute.
 *
 * PAGE USED: https://www.selenium.dev/selenium/web/mouse_interaction.html
 *            https://www.selenium.dev/selenium/web/draggable.html
 */
public class _10_ActionsClass {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);  // Create Actions instance

        // ════════════════════════════════════════════════════════════
        // 1. MOUSE HOVER (moveToElement)
        // ════════════════════════════════════════════════════════════
        System.out.println("=== 1. Mouse Hover ===");
        driver.get("https://www.selenium.dev/selenium/web/mouse_interaction.html");
        Thread.sleep(1000);

        WebElement hoverTarget = driver.findElement(By.id("hover"));
        actions.moveToElement(hoverTarget).perform();
        System.out.println("Hovered over element: " + hoverTarget.getText());
        Thread.sleep(1000);

        // Hover to a specific offset within an element
        actions.moveToElement(hoverTarget, 10, 10).perform();
        System.out.println("Moved to offset (10,10) within element.");
        Thread.sleep(1000);

        // Move to absolute coordinates on screen
        actions.moveByOffset(100, 200).perform();
        System.out.println("Moved mouse by offset (100, 200).");
        Thread.sleep(800);

        // ════════════════════════════════════════════════════════════
        // 2. CLICK TYPES
        // ════════════════════════════════════════════════════════════
        System.out.println("\n=== 2. Click Types ===");

        // Regular click (same as WebElement.click())
        WebElement clickable = driver.findElement(By.id("clickable"));
        actions.click(clickable).perform();
        System.out.println("2a. Regular click done.");
        Thread.sleep(500);

        // Double Click
        try {
            WebElement dblClickEl = driver.findElement(By.id("double-click"));
            actions.doubleClick(dblClickEl).perform();
            System.out.println("2b. Double click done.");
        } catch (NoSuchElementException e) {
            System.out.println("2b. Double click element not found on this page.");
        }
        Thread.sleep(500);

        // Right Click (Context Menu)
        try {
            WebElement rightClickEl = driver.findElement(By.id("context-menu"));
            actions.contextClick(rightClickEl).perform();
            System.out.println("2c. Right click (context click) done.");
            // Press Escape to close the context menu
            actions.sendKeys(Keys.ESCAPE).perform();
        } catch (NoSuchElementException e) {
            System.out.println("2c. Right click element not found on this page.");
        }
        Thread.sleep(500);

        // Click and Hold, then Release
        WebElement clickHoldEl = driver.findElement(By.id("clickable"));
        actions.clickAndHold(clickHoldEl).pause(Duration.ofSeconds(1)).release().perform();
        System.out.println("2d. Click-and-hold then release done.");

        // ════════════════════════════════════════════════════════════
        // 3. KEYBOARD ACTIONS
        // ════════════════════════════════════════════════════════════
        System.out.println("\n=== 3. Keyboard Actions ===");
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        Thread.sleep(1000);

        WebElement inputField = driver.findElement(By.id("my-text-id"));
        inputField.click();

        // Type using Actions
        actions.sendKeys("Hello Selenium Actions").perform();
        System.out.println("3a. Typed via Actions.sendKeys()");
        Thread.sleep(500);

        // Select All (Ctrl+A) then Delete
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        actions.sendKeys(Keys.DELETE).perform();
        System.out.println("3b. Ctrl+A → Delete → cleared text.");
        Thread.sleep(500);

        // Type again
        actions.sendKeys("New Text").perform();
        System.out.println("3c. Typed 'New Text'.");

        // Ctrl+C (copy) and Ctrl+V (paste)
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
        System.out.println("3d. Ctrl+A + Ctrl+C (copy).");

        WebElement anotherField = driver.findElement(By.name("my-textarea"));
        anotherField.click();
        actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
        System.out.println("3e. Ctrl+V (pasted into textarea): " + anotherField.getAttribute("value"));
        Thread.sleep(500);

        // Press Tab key
        actions.sendKeys(Keys.TAB).perform();
        System.out.println("3f. Tab key pressed.");

        // Press Enter key
        actions.sendKeys(Keys.ENTER).perform();
        System.out.println("3g. Enter key pressed.");

        // Special keys: HOME, END, PAGE_UP, PAGE_DOWN, ARROW keys
        actions.sendKeys(Keys.HOME).perform();
        System.out.println("3h. HOME key pressed.");

        // Shift + Click (select range)
        driver.get("https://www.selenium.dev/selenium/web/mouse_interaction.html");
        Thread.sleep(1000);
        WebElement firstEl = driver.findElement(By.id("clickable"));
        actions.click(firstEl)
               .keyDown(Keys.SHIFT)
               .sendKeys(Keys.END)
               .keyUp(Keys.SHIFT)
               .perform();
        System.out.println("3i. Shift+End (range select).");

        // ════════════════════════════════════════════════════════════
        // 4. DRAG AND DROP
        // ════════════════════════════════════════════════════════════
        System.out.println("\n=== 4. Drag and Drop ===");
        driver.get("https://www.selenium.dev/selenium/web/draggable.html");
        Thread.sleep(1000);

        // Method A: dragAndDrop(source, target)
        try {
            WebElement source = driver.findElement(By.id("draggable"));
            WebElement target = driver.findElement(By.id("droppable"));
            actions.dragAndDrop(source, target).perform();
            System.out.println("4a. dragAndDrop(source, target) done.");
        } catch (NoSuchElementException e) {
            System.out.println("4a. Drag-drop elements not found.");
        }
        Thread.sleep(800);

        // Method B: dragAndDropBy(source, xOffset, yOffset)
        try {
            WebElement draggable = driver.findElement(By.id("draggable"));
            actions.dragAndDropBy(draggable, 200, 0).perform();  // Move 200px right
            System.out.println("4b. dragAndDropBy(element, 200, 0) done.");
        } catch (Exception e) {
            System.out.println("4b. dragAndDropBy not applicable here.");
        }
        Thread.sleep(800);

        // Method C: Manual click-hold-move-release
        try {
            WebElement dragEl = driver.findElement(By.id("draggable"));
            actions.clickAndHold(dragEl)
                   .moveByOffset(150, 50)
                   .release()
                   .perform();
            System.out.println("4c. Manual drag via clickAndHold+moveByOffset+release.");
        } catch (Exception e) {
            System.out.println("4c. Manual drag not applicable here.");
        }

        // ════════════════════════════════════════════════════════════
        // 5. SCROLL ACTIONS (Selenium 4.2+)
        // ════════════════════════════════════════════════════════════
        System.out.println("\n=== 5. Scroll Actions ===");
        driver.get("https://www.selenium.dev/selenium/web/scrolling_tests/page_with_iframe_removed_on_scroll.html");
        Thread.sleep(1000);

        // Scroll down by pixel amount
        actions.scrollByAmount(0, 300).perform();
        System.out.println("5a. Scrolled down 300px.");
        Thread.sleep(800);

        // Scroll to a specific element
        try {
            WebElement scrollTarget = driver.findElement(By.tagName("iframe"));
            actions.scrollToElement(scrollTarget).perform();
            System.out.println("5b. Scrolled to element.");
        } catch (Exception e) {
            System.out.println("5b. Scroll to element – element not found.");
        }
        Thread.sleep(800);

        Thread.sleep(2000);
        driver.quit();
        System.out.println("\n✅ Actions Class concept DONE.");
    }
}
