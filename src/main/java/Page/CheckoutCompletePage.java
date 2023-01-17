package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class CheckoutCompletePage extends TestBase{

	@FindBy(xpath="//span[@class=\"title\"]")private WebElement CheckoutCompEle;
	@FindBy(xpath="//h2[@class=\"complete-header\"]")private WebElement ThankuStatus;
	@FindBy(xpath="//button[@id=\"back-to-products\"]")private WebElement BackButn;
	@FindBy(xpath="//img[@class=\"pony_express\"]")private WebElement ImgElement;

	public CheckoutCompletePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyCheckoutCompleteText()
	{
		String value = CheckoutCompEle.getText();
		System.out.println(value);
		return value;
	}
	
	public String verifyThankuText()
	{
		String value = ThankuStatus.getText();
		System.out.println(value);
		return value;
	}
	
	public String verifyBackButtonText()
	{
		String value = BackButn.getText();
		System.out.println(value);
		BackButn.click();
		return value;
	}
	
	public boolean verifyImg()
	{
		return ImgElement.isDisplayed();	
	}

}
