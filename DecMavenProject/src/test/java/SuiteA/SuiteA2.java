package SuiteA;

import org.testng.annotations.Test;

public class SuiteA2 
{
  @Test
  public void f() throws Exception 
  {
	  System.out.println("Starting TestA2");
	  Thread.sleep(2000);
	  System.out.println("Ending TestA2");
  }
}
