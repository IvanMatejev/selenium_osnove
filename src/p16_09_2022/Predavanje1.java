package p16_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Predavanje1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("");
		
		driver.findElement(By.id("showInBtn")).click();
		driver.findElement(By.id("showInBtn")).click();
		driver.findElement(By.id("showInBtn")).click();
		driver.findElement(By.id("showInBtn")).click();
		driver.findElement(By.id("showInBtn")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id-0")));
		
		wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("div"), 5));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("login-btn")));
		
		WebElement btn = driver.findElement(By.id("login-btn"));
		wait.until(ExpectedConditions.elementToBeClickable(btn));
		
		wait.until(ExpectedConditions.urlContains("/home"));
		
		wait.until(ExpectedConditions.titleContains("(1)"));
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.tagName("idiv")));
		
		
		
		
		System.out.println("Pojavio se element");
		
		
		
		Thread.sleep(5000);
		driver.quit();
	}

}
