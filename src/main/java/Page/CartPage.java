package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class CartPage extends TestBase {

	@FindBy(xpath="//span[@class=\"title\"]")private WebElement YourCart;
	@FindBy(xpath="//div[@class=\"cart_quantity_label\"]")private WebElement Qynt;
	@FindBy(xpath="//div[@class=\"cart_desc_label\"]")private WebElement Description;
	@FindBy(xpath="//button[@class=\"btn btn_action btn_medium checkout_button\"]")private WebElement CheckOut;
	@FindBy(xpath="//img[@class=\"footer_robot\"]")private WebElement ImgBoot;
	
	public CartPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public String verifyYourCartText()
	{
		String value = YourCart.getText();
		System.out.println(value);
		return value;
	}
	
	public String verifyQuantityText()
	{
		String value = Qynt.getText();
		System.out.println(value);
		return value;
	}
	
	public String verifyDescriptionText()
	{
		String value = Description.getText();
		System.out.println(value);
		return value;
	}
	public String verifyCheckOutButton() throws Exception
	{
		CheckOut.click();
		Thread.sleep(3000);
		return driver.getCurrentUrl();
	}
	
	public boolean verifyImgBoot()
	{
		 return ImgBoot.isDisplayed();
	}

}
