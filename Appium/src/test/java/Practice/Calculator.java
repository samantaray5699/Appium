package Practice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Calculator {

	@Test
	public void calculator() throws MalformedURLException
	{
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability("platformName", "Android");
		dc.setCapability("automationName", "uiAutomator2");
		dc.setCapability("deviceName","iQOO Z5");//optional
		dc.setCapability("UDID", "1367872601000BB");//not mandatory , but when we are using multiple device that time mandatory
		dc.setCapability("noReset",true);
		dc.setCapability("autoGrantPermission",true);
		dc.setCapability("ignorHiddenApiPolicyError", true);
		dc.setCapability("appPackage", "com.vivo.calculator");//give the packege for specific app
		dc.setCapability("appActivity", "Calculator");//give the activity for specific app
		
		URL u= new URL("http://localhost:4723");
		AndroidDriver driver= new AndroidDriver(u,dc); 
		driver.findElement(AppiumBy.id("com.vivo.calculator:id/digit_7")).click();
		driver.findElement(AppiumBy.id("com.vivo.calculator:id/op_mul")).click();
		driver.findElement(AppiumBy.id("com.vivo.calculator:id/digit_9")).click();
		driver.findElement(AppiumBy.id("com.vivo.calculator:id/eq")).click();
		String result = driver.findElement(AppiumBy.id("com.vivo.calculator:id/formula")).getText();
		System.out.println(result);
		driver.terminateApp("com.vivo.calculator");
		
	}
	
}
