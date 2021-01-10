package SuiteB.copy;

import org.testng.annotations.Test;

public class SuiteB1 {
  @Test
  public void f() throws Exception 
  {
	  System.out.println("Starting TestB1");
	  Thread.sleep(2000);
	  System.out.println("Ending TestB1");
  }
}
