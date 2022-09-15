package p15_09_2022;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://demoqa.com/modal-dialogs");
		
		driver.findElement(By.id("showLargeModal")).click();
		
		boolean elementPostoji = true;
		try {
			driver.findElement(By.className("modal-body"));
		}catch(NoSuchElementException error) {
			elementPostoji = false;
		}
		
		if(elementPostoji) {
			System.out.println("Dijalog se pojavio");
		}else {
			System.out.println("Dijalog se nije pojavio");
		}
		
		driver.quit();
	}

}
