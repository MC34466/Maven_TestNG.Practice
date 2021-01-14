package Excellaunch;

public class Datamanagement {

	public static void main(String[] args) throws Exception 
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
		for(int rNum=datastartsRownum;rNum<datastartsRownum+rows;rNum++)
		{
			//Columns
			for(int cNum=0;cNum<col;cNum++)
			{
				System.out.println(e.getCellData(sheetname, cNum, rNum));
			}
		}
		
		

	}

}
