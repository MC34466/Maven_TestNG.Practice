package com.DecMavenpackage.DecMavenProject;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

public class extentmanager extends BaseTest2
{

	public static ExtentReports report; 
	
	public static ExtentReports getInstance()
	{
		if(report==null)
		{
			report=new ExtentReports(projectPath+"//HTMLRepo//htmlreport.html");
			report.loadConfig(new File(projectPath+"//extentRepoconfig.xml"));
			//report.addSystemInfo("Selenium LanguageBinding", "3.141.59").addSystemInfo("environment", parentprop.getProperty("env"));
		}
		
		return report;
	}

}
