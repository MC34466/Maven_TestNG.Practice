package ParallelSuiteRun;

import java.util.Arrays;

import org.testng.TestNG;

public class ParallelBatch {

	public static void main(String[] args) 
	{
		TestNG obj = new TestNG();
		obj.setTestSuites(Arrays.asList(new String[] {System.getProperty("user.dir")+"//batchfile.xml"}));
		obj.setSuiteThreadPoolSize(2);
		obj.run();
	}

}
