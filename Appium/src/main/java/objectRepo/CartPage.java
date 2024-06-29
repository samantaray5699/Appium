package objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class CartPage {

	AndroidDriver driver;
	public CartPage(AndroidDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	                
	@FindBy(xpath  ="//android.widget.TextView[@resource-id=\"com.hm.goe:id/hm_shoppingbag_count\"]")
	private WebElement cartIcon;
	                  
	@FindBy(xpath  ="//androidx.compose.ui.platform.ComposeView[@resource-id=\"com.hm.goe:id/composeView\"]/android.view.View/android.view.View/android.view.View[2]/android.view.View")
	private WebElement productInCart;
	//
	public WebElement getCartIcon() {
		return cartIcon;
	}
	public WebElement getProductInCart() {
		return productInCart;
	}
	
}
