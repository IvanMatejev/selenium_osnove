package d20_09_2022;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class AutomationPracticeTests extends BasicTestHW20_09 {
	@Test(priority=10)
	public void addingProductsToCart() {
//		Test #1:  Adding product to the cart
//		Ucitati stranicu /index.php?id_product=1&controller=product
//		Odskrolati do buy box-a
//		Postavite kolicinu na 3
//		Izaberite velicinu L
//		Izaberite plavu boju
//		Kliknite na dugme add to cart
//		Cekajte da dijalog layer cart bude vidljiv
//		Verifikovati da je kolicina iz layer cart dijalog 3
//		Verifikovati da je velicina L
//		Verifikovati da je izabran proizvod sa plavom bojom
//		Verifikovati da je total price 3 puta veci od cene proizvoda
//		Kliknite na dugme continue shopping
//		cekajte da dijalog layer cart postane nevidljiv
//		Izaberite novi proizvod sa kolicinom 1, velicinom S i bojom Organe
//		Kliknite na dugme add to cart
//		Cekajte da dijalog bude vidljiv
//		kliknite na dugme proceed to checkout
//		Verifikujte da je naslov stranice Order - My Store
		driver.navigate().to(baseUrl + "/index.php?id_product=1&controller=product");
		
		buyBoxPage.scrollToPickAColorElement();
		
		buyBoxPage.getQuantityInput().clear();
		buyBoxPage.getQuantityInput().sendKeys("3");
		
		buyBoxPage.getSize("L");
		
		buyBoxPage.getPickColorElement("Blue").click();
		
		buyBoxPage.getAddToCartBtn().click();
		
		layerCartPage.waitForDialogVisibility();
		
		Assert.assertTrue(
				layerCartPage.getQuantity().getText().equals("3"),
				"ERROR: Quantity should be 3");	
		
		Assert.assertTrue(
				layerCartPage.getAttributesOfProduct().getText().equals("Blue, L"),
				"ERROR: Attributes should be Blue, L");
		
		String totalPriceText = layerCartPage.getTotalPrice().getText().replaceAll("[$]", "");
		double totalPrice = Double.parseDouble(totalPriceText);
		String productPriceText = buyBoxPage.getProductPrice().getText().replaceAll("[$]", "");
		double productPrice = Double.parseDouble(productPriceText);
		
		Assert.assertTrue(
				productPrice * 3 == totalPrice,
				"ERROR: Wrong total price");
		
		layerCartPage.getContinueToShopingBtn().click();
		
		layerCartPage.waitForDialogInvisibility();
		
		buyBoxPage.scrollToPickAColorElement();
		
		buyBoxPage.getQuantityInput().clear();
		buyBoxPage.getQuantityInput().sendKeys("1");
		
		buyBoxPage.getSize("S");
		
		buyBoxPage.getPickColorElement("Orange").click();
		
		buyBoxPage.getAddToCartBtn().click();
		
		layerCartPage.waitForDialogVisibility();
		
		layerCartPage.getProcedToCheckoutBtn().click();
		
		Assert.assertTrue(
				driver.getTitle().equals("Order - My Store"),
				"ERROR: You are on wrong page");
	}
	
	@Test(priority=20)
	public void topMenuMouseOver() throws InterruptedException{
//		Test #2:  Top menu mouse over
//		Predjite misem preko women linka. Koristan link kako da predjete misem preko nekog elementa link
//		Verifikujte da je podmeni za women deo vidljiv
//		Predjite misem preko dresses linka. 
//		Verifikujte da je podmeni za dresses deo vidljiv
//		Predjite misem preko t-shirts linka. 
//		Verifikujte podmeniji za womens i dresses nevidljivi
//		Ukoliko je potrebno ukljucite odgovarajuca cekanja, kojim bi se sacekalo da stranica dodje u odgovarajuce stanje
//		Provera preko za vidljivost preko soft assert-a
//		new Actions(driver).moveToElement(topMenuPage.getWomenLink()).perform();
		actions.moveToElement(topMenuPage.getWomenLink()).perform();
		wait.until(ExpectedConditions.visibilityOf(topMenuPage.getWomenDropdown()));
		softAssert.assertTrue(
				topMenuPage.getWomenDropdown().isDisplayed(),
				"ERROR: Women submenu should be displayed");
		
		actions.moveToElement(topMenuPage.getDressesLink()).perform();
		wait.until(ExpectedConditions.visibilityOf(topMenuPage.getDressesDropdown()));
		softAssert.assertTrue(
				topMenuPage.getDressesDropdown().isDisplayed(),
				"ERROR: Dresses submenu should be displayed");
		
		actions.moveToElement(topMenuPage.getTshirtsLink()).perform();
		wait.until(ExpectedConditions.invisibilityOf(topMenuPage.getWomenDropdown()));
		wait.until(ExpectedConditions.invisibilityOf(topMenuPage.getDressesDropdown()));
		softAssert.assertFalse(
				topMenuPage.getDressesDropdown().isDisplayed() && topMenuPage.getWomenDropdown().isDisplayed(),
				"ERROR: Dresses and women submenus should not be displayed");
		
		softAssert.assertAll();
	}
	
	@Test(priority=30)
	public void phoneNumberVisibilityCheckOnResize() {
//		Test #3:  Phone number visibility check on resize
//		Maksimizujte prozor
//		Proverite da je element za broj telefona vidljiv
//		Smanjite dimenziju pretrazivaca na velicinu 767 x 700
//		Proverite element za broj telefona nije vidljiv
//		Promenite dimenziju pretrazivaca na 768 x 700
//		Proverite da je broj telefona vidljiv
//		Maksimizujte prozor
//		Provera preko soft asserta
		wait.until(ExpectedConditions.visibilityOf(headerPage.getShopPhone()));
		softAssert.assertTrue(
				headerPage.getShopPhone().isDisplayed(),
				"ERROR: Shopphone should be visible.");
		
		driver.manage().window().setSize(new Dimension(767, 700));
		wait.until(ExpectedConditions.invisibilityOf(headerPage.getShopPhone()));
		softAssert.assertFalse(
				headerPage.getShopPhone().isDisplayed(),
				"ERROR: Shopphone should not be visible.");
		
		driver.manage().window().setSize(new Dimension(800, 700));
		wait.until(ExpectedConditions.visibilityOf(headerPage.getShopPhone()));
		softAssert.assertTrue(
				headerPage.getShopPhone().isDisplayed(),
				"ERROR: Shopphone should be visible.");
		
		driver.manage().window().maximize();
		
		softAssert.assertAll();
	}
	
	@Test(priority=40)
	public void headerLinksCheck() {
//		Test #4:  Header links check
//		Kliknite na contact us link
//		Verifikujte da je naslov stranice Contact us - My Store
//		Kliknite na sign in link
//		Verifikujte da je naslov stranice Login - My Store
//		Provera preko soft asserta
		headerPage.getContactLink().click();
		softAssert.assertTrue(
				driver.getTitle().equals("Contact us - My Store"),
				"ERROR: Title should be Contact us - My Store");
		
		headerPage.getSignInLink().click();
		softAssert.assertTrue(
				driver.getTitle().equals("Login - My Store"),
				"ERROR: Title should be Login - My Store");
		
		softAssert.assertAll();

	}
}
