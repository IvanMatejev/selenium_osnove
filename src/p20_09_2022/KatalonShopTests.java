package p20_09_2022;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

}
