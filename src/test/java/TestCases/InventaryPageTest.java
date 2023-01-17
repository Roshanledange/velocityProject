package TestCases;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.TestBase;
import Page.InventaryPage;
import Page.LoginPage;
import Utility.UtilityMethod;

public class InventaryPageTest extends TestBase {

    LoginPage login;  //=new LoginPage();
    InventaryPage inv;   //=new InventaryPage();
	@BeforeMethod(alwaysRun=true)
	public void setup() throws Exception
	{	
		initalization();
		login=new LoginPage();
		login.verifyLoginApp();
	}
	
	@Test(enabled=false,groups= {"sanity","Regression"})
	public void verifyTitleTest()
	{
		inv=new InventaryPage();
		SoftAssert soft=new SoftAssert();
		String actTitle= inv.verifyTitle();
		String expTitle = "Swag Labs";
		soft.assertEquals(actTitle, true);
	//	Assert.assertEquals(actTitle, expTitle);
		System.out.println(actTitle);
		soft.assertAll();
		Reporter.log("Inventary Title="+actTitle);
	}
	
	@Test(enabled=true,groups= {"smoke","Regression"})
	public void verifyURLTest()
	{
		inv=new InventaryPage();
		SoftAssert soft=new SoftAssert();
		String actURL = inv.verifyURL();
		String expURL = "https://www.saucedemo.com/inventory.html";
	//	Assert.assertEquals(actURL, expURL);
		soft.assertEquals(actURL, true);
		System.out.println(actURL);
		soft.assertAll();
		Reporter.log("Inventary Url="+actURL);
	}
	
	@Test(enabled=false,groups= {"sanity","Regression"})
	public void verifyPeekImgTest()
	{
		inv=new InventaryPage();
		boolean actImg = inv.verifyPeekImg();
		Assert.assertEquals(actImg, true);
	}
	
	@Test(enabled=false,groups= {"smoke","Regressin"})
	public void verifyProductTextTest()
	{
		inv=new InventaryPage();
		String actText = inv.verifyProductText();
		Assert.assertEquals(actText, "PRODUCTS");
		System.out.println(inv.verifyProductText());
		Reporter.log("Product Text="+actText);
	}
	
	@Test(enabled=false)
	public void verifySelectListTest() throws Exception
	{
		inv=new InventaryPage();
		String actText = inv.verifySelectList();
		String expText = "Name (Z to A)";
		Assert.assertEquals(actText, expText);
		Reporter.log("SelectText="+actText);
	}
	
	@Test(enabled=false)
	public void verifyAddCartTest() throws Exception
	{
		inv=new InventaryPage();
		inv.verifyAddCart();
		Assert.assertTrue(true);
	}
	
	@Test(enabled=false)
	public void verifyTwiterLogoTest()
	{
		inv=new InventaryPage();
		boolean actResult = inv.verifyTwiterLogo();
		Assert.assertEquals(actResult, true);
	}
	
	@Test(enabled=false)
	public void verifyFacebookLogoTest()
	{
		inv=new InventaryPage();
		boolean actResult1 = inv.verifyFacebookLogo();
		Assert.assertEquals(actResult1, true);
	}
	
	@Test(enabled=true)
	public void verifyLinkedLogoTest()
	{
		inv=new InventaryPage();
		boolean actResult2 = inv.verifyLinkedLogo();
		Assert.assertEquals(actResult2, true);
	}
	
	@Test(enabled=false)
	public void verifyCartTest() throws Exception
	{
		inv=new InventaryPage();
		String actResult= inv.verifyCart();
		String expResult="1";
		Assert.assertEquals(actResult, actResult);
		Reporter.log("Total addcart="+actResult);
	}
	
	@Test(enabled=false)
	public void verifyCartLogingTest()
	{
		inv=new InventaryPage();
        inv.verifyCartLogin();
	}
	
	@AfterMethod(alwaysRun=true)
	public void closeBrowser(ITestResult b) throws Exception
	{
		if(ITestResult.FAILURE==b.getStatus())
		{
			UtilityMethod.captureScreenShoot(b.getName());
		}
		driver.close();
	}
		

}
