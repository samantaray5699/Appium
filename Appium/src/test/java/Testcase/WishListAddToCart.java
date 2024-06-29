package Testcase;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import objectRepo.AllProductpage;
import objectRepo.CartPage;
import objectRepo.FavouritesPage;
import objectRepo.HomePage;
import objectRepo.ProductPage;
public class WishListAddToCart extends BaseClass{

	@Test
	public void tc() throws InterruptedException
	{
		HomePage hp= new HomePage(driver);
		hp.countrySelection();
		hp.getSerchicon().click();
		hp.clickAtXY(driver, 1050, 900);
		//searching product
		hp.getSerchEdt().sendKeys("tshirt");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		AllProductpage alp= new AllProductpage(driver);
		Thread.sleep(2000);
		alp.getFirstproduct().click();
		ProductPage pp= new ProductPage(driver);
		pp.getProduct().click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		pp.addToFavGoToFavPage();
		FavouritesPage fp= new FavouritesPage(driver);
		adu.waitForElement(driver,fp.getProductInWishList());
		boolean sts=fp.getProductInWishList().isDisplayed();
		Assert.assertTrue(sts);
		Reporter.log("Item added to wishlist, passed", true);
		fp.addToCartFromFavourite();
		CartPage cp= new CartPage(driver);
		cp.getProductInCart();
		adu.waitForElement(driver,cp.getProductInCart());
		boolean sts1=cp.getProductInCart().isDisplayed();
		Assert.assertTrue(sts1);
		Reporter.log("Item added to bag from wishlist, passed", true);
		
		
	}
}
