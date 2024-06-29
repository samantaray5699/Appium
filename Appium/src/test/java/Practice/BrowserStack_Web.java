package Practice;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class BrowserStack_Web {


	public static final String userName="adityasamantaray_iO8j1A";
	public static final String accessKey="CCVb3mVT27YAuqGPRCsw";
	public static final String url="https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub";
		
	@Test
	public void tc() throws MalformedURLException
	{
		
		// Use Java Client v6.0.0 or above
		DesiredCapabilities capabilities = new DesiredCapabilities();
		HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
		browserstackOptions.put("browserName", "chrome");
		browserstackOptions.put("projectName", "pyramid");
		browserstackOptions.put("buildName", "1.2");
		browserstackOptions.put("deviceName", "Samsung Galaxy S22 Ultra");
		capabilities.setCapability("bstack:options", browserstackOptions);
		
		WebDriver driver= new RemoteWebDriver(new URL(url),capabilities); //remotewebdriver will acept parameeter
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.wikipedia.org/");
		driver.findElement(By.id("searchInput")).sendKeys("india"+Keys.ENTER);
		driver.quit();

	}
}
