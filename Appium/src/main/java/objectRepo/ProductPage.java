package objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AndroidDriverutiliy.GestureUtility;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class ProductPage extends GestureUtility{

	AndroidDriver driver;
	public ProductPage(AndroidDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(id ="com.hm.goe:id/carouselImage")
	private WebElement product;
	
	@FindBy(id ="com.hm.goe:id/carouselPhotoView")
	private WebElement productImage;
                       
	@FindAll({@FindBy(xpath  ="//android.widget.TextView[@text='XL']"),@FindBy(xpath  ="//android.widget.TextView[@text='M']"),@FindBy(xpath  ="//android.widget.TextView[@text='S']")})
	private WebElement size;
	@FindBy(xpath  ="//android.widget.Button")
	private WebElement addtocartBtn;
	@FindBy(id ="com.hm.goe:id/add_to_favourite_heart")
	private WebElement wishIcon;
	@FindBy(xpath  ="//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
	private WebElement backBtn;
	
	
	
	//
	public WebElement getProduct() {
		return product;
	}

	public WebElement getProductImage() {
		return productImage;
	}
	
	public WebElement getWishIcon() {
		return wishIcon;
	}
	

	public WebElement getBackBtn() {
		return backBtn;
	}

	//
	public void addToCart()
	{
		scrollByText(driver, "Size guide");
		size.click();
		addtocartBtn.click();
	}
	
	public void addToFavGoToFavPage()
	{
		wishIcon.click();
		backBtn.click();
		AllProductpage alp= new AllProductpage(driver);
		alp.getFavoritesIcon().click();
	}
	

	
	

}
