package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class CheckoutInformationPage extends TestBase{

	@FindBy(xpath="//span[@class=\"title\"]")private WebElement CheckoutText;
	@FindBy(xpath="//input[@id=\"first-name\"]")private WebElement Firstname;
	@FindBy(xpath="//input[@id=\"last-name\"]")private WebElement Lastname;
	@FindBy(xpath="//input[@id=\"postal-code\"]")private WebElement Postalcode;
	@FindBy(xpath="//input[@id=\"continue\"]")private WebElement ContinueBtn;
	@FindBy(xpath="//button[@id=\"cancel\"]")private WebElement CancleBtn;

	public CheckoutInformationPage()
	{
		PageFactory.initElements(driver,this);
	}

	public String verifyURL()
	{
		 return driver.getCurrentUrl();
	}

	public String verifyCheckoutInformationText()
	{
		String value = CheckoutText.getText();
		System.out.println(value);
		return value;
	}
	public boolean verifyCancleButton()
	{
		boolean value = CancleBtn.isEnabled();
		CancleBtn.click();
		return value;
		
	}
	public String verifyCheckoutLogin()
	{
		Firstname.sendKeys("Roshan");
		Lastname.sendKeys("Ledange");
		Postalcode.sendKeys("445304");
		ContinueBtn.click();
		String value = driver.getCurrentUrl();
		System.out.println(value);
		return value;
	}

}
