package com.sparky.dbutils.ro;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sparky.commonvariables.ro.CommonVariables;

public class DBUtils {
	
	public static String ZIPCODE,PHONE_NO,ALT_PHONE;
	
	public static String getALT_PHONE() {
		return ALT_PHONE;
	}

	public static void setALT_PHONE(String aLT_PHONE) {
		ALT_PHONE = aLT_PHONE;
	}

	public static String getZIPCODE() {
		return ZIPCODE;
	}

	public static void setZIPCODE(String zIPCODE) {
		ZIPCODE = zIPCODE;
	}

	public static String getPHONE_NO() {
		return PHONE_NO;
	}

	public static void setPHONE_NO(String pHONE_NO) {
		PHONE_NO = pHONE_NO;
	}

	public static void auditLog(String module,String applicationname,String testmethodname,String result,String screenshotpath, String username) {
	if(!CommonVariables.REGION.equalsIgnoreCase("LMDC")) {	
		java.sql.Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName(CommonVariables.CONNECTOR);
			conn = DriverManager.getConnection(CommonVariables.DB_ENDPOINT, CommonVariables.DB_USER, CommonVariables.DB_PWD);
			System.out.println("Connected database successfully...");
			stmt = conn.createStatement();
			PreparedStatement preparedStmt = conn.prepareStatement("INSERT into audit_log ( module, application,test_name,test_result,execute_datetime,scrnshot_path,workstationID,user_id) VALUES(?,?,?,?,?,?,?,?)",
					stmt.RETURN_GENERATED_KEYS);   
			preparedStmt.setString(1,module);
			preparedStmt.setString(2,applicationname);
			preparedStmt.setString(3,testmethodname);
			preparedStmt.setString(4,result);
			preparedStmt.setTimestamp(5, new java.sql.Timestamp(new java.util.Date().getTime()));                           
			preparedStmt.setString(6, screenshotpath);
			preparedStmt.setString(7, System.getenv("COMPUTERNAME"));
			preparedStmt.setString(8, username);
			preparedStmt.executeUpdate(); 
			ResultSet tableKeys = preparedStmt.getGeneratedKeys();
			tableKeys.next();
			System.out.println("Records Added Sucessfully");
		}

		catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}
		catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}

		finally{
			//finally block used to close resources
			try{
				if(stmt!=null)
					conn.close();
			}

			catch(SQLException se){
			}

			try{
				if(conn!=null)
					conn.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}//end try

	}//end main
	}
	
	public static void returnZipCode() throws Exception {
    
          // This will load the MySQL driver, each DB has its own driver
        	java.sql.Connection conn = null;
    		Statement stmt = null;
    		String query = "select distinct zipcode,phone_no,alt_phone from lk_zipcode order by RAND() LIMIT 1";
    		String zip = null;
			try{
    			Class.forName(CommonVariables.CONNECTOR);
    			conn = DriverManager.getConnection(CommonVariables.DB_ENDPOINT, CommonVariables.DB_USER, CommonVariables.DB_PWD);
    			System.out.println("Connected database successfully...");
    		   
    			stmt = conn.createStatement();
    			 ResultSet rs = stmt.executeQuery(query);
    			
    			 while (rs.next()) {
    				 ZIPCODE = rs.getString("zipcode").toString().trim();
    				 PHONE_NO = rs.getString("phone_no").toString().trim();
    				 ALT_PHONE = rs.getString("alt_phone").toString().trim();
 		            			
    			 }
    			
    			
        }catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}
		catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}

		finally{
			//finally block used to close resources
			try{
				if(stmt!=null)
					conn.close();
			}

			catch(SQLException se){
			}

			try{
				if(conn!=null)
					conn.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}//end try
			
	}
	//end main
}
	
