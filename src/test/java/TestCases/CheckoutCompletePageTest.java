package TestCases;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Page.CartPage;
import Page.CheckoutCompletePage;
import Page.CheckoutInformationPage;
import Page.CheckoutOverview;
import Page.InventaryPage;
import Page.LoginPage;
import Utility.UtilityMethod;

public class CheckoutCompletePageTest extends TestBase {

	LoginPage login;  //=new LoginPage();
	InventaryPage inv;  //=new InventaryPage();
	CartPage car;  //=new CartPage();
	CheckoutInformationPage che;  //=new CheckoutInformationPage();
	CheckoutOverview ove;  //=new CheckoutOverview();
	CheckoutCompletePage com;  //=new CheckoutCompletePage();
	
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
		che=new CheckoutInformationPage();
		che.verifyCheckoutLogin();
		ove=new CheckoutOverview();
		ove.verifyFinishButn();	
	}
	
	@Test(enabled=true)
	public void verifyCheckoutCompleteTextTest()
	{
		com=new CheckoutCompletePage();
		String actText=com.verifyCheckoutCompleteText();
		String expText="CHECKOUT: COMPLETE!";
		Assert.assertEquals(actText, expText);
	}
	
	@Test(enabled=true)
	public void verifyThankuTextTest()
	{
		com=new CheckoutCompletePage();
		String actText=com.verifyThankuText();
		String expText="THANK YOU FOR YOUR ORDER";
		Assert.assertEquals(actText, expText);
	}
	
	@Test(enabled=true)
	public void verifyBackButtonTextTest()
	{
		com=new CheckoutCompletePage();
		String actText=com.verifyBackButtonText();
		String expText="BACK HOME";
		Assert.assertEquals(actText, expText);
	}
	
	@Test(enabled=true)
	public void verifyImgTest()
	{
		com=new CheckoutCompletePage();
		boolean actText = com.verifyImg();
		Assert.assertEquals(actText, true);
	}
	
	@AfterMethod
	public void CloseBrowser(ITestResult e) throws Exception
	{
		if(ITestResult.FAILURE==e.getStatus())
		{
			UtilityMethod.captureScreenShoot(e.getName());
		}
		driver.close();
	}

}
