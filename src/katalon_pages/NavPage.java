package katalon_pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage {
//	Zadatak
//	Kreirati NavPage koja ima:
//	cart link 
//	checkout link 
//	my account link 
//	sample page link 
//	shop link 
	private WebDriver driver;
	private WebDriverWait wait; 

	public List<WebElement> getLinks(){
		return driver.findElements(By.xpath("//*[contains(@class, ' nav-menu')]//a"));
	}
	public NavPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public WebElement getCart () {
		return getLinks().get(0);
	}
	
	public WebElement getCheckout () {
		return getLinks().get(1);
	}
	
	public WebElement getMyAccount () {
		return getLinks().get(2);
	}
	
	public WebElement getSamplePage () {
		return getLinks().get(3);
	}
	
	public WebElement getShop () {
		return getLinks().get(4);
	}

}
