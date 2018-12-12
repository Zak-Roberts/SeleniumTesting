package com.cognizant.firstDDTExample;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class firstDDT {

	@Test
	public void loginTest() throws IOException {
		
		FileInputStream file = new FileInputStream("C:/Users/Admin/Desktop/AutomatedTesting/DemoSiteDDT.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);

//		Reading from spreadsheet
		for (int row = 0; row < sheet.getPhysicalNumberOfRows(); row++) {
			for (int column = 0; column < sheet.getRow(row).getPhysicalNumberOfCells(); column++) {
				XSSFCell cell = sheet.getRow(row).getCell(column);
				String userCell = cell.getStringCellValue();
				System.out.println(userCell);
			}
		}

//		Writing to spreadsheet
		XSSFRow row = sheet.getRow(1);
		XSSFCell cell = row.getCell(1);
		if (cell == null) {
			cell = row.createCell(1);
		}
		cell.setCellValue("Hello");
		
		FileOutputStream fileOut = new FileOutputStream("C:/Users/Admin/Desktop/AutomatedTesting/DemoSiteDDT.xlsx");
		
		workbook.write(fileOut);
		fileOut.flush();
		fileOut.close();		
		file.close();
		
	}

}
