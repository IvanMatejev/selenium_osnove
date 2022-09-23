package d20_09_2022;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import d20_09_2022.BuyBoxPage;
import d20_09_2022.HeaderPage;
import d20_09_2022.LayerCartPage;
import d20_09_2022.TopMenuPage;
import katalon_pages.CartPages;
import katalon_pages.LoginPage;
import katalon_pages.NavPage;
import katalon_pages.ProductPage;

public abstract class  BasicTestHW20_09 {
	protected WebDriver driver;
 	protected WebDriverWait wait;
 	protected SoftAssert softAssert;
 	protected Actions actions;
    protected String baseUrl = "http://automationpractice.com/";
    protected BuyBoxPage buyBoxPage;
    protected LayerCartPage layerCartPage;
    protected TopMenuPage topMenuPage;
    protected HeaderPage headerPage;
    

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        buyBoxPage = new BuyBoxPage(driver,wait);
        layerCartPage = new LayerCartPage(driver,wait);
        topMenuPage = new TopMenuPage(driver,wait);
        headerPage = new HeaderPage(driver, wait);
        softAssert = new SoftAssert();
        actions = new Actions(driver);

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
