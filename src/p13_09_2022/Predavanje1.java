package p13_09_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Predavanje1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		
//		driver.manage().window().maximize();
//		WebElement searchInput=driver.findElement(By.xpath("//*[@name='q']"));
//		searchInput.sendKeys("IT Bootcamp");
		driver.findElement(By.xpath("//*[@name='q']")).sendKeys("IT Bootcamp");
		
		
		
		
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		
		WebElement firstReasult = driver.findElement(By.xpath("//*[@class='CCgQ5 vCa9Yd QfkTvb MUxGbd v0nnCb']"));
		firstReasult.click();
		
//		driver.close();
		driver.quit();
//		searchInput.clear();
//		searchInput.sendKeys("1000");
	}

}
