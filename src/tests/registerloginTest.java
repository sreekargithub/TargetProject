package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import utils.Helper;

public class registerloginTest extends Helper
{
	
	 @Test
	 public void register() throws Exception 
	 {
		  driver.manage().window().maximize();
		  driver.get(config.getProperty("testUrl"));
		  log.debug("Loading the url for Register testcase.....");
		  		if(driver.findElements(By.id(OR.getProperty("homesigninbutton_id"))).size()==0)
		  		{
		  			Assert.fail("home sign in account button not found");
		  		}
		  log.debug("Clicking the sign in account button .....");
		  driver.findElement(By.id(OR.getProperty("homesigninbutton_id"))).click();
		  		if(driver.findElements(By.linkText(OR.getProperty("createaccount_linktext"))).size()==0)
		  		{
		  			Assert.fail("create account button not found");
		  		}
		  log.debug("Clicking the createaccount button  for registration.....");
		  driver.findElement(By.linkText(OR.getProperty("createaccount_linktext"))).click();
		  		if(driver.findElements(By.id(OR.getProperty("fname_id"))).size()==0)
		  		{
		  			Assert.fail("firstname field not found");
		  		}
		  log.debug("Started the registration fields entry.....");
		  driver.findElement(By.id(OR.getProperty("fname_id"))).sendKeys(sh.getCell(0,1).getContents());
		  		if(driver.findElements(By.id(OR.getProperty("lname_id"))).size()==0)
		  		{
		  			Assert.fail("lastname field not found");
		  		}
		  driver.findElement(By.id(OR.getProperty("lname_id"))).sendKeys(sh.getCell(0,2).getContents());
		  		if(driver.findElements(By.id(OR.getProperty("email_id"))).size()==0)
		  		{
		  			Assert.fail("email field not found");
		  		}
		  driver.findElement(By.id(OR.getProperty("email_id"))).sendKeys(sh.getCell(0,3).getContents());
		  		if(driver.findElements(By.id(OR.getProperty("pwd_id"))).size()==0)
		  		{
		  			Assert.fail("Password field not found");
		  		}
		  driver.findElement(By.id(OR.getProperty("pwd_id"))).sendKeys(sh.getCell(0,4).getContents());
		  		if(driver.findElements(By.id(OR.getProperty("registersubmit_id"))).size()==0)
		  		{
		  			Assert.fail("register button not found");
		  		}
		  log.debug("Submitting the registration details.....");
		  driver.findElement(By.id(OR.getProperty("registersubmit_id"))).click();
		  help.takescreenshot("registration");
		  Reporter.log("Registration successfull");
		  driver.close();		  
	 }
	 
	 @Test
	 public void login() throws Exception 
	 {
		  driver.manage().window().maximize();
		  log.debug("Loading the url for Login testcase.....");
		  driver.get(config.getProperty("testUrl"));
		  		if(driver.findElements(By.id(OR.getProperty("homesigninbutton_id"))).size()==0)
		  		{
		  			Assert.fail("home sign in account button not found");
		  		}
		  log.debug("clicking the sign in button.....");
		  driver.findElement(By.id(OR.getProperty("homesigninbutton_id"))).click();
		  		if(driver.findElements(By.id(OR.getProperty("signinemail_id"))).size()==0)
		  		{
		  			Assert.fail("Sign in email field not found");
		  		}
		  log.debug("entering email and password detail for login.....");
		  driver.findElement(By.id(OR.getProperty("signinemail_id"))).sendKeys(config.getProperty("loginemail"));
		  		if(driver.findElements(By.id(OR.getProperty("signinpwd_id"))).size()==0)
		  		{
		  			Assert.fail("Sign in pwd field not found");
		  		}
		  driver.findElement(By.id(OR.getProperty("signinpwd_id"))).sendKeys(config.getProperty("loginpwd"));
		  		if(driver.findElements(By.id(OR.getProperty("acctsignin_id"))).size()==0)
		  		{
		  			Assert.fail("Account sign in button not found");
		  		}
		  driver.findElement(By.id(OR.getProperty("acctsignin_id"))).click();
		  help.sleep(3);
		  		if(driver.findElement(By.id(OR.getProperty("loggedinpopup_id"))).getAttribute("title").equalsIgnoreCase(sh.getCell(1,2).getContents()))
		  		{
		  			Reporter.log("login successfull with credentials of Sree");
		  		}
		  		else 
		  		   	{
		  				Reporter.log("login not successfull with credentials of sree ");
		  		   	}
		help.takescreenshot("login");
		driver.close();
	}		 
  
  @BeforeMethod
  public void beforeMethod() {
	  help.bMeth();
	 
  }

  @AfterMethod
  public void afterMethod() {
  }

}
