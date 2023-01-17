package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.TestBase;
import Utility.UtilityMethod;

public class InventaryPage extends TestBase{

	@FindBy(xpath="//div[@class=\"peek\"]")private WebElement Peekimg;
	@FindBy(xpath="//span[@class=\"title\"]")private WebElement ProductStatus;
	@FindBy(xpath="//select[@class=\"product_sort_container\"]")private WebElement SelectList;
	@FindBy(xpath="//option[text()=\"Name (Z to A)\"]")private WebElement SelectListZtoA;
	@FindBy(xpath="(//button[text()=\"Add to cart\"])[1]")public WebElement addCart1;
	@FindBy(xpath="(//button[text()=\"Add to cart\"])[2]")private WebElement addCart2;
	@FindBy(xpath="//a[@href=\"https://twitter.com/saucelabs\"]")private WebElement TwitterElement;
	@FindBy(xpath="//a[@href=\"https://www.facebook.com/saucelabs\"]")private WebElement FacebookElement;
	@FindBy(xpath="//a[@href=\"https://www.linkedin.com/company/sauce-labs/\"]")private WebElement LinkedElement;
	@FindBy(xpath="//a[@class=\"shopping_cart_link\"]")private WebElement Cart;
	
public InventaryPage()
{
	PageFactory.initElements(driver,this);
}
public String verifyTitle()
{
	 return driver.getTitle();
}
public String verifyURL()
{
	 return driver.getCurrentUrl();
}
public boolean verifyPeekImg()
{
	return Peekimg.isDisplayed();
}
public String verifyProductText()
{
	return ProductStatus.getText();
}
public String verifySelectList() throws Exception 
{
//	Select s=new Select(SelectList);
//  s.selectByVisibleText("Name (Z to A)");
	UtilityMethod.selectClass(SelectList, "Name (Z to A)");
	Thread.sleep(2000);
    System.out.println(SelectListZtoA.getText());
    return SelectListZtoA.getText();
}
public void verifyAddCart() throws Exception
{
	addCart1.click();
	Thread.sleep(2000);
	addCart2.click();
}
public boolean verifyTwiterLogo()
{
	return TwitterElement.isDisplayed();
}
public boolean verifyFacebookLogo()
{
	return FacebookElement.isDisplayed();
}
public boolean verifyLinkedLogo()
{
	return LinkedElement.isDisplayed();
}
public String verifyCart() throws Exception
{
	addCart1.click();
	Thread.sleep(2000);
	Cart.click();
	String value = Cart.getText();
	System.out.println(value);
	return value;
}
public void verifyCartLogin()
{
	Cart.click();
}


}
