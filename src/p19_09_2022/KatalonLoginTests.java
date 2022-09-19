package p19_09_2022;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.NoSuchElementException;

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

public class KatalonLoginTests {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private String baseUrl = "https://cms.demo.katalon.com" ;
	
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
		driver.get(baseUrl);
	}
	
	@Test(priority = 10)
	public void visitLoginPageFromNavBar() {
		
		driver.findElement(By.xpath("//*[contains(@class, 'page-item-10')]/a")).click();
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "My account – Katalon Shop";
		
		Assert.assertEquals(actualTitle, expectedTitle, "ERROR: Unexpected Title");
		
		boolean actualUrl = driver.getCurrentUrl().contains("/my-account");
		boolean expectedUrl = true;
		Assert.assertEquals(actualUrl, expectedUrl, "ERROR: Url should contains myaccount/");

		
	}
	
	@Test(priority = 20)
	public void checkInputTypes() {
		driver.get(baseUrl + "/my-account");
		
		String actualUsernameType = driver.findElement(By.name("username")).getAttribute("type");
		String expectedUserNameType = "text";
		Assert.assertEquals(actualUsernameType, expectedUserNameType, "ERROR: Username type should be text");
		
		String actualPasswordType = driver.findElement(By.name("password")).getAttribute("type");
		String expectedPasswordType = "password";
		Assert.assertEquals(actualPasswordType, expectedPasswordType, "ERROR: Password type should be password");
		
		String actualCheckboxType = driver.findElement(By.name("rememberme")).getAttribute("type");
		String expectedCheckboxType = "checkbox";
		Assert.assertEquals(actualPasswordType, expectedPasswordType, "ERROR: Password type should be checkbox");
		
		boolean isCheckBoxSelected = driver.findElement(By.name("rememberme")).isSelected();
		boolean expectedStatus = false;
		Assert.assertEquals(isCheckBoxSelected, expectedStatus, "ERROR: Checkbox should be not selected");
		
	}
	
	@Test(priority = 30)
	public void  displayErrorWhenCredentialsAreWrong() {
		driver.get(baseUrl + "/my-account");
		driver.findElement(By.name("username")).sendKeys("invalidemail@gmail.com");
		driver.findElement(By.name("password")).sendKeys("invalid123");
		driver.findElement(By.name("login")).click();
		
		boolean postoji = true;
		try {
			driver.findElement(By.className("woocommerce-error"));
		}catch(NoSuchElementException error) {
			postoji = false;
		}
		Assert.assertEquals(postoji, true, "ERROR: Url should contains myaccount/");
	}
	
	
	
	@AfterMethod
	public void afterMethod() {
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
