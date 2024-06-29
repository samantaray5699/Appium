package Practice;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.checkerframework.common.value.qual.StaticallyExecutable;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import AndroidDriverutiliy.GestureUtility;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class BrowserStack_hybrid {

	public static final String userName="adityasamantaray_iO8j1A";
	public static final String accessKey="CCVb3mVT27YAuqGPRCsw";
	public static final String url="https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub";
		
	@Test
	public void tc() throws MalformedURLException
	{
		
		// Use Java Client v6.0.0 or above
		DesiredCapabilities capabilities = new DesiredCapabilities();
		HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
		browserstackOptions.put("projectName", "tekpyramid");
		browserstackOptions.put("buildName", "1.2");
		capabilities.setCapability("platformName", "android");
		capabilities.setCapability("platformVersion", "12.0");
		capabilities.setCapability("deviceName", "Samsung Galaxy S22 Ultra");
		capabilities.setCapability("app", "bs://dbc25d172d3979f2f782323db12961c7237cae2b");
		capabilities.setCapability("bstack:options", browserstackOptions);
		
		URL u= new URL(url);
		AndroidDriver driver= new AndroidDriver(u,capabilities); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.activateApp("com.androidsample.generalstore");
		
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("aditya");   
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		WebDriverWait waitForToast = new WebDriverWait(driver, Duration.ofSeconds(10));
		waitForToast.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));
		String toastMessage = driver.findElement((AppiumBy.xpath("/hierarchy/android.widget.Toast"))).getText();

		System.out.println(toastMessage);
		//driver.terminateApp("com.androidsample.generalstore");
		driver.quit();//we have to give to avoid timeout in browserstack 

	}
}
