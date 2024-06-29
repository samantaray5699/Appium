package objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class FavouritesPage {

	AndroidDriver driver;
	public FavouritesPage(AndroidDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}               
	@FindBy(id="com.hm.goe:id/itemContainer")
	private WebElement ProductInWishList;
	@FindBy(id="com.hm.goe:id/selectSizeArrow")
	private WebElement selectSizeArrow;
	@FindAll({@FindBy(xpath  ="//android.widget.TextView[@text='XL']"),@FindBy(xpath  ="//android.widget.TextView[@text='M']"),@FindBy(xpath  ="//android.widget.TextView[@text='S']")})
	private WebElement size;
	@FindBy(id="com.hm.goe:id/moveToBag")
	private WebElement addBtn;
	@FindBy(xpath  ="//android.widget.TextView[@resource-id=\"com.hm.goe:id/hm_shoppingbag_count\"]")
	private WebElement cartIcon;

	public WebElement getProductInWishList() {
		return ProductInWishList;
	}
	
	//
	public void addToCartFromFavourite() throws InterruptedException
	{
		selectSizeArrow.click();
		size.click();
		addBtn.click();
		Thread.sleep(200);
		cartIcon.click();
	}

}
