package p13_09_2022;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak5 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://s.bootsnipp.com/iframe/z80en");
		
		List<WebElement> row = driver.findElements(By.xpath("//*[@id='lorem']//tbody/tr[1]/td"));
		
		for ( int i = 0; i < row.size(); i++ ) {
			System.out.println(row.get(i).getText());
			Thread.sleep(2000);
		}
		
		List<WebElement> column = driver.findElements(By.xpath("//*[@id='lorem']//tbody/tr/td[1]"));
		
		for ( int i = 0; i < column.size(); i++ ) {
			System.out.println(column.get(i).getText());
			Thread.sleep(2000);
		}
		
		Thread.sleep(5000);
		driver.quit();

	}

}
