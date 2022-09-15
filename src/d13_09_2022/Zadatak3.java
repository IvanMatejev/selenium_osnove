package d13_09_2022;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php");
		
		
		
		for ( int i = 0; i < 5 ; i++) {
			driver.findElement(By.className("add-new")).click();
			
			driver.findElement(By.name("name")).sendKeys("Ivan Matejev");
			driver.findElement(By.name("department")).sendKeys("QA");
			driver.findElement(By.name("phone")).sendKeys("0691888001");
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//tbody/tr[last()]//a[contains(@class, 'add')]")).click();
			Thread.sleep(500);
			
		}
		
		Thread.sleep(5000);
		driver.quit();
	}

}
