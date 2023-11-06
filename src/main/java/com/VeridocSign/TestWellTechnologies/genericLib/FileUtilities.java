package com.VeridocSign.TestWellTechnologies.genericLib;

import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
/**
 * 
 * @author surajkumar
 *
 */

public class FileUtilities {
	/**
	 * It is used to read data from property File
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getPropertyFile(String key) throws IOException
	{
		Properties p=new Properties();
		FileInputStream fis=new FileInputStream(AutoConstant.propertyfilepath);
		p.load(fis);
		return p.getProperty(key);
	}
	/**
	 * It is used to read data from Excel sheet
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getExcelFile(String sheetname, int row, int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(AutoConstant.excelfilepath);
		Workbook wb = WorkbookFactory.create(fis);
		return wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
	}
	
}
