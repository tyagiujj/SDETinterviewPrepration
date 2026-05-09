package Day1;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;

/**
 * CONCEPT 1: WebDriver Setup
 * ─────────────────────────────────────────────────────────────────
 * WebDriver is the core interface of Selenium that lets you control
 * a real browser programmatically.
 *
 * SETUP STEPS:
 *  1. Add Selenium dependency in pom.xml (Maven) or build.gradle
 *  2. WebDriverManager auto-downloads the correct browser driver
 *
 * Maven dependency:
 *  <dependency>
 *    <groupId>org.seleniumhq.selenium</groupId>
 *    <artifactId>selenium-java</artifactId>
 *    <version>4.18.1</version>
 *  </dependency>
 *  <dependency>
 *    <groupId>io.github.bonigarcia</groupId>
 *    <artifactId>webdrivermanager</artifactId>
 *    <version>5.7.0</version>
 *  </dependency>
 */
public class _01_WebDriverSetup {

    public static void main(String[] args) throws InterruptedException {

        // ── 1. Launch Chrome (most common) ─────────────────────────
        System.out.println("=== Launching Chrome ===");
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.google.com");
        System.out.println("Title: " + chromeDriver.getTitle());
        Thread.sleep(2000);
        chromeDriver.quit();

        // ── 2. Launch Firefox ──────────────────────────────────────
        System.out.println("\n=== Launching Firefox ===");
        WebDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.get("https://www.google.com");
        System.out.println("Title: " + firefoxDriver.getTitle());
        Thread.sleep(2000);
        firefoxDriver.quit();

//        // ── 3. Launch Edge ─────────────────────────────────────────
//        System.out.println("\n=== Launching Edge ===");
//        WebDriver edgeDriver = new EdgeDriver();
//        edgeDriver.get("https://www.google.com");
//        System.out.println("Title: " + edgeDriver.getTitle());
//        Thread.sleep(2000);
//        edgeDriver.quit();

        // ── 4. Chrome with Options ─────────────────────────────────
        System.out.println("\n=== Chrome with Options ===");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");          // Open maximized
        options.addArguments("--disable-notifications");    // Block popups
        options.addArguments("--incognito");                // Incognito mode
        // options.addArguments("--headless");              // No browser UI
        WebDriver optionsDriver = new ChromeDriver(options);
        optionsDriver.get("https://www.selenium.dev");
        System.out.println("Title: " + optionsDriver.getTitle());
        Thread.sleep(2000);
        optionsDriver.quit();

        // ── 5. Firefox with Options ────────────────────────────────
        System.out.println("\n=== Firefox with Options ===");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("-private");            // Private mode
        WebDriver ffDriver = new FirefoxDriver(firefoxOptions);
        ffDriver.get("https://www.selenium.dev");
        System.out.println("Title: " + ffDriver.getTitle());
        Thread.sleep(2000);
        ffDriver.quit();

        System.out.println("\n✅ WebDriver Setup concept DONE.");
    }
}
