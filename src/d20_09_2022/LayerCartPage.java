package d20_09_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LayerCartPage {
//	continue shopping dugme
//	proced to checkout dugme
//	element koji vraca atrubute
//	 proizvoda (sa slike je to desno od devojke)
//	element koji cuva quantity
//	(takodje desno od devojke)
//	element koji cuva total price
//	metodu koja ceka da dijalog bude vidljiv
//	metodu koja ceka da dijalog bude nevidljiv
	private WebDriver driver;
	private WebDriverWait wait;
	
	public LayerCartPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public WebElement getContinueToShopingBtn () {
		return driver.findElement(By.className("continue"));
	}
	
	public WebElement getProcedToCheckoutBtn () {
		return driver.findElement(By.xpath("//*[@title='Proceed to checkout']"));
	}
	
	public WebElement getAttributesOfProduct () {
		return driver.findElement(By.id("layer_cart_product_attributes"));
	}
	
	public WebElement getQuantity() {
		return driver.findElement(By.id("layer_cart_product_quantity"));
	}
	
	public WebElement getTotalPrice() {
		return driver.findElement(By.id("layer_cart_product_price"));
	}
	
	public void waitForDialogVisibility () {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("layer_cart")));
	}
	
	public void waitForDialogInvisibility () {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("layer_cart")));
	}

}
