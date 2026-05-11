package Day2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationCommand {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://myschoolone.com/hisp");
		driver.navigate().to("https://mypayroll.in/");
		driver.navigate().back();
		driver.navigate().forward();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.manage().window().minimize();
		Thread.sleep(2000);
		driver.manage().window().fullscreen();
		Thread.sleep(2000);
		driver.navigate().refresh();
		driver.quit();
		System.out.println("All Method Executed Successfully");

	}

}
