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

public class CliclGesture {

@Test
public void tc() throws MalformedURLException
{
	DesiredCapabilities dc= new DesiredCapabilities();
	dc.setCapability("platformName", "Android");
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
	/*Java
	((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
	    "elementId", ((RemoteWebElement) element).getId()
	));*/
	WebElement ele = driver.findElement(AppiumBy.accessibilityId("Views"));
	String id = ((RemoteWebElement)ele).getId();
	

	JavascriptExecutor js= (JavascriptExecutor)driver;
	js.executeScript("mobile: clickGesture", ImmutableMap.of("elementId",id));//we can go with x y cordinates
	driver.terminateApp("io.appium.android.apis");
   

}
}
