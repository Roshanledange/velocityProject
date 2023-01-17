package TestCases;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.internal.annotations.ITest;

import Base.TestBase;
import Page.LoginPage;
import Utility.ReadData;
import Utility.UtilityMethod;

public class LoginPageTest extends TestBase {

	LoginPage login;  //=new LoginPage();
	ReadData data;    //=new ReadData();
	
	@BeforeMethod(alwaysRun=true)
	public void setup() throws Exception
	{
		data=new ReadData();
	//	LoginPage login;
		initalization();
	}

	@Test(enabled=false,priority=2,groups= {"sanity","Regression"},invocationCount=3)
	public void verifyTitleTest()
	{
		login=new LoginPage();
	    String actTitle= login.verifyTitle();
		String expTitle="Swag Labs";
		Assert.assertEquals(actTitle, expTitle);
		System.out.println(login.verifyTitle());
		Reporter.log("LoginPage Title="+actTitle);
	}

	@Test(enabled=false,priority=1,groups= {"smoke","Regression"},invocationCount=2)
	public void verifyCurrentURLTest() 
	{
		login=new LoginPage();
		String actURL= login.VerifyCurrentURL();
		String expURL="https://www.saucedemo.com/";
		Assert.assertEquals(actURL, expURL);
		System.out.println(login.VerifyCurrentURL());
		Reporter.log("Loginpage Url="+actURL);
	}

	@Test(enabled=true,priority=4,groups= {"sanity","Regression"})
	public void verifyLoginLogoTest()
	{
	   login=new LoginPage();
	   boolean actLogoResult = login.verifyLoginLogo();	
	   Assert.assertEquals(actLogoResult, false);
	   Reporter.log("Status of LoginLogo="+actLogoResult);
	}

	@Test(enabled=true,dependsOnMethods="verifyLoginLogoTest",priority=3,groups= {"smoke","Regression"},timeOut=2000)
	public void verifyBotLogoTest()
	{
		login=new LoginPage();
		boolean actBotLogoResult = login.verifyBotLogo();
		Assert.assertEquals(actBotLogoResult, true);
		Reporter.log("Status of BotLogo="+actBotLogoResult);
	}

	@Test(enabled=false,priority=5,groups= {"sanity","Regression"},invocationCount=2)
	public void verifyLoginAppTest() throws Exception
	{
		login=new LoginPage();
		String actResult= login.verifyLoginApp();
		String expResult="https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(actResult, expResult);
		Reporter.log("LoginAppresult="+actResult);
	}

	@AfterMethod(alwaysRun=true)
	public void CloseBrowser(ITestResult a) throws Exception
	{
		if(ITestResult.FAILURE==a.getStatus())
		{
			UtilityMethod.captureScreenShoot(a.getName());
		}
		driver.close();
	}
	
}
