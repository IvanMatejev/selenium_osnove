package p13_09_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		driver.manage().window().maximize();
		driver.get("https://cms.demo.katalon.com/ ");
		
		driver.findElement(By.xpath("//input[@name='s']")).sendKeys("Flying Ninja");
		
		driver.findElement(By.xpath("//button[@class='search-submit']")).click();
//		driver.findElement(By.name(name));
//		driver.findElement(By.className(className)); ime samo jedne klase;
//		driver.findElement(By.id(id));
		
		Thread.sleep(5000);
		
		driver.quit();
	}

}
