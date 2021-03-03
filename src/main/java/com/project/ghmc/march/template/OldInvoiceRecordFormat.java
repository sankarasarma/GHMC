package com.project.ghmc.march.template;

import java.util.Date;

public class OldInvoiceRecordFormat {

	private final Integer SERIAL_NUMBER;
	private final String VEHICAL_NUMBER;
	private final String INDENT_NUMBER;
	private final Integer QUOTATION_NUMBER;
	private final Date DATE;
	private final Integer CLAIMED_AMOUNT;
	private final String PAID_AMOUNT;
	private final String DIFFERENCE_AMOUNT;
	private final Integer NUMBER_OF_MONTHS_DELAYED;
	private final Integer FINANCIAL_CHARGES;
	private final Integer RECIEVABLES;
	private final String REMARKS;

	public OldInvoiceRecordFormat(Integer SERIAL_NUMBER, String VEHICAL_NUMBER, String INDENT_NUMBER, 
			Integer QUOTATION_NUMBER, Date DATE, Integer CLAIMED_AMOUNT, String PAID_AMOUNT, 
			String DIFFERENCE_AMOUNT, Integer NUMBER_OF_MONTHS_DELAYED, Integer FINANCIAL_CHARGES,
			Integer RECIEVABLES, String REMARKS) {
		this.SERIAL_NUMBER = SERIAL_NUMBER;
		this.VEHICAL_NUMBER = VEHICAL_NUMBER;
		this.INDENT_NUMBER = INDENT_NUMBER;
		this.QUOTATION_NUMBER = QUOTATION_NUMBER;
		this.DATE = DATE;
		this.CLAIMED_AMOUNT = CLAIMED_AMOUNT;
		this.PAID_AMOUNT= PAID_AMOUNT;
		this.DIFFERENCE_AMOUNT = DIFFERENCE_AMOUNT;
		this.NUMBER_OF_MONTHS_DELAYED = NUMBER_OF_MONTHS_DELAYED;
		this.FINANCIAL_CHARGES = FINANCIAL_CHARGES;
		this.RECIEVABLES = RECIEVABLES;
		this.REMARKS = REMARKS;
		
	}

	@Override
	public String toString() {
		StringBuilder oldInvoiceRecord = new StringBuilder(1024);
		oldInvoiceRecord.append(this.SERIAL_NUMBER).append("-");
		oldInvoiceRecord.append(this.VEHICAL_NUMBER).append("-");
		oldInvoiceRecord.append(this.INDENT_NUMBER).append("-");
		oldInvoiceRecord.append(this.QUOTATION_NUMBER).append("-");
		oldInvoiceRecord.append(this.DATE).append("-");
		oldInvoiceRecord.append(this.CLAIMED_AMOUNT).append("-");
		oldInvoiceRecord.append(this.PAID_AMOUNT).append("-");
		oldInvoiceRecord.append(this.REMARKS);
		return oldInvoiceRecord.toString();
	}

}
