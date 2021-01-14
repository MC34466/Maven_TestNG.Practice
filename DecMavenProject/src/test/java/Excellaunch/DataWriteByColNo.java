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

public class DataWriteByColNo {

	public static void main(String[] args) throws Exception 
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\dell\\Desktop\\Selenium Documents\\Datadriven\\Test.xlsx");
		FileOutputStream fos = null;
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("login");
		
		XSSFFont font = wb.createFont();
		XSSFCellStyle style = wb.createCellStyle();
		
		XSSFRow row = sheet.getRow(2);
		XSSFCell cell = row.getCell(4);
		cell.setCellValue("passed");
		
		font.setFontName("Algerian");
		font.setFontHeight(20);
		font.setBold(true);
		
		style.setFont(font);
		cell.setCellStyle(style);
		
		fos = new FileOutputStream("C:\\Users\\dell\\Desktop\\Selenium Documents\\Datadriven\\Test.xlsx");
		wb.write(fos);
		wb.close();
		fos.close();
		
	}

}
