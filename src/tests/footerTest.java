package tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.Helper;

public class footerTest extends Helper
{
	
	@Test
	public void targetfooter() throws Exception
	{
		  driver.manage().window().maximize();
		  log.debug("Loading the url for footer testcase.....");
		  driver.get(config.getProperty("testUrl"));
		  	if(driver.findElements(By.cssSelector(OR.getProperty("footer_classname"))).size()==0)
		  	{
		  		Assert.fail("footer container not found");
		  	} 
		  	  if(driver.findElements(By.tagName(OR.getProperty("footer_tagname"))).size()==0)
		  	  {
		  		Assert.fail("footer tags with 'a' not found");
		  	  }
		  
		  	 List<WebElement> footerlist= driver.findElement(By.cssSelector(OR.getProperty("footer_classname"))).findElements(By.tagName(OR.getProperty("footer_tagname")));
		  	 String si=String.valueOf(footerlist.size());
		  	 Reporter.log("The size of Footer list is:" +si);
		 			if(footerlist.size()==0)
		 			{
		 			  Assert.fail("footer elements list  not found");
		 			}
		 		ArrayList<String> arrLinks1 = new ArrayList<String>();		
		 			for(int i=0; i<footerlist.size();i++)
		 			{			
		 				arrLinks1.add(footerlist.get(i).getAttribute(OR.getProperty("attrhref_tag")));						
		 			}
		 		log.debug("clicking the footer links.....");
		 				for(int j=0;j<arrLinks1.size();j++)
		 				{
		 					driver.get(arrLinks1.get(j));
		 					help.takescreenshot("footer"+j);
		 					Reporter.log("current url is: "+driver.getCurrentUrl());
		 						if(driver.getCurrentUrl().equalsIgnoreCase(arrLinks1.get(j)))
		 						{
		 							Reporter.log("This footerlinks navigated to the correct site");
								}
		 						else
		 						{
		 							Reporter.log("this footer links naviagted to wrong site");
		 						}
		 				}
		 					driver.close();
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
