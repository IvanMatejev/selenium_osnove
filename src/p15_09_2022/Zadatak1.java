package p15_09_2022;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		
		
		driver.get("http://cms.demo.katalon.com/my-account/");
		
		driver.findElement(By.name("rememberme")).click();;
		
		if(driver.findElement(By.name("rememberme")).isSelected()) {
			System.out.println("Selektovano je.");
		}else {
			System.out.println("Nije selektovano.");
		}
		
		boolean elementPostoji = true;
		try {
			driver.findElement(By.name(""));
		}catch(NoSuchElementException error) {
			elementPostoji = false;
		}
		
		if(elementPostoji) {
			System.out.println("Element postoji.");
		}else {
			System.out.println("Element ne postoji.");
		}
		
		
		Thread.sleep(5000);
		driver.quit();
	}

}
