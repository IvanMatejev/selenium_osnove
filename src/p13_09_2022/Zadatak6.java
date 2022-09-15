package p13_09_2022;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak6 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		6.Zadatak (Za vezbanje)
//		Napisti program koji:
//		Ucitava stranicu https://s.bootsnipp.com/iframe/z80en
//		Hvata sve elemente iz tabele i stampa tekst svakog elementa. Kako da od nekog elementa
//		procitamo tekst imate na sledecem linku 
//		Ceka 5s
//		Zatvara pretrazivac
//		Stampa treba da bude kao u primeru:
//		John	Doe	john@example.com
//		Mary	Moe	mary@example.com
//		July	Dooley	july@example.com
//
//		HINT: bice vam lakse da radite ulancano trazenje. findElement().findELement()...
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://s.bootsnipp.com/iframe/z80en");
		
		List<WebElement> lista = driver.findElements(By.xpath("//div[@id='lorem']//tbody"));
		
		for (int i = 0; i < lista.size(); i++) {
			System.out.print(lista.get(i).getText());
		}
		driver.quit();

	}

}
