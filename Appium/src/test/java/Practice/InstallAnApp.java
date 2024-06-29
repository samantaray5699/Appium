package Practice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class InstallAnApp {

	@Test
	public void test() throws MalformedURLException
	{
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability("platformName", "Android");
		dc.setCapability("automationName", "uiAutomator2");
		dc.setCapability("deviceName","iQOO Z5");
		dc.setCapability("UDID", "1367872601000BB");
		dc.setCapability("noReset",true);
		dc.setCapability("autoGrantPermission",true);
		dc.setCapability("ignorHiddenApiPolicyError", true);

		dc.setCapability("app","C:\\Users\\adity\\OneDrive\\Desktop\\TekPyramid\\appium\\ApiDemos-debug.apk");
		URL u= new URL("http://localhost:4723");
		AndroidDriver driver= new AndroidDriver(u,dc);
		driver.findElement(AppiumBy.accessibilityId("Access'ibility")).click();

		

	}
}
