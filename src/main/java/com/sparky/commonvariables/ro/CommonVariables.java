package com.sparky.commonvariables.ro;

import java.util.ArrayList;

public class CommonVariables  {

	public static CommonVariables CommonVariables = new CommonVariables();

	public static String REPORT_PATH = "./Output/CMMI_Execution/";


	//**********Driver Path variables
	public static String GECKO_DRIVER_PATH = System.getProperty("user.dir")+ "\\src\\main\\resources\\Drivers\\geckodriver.exe";
	public static String CHROME_DRIVER_PATH = System.getProperty("user.dir")+ "\\src\\main\\resources\\Drivers\\chromedriver.exe";


	// *********Screen Shot Variables
	public static String SCREENSHOT_PATH;
	public static String EXECUTION_FOLDER_PATH ;
	public static String EXECUTION_SUBFOLDER_PATH;
	public static String SCREENSHOT_SUBFOLDER_PATH;

	//Initialize Variables
	public static String EXECUTETESTGROUP;
	public static String EXECUTETESTGROUPTOBEEXECUTED;

	//public static String BROWSERSELECT = "FirefoxDownload";
	public static String BROWSERSELECT = "Chrome";

	//*********Application Function Variables********//

	public static String DOWNLOAD_OR_ICLICK;
	public static String LMDC_URL = "https://portaldev.cms.gov/wps/portal/unauthportal/home/";
	public static String DOWNLOAD_FILEPATHLOCAL =  System.getProperty("user.dir")+ "/Download_File";
	public static String ARCHIVE_FILEPATHLOCAL =  System.getProperty("user.dir")+ "//"+"Download_File"+"//"+"Archive";
	public static String TextValPropertyFilePath =System.getProperty("user.dir")+"\\src\\main\\resources\\PropertyFiles\\Textvalidations.properties";;
	public static String UPLOAD_FILEPATHLOCAL =  System.getProperty("user.dir")+ "/Upload_File";


	public static String EIDMID = "JK_MDPCP_CTOUSER1";
	public static String PRACID = "JK_MDPCP_PRACTICEUSER1";
	public static String REQHISTORY_SHEETNAME="Workflow Request History";
	public static String REQHISTORY_FILENAME="RequestHistory_";

	public static String RequestTypeText= "All";
	public static String RequestStatusText= "All";
	public static String DocumentCatText= "Resources";

	public static String dropdownItems = "100";

	public static String UPLD_FILENAME ="TESTFILE.xlsx";
	public static String UPLD_FILENAMETYPE ="EPPE Batch Processing Template";
	public static String DELFILES_FROMDT ="09/07/2018";
	public static String DELFILES_ENDDT ="09/30/2018";
	public static String DELFILE_EXPORTEDFILENAME ="AvailableFiles.xlsx";
	public static String DELFILE_EXPORTEDSHEETNAME ="AvailableFiles";

	public static String REGION ="LMDC";

	public static String DELFILESTYPE = "Beneficiary Attribution Report" ;
	public static String DEL_DOCCAT_EXT = "CTO Documents" ;

	public static String CTOPA_FILENAME="CTOPracticeAssociation_Details.xlsx";
	public static String CTOPA_SHEETNAME="CTOPracticeAssociation_Details";

	public static String CTOTYPE_LBL="Active";

	public static int WT_ROWCOUNT;
	public static int WT_COLCOUNT;
	public static int ROWITERATE;
	public static String CLICKCOL;
	public static String EXPECTED_ROWVALUE;
	public static String EXPECTED_COLVALUE;
	public static String ACTUAL_ROWVALUE;
	public static int COL_ITERATE;

	public static String ACTUAL_COLVALUE;

	public static String NEXT_BTN_ATTRIBUTE;

	public static String NPI_NUMBER;
	public static String COMPRPT_PRACID = "T1MD0033";
	public static String COMPRPT_NAME = "CompositionReportRealTime";
	
	
	
	
	
	//*********************Added 02/11/19******************************************/
	
	public static String DB_ENDPOINT ="jdbc:mysql://spark.cfuiwit3kvcr.us-east-1.rds.amazonaws.com/cmmi_ivv";
	public static String DB_USER ="spark";
	public static String DB_PWD ="SparkCloud2016!!";
	public static String CONNECTOR = "com.mysql.cj.jdbc.Driver";
	public static String NSFMODULE ="NON_SALESFORCE";
	public static String NSFMODULE_NAME ="AHC";
	public static String FAIL_RESULT ="Failed";
	public static String PASS_RESULT ="Passed";


	public static String DATA[][];		
	public static String ACTUALSTATUSSTRING;

	/***Excel Sheet Common Variables**/

	public static String INPUT_EXCELFILE = "./Input/icmmiSparksoft.xlsx";
	public static String FILEPATH = INPUT_EXCELFILE;
	public static String SHEET = "iTestCaseSheet";
	public static String MY_IMAGEFOLDER = "./Output/CMMI_Execution";
	public static String APP_BROWSERSEL ="FireFox";
	public static String APP_BROWSERFILE ="FireFoxProfile";	
	public static String APP_EXECUTIONSTATUS;
	public static String ITABLEID = "participantsTable";

	public static int TXT_VAL_ROWNUM;
	public static String TXT_VAL_TESTID;
	public static String TXT_VAL_UID;
	public static String TEXT_VAL_EXPVALUE;
	public static String ACTUAL_STATUS_STRING = null;
	public static String TEXT_VAL_ACTVALUE;
	public static String TXT_VAL_COMPRE_RESULTS;
	public static String TXT_VAL_SHEET = "iAARegAttributeValidation";
	public static String INITIALIZE_PATH = System.getProperty("user.dir")+ "\\iSourceFiles\\CmmiSparksoft.xlsx";
	public static  String DTPRV_SOURCE_FILE = System.getProperty("user.dir")+"\\iSourceFiles\\iAAcmmiSparksoft.xlsx";
	public static String SCREENSHOTSUBFOLDERPATH = System.getProperty("user.dir")+"\\Output";
	public static String EXL_TEXTVALIDATIONSHEET = "iAARegAttributeValidation";
	public static int EXL_TXTVALIDATION_ROWNUM;
	public static int WT_ROW_CNT;
	public static int WT_COL_CNT;
	public static int ROW_ITRT;
	public static String GET_OR_CLICK;
	public static String EXP_ROW_VALUE;
	public static String EXP_COl_VALUE;
	public static String ACT_ROW_VALUE;
	public static int COl_ITERATE;
	public static String ACT_COL_VALUE;
	public static String GET_NXT_BTN_STATUS;

	public static String IUSERPATTERN;
	public static int IWEBTABLEROWCOUNT;
	public static int IWEBTABLECOLUMNCOUNT;
	public static int IROWITERATE;
	public static int ICOLUMNITERATE;
	public static String IGETNEXTBUTTONSTATUS;
	public static String IGETORICLICK;
	public static String IEXPECTROWVALUE;
	public static CharSequence IEXPECTEDROWVALUE;
	public static String IEXPECTCOLUMNVALUE;
	public static String IACTUALROWVALUE;
	public static String IACTUALCOLUMNVALUE;

	public static String APP_BROW_SEL ="Gecko";


	public static CharSequence FIRSTNAME;
	public static CharSequence DATEOFBIRTH;

	public static CharSequence EnterString;


	public static String EDITBENENAME ;
	public static String MEDNO ;


	public static String COL_VALUES;
	public static int COL_ITRT;
	public static String MONTHTODATE_VAL_INITIAL;
	public static String YEARTODATE_VAL_INITIAL;
	public static String MODELTODATE_VAL_INITIAL;
	public static String CUSTOMDATERANGE_VAL_INITIAL_ILLUSREPO;
	public static String CUSTOMDATERANGE_VAL_FINAL_ILLUSREPO;
	public static String CUSTOMDATERANGE_VAL_INITIAL_COMPSREPO;
	public static String CUSTOMDATERANGE_VAL_FINAL_COMPSREPO;

	public static String MONTHTODATE_VAL_FINAL;
	public static String YEARTODATE_VAL_FINAL;
	public static String MODELTODATE_VAL_FINAL;
	public static String CUSTOMDATERANGE_VAL_FINAL;
	public static String[] WaitlistInitial_IllusReport;
	public static String[] WaitlistFinal_IllusReport;



	//App CommonVariables
	/***Application Login Variables***/
	public static String AHC_SNS_USER = "IVVPerfUser113";
	public static String AHC_SNS_PWD = "Sp@rky19";	
	public static String AHC_BO_NAME = "IVV Bridge Org 6 SNS 3";
	public static String AHC_ORG_NAME = "IVV Bridge Org 6";
	public static String AHC_BO_USERID = "IVVPerfUser47";
	public static String AHC_BO_PWD = "S@mmer19";	
	public static String AHC_HELPDESK_USER = "IVVPerfUser151";
	public static String AHC_HELPDESK_PWD = "Sp@rky19";

	public static String VAL_URL = "https://portaldev.cms.gov/wps/portal/unauthportal/home/";
	public static String VAL_SELF_REG = "https://portaldev.cms.gov/wps/portal/unauthportal/ic/ahc/icbss_wsrp";
	public static String PROD_AHC = "https://portaldev.cms.gov/wps/portal/unauthportal/home/";
	public static String VAL_AHC_SCRNURL = "https://portaldev.cms.gov/wps/myportal/cmsportal/ic/ahc_wsrp/#!/1116064";

	/***Self Register common variables***/
	public static String LAST_NAME;
	public static String FIRST_NAME = "IVVTest";
	public static String DOB1 = "01/01/1980";
	public static String MEDICARE_HICN;
	public static String MEDICAID_ID;
	public static String MEDICARE_NUMBER;
	public static String CVALUE2;
	public static String MG_LNAME;
	public static String MG_EMAIL;
	public static CharSequence ENTERSTRING;
	public static CharSequence NUMBER;
	public static CharSequence EMAIL;
	public static String CELLVALUE;
	public static boolean STA_OF_DRPDWN;
	public static String USERID_AHC_SNS = "IVVPerfUser123";
	public static String PASSWORD_AHC_SNS = "S@mmer19";
	public static String BRIDGE_ORG_AHC = "IVV Bridge Org 6 SNS 3";
	public static String BO_USER2 = "IVV Bridge Org 6 SNS 2";	
	public static String LAST_NAME1;
	public static String FIRST_NAME1;
	public static String DATE_OF_BIRTH = "01/01/1979";
	public static String MEDICARE_HICN1;
	public static String MEDICAID_ID1;
	public static String MEDICARE_NUMBER1;
	public static String USER_ID_AHC = "IVVPerfUser123";
	public static String PASSWORD_AHC = "S@mmer19";	

	/***Screenshot and Excel sheet Common Variables***/
	public static String LOGGER_STATUS;
	public static String SCRNSHOT;
	public static String LOGGER_SCRNSHT;
	public static String DOWNLD_PATH =  System.getProperty("user.dir")+ "\\iDownload_File";

	/***AHC Application specific variables***/
	public static String QUATER_SELECTION = "2018-Q1";
	public static String STRT_SCREENBTN = "Start Screening";
	public static String NEXT_BTN = "Next";
	public static String HOME_BTN = "Home";
	public static String SUBMIT_BTN = "Submit";
	public static String NAV_BTN = "Navigate (Our cases)";
	public static String ZIPCODE = "21030";
	public static String DOB= "01/02/1970";
	public static String SRCH_BTN = "Search";
	public static String CONTINUE_ENCOUNTER = "Continue Encounter";

	/***Array List Common Variables***/
	public static ArrayList<String> PMT_TABLE_ROWVALUES = new ArrayList<String>();
	public static ArrayList<String> PMY_TABLE_COLVALUES = new ArrayList<String>();
	public static ArrayList<String> LOGGER_VAR =new ArrayList<String>();
	public static ArrayList<String> LOGGER_EXP_PASSVAR = new ArrayList <String>() ;
	public static ArrayList<String> LOGGER_FAIL_VAR;

	/***Edit Bene Common Variables***/
	public static String prev_HICN = null, prev_Medicaid = null, prev_Medicare = null, prev_ZipCode = null, prev_MainPhone = null, prev_AltPhone = null;

	//5/23

	public static String USERROLE_SNS = "SNS";
	public static String USERROLE_APPADMIN = "APPADMIN";
	public static String USERROLE_HD = "HELPDESK";
	public static String USERROLE_BUSINESSOWN = "BO";
	public static String USERROLE_PROJECTOFFICER = "PO";
	public static String USERROLE_NONCMS = "Non-CMS";
	public static String USERROLE_BRGORG = "BrgOrg";
	public static String USERROLE_IMPCONT = "IC";

	public static String iCellValue2;
	public static String DOB_SRCH;

	public static String Bridge_Org_AHC = "IVV Bridge Org 6 SNS 3";
	public static String INPUT_FILE = System.getProperty("user.dir")+"\\iSourceFiles\\iAAcmmiSparksoft.xlsx";
	public static String TEXTVAL_SHEET = "Text_Validation";

	public static String CASE_STATUS = "Open";
	public static String DOWNLD_FILEPTH =  System.getProperty("user.dir")+ "\\Download_File";
	public static String BACKTOSEARCH ="Back to Search";
	public static String DELETE_BTN="Delete";
	
	public static String filePath = System.getProperty("user.dir")+"//Source_Files//";
	public static String fileName = "CmmiSparksoft.xlsx";

	public static String CONFIRM ="Confirm";
	
	
}