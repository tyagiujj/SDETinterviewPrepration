package Day1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;

public class _02_WebDriverSetup {

	public static void main(String[] args) throws InterruptedException {
		
		 WebDriver chromeDriver = new ChromeDriver();
		 chromeDriver.get("https://myschoolone.com/hisp");
		 chromeDriver.manage().window().maximize();
		 System.out.println("Title of the page is : " + chromeDriver.getTitle());
		 Thread.sleep(2000);
		 chromeDriver.quit();
		 
		 ChromeOptions options = new ChromeOptions();
	        options.addArguments("--start-maximized");          // Open maximized
	        options.addArguments("--disable-notifications");    // Block popups
	        options.addArguments("--incognito");   
	        
	        WebDriver optionsDriver = new ChromeDriver(options);
	        optionsDriver.get("https://www.selenium.dev");
	        System.out.println("Title: " + optionsDriver.getTitle());
	        Thread.sleep(2000);
	        optionsDriver.quit();
		 

	}

}
