package p16_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		
		driver.get(" https://docs.katalon.com/");
		
		driver.findElement(By.tagName("html")).getAttribute("data-theme");
		
		if(driver.findElement(By.tagName("html")).getAttribute("data-theme").equals("light")) {
			System.out.println("Okej");
		}else {
			System.out.println("Nije okej");
		}
		
		driver.findElement(By.className("toggleButton_rCf9")).click();
		
		if(driver.findElement(By.tagName("html")).getAttribute("data-theme").equals("dark")) {
			System.out.println("Okej");
		}else {
			System.out.println("Nije okej");
		}
		
		
		new Actions(driver).keyDown(Keys.CONTROL).sendKeys("k").perform();
		
		if(driver.findElement(By.id("docsearch-input")).getAttribute("type").endsWith("search")) {
			System.out.println("Sve cool");
		}else {
			System.out.println("Ne valja");
		}
		
		
		
		
		
		Thread.sleep(5000);
		driver.quit();
	}

}
