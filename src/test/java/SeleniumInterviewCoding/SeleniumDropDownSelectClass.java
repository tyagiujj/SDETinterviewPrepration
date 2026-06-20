package SeleniumInterviewCoding;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumDropDownSelectClass {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void Setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().to("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
    }

    @AfterClass
    public void TearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void SelectTheDropDown() {

        WebElement country = driver.findElement(By.id("country"));

        Select countryDropdown = new Select(country);

        countryDropdown.selectByVisibleText("Canada");

        Assert.assertEquals(countryDropdown.getFirstSelectedOption().getText(), "Canada", "Country selection failed");

        System.out.println("Canada Country is Selected Successfully");
    }

    @Test(priority = 2)
    public void CountNumberOfDropDown() {

        WebElement country = driver.findElement(By.id("country"));

        Select countryDropdown = new Select(country);

        int countOfDropDown = countryDropdown.getOptions().size();

        Assert.assertTrue(countOfDropDown > 0, "Dropdown is Empty");

        System.out.println("Count of the Drop Down is : " + countOfDropDown);
    }

    @Test(priority = 3)
    public void PrintNumberOfDropDown() {

        WebElement country = driver.findElement(By.id("country"));

        Select countryDropdown = new Select(country);

        Assert.assertTrue(countryDropdown.getOptions().size() > 0, "Dropdown has no values");

        for (WebElement text : countryDropdown.getOptions()) {
            System.out.println("Text of the Drop Down is : " + text.getText());
        }
    }

    @Test(priority = 4)
    public void VerifyCanadaOptionExists() {

        WebElement country = driver.findElement(By.id("country"));

        Select countryDropdown = new Select(country);

        boolean isCanadaPresent = countryDropdown.getOptions()
                .stream()
                .anyMatch(option -> option.getText().equals("Canada"));

        Assert.assertTrue(isCanadaPresent, "Canada option not found in dropdown");

        System.out.println("Canada option is present in the dropdown");
    }
}