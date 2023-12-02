package com.inquiry;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.customer.DBConnect;
import com.mysql.jdbc.Statement;



public class InquiryDBUtil {
	
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
    
	
	
public static boolean insertInquiry(String inname, String inemail,String intype, String inmessage) {
    	
    	boolean isSuccess = false;
    	
    	
    	try {
    		con = DBConnect.getConnection();
    		stmt = (Statement) con.createStatement();
    	    String sql = "insert into inquiry values (0,'"+inname+"','"+inemail+"','"+intype+"','"+inmessage+"')";
    	   
            int rs = stmt.executeUpdate(sql);
          
    		
    		if(rs > 0) {
    			isSuccess = true;
    		} else {
    			isSuccess = false;
    		}
    		
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
 	
    	return isSuccess;
    }
public static List<Inquiry> getInquiryDetails(String iEmail) {
    
    ArrayList<Inquiry> inquiries = new ArrayList<>();

    try {
        con = DBConnect.getConnection();
        stmt = (Statement) con.createStatement();
        String sql = "SELECT * FROM inquiry WHERE inemail='"+iEmail+"'";
        rs = stmt.executeQuery(sql);

        while (rs.next()) {
            int inquiryNo = rs.getInt(1);
            String inname = rs.getString(2);
            String inemail = rs.getString(3);
            String intype = rs.getString(4);
            String inmessage = rs.getString(5);

            Inquiry inquiry = new Inquiry(inquiryNo, inname, inemail, intype, inmessage);
            inquiries.add(inquiry);
        }

        
        
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    return inquiries;
}
public static boolean updateinquiry(String inquiryNo, String inname, String inemail, String intype, String inmessage) {
	
	try {
		
		con = DBConnect.getConnection();
		stmt = (Statement) con.createStatement();
		String sql = "update inquiry set inname='"+inname+"',inemail='"+inemail+"',intype='"+intype+"',inmessage='"+inmessage+"'"
				+ "where inquiryNo='"+inquiryNo+"'";
		int rs = stmt.executeUpdate(sql);
		
		if(rs > 0) {
			isSuccess = true;
		}
		else {
			isSuccess = false;
		}
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
	return isSuccess;
}



public static boolean deleteInquiry(String inquiryNo) {
	
	int convId = Integer.parseInt(inquiryNo);
	
	try {
		
		con = DBConnect.getConnection();
		stmt = (Statement) con.createStatement();
		String sql = "delete from inquiry where inquiryNo ='"+convId+"'";
		int r = stmt.executeUpdate(sql);
		
		if (r > 0) {
			isSuccess = true;
		}
		else {
			isSuccess = false;
		}
		
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	
	return isSuccess;
}

public static List<Inquiry> getAllInquiries() {
    List<Inquiry> inquiries = new ArrayList<>();

    try {
        con = DBConnect.getConnection();
        String sql = "SELECT * FROM inquiry";
        stmt = (Statement) con.createStatement();
        rs = stmt.executeQuery(sql);
        
        while (rs.next()) {
            int inquiryNo = rs.getInt("inquiryNo");
            String inname = rs.getString("inname");
            String inemail = rs.getString("inemail");
            String intype = rs.getString("intype");
            String inmessage = rs.getString("inmessage");

            Inquiry inquiry = new Inquiry(inquiryNo, inname, inemail, intype, inmessage);
            inquiries.add(inquiry);
        }
    } catch (Exception e) {
        e.printStackTrace();
    } 

    return inquiries;
}
}










