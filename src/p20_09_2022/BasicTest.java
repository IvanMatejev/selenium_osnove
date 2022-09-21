package p20_09_2022;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import katalon_pages.CartPages;
import katalon_pages.NavPage;
import katalon_pages.ProductPage;

public abstract class BasicTest {
	 	protected WebDriver driver;
	 	protected WebDriverWait wait;
	    protected String baseUrl = "https://cms.demo.katalon.com";
	    protected NavPage navPage;
	    protected ProductPage productPage;
	    protected CartPages cartPage;
	    

	    @BeforeClass
	    public void beforeClass() {
	        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
	        driver = new ChromeDriver();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        cartPage = new CartPages(driver,wait);
	        productPage = new ProductPage(driver,wait);
	        navPage = new NavPage(driver,wait);

	    }
	    @BeforeMethod
	    public void beforeMethod() {
	        driver.get(baseUrl);
	    }

	    @AfterMethod
	    public void afterMethod() {

	    }

	    @AfterClass
	    public void afterClass() {
	        driver.quit();
	    }
}
