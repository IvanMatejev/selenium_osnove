package katalon_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
//	Kreirati ProductPage koja ima:
//		quantity
//		add to cart button
//		poruka o dodavanju proizvoda u korpu
	private WebDriver driver;
	private WebDriverWait wait; 
	
	public ProductPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public WebElement quantity() {
		return driver.findElement(By.name("quantity"));
	}
	
	public WebElement cartBtn() {
		return driver.findElement(By.name("add-to-cart"));
	}
	
	public WebElement msg() {
		return driver.findElement(By.className("woocommerce-message"));
	}
}
