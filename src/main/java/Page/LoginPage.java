package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import Utility.ReadData;

public class LoginPage extends TestBase {
	
	@FindBy(xpath="//div[@class='login_logo']")private WebElement LoginLogo;
	@FindBy(xpath="//div[@class='bot_column']")private WebElement BotLogo;
	@FindBy(xpath="//input[@id=\"user-name\"]")private WebElement Username;
	@FindBy(xpath="//input[@id='password']")private WebElement Passward;
	@FindBy(xpath="//input[@id='login-button']")private WebElement LoginButton;
	public LoginPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public String verifyTitle() 
	{
		 return driver.getTitle();	
	}
	
	public String VerifyCurrentURL()
	{
		return driver.getCurrentUrl();
	}
	
	public boolean verifyLoginLogo()
	{
		return LoginLogo.isDisplayed();
	}
	
	public boolean verifyBotLogo()
	{
		return BotLogo.isDisplayed();		
	}
	
	public String verifyLoginApp() throws Exception
	{	
	   
		Thread.sleep(2000);
	//	Username.sendKeys("performance_glitch_user");
	//	Username.sendKeys(ReadData.readPropertyFile("Username"));
		Username.sendKeys(ReadData.readExcelFile(0,0));
		Thread.sleep(2000);
	//	Passward.sendKeys("secret_sauce");
	//	Passward.sendKeys(ReadData.readPropertyFile("Password"));
		Passward.sendKeys(ReadData.readExcelFile(0,1));
		Thread.sleep(2000);
		LoginButton.click();
		return driver.getCurrentUrl();
		
	}
		
}



