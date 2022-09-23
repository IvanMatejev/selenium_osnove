package d20_09_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BuyBoxPage {
//	input za kolicinu
//	select za velicinu
//	add to cart dugme
//	add to wishlist dugme
//	metodu koja vraca element boje. 
//	Metoda kao parametar prima naziv boje 
//	(npr: “Orange”, “Blue”) a vraca link koji ima atribut title
//	prema trazenoj vrednosti.
//	metodu koja skrola do ovog dela stranice
	private WebDriver driver;
	private WebDriverWait wait;
	
	public BuyBoxPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public WebElement getQuantityInput() {
		return driver.findElement(By.id("quantity_wanted"));
	}
	
	public WebElement getAddToCartBtn() {
		return driver.findElement(By.name("Submit"));
	}
	
	public WebElement getAddToWishListBtn () {
		return driver.findElement(By.id("wishlist_button"));
	}
	
	public WebElement getPickColorElement( String color ) {
		return driver.findElement(By.id("color_to_pick_list")).findElement(By.xpath("//*[@title='"+color+"']"));
	}
	
	public void scrollToPickAColorElement () {
		Actions actions = new Actions(driver);
		actions.moveToElement(getAddToWishListBtn());
		actions.perform();
	}
	
	public void getSize (String size) {
		Select color = new Select(driver.findElement(By.id("group_1")));
		color.selectByVisibleText(size);
	}
	
	public WebElement getProductPrice() {
		return driver.findElement(By.id("our_price_display"));
	}
	
	

}
