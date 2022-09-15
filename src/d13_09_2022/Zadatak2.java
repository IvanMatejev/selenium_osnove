package d13_09_2022;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get(" https://s.bootsnipp.com/iframe/WaXlr");
		
		List<WebElement> stars = driver.findElements(By.xpath("//*[contains(@id, 'rating-star')]"));
		
		Scanner s = new Scanner(System.in);
		Thread.sleep(3000);
		int ocena = s.nextInt();
		
		stars.get(ocena-1).click();
		
//		for ( int i = 0; i < stars.size(); i++ ) {
//			stars.get(ocena).click();
//		}
		
		Thread.sleep(5000);
		driver.quit();
	}

}
