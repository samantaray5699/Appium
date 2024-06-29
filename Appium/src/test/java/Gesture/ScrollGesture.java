package Gesture;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class ScrollGesture {

	
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
		dc.setCapability("appium:appPackage","io.appium.android.apis");
		dc.setCapability("appium:appActivity","ApiDemos");
		URL u= new URL("http://localhost:4723");
		AndroidDriver driver= new AndroidDriver(u,dc);
		driver.findElement(AppiumBy.accessibilityId("Views")).click();

		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Visibility\"));")).click();
	}
}
