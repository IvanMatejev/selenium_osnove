package d15_09_2022;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		1.Zad
//		Napisati program koji:
//		Ucitava stranicu https://s.bootsnipp.com/iframe/Dq2X
//		Klikce na svaki iks da ugasi obavestenje i proverava da li se nakon klika element obrisao 
//		sa stranice i ispisuje odgovarajuce poruke (OVO JE POTREBNO RESITI PETLJOM)
//		POMOC: Brisite elemente odozdo.
//		(ZA VEZBANJE)Probajte da resite da se elemementi brisu i odozgo
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		driver.get("https://s.bootsnipp.com/iframe/Dq2X");
		List<WebElement> elements = driver.findElements(By.className("alert"));

		
		for( int i = elements.size()-1; i >= 0; i-- ) {
			elements.get(i).findElement(By.className("close")).click();
			boolean exist = true;
			try {
				driver.findElements(By.className("alert")).get(i);
			}catch(Exception e){
				exist = false;
			}
			if(exist) {
				System.out.println("Tu sam");
			}else {
				System.out.println("Element ne postoji");
			}
			
		}
		
		
		Thread.sleep(5000);
		driver.quit();


	}

}
