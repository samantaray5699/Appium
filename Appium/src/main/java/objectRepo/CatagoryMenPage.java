package objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AndroidDriverutiliy.GestureUtility;
import io.appium.java_client.android.AndroidDriver;

public class CatagoryMenPage extends GestureUtility {

	AndroidDriver driver;
	public CatagoryMenPage(AndroidDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	//android.widget.ExpandableListView/android.view.ViewGroup[6]
	@FindBy(xpath  ="//android.widget.TextView[@resource-id='com.hm.goe:id/departmentChild' and @text='View All']")
	private WebElement viewAllLink;
	//
	public WebElement getViewAllLink() {
		return viewAllLink;
	}
	public void scrollAndClickViewAll()
	{
		scrollByText(driver, "View All");
		getViewAllLink().click();
	}
	
	
}
