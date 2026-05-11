package Day2;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * CONCEPT 3: Browser Navigation & Window Management
 * ─────────────────────────────────────────────────────────────────
 * Covers:
 *  - Navigating to URLs
 *  - Browser history (back, forward, refresh)
 *  - Window maximize, minimize, resize, move
 *  - Getting page info (title, URL, page source)
 *  - Closing vs quitting
 */
public class _03_BrowserNavigation {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        // ── 1. Open a URL ──────────────────────────────────────────
        driver.get("https://www.selenium.dev");           // Preferred
        // OR
        driver.navigate().to("https://www.selenium.dev"); // Same result
        System.out.println("1. Opened URL: " + driver.getCurrentUrl());
        Thread.sleep(1500);

        // ── 2. Get Page Info ───────────────────────────────────────
        System.out.println("2a. Page Title   : " + driver.getTitle());
        System.out.println("2b. Current URL  : " + driver.getCurrentUrl());
        String source = driver.getPageSource();
        System.out.println("2c. Page Source length: " + source.length() + " chars");

        // ── 3. Navigate to a second page ───────────────────────────
        driver.navigate().to("https://www.selenium.dev/documentation/");
        System.out.println("3. Navigated to: " + driver.getCurrentUrl());
        Thread.sleep(1500);

        // ── 4. Browser Back ────────────────────────────────────────
        driver.navigate().back();
        Thread.sleep(1500);
        System.out.println("4. After back()   : " + driver.getCurrentUrl());

        // ── 5. Browser Forward ────────────────────────────────────
        driver.navigate().forward();
        Thread.sleep(1500);
        System.out.println("5. After forward(): " + driver.getCurrentUrl());

        // ── 6. Refresh Page ────────────────────────────────────────
        driver.navigate().refresh();
        Thread.sleep(1500);
        System.out.println("6. After refresh(): " + driver.getCurrentUrl());

        // ── 7. Window Maximize ────────────────────────────────────
        driver.manage().window().maximize();
        System.out.println("7. Window maximized.");
        Thread.sleep(1000);

        // ── 8. Window Minimize ────────────────────────────────────
        driver.manage().window().minimize();
        System.out.println("8. Window minimized.");
        Thread.sleep(1000);

        // ── 9. Full Screen ────────────────────────────────────────
        driver.manage().window().fullscreen();
        System.out.println("9. Full screen activated.");
        Thread.sleep(1000);

        // ── 10. Set Window Size ───────────────────────────────────
        driver.manage().window().setSize(new Dimension(1280, 720));
        Dimension size = driver.manage().window().getSize();
        System.out.println("10. Window size set: " + size.getWidth() + "x" + size.getHeight());
        Thread.sleep(1000);

        // ── 11. Set Window Position ───────────────────────────────
        driver.manage().window().setPosition(new Point(100, 100));
        Point pos = driver.manage().window().getPosition();
        System.out.println("11. Window position: x=" + pos.getX() + ", y=" + pos.getY());
        Thread.sleep(1000);

        // ── 12. close() vs quit() ─────────────────────────────────
        // close() → closes ONLY the current tab/window
        // quit()  → closes ALL tabs/windows + kills WebDriver session
        driver.quit();  // Always use quit() to clean up resources
        System.out.println("12. driver.quit() called – all windows closed.");

        System.out.println("\n✅ Browser Navigation concept DONE.");
    }
}
