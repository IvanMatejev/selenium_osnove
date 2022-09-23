package d20_09_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopMenuPage {
//	metodu koja vraca WOMEN link iz glavnom menija
//	metodu koja vraca DRESSES link iz glavnom menija
//	metodu koja vraca T-SHIRTS link iz glavnom menija
//	metodu koja vraca podmeni za WOMEN
//	metodu koja vraca podmeni za DRESSES
	private WebDriver driver;
	private WebDriverWait wait;
	
	public TopMenuPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public WebElement getWomenLink () {
		return driver.findElement(By.xpath("//ul[contains(@class, 'sf-menu')]/li[1]"));
	}
	
	public WebElement getDressesLink () {
		return driver.findElement(By.xpath("//ul[contains(@class, 'sf-menu')]/li[2]"));
	}

	public WebElement getTshirtsLink () {
		return driver.findElement(By.xpath("//ul[contains(@class, 'sf-menu')]/li[3]"));
	}
	
	public WebElement getWomenDropdown() {
		return driver.findElement(By.xpath("//ul[contains(@class, 'sf-menu')]/li[1]/ul"));
	}
	
	public WebElement getDressesDropdown() {
		return driver.findElement(By.xpath("//ul[contains(@class, 'sf-menu')]/li[2]/ul"));
	}


}
