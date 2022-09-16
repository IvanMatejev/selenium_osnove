package d13_09_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		
		driver.findElement(By.className("oxd-button")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.className("oxd-input")).sendKeys("Me");
		
		driver.findElement(By.className("oxd-main-menu-item")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.className("oxd-userdropdown-tab")).click();
		
		driver.findElement(By.xpath("//*[text()='Logout']")).click();
		
		
		
		
		Thread.sleep(5000);
		driver.quit();
	}

}
