package p19_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNgUvod {
	private WebDriver driver;
	private WebDriverWait wait;
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@BeforeMethod
	public void beforeMethod() {
		driver.get("https://www.google.com/");
	}
	
	@Test(priority = 10)
	public void openHomePage() {
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "Google";
		
		Assert.assertEquals(actualTitle, expectedTitle, "ERROR: Unexpected Title");
		
		String actualLang=driver.findElement(By.tagName("html")).
						getAttribute("lang");
		
		String expectedLang = "sr";
		
		Assert.assertEquals(actualLang, expectedLang, "Error: Lang should be eng");
		
	}
	
	@Test(priority = 20)
	public void search() {
		System.out.println("Test 2");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After method");
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
}
