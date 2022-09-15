package p15_09_2022;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadatak3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.ebay.com/");
		Thread.sleep(3000);
		
		Random r = new Random();
		Select dropdown = new Select(driver.findElement(By.name("_sacat")));
		
		List<WebElement> options = dropdown.getOptions();
		
		int opcija = r.nextInt(options.size());
		dropdown.selectByIndex(opcija);
		
	}

}
