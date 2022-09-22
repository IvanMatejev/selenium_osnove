package d20_09_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderPage {
//	shop phone element - gde je prikazan broj telefona
//	contact us link
//	sign in link
	private WebDriver driver;
	private WebDriverWait wait;
	
	public HeaderPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public WebElement getShopPhone() {
		return driver.findElement(By.className("shop-phone"));
	}
	
	public WebElement getContactLink() {
		return driver.findElement(By.linkText("Contact us"));
	}
	
	public WebElement getSignInLink() {
		return driver.findElement(By.linkText("Sign in"));
	}
	
}
