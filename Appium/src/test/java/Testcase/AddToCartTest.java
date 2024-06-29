package Testcase;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import BaseClass.BaseClass;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import objectRepo.AllProductpage;
import objectRepo.CartPage;
import objectRepo.HomePage;
import objectRepo.ProductPage;

public class AddToCartTest extends BaseClass {

	@Test
	public void tc() throws MalformedURLException, InterruptedException
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
		pp.addToCart();
		CartPage cp= new CartPage(driver);
		Thread.sleep(2000);
		cp.getCartIcon().click();
		//validation
		adu.waitForElement(driver,cp.getProductInCart());
		boolean sts=cp.getProductInCart().isDisplayed();
		Assert.assertTrue(sts);
		Reporter.log("Item added to bag, passed", true);
	}
}
