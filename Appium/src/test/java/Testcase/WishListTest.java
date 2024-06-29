package Testcase;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import objectRepo.AllProductpage;
import objectRepo.FavouritesPage;
import objectRepo.HomePage;
import objectRepo.ProductPage;
public class WishListTest extends BaseClass {

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
		FavouritesPage wp= new FavouritesPage(driver);
		adu.waitForElement(driver,wp.getProductInWishList());
		boolean sts=wp.getProductInWishList().isDisplayed();
		Assert.assertTrue(sts);
		Reporter.log("Item added to wishlist, passed", true);
		
	}
}
