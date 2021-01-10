package SuiteA;

import org.testng.annotations.Test;

public class SuiteA3 
{
  @Test
  public void f() throws Exception 
  {
	  System.out.println("Starting TestA3");
	  Thread.sleep(2000);
	  System.out.println("Ending TestA3");
  }
}
