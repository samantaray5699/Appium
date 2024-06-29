package DriverMethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class PressKey {

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
		driver.pressKey(new KeyEvent(AndroidKey.BRIGHTNESS_UP));
	   
	}
}
