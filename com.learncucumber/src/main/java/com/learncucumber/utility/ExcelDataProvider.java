package com.learncucumber.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	public XSSFSheet sh;
	public XSSFWorkbook wb;
	public ExcelDataProvider() throws Exception {
		
		String filepath="C:\\Users\\soumesh\\git\\Ecommerce_Cucymber_Project\\com.learncucumber\\TestData\\UserLoginInfo.xlsx";
		FileInputStream fis=new FileInputStream(filepath);
		wb=new XSSFWorkbook(fis);
		sh=wb.getSheet("Sheet1");
	}
	
	public String username(int i) {
		return sh.getRow(i).getCell(0).getStringCellValue();
	}
	public String password(int i) {
		return sh.getRow(i).getCell(1).getStringCellValue();
	}

}
