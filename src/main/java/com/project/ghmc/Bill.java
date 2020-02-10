package com.project.ghmc;

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
		this.ghmcOrderDate = ghmcOrderDate;// 9
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

}
