package listeners;

import org.testng.ITestNGListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;


import com.DecMavenpackage.DecMavenProject.BaseTest2;

public class TestNGListeners extends BaseTest2 implements ITestNGListener
{
	public void onTestStart(ITestResult result) 
	{
		Reporter.log("Test Started Running :" + result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) 
	{
		if(result.isSuccess())
		{
			try 
			{
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(scrFile, new File(projectPath+"//success//"+filepath+".png"));
			
				Reporter.log("<a href='" + projectPath+"//success//"+filepath+".png" + "'> <img src='" + projectPath+"//success//"+filepath+".png" + "' height='100' width='100'/> </a>");
				Reporter.log("Test has Success:" + result.getMethod().getMethodName());
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
			
	}

	public void onTestFailure(ITestResult result) 
	{
		if(!result.isSuccess())
		{
			try 
			{
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(scrFile, new File(projectPath+"//failure//"+filepath+".png"));
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			
			Reporter.log("<a href='" + projectPath+"//failure//"+filepath+".png" + "'> <img src='" + projectPath+"//failure//"+filepath+".png" + "' height='100' width='100'/> </a>");
			Reporter.log("Test has Failed:" + result.getMethod().getMethodName());
		}
		
	}

	public void onTestSkipped(ITestResult result) 
	{
		Reporter.log("Test is skipped :" + result.getMethod().getMethodName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
