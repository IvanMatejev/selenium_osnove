package katalon_pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPages {
//	Kreirati CartPage
//	hvata delete dugme za red po indeksu
//	input za kupon
//	dugme apply coupon
//	update cart dugme
//	hvata sve redove tabele
	private WebDriver driver;
	private WebDriverWait wait; 
	
	public CartPages(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public WebElement getDelete(int indeks) {
		return driver.findElements(By.className("remove")).get(indeks);
		
	}
	
	public WebElement getKuponInput() {
		return driver.findElement(By.id("coupon_code"));
	}
	
	public WebElement getApplyCoupon() {
		return driver.findElement(By.name("apply_coupon"));
		
	}
	
	public WebElement getUpdateCartBtn() {
		return driver.findElement(By.name("update_cart"));
	}
	
	public List<WebElement> getRows(){
		return driver.findElements(By.className("cart_item"));
	}
	
	public void waitForNumberOfElementsToBe( int productNum) {
//		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfElementsToBe(
				By.className("cart_item"),
				productNum));
	}

}
