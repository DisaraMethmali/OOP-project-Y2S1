package com.inquiry;


public class Inquiry{
private int inquiryNo;
private String inname;
private String inemail;
private String intype;
private String inmessage;
public Inquiry(int inquiryNo, String inname, String inemail,String intype, String inmessage) {
	
	this.inquiryNo = inquiryNo;
	this.inname = inname;
	this.inemail = inemail;
	this.intype = intype;
	this.inmessage = inmessage;
}
public String getIntype() {
	return intype;
}
public int getInquiryNo() {
	return inquiryNo;
}
public String getInname() {
	return inname;
}
public String getInemail() {
	return inemail;
}
public String getInmessage() {
	return inmessage;
}

}