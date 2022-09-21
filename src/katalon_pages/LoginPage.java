package katalon_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public LoginPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	} 
	
	public WebElement getUserNameInput() {
		return driver.findElement(By.id("username"));
	}
	
	public WebElement getPasswordInput() {
		return driver.findElement(By.id("password"));
	}
	
	public WebElement getloginBtn() {
		return driver.findElement(By.xpath("//button[contains(@name, 'login')]"));
	}
	
	public WebElement getLostYourPassword() {
		return driver.findElement(By.xpath("//*[contains(@class, 'woocommerce-LostPassword')]/a"));
	}
	
	public WebElement getErrorMsg() {
		return driver.findElement(By.className("woocommerce-error"));
	}
	
	public WebElement getSuccessfulLoginMsg() {
		return driver.findElement(By.xpath("//*[text()='Katalon Parlitul_Changed'][1]"));
	}
	
	public void waitForErrorMsg() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("woocommerce-error")));
	}
	
	public void wairForSuccessfulLoginMsg() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Katalon Parlitul_Changed'][1]")));
	}
}
