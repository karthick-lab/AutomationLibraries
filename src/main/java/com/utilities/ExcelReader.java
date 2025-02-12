package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelReader {
	
	public static int rowcount;
	public static int colcount;
	public static HSSFSheet sheet;
	
	public ExcelReader(String filename,String sheetname)
	{
		File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Test Data\\" + filename);
		try
		{
			FileInputStream fis = new FileInputStream(file);
			HSSFWorkbook workbook = new HSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetname);
		}
		catch(Exception e)
		{
			
		}
	}
	
	
	public int getrowcount() {
		
		try {
			
			rowcount = sheet.getLastRowNum();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowcount;
	}

	public int getcolcount() {
		colcount = sheet.getRow(0).getLastCellNum();
		return colcount;

	}

	public List<String> getcolname() {

		ArrayList<String> colname =new ArrayList<String>();;
		String data="";
		for(int j=0;j<getcolcount();j++)
		{
		try {
			data=sheet.getRow(0).getCell(j).getStringCellValue();
			colname.add(data);
			//System.out.println(colname);
		} catch (Exception e) {
			colname.add(String.valueOf((long) sheet.getRow(0).getCell(j).getNumericCellValue()));
			System.out.println("catch block");
			e.printStackTrace();
		}
		}

		return colname;
	}
	
	public String getdata(int row, int col) {

		String data = "";

		try {
			data = sheet.getRow(row).getCell(col).getStringCellValue();
			System.out.println(data);
		} catch (Exception e) {
			data = String.valueOf((long) sheet.getRow(row).getCell(col).getNumericCellValue());
			System.out.println("catch block");
			e.printStackTrace();
		}

		return data;
	}
	
	
	public String getdata(String colname, int row)
	{
		int col=-1;
		String data="";
		for(int j=0;j<getcolname().size();j++)
		{
			//System.out.println("Colname "+getcolname().get(j));
			if(colname.trim().equals(getcolname().get(j).trim()))
			{
				col=j;
				break;
			}
		}
		
		
		try {
			data = sheet.getRow(row).getCell(col).getStringCellValue();
			//System.out.println(colname);
		} catch (Exception e) {
			data = String.valueOf((long) sheet.getRow(row).getCell(col).getNumericCellValue());
			System.out.println("colname doesnot exist");
			e.printStackTrace();
		}

		return data;
		
	}

}
