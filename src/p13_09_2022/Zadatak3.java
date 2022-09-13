package p13_09_2022;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		ArrayList<String> stranice = new ArrayList<String>();
		stranice.add("https://google.com/");
		stranice.add("https://youtube.com/");
		stranice.add("https://www.ebay.com/");
		stranice.add("https://www.kupujemprodajem.com/");
		
		for ( int i = 0 ; i < stranice.size(); i++ ) {
			driver.get(stranice.get(i));
			System.out.println(driver.getTitle());
		}
		
		driver.quit();

	}

}
