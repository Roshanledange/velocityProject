package TestCases;

import javax.rmi.CORBA.Util;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Page.CartPage;
import Page.CheckoutInformationPage;
import Page.InventaryPage;
import Page.LoginPage;
import Utility.UtilityMethod;

public class CheckoutInformationPageTest extends TestBase {

	LoginPage login;  //=new LoginPage();
	InventaryPage inv;  //=new InventaryPage();
	CartPage car;  //=new CartPage();
	CheckoutInformationPage che;  //=new CheckoutInformationPage();
	
	@BeforeMethod
	public void setup() throws Exception
	{
		initalization();
		login=new LoginPage();
		login.verifyLoginApp();
		inv=new InventaryPage();
		inv.verifyCartLogin();
		car=new CartPage();
		car.verifyCheckOutButton();
	}
	
	@Test(enabled=false)
	public void verifyURLTest()
	{ 
		che=new CheckoutInformationPage();
		String actUrl=che.verifyURL();
		String expUrl="https://www.saucedemo.com/checkout-step-one.html";
		Assert.assertEquals(actUrl, expUrl);
	}
	
	@Test(enabled=false)
	public void verifyCheckoutInformationTextTest()
	{
		che=new CheckoutInformationPage();
		String actText=che.verifyCheckoutInformationText();
		String expText="CHECKOUT: YOUR INFORMATION";
		Assert.assertEquals(actText, expText);
	}
	
	@Test(enabled=true)
	public void verifyCancleButtonTest()
	{
		che=new CheckoutInformationPage();
		boolean actButn=che.verifyCancleButton();
		Assert.assertEquals(actButn,true);
	}
	
	@Test(enabled=true)
	public void  verifyCheckoutLoginTest()
	{
		che=new CheckoutInformationPage();
		String actNextLink=che.verifyCheckoutLogin();
		String expNextLink="https://www.saucedemo.com/checkout-step-two.html";
		Assert.assertEquals(actNextLink, expNextLink);
	}
	
	@AfterMethod
	public void CloseBrowser(ITestResult d) throws Exception
	{
		if(ITestResult.FAILURE==d.getStatus())
		{
			UtilityMethod.captureScreenShoot(d.getName());
		}
		driver.close();
	}

}
