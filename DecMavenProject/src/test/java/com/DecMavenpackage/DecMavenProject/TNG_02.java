package com.DecMavenpackage.DecMavenProject;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class TNG_02 extends BaseTest2
{

  @BeforeMethod
  @Parameters("browser")
  public void startProcess() throws Exception 
  {
	  init();
		
		test=report.startTest("Test_006_HTML_Reports");
		test.log(LogStatus.INFO, "-----------Started Test_006-----------");
		test.log(LogStatus.INFO, "Initialising the dependency files...");
		
		launch("chromebrowser");
		test.log(LogStatus.PASS, "Opening browser:	"+p.getProperty("chromebrowser"));
		
		navigateurl("amazonurl");
		test.log(LogStatus.INFO, "Navigate to url     "+childprop.getProperty("amazonurl"));
	  
  }
  
  @Test
  public void amazon() 
  {
	  	search("Amazondropdown_name","Books");
		test.log(LogStatus.FAIL, "Selected the option Books by locator:      "+orprop.getProperty("Amazondropdown_name"));
	
		type("Amazonsearchtext_name","Harry Potter");
		test.log(LogStatus.INFO, "Type Harry potter bookaname by locator:     "+orprop.getProperty("Amazonsearchtext_name"));
		
		find("Amazonsearchbutton_xpath");
		test.log(LogStatus.ERROR, "click on the search botton by locator:     "+orprop.getProperty("Amazonsearchbutton_xpath"));

		test.log(LogStatus.INFO, "-----------Ended Test_006-----------");
	  
  }
  
  @AfterMethod
  public void endProcess() 
  {
	  System.out.println("End Process");
	  report.endTest(test);
	  report.flush();  
	  driver.quit();
  }

}
