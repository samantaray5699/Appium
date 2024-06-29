package Practice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class BrowserStack_window {
	public static final String userName="adityasamantaray_iO8j1A";
	public static final String accessKey="CCVb3mVT27YAuqGPRCsw";
	public static final String url="https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub";

	@Test
	public void tc() throws MalformedURLException
	{
//		ChromeOptions browseroptions = new ChromeOptions();
//		browseroptions.setPlatformName("Windows 11");
//		browseroptions.setBrowserVersion("latest");
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability("platformName", "Windows 11");
		dc.setCapability("browserVersion", "latest");
		HashMap<String, Object> Options = new HashMap();
		Options.put("build", "selenium-build-GME35"); 
		Options.put("name", "facebook");

		dc.setCapability("sauce:options", Options);

		RemoteWebDriver driver = new RemoteWebDriver(new URL(url), dc);

		driver.get("https://www.facebook.com/");

		System.out.println(driver.getTitle());
		driver.quit();
	}
}
