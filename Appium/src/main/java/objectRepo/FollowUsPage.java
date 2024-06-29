package objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class FollowUsPage {

	AndroidDriver driver;
	public FollowUsPage(AndroidDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//android.widget.TextView[@text='Pinterest']")
	private WebElement pinterestLink;
	//
	public WebElement getPinterestLink() {
		return pinterestLink;
	}
	
	
	
}
