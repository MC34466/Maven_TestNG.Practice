package Excellaunch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataWriteByColName {

	public static void main(String[] args) throws Exception 
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\dell\\Desktop\\Selenium Documents\\Datadriven\\Test.xlsx");
		FileOutputStream fos = null;
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("login");
		
		
		XSSFRow row = sheet.getRow(0);
		XSSFCell cell=null;
		
		int columnIndex = -1;
		
		for(int i=0;i<row.getLastCellNum();i++)
		{
			if(row.getCell(i).getStringCellValue().trim().equals("Result"))
				columnIndex = i;
		}
		
		row=sheet.getRow(3);
		cell=row.getCell(columnIndex);
		cell.setCellValue("failed");
		
		
		fos = new FileOutputStream("C:\\Users\\dell\\Desktop\\Selenium Documents\\Datadriven\\Test.xlsx");
		wb.write(fos);
		wb.close();
		fos.close();

	}

}
