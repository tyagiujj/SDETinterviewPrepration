package SeleniumInterviewCoding;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumNavigationCommand {
	
	WebDriver driver;
	
	@BeforeClass
		public void Setup() {
			driver=new ChromeDriver();
			driver.navigate().to("https://sniffleshealth.devtrust.biz/login");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofNanos(10));	
		}
	@Test(priority=1)
	public void RefereshThepage() {
		driver.navigate().refresh();
		System.out.println("Page Successfully Referesh");
	}
	@Test(priority=2)
	public void LanuchTheSecondBrowser() {
		driver.get("https://myschoolone.com/hisp");
		System.out.println("Browser Successfully Launch");
		System.out.println("Title of the Page is : " +driver.getTitle());
		
	}
	@Test(priority=3)
	public void BackwardThePage() {
		driver.navigate().back();
		System.out.println("Page Successfully Back");
		System.out.println("Title of this page is : " +driver.getTitle());
	}
	@Test(priority=4)
	public void ForwardThePage() {
		driver.navigate().forward();
		System.out.println("Page Successfully Forward");
		System.out.println("Title of the page is After Forward : " + driver.getTitle());
		
	}
	@AfterClass
	public void TearDown() {
		driver.quit();
	}
	}


