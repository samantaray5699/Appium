package Testcase;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import BaseClass.BaseClass;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import objectRepo.AllProductpage;
import objectRepo.CartPage;
import objectRepo.CatagoryMenPage;
import objectRepo.HomePage;
import objectRepo.OptionPage;
import objectRepo.ProductPage;

public class CatagoryTest extends BaseClass {

	@Test
	public void tc() throws InterruptedException
	{
		HomePage hp= new HomePage(driver);
		hp.countrySelection();

		hp.getHamBergerIcon().click();
		OptionPage op= new OptionPage(driver);
		op.getMenLink().click();
		CatagoryMenPage cmp= new CatagoryMenPage(driver);
		cmp.scrollAndClickViewAll();
		AllProductpage alp= new AllProductpage(driver);
		Thread.sleep(2000);
		alp.getFirstproduct().click();
		ProductPage pp= new ProductPage(driver);
		pp.getProduct().click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		pp.addToCart();
		CartPage cp= new CartPage(driver);
		Thread.sleep(2000);
		cp.getCartIcon().click();
		//validation
		adu.waitForElement(driver, cp.getProductInCart());
		boolean sts=cp.getProductInCart().isDisplayed();
		Assert.assertTrue(sts);
		Reporter.log("Item added to bag, passed", true);
	}

}
