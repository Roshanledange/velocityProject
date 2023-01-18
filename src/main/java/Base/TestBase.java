package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Utility.ReadData;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
//	ReadData data;
    public void initalization() throws Exception
{
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
//	data=new ReadData();
	driver.manage().deleteAllCookies();
	driver.get(ReadData.readPropertyFile("url"));
//	driver.get("https://www.saucedemo.com/");
    //i alreday push the code to git repo
}


}
