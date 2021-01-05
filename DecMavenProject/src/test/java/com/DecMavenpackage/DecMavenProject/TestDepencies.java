package com.DecMavenpackage.DecMavenProject;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestDepencies {
  @Test(priority=1)
  public void orange() 
  {
	  System.out.println("orange");
  }
  
  @Test(priority=2,dependsOnMethods = {"orange"})
  public void white() 
  {
	  System.out.println("white");
  }
  
  @Test(priority=3,dependsOnMethods = {"white"})
  public void blue() 
  {
	  System.out.println("blue");
	  //Assert.assertTrue(false, "blue test is failed...");
	  throw new SkipException("Blue method skip...");
  }
  
  @Test(priority=4,dependsOnMethods = {"blue"})
  public void green() 
  {
	  System.out.println("green");
  }
}
