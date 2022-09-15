package p15_09_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		
		driver.get("https://cms.demo.katalon.com/");
		Thread.sleep(3000);

		if(driver.findElement(By.className("menu-toggle")).isDisplayed() ) {
			System.out.println("Dugme nije vidljivo");
		}else {
			System.out.println("Dugme je vidljivo");
		}
		
		Dimension newDimension = new Dimension(700, 700);
		driver.manage().window().setSize(newDimension);
		
	}

}
