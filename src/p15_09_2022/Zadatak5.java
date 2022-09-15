package p15_09_2022;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://demoqa.com/login");
		
		driver.findElement(By.id("userName")).sendKeys("itbootcamp");
		driver.findElement(By.id("password")).sendKeys("ITBootcamp2021!");
		
		driver.findElement(By.id("login")).click();
		
		
		boolean elementPostoji = true;
		try {
			driver.findElement(By.id("submit"));
		}catch(NoSuchElementException error) {
			elementPostoji = false;
		}
		
		if(elementPostoji) {
			driver.findElement(By.id("submit")).click();
		}else {
			System.out.println("Element ne postoji");
		}
		
		
		driver.quit();
		
		
	}

}
