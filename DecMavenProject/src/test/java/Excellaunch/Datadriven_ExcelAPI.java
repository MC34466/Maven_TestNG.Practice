package Excellaunch;

public class Datadriven_ExcelAPI {

	public static void main(String[] args) throws Exception 
	{
		ExcelAPI e1 = new ExcelAPI("C:\\Users\\dell\\Desktop\\Selenium Documents\\Datadriven\\Test.xlsx");
		int rowcount = e1.getRowCount("login");
		System.out.println(rowcount);
		int colcount = e1.columnCount("login");
		System.out.println(colcount);
		
		System.out.println(e1.getCellData("login", 1, 2));
		System.out.println(e1.getCellData("login", "Password", 4));
		
		e1.setCellData("login", 4, 4, "Pass");
	}

}
