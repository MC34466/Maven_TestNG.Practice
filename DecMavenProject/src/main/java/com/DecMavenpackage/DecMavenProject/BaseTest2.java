package com.DecMavenpackage.DecMavenProject;

import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseTest2 
{
	public static WebDriver driver;
	public static String projectPath = System.getProperty("user.dir");
	public static FileInputStream fis;
	public static Properties p;
	public static Properties parentprop;
	public static Properties childprop;
	public static Properties orprop;
	public static ExtentReports report ; 
	public static ExtentTest test;
	public static String filepath;
	 
	static
	{
		Date dt = new Date();
		filepath = dt.toString().replace(':', '_').replace(' ','_');
	}
	
	
	public static void init() throws Exception
	{
		fis = new FileInputStream(projectPath+"/data.properties");
		p = new Properties();
		p.load(fis);
		
		fis = new FileInputStream(projectPath+"/environment.properties");
		parentprop = new Properties();
		parentprop.load(fis);
		String e = parentprop.getProperty("env");
		System.out.println(e);
		
		fis = new FileInputStream(projectPath+"/"+e+".properties");
		childprop = new Properties();
		childprop.load(fis);
		String c = childprop.getProperty("googleurl");
		System.out.println(c);	
		
		fis = new FileInputStream(projectPath+"/or.properties");
		orprop = new Properties();
		orprop.load(fis);
		
		fis = new FileInputStream(projectPath+"/log4jconfig.properties");
		PropertyConfigurator.configure(fis);
		
		report = extentmanager.getInstance();
			
	}
	public static void launch(String browser)
	{
		//Stand alone 
//		ChromeDriver driver = new ChromeDriver();
//		driver.get("http://amazon.in");
//		FirefoxDriver driver1 = new FirefoxDriver();
//		driver1.get("http://flipkart.in");
		
		
		//Partially Dynamic: TC_001
//		if(browser.equals("chrome"))
//		{
//			driver = new ChromeDriver();
//		}
//		else if(browser.equals("firefox")) 
//		{
//			driver = new FirefoxDriver();
//		}
		
		
		//Fully Dynamic: TC_002
		//if(p.getProperty(browser).equals("chrome"))
		if(browser.equals("chrome"))
		{
			driver = new ChromeDriver();
			//System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "false");
		}
		//else if(p.getProperty(browser).equals("firefox"))
		else if(browser.equals("firefox"))	
		{
			driver = new FirefoxDriver();
		}
	}
	
	public static void navigateurl(String url)
	{
		//Partially Dynamic: TC_001
//		driver.get(url);
		
		//Fully Dynamic: TC_002
		//driver.get(childprop.getProperty(url));
		driver.navigate().to(childprop.getProperty(url));
	}
	
	public static void search(String locatorKey, String category) 
	{
		//driver.findElement(By.id(locater)).sendKeys(locater);
		//driver.findElement(By.id(orprop.getProperty(locatorKey))).sendKeys(category);
		selectLocator(locatorKey).sendKeys(category);
	}


	public static void type(String locatorKey, String thing) 
	{
		//driver.findElement(By.id(locater)).sendKeys(thing);
		//driver.findElement(By.id(orprop.getProperty(locatorKey))).sendKeys(thing);
		selectLocator(locatorKey).sendKeys(thing);
		
	}
	
	public static void find(String locatorKey) 
	{
		//driver.findElement(By.xpath(locator)).click();
		//driver.findElement(By.xpath(orprop.getProperty(locatorKey))).click();
		selectLocator(locatorKey).click();
	}
	
	public static WebElement selectLocator(String locatorKey) 
	{
		WebElement element=null;
		
		if(locatorKey.endsWith("_id")) {
			element=driver.findElement(By.id(orprop.getProperty(locatorKey)));
		} else if(locatorKey.endsWith("_name")){
			element=driver.findElement(By.name(orprop.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_classname")){
			element=driver.findElement(By.className(orprop.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_linkText")){
			element=driver.findElement(By.linkText(orprop.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_parLinktext")){
			element=driver.findElement(By.partialLinkText(orprop.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_xpath")){
			element=driver.findElement(By.xpath(orprop.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_cssselector")){
			element=driver.findElement(By.cssSelector(orprop.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_tagname")){
			element=driver.findElement(By.tagName(orprop.getProperty(locatorKey)));
		}
		
		return element;
	}


}
