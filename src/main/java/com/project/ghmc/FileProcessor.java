package com.project.ghmc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileProcessor {

	private static final String FILE = "D:\\Sankar\\Projects\\GHMC\\REPO.xlsx";
	private static final short TOTAL_BILLCOUNT = 848; 



	public static void readFile() throws IOException {
		File aFile  = new File(FILE);
		FileInputStream fileInputStream = null;
		XSSFWorkbook aWorkbook = null;
		XSSFSheet aSheet = null;
		try {		
			if(aFile.exists()) {
				System.out.println("1. File Exits");
				fileInputStream = new FileInputStream(aFile);
				aWorkbook = new XSSFWorkbook(fileInputStream);
				aSheet = aWorkbook.getSheet("DATA");
				Iterator<Row> rows = aSheet.rowIterator();
				int rowCount = 1;
				Bill bill;
				while (rows.hasNext()) {
					Row aRow = rows.next();
					bill = new Bill(aRow.getCell(0).toString(), aRow.getCell(1).toString(), aRow.getCell(2).toString(),
							aRow.getCell(3).toString(), aRow.getCell(4).toString(), aRow.getCell(5).toString(), aRow.getCell(6).toString(),
							aRow.getCell(7).toString(), aRow.getCell(8).toString(), aRow.getCell(9).toString(), aRow.getCell(10).toString(), 
							aRow.getCell(11).toString(), aRow.getCell(12).toString());
					System.out.println(bill.toString());
					if(rowCount == TOTAL_BILLCOUNT) {
						break;
					}				
					rowCount++;
				}


			} else {
				System.out.println("File Doesn't Exits");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(aWorkbook != null)
				aWorkbook.close();			
			if(fileInputStream != null)
				fileInputStream.close();


		}

	}

}
