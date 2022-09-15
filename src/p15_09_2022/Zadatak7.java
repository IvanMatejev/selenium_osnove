package p15_09_2022;

import java.awt.List;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		
		driver.get("file:///C:/Users/Ivan/Downloads/Zadatak6.html");
		
		for ( int i = 0; i < 5; i++) {
			driver.findElement(By.id("showInBtn")).click();
			driver.findElement(By.id("id-"+ i));
		}

	}
}
