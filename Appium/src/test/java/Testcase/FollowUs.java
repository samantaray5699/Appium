package Testcase;

import static org.testng.Assert.assertEquals;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import objectRepo.FollowUsPage;
import objectRepo.HomePage;
import objectRepo.OptionPage;

public class FollowUs extends BaseClass {

	@Test
	public void tc() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		hp.countrySelection();
		hp.getHamBergerIcon().click();
		OptionPage op = new OptionPage(driver);
		op.scrollAndClickOnFollowUs();
		FollowUsPage fup= new FollowUsPage(driver);
		fup.getPinterestLink().click();
		Thread.sleep(3000);
		adu.switchToContext(driver,"WEBVIEW_chrome");
		driver.findElement(By.xpath("//div[text()='Created']")).click();
		String acturl = driver.getCurrentUrl();
		assertEquals(acturl,"https://www.pinterest.com/hm/_created");
		Reporter.log("navigateed to correct page");
		
	}
}
