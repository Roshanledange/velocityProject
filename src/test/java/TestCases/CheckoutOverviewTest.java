package TestCases;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.TestBase;
import Page.CartPage;
import Page.CheckoutInformationPage;
import Page.CheckoutOverview;
import Page.InventaryPage;
import Page.LoginPage;
import Utility.UtilityMethod;

public class CheckoutOverviewTest extends TestBase{

	LoginPage login;  //=new LoginPage();
	InventaryPage inv;  //=new InventaryPage();
	CartPage car;  //=new CartPage();
	CheckoutInformationPage che;  //=new CheckoutInformationPage();
	CheckoutOverview ove;  //=new CheckoutOverview();
	
	@BeforeMethod(alwaysRun=true)
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
	}
	
	@Test(enabled=false)
	public void verifyCheckoutOverviewTextTest()
	{
		ove=new CheckoutOverview();
		String actText=ove.verifyCheckoutOverviewText();
		String expText="CHECKOUT: OVERVIEW";
	    Assert.assertEquals(actText, expText);
	}
	
	@Test(enabled=true,groups="suit")
	public void verifyQuntyTextTest()
	{
		ove=new CheckoutOverview();
		String actText=ove.verifyQuntyText();
		String ExpText="QTY";
		Assert.assertEquals(actText, ExpText);
	}
	
	@Test(enabled=true,groups="suit")
	public void verifyDescriptionTextTest()
	{
		ove=new CheckoutOverview();
		String actText=ove.verifyDescriptionText();
		String expText="DESCRIPTION";
		Assert.assertEquals(actText, expText);
	}
	
	@Test(enabled=true,groups="suit")
	public void verifyCancelButnTest()
	{
		ove=new CheckoutOverview();
		String actText=ove.verifyCancelButn();
		String ExpText="CANCEL";
		Assert.assertEquals(actText, ExpText);
	}
	
	@Test(enabled=true,groups="suit")
	public void verifyFinishButnTest()
	{
		ove=new CheckoutOverview();
		String actText=ove.verifyFinishButn();
		String expText="FINISH";
		Assert.assertEquals(actText, expText);
	}
	
	@AfterMethod(alwaysRun=true)
	public void closeBrowser(ITestResult c) throws Exception
	{
		if(ITestResult.FAILURE==c.getStatus())
		{
			UtilityMethod.captureScreenShoot(c.getName());
		}
		driver.close();
	}

}
