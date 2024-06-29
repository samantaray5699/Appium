package DriverMethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Context {

	@Test
	public void tc() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability("platformName", "android");
		dc.setCapability("automationName", "uiAutomator2");
		dc.setCapability("deviceName","iQOO Z5");
		dc.setCapability("UDID", "1367872601000BB");
		dc.setCapability("noReset",true);
		dc.setCapability("autoGrantPermission",true);
		dc.setCapability("ignorHiddenApiPolicyError", true);
		URL u= new URL("http://localhost:4723");
		AndroidDriver driver= new AndroidDriver(u,dc);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.activateApp("com.androidsample.generalstore");
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("aditya");   
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Air Jordan 1 Mid SE']/..//android.widget.TextView[@text='ADD TO CART']")).click();
		
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(3000);
		Set<String> context = driver.getContextHandles();
		for(String co: context)
		{
			System.out.println(co);
			driver.context("WEBVIEW_com.androidsample.generalstore");
		}
		driver.findElement(By.name("q")).sendKeys("appium");
		//driver.findElement(AppiumBy.xpath("//android.widget.EditText")).sendKeys("appium");
		
		//driver.terminateApp("com.androidsample.generalstore");



		
		
	}
}
