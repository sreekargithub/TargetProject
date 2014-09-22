package utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import tests.TestBase;


public class Helper extends TestBase {
	
	public void takescreenshot(String filename) throws IOException{
		File scrfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(scrfile, new File(System.getProperty("user.dir")+"\\src\\screenshots\\"+filename+".jpg"));
			//FileUtils.copyFile(scrfile, new File(config.getProperty("screenShotsPath")+"\\"+filename+".jpg"));
										}
	
	public void bMeth() {
		 if(config.getProperty("browserType").equalsIgnoreCase("Firefox")){
			  driver= new FirefoxDriver();
			  }
		  else if(config.getProperty("browserType").equalsIgnoreCase("Chrome")){
			  System.setProperty("webdriver.chrome.driver",dir1+"\\src\\Jars\\chromedriver.exe");
			  driver = new ChromeDriver();
		  }
		  else {
			  if(config.getProperty("browserType").equalsIgnoreCase("IE"))
			  System.setProperty("webdriver.ie.driver",dir1+"\\src\\Jars\\IEDriverServer.exe");
			  driver=new InternetExplorerDriver();
		    }	  
	  }
	 	
	public void sleep(int seconds){
		try {
			Thread.sleep(seconds*1000);
		}catch(Exception e) {
	
		}
	}
	
	public boolean waitforElement(int timeout, By by )
	{ 
		while(timeout>0)
		{
			sleep(1);
	
			List<WebElement> list= driver.findElements(by);
			if(list.size()!=0)
			{
				return true;			
				}
		timeout--;
		}
		System.out.println("Waiting timed out, Element not found"+ by.toString());
			return false;
		
	}
		

}
