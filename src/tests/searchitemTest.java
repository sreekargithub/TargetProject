package tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import utils.Helper;

public class searchitemTest extends Helper
{
 
	 @Test
	 public void searchIpod() throws Exception
	 {
			  driver.manage().window().maximize();
			  log.debug("Loading the url for searchItem testcase.....");
			  driver.get(config.getProperty("testUrl"));
			  		if(driver.findElements(By.id(OR.getProperty("searchtype_id"))).size()==0)
			  		{
			  			Assert.fail("Search box not found");
			  		}
			  driver.findElement(By.id(OR.getProperty("searchtype_id"))).sendKeys(sh.getCell(1,0).getContents());
			  //driver.findElement(By.id("searchTerm")).sendKeys(OR.getProperty("enterkeys"));
			  		if(driver.findElements(By.id(OR.getProperty("click_search"))).size()==0)
			  		{
			  			Assert.fail("search click button not found");
			  		}
			  log.debug("Clicing the search button for search of the entered item.....");
			  driver.findElement(By.id(OR.getProperty("click_search"))).click();
			  String str=sh.getCell(1,1).getContents();	
			  		if(driver.findElements(By.id(OR.getProperty("container1_id"))).size()==0)
			  		{
			  			Assert.fail("Ipod list1 container not found");
			  		}
			  		if(driver.findElements(By.cssSelector(OR.getProperty("subcontainer_classname"))).size()==0)
			  		{
			  			Assert.fail("Iodlist1 subcontainerlist not found");  
			  		}
			  log.debug("Capturing the 1st list of available Ipods.....");
			  List<WebElement> ipodlist1=driver.findElement(By.id(OR.getProperty("container1_id"))).findElements(By.cssSelector(OR.getProperty("subcontainer_classname")));
			  String ti=String.valueOf(ipodlist1.size());
			  Reporter.log("The ipodlist1 in page one size is: " +ti); 
			  help.takescreenshot("list1");
			  		if(ipodlist1.size()==0)
			  		{
			  			Assert.fail("list1 not found");
			  		}
			  log.debug("storing the ist list of Ipods to  Array1.....");
			  ArrayList<String> arrLinks1 = new ArrayList<String>();
			   		for (int s = 0; s < ipodlist1.size(); s++)
			   		{
				  
			   			// Reporter.log(laplist.get(s).getText()); 
			   			arrLinks1.add(ipodlist1.get(s).getText());
			   			if(!ipodlist1.get(s).getText().toLowerCase().contains(str))
			   			{
			   				Reporter.log(ipodlist1.get(s).getText()+" does not contain "+ str);
			   			}
			   			else
			   			{
			   				Reporter.log(ipodlist1.get(s).getText()+ " contains "+ str);
			   			}
				  
			   		}
			   
			   		if(driver.findElements(By.cssSelector(OR.getProperty("pagination_classname"))).size()==0)
			   		{
			   			Assert.fail("Pagination icon not found"); 
			   		}
			  log.debug("clicking on the pagination button.....");
			  driver.findElement(By.cssSelector(OR.getProperty("pagination_classname"))).click();
			  		if(!help.waitforElement(20, By.id(OR.getProperty("container2_id"))))
			  		{
			  			help.takescreenshot("cart");
			  			Assert.fail("Searching container2  not found");
			  		} 
			  		else
			  		{
			  				Reporter.log("cart container2  found");
			  		}
			  		if(driver.findElements(By.id(OR.getProperty("container2_id"))).size()==0)
			  		{
			  			Assert.fail("ipodlist 2 container not found"); 
			  		}
			  		if(driver.findElements(By.cssSelector(OR.getProperty("subcontainer_classname"))).size()==0)
			  		{
			  			Assert.fail("ipolist 2 subcontainer not found ");
				  
			  		}
			  log.debug("Capturing the ipodlist 2 in page2.....");
			  List<WebElement> ipodlist2=driver.findElement(By.id(OR.getProperty("container2_id"))).findElements(By.cssSelector(OR.getProperty("subcontainer_classname")));
			  String xi=String.valueOf(ipodlist2.size());
			  Reporter.log("The ipodlist2 in page 2 size is: " +xi); 
			  	  	if(ipodlist2.size()==0)
			  	  	{
			  	  		Assert.fail("list2 not found");
			  	  	}
			  ArrayList<String> arrLinks2 = new ArrayList<String>();
			   		for (int j = 0; j < ipodlist2.size(); j++)
			   			{
			   				arrLinks2.add(ipodlist2.get(j).getText());
			   			}
			  log.debug("comparing the two lists of ipods in page 1 and page2.....");
			  ArrayList<String> arrLinks3= new ArrayList<String>();
			  			for (String temp : arrLinks1)
			  				arrLinks3.add(arrLinks2.contains(temp) ? "Yes" : "No");
			  				help.takescreenshot("List2");
			  				System.out.println(arrLinks3);	         
	          driver.close();			 
	} 
	 
  @BeforeMethod
  public void beforeMethod() 
  {
	 help.bMeth();
  }

  @AfterMethod
  public void afterMethod() {
  }

}
