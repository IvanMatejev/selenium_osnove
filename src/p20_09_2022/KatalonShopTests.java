package p20_09_2022;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import katalon_pages.CartPages;
import katalon_pages.NavPage;
import katalon_pages.ProductPage;
import p20_09_2022_pages.BootstrapTablePage;
import p20_09_2022_pages.DeleteDialogPage;
import p20_09_2022_pages.EditDialogPage;

public class KatalonShopTests extends BasicTest {
//	Kreirati KatalonShopTests klasu:
//		baseUrl: https://cms.demo.katalon.com
//		Test #1:  Adding product with quantity to the cart
//		Prioritet = 10
//		Koraci:
//	Ucitati stranicu /product/flying-ninja/
//	Unesite kolicinu 3
//	Klik na Add to cart dugme
//	Verifikovati da poruka sadrzi tekst “Flying Ninja”.
//	Klik na Cart link iz navigacije
//	Verifikovati da u url-u stoji /cart ruta
//	Verifikovati da je broj proizvoda u korpi jednako 1
//
//		Test #2:  Removing product from cart
//		Prioritet = 20
//		Koraci:
//	Klik na Cart link iz navigacije
//	Verifikovati da u url-u stoji /cart ruta
//	Verifikovati da je broj proizvoda u korpi jednako 1
//	Klik na remove dugme iz prvog reda
//	Verifikovati da je broj proizvoda u korpi jedako 0
	
	@Test(priority=10)
	public void addingProducts() {
		driver.get(baseUrl + "/product/flying-ninja/");
		
		productPage.quantity().clear();
		productPage.quantity().sendKeys("3");
		productPage.cartBtn().click();
		
		Assert.assertTrue(
				productPage.msg().getText().contains("been added to your cart"),
				"Wrong msg");
				
		
		navPage.getCart().click();
		
		Assert.assertTrue(
				driver.getCurrentUrl().contains("/cart"),
				"Error: url should contain /cart");

		Assert.assertEquals(
				cartPage.getRows().size(),
				1,
				"Should be 1 row");
	}
	
	@Test(priority=20)
	public void deleteRowTest() throws InterruptedException {
//				Koraci:
//			Klik na Cart link iz navigacije
//			Verifikovati da u url-u stoji /cart ruta
//			Verifikovati da je broj proizvoda u korpi jednako 1
//			Klik na remove dugme iz prvog reda
//			Verifikovati da je broj proizvoda u korpi jedako 0
		navPage.getCart().click();
		
		Assert.assertTrue(
				driver.getCurrentUrl().contains("/cart"),
				"Error: url should contain /cart");
		
		Assert.assertTrue(
				cartPage.getRows().size() == 1,
				"Greska: Vise od jednog proizvod");
		
		cartPage.getDelete(0).click();
		cartPage.waitForNumberOfElementsToBe(0);
		Assert.assertTrue(
				cartPage.getRows().size() == 0,
				"Greska: Proizvoda ima vise od 0");	
	}
	
	@Test(priority=30)
	public void verifyErrorIsDisplayesWhenUsernameIsMissing() throws InterruptedException {
//		Test #3:  Verify error is displayed when username is missing
//		Prioritet = 30
//		Koraci:
//	Kliknite na my account link
//	Klik na login dugme
//	Verifikovati da je prikazana poruka Error: Username is required.
		navPage.getMyAccount().click();
		
		loginPage.getloginBtn().click();
		
		loginPage.waitForErrorMsg();
		
		Assert.assertEquals(
				loginPage.getErrorMsg().getText(),
				"Error: Username is required.",
				"Error: message is wrong");	
	}
	
	@Test(priority=40)
	public void verifyErrorIsDisplayedWhenPasswordIsMissing() {
//		Test #4:  Verify error is displayed when password is missing
//		Prioritet = 40
//		Koraci:
//	Kliknite na my account link
//	Unesite username customer
//	Klik na login dugme
//	Verifikovati da je prikazana poruka ERROR: The password field is empty.
		navPage.getMyAccount().click();
		
		loginPage.getUserNameInput().sendKeys("customer");
		loginPage.getloginBtn().click();
		loginPage.waitForErrorMsg();
		
		Assert.assertEquals(
				loginPage.getErrorMsg().getText(),
				"ERROR: The password field is empty.",
				"Error: message is wrong");	
	}
	
	@Test(priority=50)
	public void verifyErrorIsDisplayedWhenPassworIsWrong() {
//		Test #5:  Verify error is displayed when password is wrong
//		Prioritet = 50
//		Koraci:
//	Kliknite na my account link
//	Unesite username customer
//	Unesite nevalidan pass invalidpassword
//	Klik na login dugme
//	Verifikovati da je prikazana poruka ERROR: The password you entered for the username customer is incorrect. Lost your password?
		navPage.getMyAccount().click();
		
		loginPage.getUserNameInput().sendKeys("customer");
		loginPage.getPasswordInput().sendKeys("invalidpassword");
		loginPage.getloginBtn().click();
		loginPage.waitForErrorMsg();
		
		Assert.assertEquals(
				loginPage.getErrorMsg().getText(),
				"ERROR: The password you entered for the username customer is incorrect. Lost your password?",
				"Error: message is wrong");		
	}
	
	@Test(priority=60)
	public void verifyErrorIsDisplatedWhenUserDoesNotExist() {
//		Test #6:  Verify error is displayed when user does not exist
//		Prioritet = 60
//		Koraci:
//	Kliknite na my account link
//	Unesite username invaliduser
//	Unesite nevalidan pass (ex: pass1234)
//	Klik na login dugme
//	Verifikovati da je prikazana poruka ERROR: Invalid username. Lost your password?
		navPage.getMyAccount().click();
		
		loginPage.getUserNameInput().sendKeys("invaliduser");
		loginPage.getPasswordInput().sendKeys("pass1234");
		loginPage.getloginBtn().click();
		loginPage.waitForErrorMsg();
		
		Assert.assertEquals(
				loginPage.getErrorMsg().getText(),
				"ERROR: Invalid username. Lost your password?",
				"Error: message is wrong");
	}
	
	@Test(priority=70)
	public void verifySuccessfulLogin() {
//		Test #7:  Verify successful login
//		Prioritet = 70
//		Koraci:
//	Kliknite na my account link
//	Unesite username customer
//	Unesite validan pass crz7mrb.KNG3yxv1fbn
//	Klik na login dugme
//	Verifikovati na stranici pise Hello Katalon Parlitul_Changed
//		Dopunite pageve za sve sto je potrebno za ove testove, ako je potrebno kreirajte i nove pageve
		navPage.getMyAccount().click();
		
		loginPage.getUserNameInput().sendKeys("customer");
		loginPage.getPasswordInput().sendKeys("crz7mrb.KNG3yxv1fbn");
		loginPage.getloginBtn().click();
		loginPage.wairForSuccessfulLoginMsg();
		
		Assert.assertTrue(
				loginPage.getSuccessfulLoginMsg().getText().equals("Katalon Parlitul_Changed"),
				"Error: message is wrong");
		
	}

}
