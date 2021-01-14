package Excellaunch;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class DataProvideTestdemo 
{
	
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.out.println("I am before method.....");
  }

  @DataProvider
  public Object[][] dp() {
	  System.out.println("I am dataprovider method.....");
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) 
  {
	  System.out.println("I am test method.....");
  }


  @AfterMethod
  public void afterMethod() 
  {
	  System.out.println("I am after method.....");
  }
 
}
