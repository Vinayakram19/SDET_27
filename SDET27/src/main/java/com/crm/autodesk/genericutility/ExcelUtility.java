package com.crm.autodesk.genericutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author VINAYAKARAM J
 *
 */

public class ExcelUtility {
	/**
	 *  its used read the data from excel based on below arguments 
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @return Data
	 * @throws Throwable
	 */

	public String getDataFromExcel(String sheetName , int rowNum, int celNum) throws Throwable {
		FileInputStream fis  = new FileInputStream("./data/Book.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		String data = row.getCell(celNum).getStringCellValue();
		wb.close();
		return data;
	}

/**
 * used to get the last used row number on specified Sheet
 * @param SheetName
 * @return
 * @throws Throwable
 */
 
  public int getRowCount(String SheetName) throws Throwable {
	  FileInputStream fis = new FileInputStream("./data/Book.xlsx");
	  Workbook wb=WorkbookFactory.create(fis);
	  Sheet sh=wb.getSheet(SheetName);
	  wb.close();
	  return sh.getLastRowNum();
	  
  }
  
 public void setDataExcel(String sheetName , int rowNum, int celNum ,String data) throws Throwable {
	 
	 FileInputStream fis = new FileInputStream("./Data/Book.xlsx");
	 Workbook wb = WorkbookFactory.create(fis);
	 Sheet sh = wb.getSheet(sheetName);
	 Row ro = sh.getRow(rowNum);
	 Cell cel = ro.createCell(celNum);
	 cel.setCellValue(data);
	 FileOutputStream fos = new FileOutputStream("./Data/Book.xlsx");
	 wb.write(fos);
	 wb.close();
	 
	 
 }
}







