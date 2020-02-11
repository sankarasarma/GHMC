package com.project.ghmc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileProcessor {

	private static final String FILE = "D:\\Sankar\\Projects\\GHMC\\REPO.xlsx";
	private static final String FILE_NEW = "D:\\Sankar\\Projects\\GHMC\\";
	private static final ArrayList<Bill> PROCESSED_BIL  = new ArrayList<Bill>();
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
					XSSFRow aRow = (XSSFRow) rows.next();
					bill = new Bill(String.valueOf(aRow.getCell(0).getNumericCellValue()), aRow.getCell(1).toString(), aRow.getCell(2).toString(),
							aRow.getCell(3).toString(), aRow.getCell(4).toString(), aRow.getCell(5).toString(), aRow.getCell(6).toString(),
							aRow.getCell(7).toString(), aRow.getCell(8).toString(), aRow.getCell(9).toString(), aRow.getCell(10).toString(), 
							aRow.getCell(11).toString(), aRow.getCell(12).toString());
//					System.out.println(bill.toString());
					PROCESSED_BIL.add(bill);
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

	public static void writeFile() throws IOException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss.SSS");
		String fileName = "GHMC_Pending_Bills"+dateFormat.format(new Date())+".xlsx";		
		File aFile  = new File(FILE_NEW+fileName);
		if(!aFile.exists())
			aFile.createNewFile();

		FileOutputStream fileOutputStream = null;
		XSSFWorkbook aWorkbook = null;
		XSSFSheet aSheet = null;


		try {
			System.out.println("Writing Start");

			fileOutputStream = new FileOutputStream(aFile);
			aWorkbook = new XSSFWorkbook();
			aSheet = aWorkbook.createSheet("DATA");

			CreationHelper creationHelper = aWorkbook.getCreationHelper();

			XSSFRow row = aSheet.createRow(0);
			XSSFCell cell =  row.createCell(0);
			cell.setCellValue("Sl.No.");
			
			cell =  row.createCell(1);
			cell.setCellValue("Vehicle No.");
			
			cell =  row.createCell(2);				
			cell.setCellValue("GHMC Indent No.");

			cell =  row.createCell(3);
			cell.setCellValue("GHMC Indent No.");

			cell =  row.createCell(4);
			cell.setCellValue("Our Delivery Challan No.");
		
			cell =  row.createCell(5);
			cell.setCellValue("GHMC Order No.");

			cell =  row.createCell(6);
			cell.setCellValue("GHMC Order No.");
						
			cell =  row.createCell(7);
			cell.setCellValue("Date of GHMC Order");
			
			cell =  row.createCell(8);
			cell.setCellValue("Date of GHMC Order");

			cell =  row.createCell(9);
			cell.setCellValue("Claimed Amount");
			
			cell =  row.createCell(10);
			cell.setCellValue("Sanctioned Amount");
			
			cell =  row.createCell(11);
			cell.setCellValue("Difference Amount");
			
			cell =  row.createCell(12);			
			cell.setCellValue("No. of Months  delay of payment by GHMC");
			
			cell =  row.createCell(13);			
			cell.setCellValue("5% p.m. Financial Charges for the delayed period");
			
			cell =  row.createCell(14);			
			cell.setCellValue("Net amount receivable from GHMC as on 31.08.2015");
			
			cell =  row.createCell(15);
			cell.setCellValue("Remarks");

			 
			for (int rowCount = 1 ; rowCount <= PROCESSED_BIL.size() ; rowCount++) {
				row = aSheet.createRow(rowCount);

				Bill bill = PROCESSED_BIL.get(rowCount-1);

				String slNo = bill.getSlNo();
				cell =  row.createCell(0);
				cell.setCellType(CellType.NUMERIC);
				cell.setCellValue(slNo);

				String vehicalNo = bill.getVehicalNo();
				
				CellStyle numericStyle = aWorkbook.createCellStyle();
				numericStyle.setDataFormat(creationHelper.createDataFormat().getFormat("0"));
				cell =  row.createCell(1);
				
				if(vehicalNo == null || vehicalNo.trim().isEmpty()) { cell.setBlank(); } else {cell.setCellValue(vehicalNo);}

				String getGhmcIndentNo1 = bill.getGhmcIndentNo1();
				
				cell =  row.createCell(2);				
				if(getGhmcIndentNo1 == null || getGhmcIndentNo1.trim().isEmpty()) { cell.setBlank(); } else {cell.setCellValue(getGhmcIndentNo1);}

				String getGhmcIndentNo2 = bill.getGhmcIndentNo2();
				
				cell =  row.createCell(3);
				if(getGhmcIndentNo2 == null || getGhmcIndentNo2.trim().isEmpty()) { cell.setBlank(); } else {cell.setCellValue(getGhmcIndentNo2);}

				String ourDeliveryChallanNo = bill.getOurDeliveryChallanNo();
				
				cell =  row.createCell(4);
				if(ourDeliveryChallanNo == null || ourDeliveryChallanNo.trim().isEmpty()) { cell.setBlank(); } else {cell.setCellValue(ourDeliveryChallanNo);}

				String getGhmcOrderNo1 = bill.getGhmcOrderNo1();
				
				cell =  row.createCell(5);
				if(getGhmcOrderNo1 == null || getGhmcOrderNo1.trim().isEmpty()) { cell.setBlank(); } else {cell.setCellValue(getGhmcOrderNo1);}

				String getGhmcOrderNo2 = bill.getGhmcOrderNo2();
				
				cell =  row.createCell(6);
				if(getGhmcOrderNo2 == null || getGhmcOrderNo2.trim().isEmpty()) { cell.setBlank(); } else {cell.setCellValue(getGhmcOrderNo2);}

				CellStyle dateStyle = aWorkbook.createCellStyle();
				dateStyle.setDataFormat(creationHelper.createDataFormat().getFormat("dd/MM/yy"));
				String getGhmcOrderDate = bill.getGhmcOrderDate();
				
				cell =  row.createCell(7);
				cell.setCellStyle(dateStyle);
				if(getGhmcOrderDate == null || getGhmcOrderDate.trim().isEmpty()) { cell.setBlank(); } else {cell.setCellValue(getGhmcOrderDate);}

				
				cell =  row.createCell(8);
				if(getGhmcOrderDate == null || getGhmcOrderDate.trim().isEmpty()) { cell.setBlank(); } else {cell.setCellValue(bill.getNewOrderDate());}

				
				String getClaimedAmount = bill.getClaimedAmount();
				
				cell =  row.createCell(9);
				if(getClaimedAmount == null || getClaimedAmount.trim().isEmpty()) { cell.setCellValue(Double.valueOf(0)); } 
				else {cell.setCellValue(Double.valueOf(getClaimedAmount));}

				String getSanctionedAmount = bill.getSanctionedAmount();
				
				cell =  row.createCell(10);
				if(getSanctionedAmount == null || getSanctionedAmount.trim().isEmpty()) { cell.setCellValue(Double.valueOf(0)); } 
				else {cell.setCellValue(Double.valueOf(getSanctionedAmount));}

				cell =  row.createCell(12);
				if(getGhmcOrderDate == null || getGhmcOrderDate.trim().isEmpty()) { cell.setBlank(); } else {
					dateFormat = new SimpleDateFormat("dd/MM/yy");
					Calendar orderDay = new GregorianCalendar();
					orderDay.setTime(dateFormat.parse(getGhmcOrderDate));
					Calendar today = new GregorianCalendar();
					today.setTime(new Date());

					int yearsInBetween = today.get(Calendar.YEAR) - orderDay.get(Calendar.YEAR); 
					int monthsDiff = today.get(Calendar.MONTH) - orderDay.get(Calendar.MONTH);
					long months = yearsInBetween*12 + monthsDiff;
					cell.setCellValue(Double.valueOf(months));
				}
				
				String getRemarks = bill.getRemarks();
				cell =  row.createCell(15);
				if(getRemarks == null || getRemarks.trim().isEmpty()) { cell.setBlank(); } 
				else {cell.setCellValue(getRemarks);}

				
				

			}

			aWorkbook.write(fileOutputStream);
			System.out.println("Writing END");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {		
			if(fileOutputStream != null)
				fileOutputStream.close();
		}

	}


}
