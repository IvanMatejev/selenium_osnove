package d15_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Zadatak3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		3.Zadatak (Za vezbanje)
//		Napisati program koji 
//		Ucitava https://seeds.sproutsocial.com/components/loader-button/
//		Odskrola do Loader buttons are used to display a loading indicator inside of a button. 
//		paragrafa. Koristan link
//		Klikce ne dugme 
//		Ceka da dugme zavrsi sa loadingom 
//		Ispisati poruku na ekranu
//		Zatvoriti pretrazivac
//		HINT: Koristite data-qa-button-isloading  atribut elementa za cekanje odredjenog stanja tog
//		elementa
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		
		driver.get("https://seeds.sproutsocial.com/components/loader-button/");
		
		new Actions(driver).scrollToElement(driver.findElement(By.className("dYHkzc"))).perform();
		
		driver.findElement(By.className("dzjEcK")).click();
		
		boolean isLoading = true;
		try {
			driver.findElement(By.xpath("//*[@data-qa-button-isloading='true']"));
		}catch(Exception e){
			isLoading = false;
		}
		if(isLoading) {
			System.out.println("Stranica se ocitava");
		}else {
			System.out.println("Stranica se ne ocitava");
		}
		
		isLoading = false;
		try {
			driver.findElement(By.xpath("//*[@data-qa-button-isloading='false']"));
		}catch(Exception e){
			isLoading = true;
		}
		if(!isLoading) {
			System.out.println("Stranica se ocitala");
		}else {
			System.out.println("Stranica se nije ocitala");
		}
		
		
		Thread.sleep(5000);
		driver.quit();
	}

}
