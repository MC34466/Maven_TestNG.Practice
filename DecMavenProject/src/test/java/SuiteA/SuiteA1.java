package SuiteA;

import org.testng.annotations.Test;

public class SuiteA1 
{
  @Test
  public void f() throws Exception 
  {
	  System.out.println("Starting TestA1");
	  Thread.sleep(2000);
	  System.out.println("Ending TestA1");
  }
}
