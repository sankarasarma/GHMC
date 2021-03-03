package com.project.ghmc.march.template;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Date;

public class Bill {

	private String slNo;
	private String vehicalNo;
	private String ghmcIndentNo1;
	private String ghmcIndentNo2;
	private String ourQuotationNo;
	private String ourDeliveryChallanNo;
	private String ghmcOrderNo1;
	private String ghmcOrderNo2;
	private String ghmcOrderDate;
	private String newOrderDate;
	private String claimedAmount;
	private String sanctionedAmount;
	private String months;
	private String remarks;

	public Bill( String slNo, String vehicalNo, String ghmcIndentNo1, String ghmcIndentNo2, String ourQuotationNo, String ourDeliveryChallanNo,
			String ghmcOrderNo1, String ghmcOrderNo2, String ghmcOrderDate, String claimedAmount, String sanctionedAmount, String months,
			String remarks) {
		this.slNo = slNo;// 1
		this.vehicalNo = vehicalNo;// 2		
		this.ghmcIndentNo1 = ghmcIndentNo1;// 3
		this.ghmcIndentNo2 = ghmcIndentNo2;// 4
		this.ourQuotationNo = ourQuotationNo;// 5
		this.ourDeliveryChallanNo = ourDeliveryChallanNo;// 6
		this.ghmcOrderNo1 = ghmcOrderNo1;// 7
		this.ghmcOrderNo2 = ghmcOrderNo2;// 8
		if(ghmcOrderDate != null && !ghmcOrderDate.toString().isEmpty()) {
			String oldDate  =  ghmcOrderDate;
			int start = oldDate.indexOf(".");
			int end = oldDate.lastIndexOf(".");			
			String year = oldDate.substring(oldDate.lastIndexOf(".")+1);
			String month = oldDate.substring(start+1,end);
			String day = oldDate.substring(0,start);

			SimpleDateFormat validDateFormat = new SimpleDateFormat("dd-MM-yy");
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
			SimpleDateFormat newdateFormat = new SimpleDateFormat("yy/MM/dd");
			try {
			if(year.length() == 4 | year.length() == 2) {
				String dayFormat = day.length() == 2 ? day : "0"+day;
				String monthFormat = month.length() == 2 ? month : "0"+month;
				String yearFormat = year.length() == 4 ? year.substring(2) : year;
				String date = dayFormat+"-"+monthFormat+"-"+yearFormat;
				String newdate = yearFormat+"-"+monthFormat+"-"+date;
				Date tempDate = validDateFormat.parse(date);
//				 System.out.println(slNo+"|"+oldDate+"|"+date+"|"+dateFormat.format(tempDate));
				this.ghmcOrderDate = dateFormat.format(tempDate);
				this.newOrderDate = newdateFormat.format(tempDate);
			} else {
				System.out.println("Invalid Date - "+year+"-"+slNo);
			}
			} catch (Exception e) {
				System.out.println(slNo+"-"+e.getMessage());
			}

		} else {
			System.out.println(this.slNo);
			this.ghmcOrderDate = ghmcOrderDate;
		}
		// 9
		this.claimedAmount = claimedAmount;// 10
		this.sanctionedAmount = sanctionedAmount;// 11
		this.months = months;// 12
		this.remarks = remarks;// 13
	}



	@Override
	public String toString() {
		StringBuilder bill = new StringBuilder();
		bill.append(this.slNo).append("-");
		bill.append(this.vehicalNo).append("-");
		bill.append(this.ghmcIndentNo1).append("-");
		bill.append(this.ghmcIndentNo2).append("-");
		bill.append(this.ourQuotationNo).append("-");
		bill.append(this.ourDeliveryChallanNo).append("-");
		bill.append(this.ghmcOrderNo1).append("-");
		bill.append(this.ghmcOrderNo2).append("-");
		bill.append(this.ghmcOrderDate).append("-");
		bill.append(this.claimedAmount).append("-");
		bill.append(this.sanctionedAmount).append("-");
		bill.append(this.months).append("-");
		bill.append(this.remarks);
		return bill.toString();

	}

	public String getNewOrderDate() {
		return newOrderDate;
	}

	public String getSlNo() {
		return slNo;
	}



	public String getVehicalNo() {
		return vehicalNo;
	}



	public String getGhmcIndentNo1() {
		return ghmcIndentNo1;
	}



	public String getGhmcIndentNo2() {
		return ghmcIndentNo2;
	}



	public String getOurQuotationNo() {
		return ourQuotationNo;
	}



	public String getOurDeliveryChallanNo() {
		return ourDeliveryChallanNo;
	}



	public String getGhmcOrderNo1() {
		return ghmcOrderNo1;
	}



	public String getGhmcOrderNo2() {
		return ghmcOrderNo2;
	}



	public String getGhmcOrderDate() {
		return ghmcOrderDate;
	}



	public String getClaimedAmount() {
		return claimedAmount;
	}



	public String getSanctionedAmount() {
		return sanctionedAmount;
	}



	public String getMonths() {
		return months;
	}



	public String getRemarks() {
		return remarks;
	}

}
