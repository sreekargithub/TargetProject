package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import jxl.Sheet;
import jxl.Workbook;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

import utils.Helper;

public class TestBase {
  public static String dir1;
  public static Properties config=null;
  public static Properties OR=null;
  public static WebDriver driver;
  public static FileInputStream fp, fp1;
  
  //initializing log4j
  public static Logger log;
  public static File fi; 
  public static Workbook w;
  public static Sheet sh;
  public static Helper help;
 
  

	@BeforeSuite	
	public void intialize() throws IOException, Exception   {
		log = Logger.getLogger("devpinoyLogger");
		log.debug("Starting the test suite......");
		log.debug("Loading the config files.....");
		dir1= System.getProperty("user.dir");	
		fp= new FileInputStream(dir1+"\\src\\configfiles\\config.properties");
		config = new Properties();
		config.load(fp);
		log.debug("Loading the Object repository files.....");
		fp1= new FileInputStream(dir1+"\\src\\configfiles\\or.properties");
		OR = new Properties();
		OR.load(fp1);
		log.debug("Loading the TestData related Excel files.....");
		fi = new File(dir1+"\\src\\testdata\\target-or.xls");
		w = Workbook.getWorkbook(fi);		
		sh = w.getSheet(0);
		log.debug("Loading the Helper class files.....");
		help= new Helper();
		
		Reporter.log("Choosing the browser: "+ config.getProperty("browserType"));
		
			}
}
