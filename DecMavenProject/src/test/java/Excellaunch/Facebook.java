package Excellaunch;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook {

	public static void main(String[] args) throws Exception 
	{
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		ExcelAPI e= new ExcelAPI("C:\\Users\\dell\\Desktop\\Selenium Documents\\Datadriven\\Test.xlsx");
		 
		//For Single
		//driver.findElement(By.id("email")).sendKeys(e.getCellData("login", "UserName", 2));
		//driver.findElement(By.id("pass")).sendKeys(e.getCellData("login", "Password", 2));
		
		//For all login
		
		for(int i=0;i<e.getRowCount("login");i++)
		{
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys(e.getCellData("login", "UserName", i));
			
			driver.findElement(By.id("pass")).clear();
			driver.findElement(By.id("pass")).sendKeys(e.getCellData("login", "Password", i));
			Thread.sleep(3000);
			
		}
			
	}

}
