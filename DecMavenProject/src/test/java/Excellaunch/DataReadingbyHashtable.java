package Excellaunch;

import org.testng.annotations.Test;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;

public class DataReadingbyHashtable 
{
  @Test(dataProvider = "getData")
  public void f(Hashtable<String, String>table) 
  {
  }

  @DataProvider
  public Object[][] getData() throws Exception 
  {
	    ExcelAPI e= new ExcelAPI("C:\\Users\\dell\\Desktop\\Selenium Documents\\Datadriven\\SuiteA.xlsx");
		String sheetname = "Data";
		String testcasename = "LoginTest";
		
		int teststartRowNum = 0;
		while(!e.getCellData(sheetname, 0, teststartRowNum).equals(testcasename))
		{
			teststartRowNum++;
		}
		System.out.println("Test starts from row:  "+teststartRowNum);
		
		int colstartRowNum = teststartRowNum+1;
		int datastartsRownum = teststartRowNum+2;
		//Calculate rows of data
		int rows =0;
		while (!e.getCellData(sheetname, 0, datastartsRownum+rows).equals(""))
		{
			rows++;
		}
		System.out.println("Total rows are: "+rows);
		
		//Calculate columns of data
		int col =0;
		while(!e.getCellData(sheetname, col, colstartRowNum).equals(""))
		{
			col++;
		}
		System.out.println("Total columns are: "+col);
		
		
		//Read test data
		//Rows
		
		int datarow = 0;
		Object[][] data = new Object[rows][1];
		Hashtable<String, String> table=null;
		for(int rNum=datastartsRownum;rNum<datastartsRownum+rows;rNum++)
		{
			//Columns
			table=new Hashtable<String,String>();
			for(int cNum=0;cNum<col;cNum++)
			{
				//System.out.println(e.getCellData(sheetname, cNum, rNum));
				//data[datarow][cNum]= e.getCellData(sheetname, cNum, rNum);
				
				String key = e.getCellData(sheetname, cNum, colstartRowNum);
				String value = e.getCellData(sheetname, cNum, rNum);
				table.put(key, value);
			}
			data[datarow][0]=table;
			datarow++;
		}
		return data;
	//return null;
	  
  }
}
