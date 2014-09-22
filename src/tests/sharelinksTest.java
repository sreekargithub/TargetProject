package tests;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.Helper;

public class sharelinksTest extends Helper
{
	
    @Test
	  public void targetSharelinks() throws Exception {
		  driver.manage().window().maximize();
		  log.debug("Loading the url for Sharelinks testcase.....");
		  driver.get(config.getProperty("testUrl"));
		  Actions act = new Actions(driver);
		  		if(driver.findElements(By.linkText(OR.getProperty("leftpanel_linktext"))).size()==0)
		  		{
		  			Assert.fail("leftpanel link, electronics not found");
		  		}
		  log.debug("Mouse hover the electronics links in left panel.....");
		  act.moveToElement(driver.findElement(By.linkText(OR.getProperty("leftpanel_linktext")))).build().perform();
		  		if(driver.findElements(By.linkText(OR.getProperty("selecteditem_linktext"))).size()==0)
		  		{
		  			Assert.fail("Laptops link not found");
		  		}
		  log.debug("clicking thelaptops links.....");
		  driver.findElement(By.linkText(OR.getProperty("selecteditem_linktext"))).click();
  		  help.sleep(5);
  		  		if(driver.findElements(By.id(OR.getProperty("container_id"))).size()==0)
  		  		{
  		  			Assert.fail("container1 having laptops list not found ");
  		  		}
  		  		if(driver.findElements(By.cssSelector(OR.getProperty("cssselector_classname"))).size()==0)
  		  		{
  		  			Assert.fail("container1 sublist with classname not found ");
  		  		}
 		  List<WebElement> laplist=driver.findElement(By.id(OR.getProperty("container_id"))).findElements(By.cssSelector(OR.getProperty("cssselector_classname")));
		  String ni=String.valueOf(laplist.size());
		  Reporter.log("Container with Laptoplist size is:" +ni);
 		       if(laplist.size()==0)
 		       {
 		    	   Assert.fail("Laptops list items not found");
 		       }
 		    /* for (int j = 0; j < laplist.size(); j++)
 		      {
			  System.out.println(laplist.get(j).getText());
			
			  }*/
		  log.debug("Randon selection of the Laptop from the list.....");
		  Random rd = new Random();
		  int sd= rd.nextInt(laplist.size());
		  String qi=String.valueOf(sd);
		  Reporter.log("The random list selection is:"+qi);
		  laplist.get(sd).click();
		  		if(driver.findElements(By.className(OR.getProperty("sharelinks_contianer"))).size()==0)
		  		{
		  			Assert.fail("Sharelinks container element not found ");
		  		}
		  		if(driver.findElements(By.tagName(OR.getProperty("tagname_a"))).size()==0)
		  		{
		  			Assert.fail("Sharelinks elements with tagname a not found ");
		  		}
		  log.debug("Social container links loading.....");
		  List<WebElement> sociallinks = driver.findElement(By.className(OR.getProperty("sharelinks_contianer"))).findElements(By.tagName(OR.getProperty("tagname_a")));
		  String hi=String.valueOf(sociallinks.size());
		  Reporter.log("The size of social link container is:" +hi);
		  		if(sociallinks.size()==0)
		  		{
		  			Assert.fail("Social links list not having any elements ");
		  		}
		  log.debug("clicking the social share links in a loop.....");
		  		for(int i=1; i<sociallinks.size()-2; i++)
		  		{
			    
		  			Reporter.log((sociallinks.get(i).getAttribute(OR.getProperty("attribute_title"))));
			    	sociallinks.get(i).click();
			  		help.sleep(5);	
                    Set<String> windowids = driver.getWindowHandles();					
					Iterator<String> iter = windowids.iterator();					
					String mainWindow = iter.next();
					// switching to 2nd window....					
					String popUpWindow = iter.next();	
					help.takescreenshot("sharelinks"+i);
					//Reporter.log(popUpWindow);
					driver.switchTo().window(popUpWindow);					
					//Reporter.log(driver.getTitle());
					Reporter.log(driver.getCurrentUrl());
					driver.close();
					driver.switchTo().window(mainWindow);								  					  					  
		  		}
		  driver.close();
	//    sociallinks.get(5).click();
	 }
   
    @BeforeMethod
    public void beforeMethod()
    {
	 help.bMeth();
    }

  	@AfterMethod
  	public void afterMethod()
  	{
  	}

}
