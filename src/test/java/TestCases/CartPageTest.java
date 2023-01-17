package TestCases;

import org.checkerframework.checker.units.qual.g;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Page.CartPage;
import Page.InventaryPage;
import Page.LoginPage;
import Utility.UtilityMethod;

public class CartPageTest extends TestBase {

	LoginPage login;  //=new LoginPage();
	InventaryPage inv;  //=new InventaryPage();
	CartPage car;  //=new CartPage();
	
	@BeforeMethod
	public void setup() throws Exception
	{
		initalization();
		login=new LoginPage();
		login.verifyLoginApp();
		inv=new InventaryPage();
		inv.verifyCartLogin();
	}
	
	@Test(enabled=true)
	public void verifyYourCartTextTest()
	{
		car=new CartPage();
		String actText=car.verifyYourCartText();
		String expText="YOUR CART";
		Assert.assertEquals(actText, expText);
	}
	
	@Test(enabled=true)
	public void verifyQuantityTextTest()
	{
		car=new CartPage();
		String actText=car.verifyQuantityText();
		String expText="QTY";
		Assert.assertEquals(actText, expText);
	}
	
	@Test(enabled=true)
	public void verifyDescriptionTextTest()
	{
		car=new CartPage();
		String actText=car.verifyDescriptionText();
		String expText="DESCRIPTION";
		Assert.assertEquals(actText, expText);
	}
	
	@Test(enabled=true)
	public void verifyCheckOutButtonTest() throws Exception
	{
		car=new CartPage();
		String actLink=car.verifyCheckOutButton();
		String expLink="https://www.saucedemo.com/checkout-step-one.html";
		Assert.assertEquals(actLink, expLink);
	}
	
	@Test(enabled=true)
	public void verifyImgBootTest() 
	{
		car=new CartPage();
		boolean actImg = car.verifyImgBoot();
		Assert.assertEquals(actImg, true);
	}
	
	@AfterMethod
	public void CloseBrowser(ITestResult g) throws Exception
	{
		if(ITestResult.FAILURE==g.getStatus())
		{
			UtilityMethod.captureScreenShoot(g.getName());
		}
		driver.close();
	}


}
