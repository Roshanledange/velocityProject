package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class CheckoutOverview extends TestBase {

	@FindBy(xpath="//span[@class=\"title\"]")private WebElement OverviewText;
	@FindBy(xpath="//div[@class=\"cart_quantity_label\"]")private WebElement QyntText;
	@FindBy(xpath="//div[@class=\"cart_desc_label\"]")private WebElement DescriptionText;
	@FindBy(xpath="//button[@id=\"cancel\"]")private WebElement CancleButn;
	@FindBy(xpath="//button[@id=\"finish\"]")private WebElement FinishButn;
	
	public CheckoutOverview()
	{
		PageFactory.initElements(driver,this);
	}
	 
	public String verifyCheckoutOverviewText()
	{
		String value = OverviewText.getText();
		System.out.println(value);
		return value;
	}
	
	public String verifyQuntyText()
	{
		String value = QyntText.getText();
		System.out.println(value);
		return value;
	}
	
	public String verifyDescriptionText()
	{
		String value = DescriptionText.getText();
		System.out.println(value);
		return value;
	}
	
	public String verifyCancelButn()
	{ 
		String value = CancleButn.getText();
		CancleButn.click();
		System.out.println(value);
		return value;
	}
	
	public String verifyFinishButn()
	{
		String value = FinishButn.getText();
		FinishButn.click();
		System.out.println(value);
		return value;
	}


}
