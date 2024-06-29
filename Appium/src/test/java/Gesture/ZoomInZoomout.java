package Gesture;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class ZoomInZoomout {
	@Test
	public void tc() throws MalformedURLException
	{
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability("platformName", "android");
		dc.setCapability("automationName", "uiAutomator2");
		dc.setCapability("deviceName","iQOO Z5");
		dc.setCapability("UDID", "1367872601000BB");
		dc.setCapability("noReset",true);
		dc.setCapability("autoGrantPermission",true);
		dc.setCapability("ignorHiddenApiPolicyError", true);
		dc.setCapability("appium:appPackage","com.davemorrissey.labs.subscaleview.sample");
		dc.setCapability("appium:appActivity","MainActivity");
		URL u= new URL("http://localhost:4723");
		AndroidDriver driver= new AndroidDriver(u,dc);
		driver.findElement(AppiumBy.id("com.davemorrissey.labs.subscaleview.sample:id/basicFeatures")).click();
        //img
		WebElement ele = driver.findElement(AppiumBy.id("com.davemorrissey.labs.subscaleview.sample:id/imageView"));
		String id=((RemoteWebElement)ele).getId();
		JavascriptExecutor js= (JavascriptExecutor)driver;
		//ZoomIn
		js.executeScript("mobile: pinchOpenGesture",ImmutableMap.of("elementId",id,"percent",1.0 ));//Percent must be between 0.0f and 1.0f
		//ZoomOut
		js.executeScript("mobile: pinchCloseGesture",ImmutableMap.of("elementId",id,"percent",0.5));
	}
}
