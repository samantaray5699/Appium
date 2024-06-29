package objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AndroidDriverutiliy.GestureUtility;
import io.appium.java_client.android.AndroidDriver;

public class OptionPage extends GestureUtility {

	AndroidDriver driver;
	public OptionPage(AndroidDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath  ="//android.widget.TextView[@text='Men']")
	private WebElement menLink;
	@FindBy(xpath  ="//android.widget.TextView[@text='Follow us']")
	private WebElement followusLink;
	//
	public WebElement getMenLink() {
		return menLink;
	}
	
	public void scrollAndClickOnFollowUs()
	{
		scrollByText(driver,"Follow us" );
		followusLink.click();
	}
	
}
