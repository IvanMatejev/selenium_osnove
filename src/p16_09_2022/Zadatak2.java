package p16_09_2022;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Zadatak2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		
		driver.get("https://crop-circle.imageonline.co/#circlecropresult");
		Thread.sleep(5000);
		
		WebElement element = driver.findElement(By.id("inputImage"));
		new Actions(driver).scrollToElement(element).perform();
		driver.findElement(By.id("inputImage"))
		.sendKeys(new File("img/IMG_20200429_104204.jpg").getAbsolutePath());
		
		driver.findElement(By.id("photobutton")).click();
		
		
		
		Thread.sleep(5000);
		driver.quit();
	}

}
