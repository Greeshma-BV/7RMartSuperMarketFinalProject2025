package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constants;

public class ExcelUtility {
	static FileInputStream f;
	static XSSFWorkbook w;
	static XSSFSheet sh;
	
	public static String readStringData(int row,int col,String sheet)throws IOException
	{
		String filepath=Constants.TESTDATAFILE;//set file path
		f=new FileInputStream(filepath);//open file in the reading mode
		w=new XSSFWorkbook(f);//open the workbook form excel file
		sh=w.getSheet(sheet);//extract the sheet from workbook
		XSSFRow r=sh.getRow(row);//get the row
		XSSFCell c=r.getCell(col);//get column
		return c.getStringCellValue();//get the value of the cell
	}
	
	public static String readIntegerData(int row,int col, String sheet)throws IOException
	{
				String filepath=Constants.TESTDATAFILE;
				f=new FileInputStream(filepath);
				w=new XSSFWorkbook(f);
				sh=w.getSheet(sheet);
				XSSFRow r=sh.getRow(row);
				XSSFCell c=r.getCell(col);
				int val=(int) c.getNumericCellValue();//convert double to int using upcasting
				return String.valueOf(val);//convert int to string using valueOf() method
			
	}


}
