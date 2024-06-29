package Practice;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class lunchAppiumServer {
	@Test
	public void tc(XmlTest test) throws MalformedURLException

	{
		String udid=test.getParameter("udid");
		String devicename=test.getParameter("deviceName");
		File f= new File("C:\\Users\\adity\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		AppiumDriverLocalService as=new AppiumServiceBuilder().withAppiumJS(f).
				withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(300)).build();//withtimeout is optional
		
		as.start();

		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability("platformName", "Android");
		dc.setCapability("automationName", "uiAutomator2");
		dc.setCapability("deviceName",devicename);
		dc.setCapability("UDID", udid);
		dc.setCapability("noReset",true);
		dc.setCapability("autoGrantPermission",true);
		dc.setCapability("ignorHiddenApiPolicyError", true);
		URL u= new URL("http://localhost:4724");
		AndroidDriver driver= new AndroidDriver(u,dc);
		driver.activateApp("com.hm.goe");
		as.stop();
	}
}
