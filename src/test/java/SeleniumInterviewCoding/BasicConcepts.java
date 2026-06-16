package SeleniumInterviewCoding;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BasicConcepts {
	WebDriver driver;
	
	@BeforeClass
	public void Setup() {
		driver=new ChromeDriver();
		driver.get("https://sniffleshealth.devtrust.biz/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(10));
	}
	@AfterClass
	public void TearDown() {
		driver.close();
	}
	@Test(priority=1)
	public void VerifyTheUrl() {
		String URL=driver.getCurrentUrl();
		Assert.assertEquals(URL,"https://sniffleshealth.devtrust.biz/login", "URL is not Matching");
	}
	@Test(priority=2)
	public void VerifyTheTitle() {
		String Title=driver.getTitle();
		Assert.assertEquals(Title,"SnifflesHealth - Telemedicine Platform","Title is not matching");
		System.out.println("Title of the page is : " + Title);
	}
	@Test(priority=3)
	public void VerifyTheLogo() {
		WebElement Logo=driver.findElement(By.xpath("//img[@alt='SnifflesHealth']"));
		Assert.assertTrue(Logo.isDisplayed(),"Logo of the Application is not Display");	
	}
	@Test(priority=4)
	public void VerifyTheUsernamefield() {
		WebElement username=driver.findElement(By.xpath("//input[@type=\"email\"]"));
		Assert.assertTrue(username.isEnabled(),"Username field is not Enabled");
		username.sendKeys("test@59gmail.com");	
	}
	@Test(priority=5)
	public void VerifyThePasswordfield() {
		WebElement password=driver.findElement(By.name("password"));
		Assert.assertTrue(password.isEnabled(),"Password field is not Enabled");
		password.sendKeys("Test@1234");
		
	}
	@Test(priority=6)
	public void VerifyTheLoginButton() {
		WebElement LoginButton=driver.findElement(By.xpath("//button[@type=\"submit\"]"));
		Assert.assertTrue(LoginButton.isDisplayed(),"Login Button is not Display");
		Assert.assertTrue(LoginButton.isEnabled(),"Login Button is not Enabled");
		LoginButton.click();
	}
	

}
