package com.learncucumber.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Helper {
	
	public XSSFWorkbook wb1;
	public XSSFSheet sh1;
	public String filepath1="C:\\Users\\soumesh\\git\\Ecommerce_Cucymber_Project\\com.learncucumber\\target\\Report_Excel.xlsx";
	
	public Helper() throws Exception {
		
		FileInputStream fi1=new FileInputStream(filepath1);
		wb1=new XSSFWorkbook(fi1);
		sh1=wb1.getSheet("Sheet1");
	}
	
	public void newcell(int i,int j,String msg) throws Exception {
		Row currentRow=sh1.getRow(i);
		Cell currCell=currentRow.createCell(j);
		currCell.setCellValue(msg);
		FileOutputStream fo=new FileOutputStream(filepath1);
		wb1.write(fo);
	}
	
}
