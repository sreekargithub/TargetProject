package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.Helper;

public class headerTest extends Helper
{
	 
	@Test
	  public void targetHeader() throws Exception
	{
		  driver.manage().window().maximize();
		  log.debug("Loading the url for header testcase.....");
		  driver.get(config.getProperty("testUrl"));
		  	   if(driver.findElements(By.className(OR.getProperty("menuheader_classname"))).size()==0)
		  	   {
			      Assert.fail("Header menu not found");
		  	   }
		  	   if(driver.findElements(By.tagName(OR.getProperty("tagname_li"))).size()==0)
		  	   {
		  		  Assert.fail("Header menu tags with Li not found");
		  	   }
		  log.debug("capturing the header links.....");
		  List<WebElement> hlinks= driver.findElement(By.className(OR.getProperty("menuheader_classname"))).findElements(By.tagName(OR.getProperty("tagname_li")));
		  String ri=String.valueOf(hlinks.size());
		  Reporter.log("The size of header list is:" +ri);
		  	   if(hlinks.size()==0)
	  			{
		  		   Assert.fail("Header menu list is empty");
	  			}
		  log.debug("Clicking the header links .....");
		  		  for (int k = 0; k < hlinks.size()-1; k++) 
		  				{
		  					//Reporter.log(hlinks.get(k).getText());
		  			         if(driver.findElements(By.className(OR.getProperty("menuheader_classname"))).size()==0)
		  					 {
		  							Assert.fail("Header menu2 not found");
		  					 }
		  					 if(driver.findElements(By.tagName(OR.getProperty("tagname_li"))).size()==0)
		  					  {
		  							Assert.fail("Header menu tags2 with Li2 not found");
		  					  }
                              List<WebElement> hlinks1= driver.findElement(By.className(OR.getProperty("menuheader_classname"))).findElements(By.tagName(OR.getProperty("tagname_li")));
		  						if(driver.findElements(By.tagName(OR.getProperty("click_tag"))).size()==0)
		  						{
		  							Assert.fail("Click tags2 list of a not found");
		  						}
		  					       hlinks1.get(k).findElement(By.tagName(OR.getProperty("click_tag"))).click();
		  						   help.takescreenshot("sr"+ k);
		  						   Reporter.log("The current url of the clicked header link is:" +driver.getCurrentUrl());
		  						   help.sleep(3);
		  						  driver.navigate().back();	  				
		  						help.sleep(3);		  
		  				}
		  										
		  		     if(!help.waitforElement(20, By.id(OR.getProperty("link7_id"))))
		  				{
		  				  help.takescreenshot("open redcard links");
		  				  Assert.fail("Searching open redcard links not found");
		  				} 
		  				 else
		  					{
		  					  Reporter.log("Searching open red card links  found");
		  					}
		  					  if(driver.findElements(By.id(OR.getProperty("link7_id"))).size()==0)
		  						{
		  						  Assert.fail("OpenREDcardPopup link not found");
		  						}
		  							log.debug("clicking the header links outside of loop.....");
		  						    driver.findElement(By.id(OR.getProperty("link7_id"))).click();
		  							  if(driver.findElements(By.linkText(OR.getProperty("link7.1_linktext"))).size()==0)
		  									{
		  									  Assert.fail("learn about REDcard link not found");
		  									 }
		  													
		  							  driver.findElement(By.linkText(OR.getProperty("link7.1_linktext"))).click();
		  							/*driver.navigate().back();
		 							  Thread.sleep(3000);*/
		  								if(driver.findElements(By.id(OR.getProperty("link7_id"))).size()==0)
		  								  {
		  									Assert.fail("OpenREDcardPopup link not found");
		  								  }
		  								driver.findElement(By.id(OR.getProperty("link7_id"))).click();
		  								  if(driver.findElements(By.linkText(OR.getProperty("link7.2_linktext"))).size()==0)
		  								  {
		  									Assert.fail("manage my REDcard link not found");
		  								  }
		  					driver.findElement(By.linkText(OR.getProperty("link7.2_linktext"))).click();
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
