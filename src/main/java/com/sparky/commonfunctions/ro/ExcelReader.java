package com.sparky.commonfunctions.ro;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	Workbook wb= null;
	public ExcelReader(String filePath, String fileName) {
		try {
			this.wb = getWorkBook(filePath, fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Map<String,String> getRowDetails(String SheetName,int RowNumber){
		Map<String,String> map = new HashMap<String,String>();
		Sheet ws = wb.getSheet(SheetName);
		Row row =ws.getRow(ws.getFirstRowNum());
		String ColName,Value;
		for (int iColumn = 0; iColumn < row.getLastCellNum(); iColumn++) {
			//Print Excel data in console
			ColName = row.getCell(iColumn).getStringCellValue();
			Value = ws.getRow(RowNumber).getCell(iColumn).getStringCellValue();
			map.put(ColName,Value);
		}
		return map;
	}



	public int getNumberOfTestUser(String SheetName) {
		return wb.getSheet(SheetName).getLastRowNum();
	}
	private Workbook getWorkBook(String filePath,String fileName) throws IOException{

		//Create an object of File class to open xlsx file
		File file =    new File(filePath+"\\"+fileName);
		//Create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(file);
		Workbook wb = null;
		String fileExtensionName = fileName.substring(fileName.indexOf("."));

		//Check condition if the file is xlsx file
		if(fileExtensionName.equals(".xlsx")){
			wb = new XSSFWorkbook(inputStream);
		}
		else if(fileExtensionName.equals(".xls")){
			wb = new HSSFWorkbook(inputStream);
		}
		return wb;
	}

	public int  getColumnNumber(String Sheet,String columnName) {
		Sheet ws = wb.getSheet(Sheet);
		Row row =ws.getRow(ws.getFirstRowNum());
		int iColumnNum = 0;
		//Loop through the columns and get the column names
		for (int iColumn = 0; iColumn < row.getLastCellNum(); iColumn++) {
			//Print Excel data in console
			if(row.getCell(iColumn).getStringCellValue().equals(columnName)) {
				iColumnNum = iColumn;
				return iColumnNum;
			}
		} 
		return iColumnNum;
	}

	public String getCellData(String SheetName,String ColumnName, int RowNumber) {
		Sheet ws = wb.getSheet(SheetName);
		int colNum = getColumnNumber(SheetName, ColumnName);
		return ws.getRow(RowNumber).getCell(colNum).getStringCellValue();

	}

}