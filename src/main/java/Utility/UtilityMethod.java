package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Base.TestBase;

public class UtilityMethod extends TestBase {

	public static void selectClass(WebElement ele,String option)
	{
		Select s=new Select(ele);
		s.selectByVisibleText(option);
	}
	public static void captureScreenShoot(String name) throws Exception 
	{
	  File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  File dest=new File("C:\\Users\\ACER\\eclipse-workspace\\VelocityProject\\ScreenShoot/"+name+".jpeg");
	  org.openqa.selenium.io.FileHandler.copy(source, dest);
	}
}
