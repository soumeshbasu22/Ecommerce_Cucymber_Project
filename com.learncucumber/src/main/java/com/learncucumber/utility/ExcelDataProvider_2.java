package com.learncucumber.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider_2 {
	public XSSFWorkbook wb1;
	public XSSFSheet sh1;
	public ExcelDataProvider_2() throws Exception{
		String filepath1="C:\\Users\\soumesh\\git\\Ecommerce_Cucymber_Project\\com.learncucumber\\TestData\\Product_Brands.xlsx";
		FileInputStream fis1=new FileInputStream(filepath1);
		wb1=new XSSFWorkbook(fis1);
		sh1=wb1.getSheet("Sheet1");
	}
	public String brand_name(int i) throws Exception {
		
		return sh1.getRow(i).getCell(0).getStringCellValue();
	}

}
