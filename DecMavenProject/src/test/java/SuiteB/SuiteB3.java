package SuiteB;

import org.testng.annotations.Test;

public class SuiteB3 {
  @Test
  public void f() throws Exception 
  {
	  System.out.println("Starting TestB3");
	  Thread.sleep(2000);
	  System.out.println("Ending TestB3");
  }
}
