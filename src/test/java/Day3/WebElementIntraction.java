package Day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementIntraction {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement Title=driver.findElement(By.xpath("//h1[text()=\"Web form\"]"));
		System.out.println("Title of the page is : " + Title.getText());
		boolean TitleisDisplay=Title.isDisplayed();
		System.out.println("Title is Display : " + TitleisDisplay);
		
		WebElement TextInput=driver.findElement(By.xpath("//input[@id='my-text-id']"));
		boolean ISenabled=TextInput.isEnabled();
		System.out.println("Text input field is Enalbed is : " + ISenabled);
		TextInput.sendKeys("Ujjwal Tyagi");
		TextInput.clear();
		
		WebElement CheckBox=driver.findElement(By.xpath("//input[@id='my-check-2']"));
		boolean checkboxEnabled=CheckBox.isEnabled();
		System.out.println("Checkbox is Enabled : " + checkboxEnabled);
		CheckBox.click();
		System.out.println("Is Checkbox is Selected is : " + CheckBox.isSelected());
		
		driver.quit();

	}
	

}
