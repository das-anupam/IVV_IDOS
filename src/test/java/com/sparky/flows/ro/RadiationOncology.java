package com.sparky.flows.ro;


import java.util.ArrayList;
import java.util.HashMap;
import org.apache.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.sparky.commonfunctions.ro.*;
import com.sparky.commonvariables.ro.*;
import com.sparky.helper.ro.Helper;
import com.sparky.helper.ro.LogAccess;
import com.sparky.helper.ro.Processor;
import com.sparky.listeners.ro.RetryAnalyzer;
import com.sparky.model.ro.RO;
import com.sparky.pagefunctions.ro.AppAdminPageFunctions;
import com.sparky.pagefunctions.ro.BusinessOwnerPageFunctions;
import com.sparky.pagefunctions.ro.LoginPageFunction;



@Listeners(com.sparky.listeners.ro.Listener.class)
public class RadiationOncology {

	public RadiationOncology() {
		super();


	}

	public static WebDriver driver;
	public static String EXECUTE_TST_GRP;
	public static String EXECTN_FOLDR_PATH;
	public static String EXECTN_SUBFLDR_PATH;
	public static String SCREENSHOT_SUBFOLDER_PATH;
	public static String SCREENSHOT_NAME;
	public static String TEST_NAME;
	static HashMap<String,String> userIDmap=null;
	static String userID=null;
	static String runTC=null;
	static String uname=null;
	static String pwd=null;
	static String role=null;
	static String brgOrg = null;
	static String track = null;
	static String screenSite = null;
	static double practiceid;
	public static ArrayList<String> UserIDList=new ArrayList<String>();
	static CommonFunction Setup=null;
	static ArrayList<RO> roList=null;
	public static Processor processor = null;
	public static Helper helper = null;
	String methodName;
	SoftAssert sa = new SoftAssert();


	public static String getSCREENSHOT_SUBFOLDER_PATH() {
		return SCREENSHOT_SUBFOLDER_PATH;
	}


	public static void setSCREENSHOT_SUBFOLDER_PATH(String sCREENSHOT_SUBFOLDER_PATH) {
		SCREENSHOT_SUBFOLDER_PATH = sCREENSHOT_SUBFOLDER_PATH;
	}

	public static String getTEST_NAME() {
		return TEST_NAME;
	}


	public static void setTEST_NAME(String tEST_NAME) {
		TEST_NAME = tEST_NAME;
	}

	@SuppressWarnings("static-access")
	@Test(enabled=false,priority=0, dataProvider = "getData", groups = {"ROFlows"},retryAnalyzer=RetryAnalyzer.class)
	public void BusinessOwner(RO vo) throws Exception {
		methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		System.out.println("Method Name is:" +methodName);
		System.out.println("***********************************************************************************");

		if(vo.getExecuteFlag().equalsIgnoreCase("Y") && vo.getRole().contains("RO_BO"))
		{
			System.setProperty("fileName", vo.getRole());

			LogManager.resetConfiguration();

			LogAccess.setInitializationFlag(false);

			LogAccess.setFileName(System.getProperty("fileName") );

			LogAccess.getLogger().info("FileName in Main Script class is: "+LogAccess.getFileName());

			LogAccess.getLogger().info("***********************************************************************************");

			LogAccess.getLogger().info("The values are: "+vo.getRole()+"-->"+vo.getExecuteFlag()+"-->"+vo.getUserid());

			try
			{

				EXECUTE_TST_GRP = "_" +  vo.getRole() + "_";
				EXECTN_FOLDR_PATH = CommonFunction.createFolder(CommonVariables.REPORT_PATH + EXECUTE_TST_GRP,
						"_"+methodName);
				SCREENSHOT_SUBFOLDER_PATH = CommonVariables.REPORT_PATH + EXECUTE_TST_GRP + EXECTN_FOLDR_PATH+"\\"+methodName+"_"+RetryAnalyzer.getRetryCount();

				this.setSCREENSHOT_SUBFOLDER_PATH(SCREENSHOT_SUBFOLDER_PATH);

				LogAccess.getLogger().info("SCREENSHOT_SUBFOLDER_PATH: "+SCREENSHOT_SUBFOLDER_PATH);

				driver = BrowserFunctions.CallingBrowser(CommonVariables.BROWSERSELECT);

				BrowserFunctions.accessUrl(CommonVariables.VAL_URL);

				LogAccess.getLogger().info("Reading from Main Class: " + vo.getUserid() + "-->"+ vo.getPassword() + "-->"+vo.getExecuteFlag() + "-->"
						+ vo.getRole() + "\n");
				Thread.sleep(5000);

				uname = vo.getUserid();
				pwd = vo.getPassword();
				role = vo.getRole();

				
				LoginPageFunction PFC= new LoginPageFunction(driver);
				LogAccess.getLogger().info("I am going to Login");
				PFC.valLogin(driver,vo, uname,pwd,role, SCREENSHOT_SUBFOLDER_PATH, CommonVariables.REGION);
				BusinessOwnerPageFunctions BO= new BusinessOwnerPageFunctions(driver);
				BO.BusinessOwner(SCREENSHOT_SUBFOLDER_PATH,methodName,RadiationOncology.getTEST_NAME(),sa);
				LogAccess.getLogger().info("I am going to Logout");
				PFC.valLogOut(driver, "YES", SCREENSHOT_SUBFOLDER_PATH);
				sa.assertAll();
				setPositiveStatus();

			}

			catch (Throwable e) {
				e.printStackTrace();
				setNegativeStatus();
				driver.quit();
				throw e;
			}

		}
		else
		{

			//throw new SkipException("Skipping this exception");

		}
	}
	
	@SuppressWarnings("static-access")
	@Test(enabled=false,priority=1, dataProvider = "getData", groups = {"ROFlows"},retryAnalyzer=RetryAnalyzer.class)
	public void ModelTeam(RO vo) throws Exception {
		methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		System.out.println("Method Name is:" +methodName);
		System.out.println("***********************************************************************************");

		if(vo.getExecuteFlag().equalsIgnoreCase("Y") && vo.getRole().contains("RO_MT"))
		{
			System.setProperty("fileName", vo.getRole());

			LogManager.resetConfiguration();

			LogAccess.setInitializationFlag(false);

			LogAccess.setFileName(System.getProperty("fileName") );

			LogAccess.getLogger().info("FileName in Main Script class is: "+LogAccess.getFileName());

			LogAccess.getLogger().info("***********************************************************************************");

			LogAccess.getLogger().info("The values are: "+vo.getRole()+"-->"+vo.getExecuteFlag()+"-->"+vo.getUserid());

			try
			{

				EXECUTE_TST_GRP = "_" +  vo.getRole() + "_";
				EXECTN_FOLDR_PATH = CommonFunction.createFolder(CommonVariables.REPORT_PATH + EXECUTE_TST_GRP,
						"_"+methodName);
				SCREENSHOT_SUBFOLDER_PATH = CommonVariables.REPORT_PATH + EXECUTE_TST_GRP + EXECTN_FOLDR_PATH+"\\"+methodName+"_"+RetryAnalyzer.getRetryCount();

				this.setSCREENSHOT_SUBFOLDER_PATH(SCREENSHOT_SUBFOLDER_PATH);

				LogAccess.getLogger().info("SCREENSHOT_SUBFOLDER_PATH: "+SCREENSHOT_SUBFOLDER_PATH);

				driver = BrowserFunctions.CallingBrowser(CommonVariables.BROWSERSELECT);

				BrowserFunctions.accessUrl(CommonVariables.VAL_URL);

				LogAccess.getLogger().info("Reading from Main Class: " + vo.getUserid() + "-->"+ vo.getPassword() + "-->"+vo.getExecuteFlag() + "-->"
						+ vo.getRole() + "\n");
				Thread.sleep(5000);

				uname = vo.getUserid();
				pwd = vo.getPassword();
				role = vo.getRole();

				
				LoginPageFunction PFC= new LoginPageFunction(driver);
				LogAccess.getLogger().info("I am going to Login");
				PFC.valLogin(driver,vo, uname,pwd,role, SCREENSHOT_SUBFOLDER_PATH, CommonVariables.REGION);
				BusinessOwnerPageFunctions BO= new BusinessOwnerPageFunctions(driver);
				BO.ModelTeam(SCREENSHOT_SUBFOLDER_PATH,methodName,RadiationOncology.getTEST_NAME(),sa);
				LogAccess.getLogger().info("I am going to Logout");
				PFC.valLogOut(driver, "YES", SCREENSHOT_SUBFOLDER_PATH);
				sa.assertAll();
				setPositiveStatus();

			}

			

			catch (Throwable e) {
				e.printStackTrace();
				setNegativeStatus();
				driver.quit();
				throw e;
			}

		}
		else
		{

			//throw new SkipException("Skipping this exception");

		}
	}
	
	
	
	@SuppressWarnings("static-access")
	@Test(enabled=true,priority=2, dataProvider = "getData", groups = {"ROFlows"},retryAnalyzer=RetryAnalyzer.class)
	public void ImplementationContractor(RO vo) throws Exception {
		methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		System.out.println("Method Name is:" +methodName);
		System.out.println("***********************************************************************************");

		if(vo.getExecuteFlag().equalsIgnoreCase("Y") && vo.getRole().contains("RO_IC"))
		{
			System.setProperty("fileName", vo.getRole());

			LogManager.resetConfiguration();

			LogAccess.setInitializationFlag(false);

			LogAccess.setFileName(System.getProperty("fileName") );

			LogAccess.getLogger().info("FileName in Main Script class is: "+LogAccess.getFileName());

			LogAccess.getLogger().info("***********************************************************************************");

			LogAccess.getLogger().info("The values are: "+vo.getRole()+"-->"+vo.getExecuteFlag()+"-->"+vo.getUserid());

			try
			{

				EXECUTE_TST_GRP = "_" +  vo.getRole() + "_";
				EXECTN_FOLDR_PATH = CommonFunction.createFolder(CommonVariables.REPORT_PATH + EXECUTE_TST_GRP,
						"_"+methodName);
				SCREENSHOT_SUBFOLDER_PATH = CommonVariables.REPORT_PATH + EXECUTE_TST_GRP + EXECTN_FOLDR_PATH+"\\"+methodName+"_"+RetryAnalyzer.getRetryCount();

				this.setSCREENSHOT_SUBFOLDER_PATH(SCREENSHOT_SUBFOLDER_PATH);

				LogAccess.getLogger().info("SCREENSHOT_SUBFOLDER_PATH: "+SCREENSHOT_SUBFOLDER_PATH);

				driver = BrowserFunctions.CallingBrowser(CommonVariables.BROWSERSELECT);

				BrowserFunctions.accessUrl(CommonVariables.VAL_URL);

				LogAccess.getLogger().info("Reading from Main Class: " + vo.getUserid() + "-->"+ vo.getPassword() + "-->"+vo.getExecuteFlag() + "-->"
						+ vo.getRole() + "\n");
				Thread.sleep(5000);

				uname = vo.getUserid();
				pwd = vo.getPassword();
				role = vo.getRole();

				
				LoginPageFunction PFC= new LoginPageFunction(driver);
				LogAccess.getLogger().info("I am going to Login");
				PFC.valLogin(driver,vo, uname,pwd,role, SCREENSHOT_SUBFOLDER_PATH, CommonVariables.REGION);
				BusinessOwnerPageFunctions BO= new BusinessOwnerPageFunctions(driver);
				BO.ImplementationContractor(SCREENSHOT_SUBFOLDER_PATH,methodName,RadiationOncology.getTEST_NAME(),sa);
				LogAccess.getLogger().info("I am going to Logout");
				PFC.valLogOut(driver, "YES", SCREENSHOT_SUBFOLDER_PATH);
				sa.assertAll();
				setPositiveStatus();

			}

			

			catch (Throwable e) {
				e.printStackTrace();
				setNegativeStatus();
				driver.quit();
				throw e;
			}

		}
		else
		{

			//throw new SkipException("Skipping this exception");

		}
	}
	@SuppressWarnings("static-access")
	@Test(enabled=false,priority=3, dataProvider = "getData", groups = {"ROFlows"},retryAnalyzer=RetryAnalyzer.class)
	public void HelpDesk(RO vo) throws Exception {
		methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		System.out.println("Method Name is:" +methodName);
		System.out.println("***********************************************************************************");

		if(vo.getExecuteFlag().equalsIgnoreCase("Y") && vo.getRole().contains("RO_HD"))
		{
			System.setProperty("fileName", vo.getRole());

			LogManager.resetConfiguration();

			LogAccess.setInitializationFlag(false);

			LogAccess.setFileName(System.getProperty("fileName") );

			LogAccess.getLogger().info("FileName in Main Script class is: "+LogAccess.getFileName());

			LogAccess.getLogger().info("***********************************************************************************");

			LogAccess.getLogger().info("The values are: "+vo.getRole()+"-->"+vo.getExecuteFlag()+"-->"+vo.getUserid());

			try
			{

				EXECUTE_TST_GRP = "_" +  vo.getRole() + "_";
				EXECTN_FOLDR_PATH = CommonFunction.createFolder(CommonVariables.REPORT_PATH + EXECUTE_TST_GRP,
						"_"+methodName);
				SCREENSHOT_SUBFOLDER_PATH = CommonVariables.REPORT_PATH + EXECUTE_TST_GRP + EXECTN_FOLDR_PATH+"\\"+methodName+"_"+RetryAnalyzer.getRetryCount();

				this.setSCREENSHOT_SUBFOLDER_PATH(SCREENSHOT_SUBFOLDER_PATH);

				LogAccess.getLogger().info("SCREENSHOT_SUBFOLDER_PATH: "+SCREENSHOT_SUBFOLDER_PATH);

				driver = BrowserFunctions.CallingBrowser(CommonVariables.BROWSERSELECT);

				BrowserFunctions.accessUrl(CommonVariables.VAL_URL);

				LogAccess.getLogger().info("Reading from Main Class: " + vo.getUserid() + "-->"+ vo.getPassword() + "-->"+vo.getExecuteFlag() + "-->"
						+ vo.getRole() + "\n");
				Thread.sleep(5000);

				uname = vo.getUserid();
				pwd = vo.getPassword();
				role = vo.getRole();

				
				LoginPageFunction PFC= new LoginPageFunction(driver);
				LogAccess.getLogger().info("I am going to Login");
				PFC.valLogin(driver,vo, uname,pwd,role, SCREENSHOT_SUBFOLDER_PATH, CommonVariables.REGION);
				BusinessOwnerPageFunctions BO= new BusinessOwnerPageFunctions(driver);
				BO.HelpDesk(SCREENSHOT_SUBFOLDER_PATH,methodName,RadiationOncology.getTEST_NAME(),sa);
				LogAccess.getLogger().info("I am going to Logout");
				PFC.valLogOut(driver, "YES", SCREENSHOT_SUBFOLDER_PATH);
				sa.assertAll();
				setPositiveStatus();

			}

			

			catch (Throwable e) {
				e.printStackTrace();
				setNegativeStatus();
				driver.quit();
				throw e;
			}

		}
		else
		{

			//throw new SkipException("Skipping this exception");

		}
	}
	
	@SuppressWarnings("static-access")
	@Test(enabled=false,priority=4, dataProvider = "getData", groups = {"ROFlows"},retryAnalyzer=RetryAnalyzer.class)
	public void AppAdmin(RO vo) throws Exception {
		methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		System.out.println("Method Name is:" +methodName);
		System.out.println("***********************************************************************************");

		if(vo.getExecuteFlag().equalsIgnoreCase("Y") && vo.getRole().contains("RO_AA"))
		{
			System.setProperty("fileName", vo.getRole());

			LogManager.resetConfiguration();

			LogAccess.setInitializationFlag(false);

			LogAccess.setFileName(System.getProperty("fileName") );

			LogAccess.getLogger().info("FileName in Main Script class is: "+LogAccess.getFileName());

			LogAccess.getLogger().info("***********************************************************************************");

			LogAccess.getLogger().info("The values are: "+vo.getRole()+"-->"+vo.getExecuteFlag()+"-->"+vo.getUserid());

			try
			{

				EXECUTE_TST_GRP = "_" +  vo.getRole() + "_";
				EXECTN_FOLDR_PATH = CommonFunction.createFolder(CommonVariables.REPORT_PATH + EXECUTE_TST_GRP,
						"_"+methodName);
				SCREENSHOT_SUBFOLDER_PATH = CommonVariables.REPORT_PATH + EXECUTE_TST_GRP + EXECTN_FOLDR_PATH+"\\"+methodName+"_"+RetryAnalyzer.getRetryCount();

				this.setSCREENSHOT_SUBFOLDER_PATH(SCREENSHOT_SUBFOLDER_PATH);

				LogAccess.getLogger().info("SCREENSHOT_SUBFOLDER_PATH: "+SCREENSHOT_SUBFOLDER_PATH);

				driver = BrowserFunctions.CallingBrowser(CommonVariables.BROWSERSELECT);

				BrowserFunctions.accessUrl(CommonVariables.VAL_URL);

				LogAccess.getLogger().info("Reading from Main Class: " + vo.getUserid() + "-->"+ vo.getPassword() + "-->"+vo.getExecuteFlag() + "-->"
						+ vo.getRole() + "\n");
				Thread.sleep(5000);

				uname = vo.getUserid();
				pwd = vo.getPassword();
				role = vo.getRole();

				
				LoginPageFunction PFC= new LoginPageFunction(driver);
				LogAccess.getLogger().info("I am going to Login");
				PFC.valLogin(driver,vo, uname,pwd,role, SCREENSHOT_SUBFOLDER_PATH, CommonVariables.REGION);
				AppAdminPageFunctions AA= new AppAdminPageFunctions(driver);
				AA.AppAdmin(SCREENSHOT_SUBFOLDER_PATH,methodName,RadiationOncology.getTEST_NAME(),sa);
				LogAccess.getLogger().info("I am going to Logout");
				PFC.valLogOut(driver, "YES", SCREENSHOT_SUBFOLDER_PATH);
				sa.assertAll();
				setPositiveStatus();

			}

			

			catch (Throwable e) {
				e.printStackTrace();
				setNegativeStatus();
				driver.quit();
				throw e;
			}

		}
		else
		{

			//throw new SkipException("Skipping this exception");

		}
	}
	
	@SuppressWarnings("static-access")
	@Test(enabled=false,priority=5, dataProvider = "getData", groups = {"ROFlows"},retryAnalyzer=RetryAnalyzer.class)
	public void Participant(RO vo) throws Exception {
		methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		System.out.println("Method Name is:" +methodName);
		System.out.println("***********************************************************************************");

		if(vo.getExecuteFlag().equalsIgnoreCase("Y") && vo.getRole().contains("RO_PA"))
		{
			System.setProperty("fileName", vo.getRole());

			LogManager.resetConfiguration();

			LogAccess.setInitializationFlag(false);

			LogAccess.setFileName(System.getProperty("fileName") );

			LogAccess.getLogger().info("FileName in Main Script class is: "+LogAccess.getFileName());

			LogAccess.getLogger().info("***********************************************************************************");

			LogAccess.getLogger().info("The values are: "+vo.getRole()+"-->"+vo.getExecuteFlag()+"-->"+vo.getUserid());

			try
			{

				EXECUTE_TST_GRP = "_" +  vo.getRole() + "_";
				EXECTN_FOLDR_PATH = CommonFunction.createFolder(CommonVariables.REPORT_PATH + EXECUTE_TST_GRP,
						"_"+methodName);
				SCREENSHOT_SUBFOLDER_PATH = CommonVariables.REPORT_PATH + EXECUTE_TST_GRP + EXECTN_FOLDR_PATH+"\\"+methodName+"_"+RetryAnalyzer.getRetryCount();

				this.setSCREENSHOT_SUBFOLDER_PATH(SCREENSHOT_SUBFOLDER_PATH);

				LogAccess.getLogger().info("SCREENSHOT_SUBFOLDER_PATH: "+SCREENSHOT_SUBFOLDER_PATH);

				driver = BrowserFunctions.CallingBrowser(CommonVariables.BROWSERSELECT);

				BrowserFunctions.accessUrl(CommonVariables.VAL_URL);

				LogAccess.getLogger().info("Reading from Main Class: " + vo.getUserid() + "-->"+ vo.getPassword() + "-->"+vo.getExecuteFlag() + "-->"
						+ vo.getRole() + "\n");
				Thread.sleep(5000);

				uname = vo.getUserid();
				pwd = vo.getPassword();
				role = vo.getRole();

				
				LoginPageFunction PFC= new LoginPageFunction(driver);
				LogAccess.getLogger().info("I am going to Login");
				PFC.valLogin(driver,vo, uname,pwd,role, SCREENSHOT_SUBFOLDER_PATH, CommonVariables.REGION);
				AppAdminPageFunctions AA= new AppAdminPageFunctions(driver);
				AA.Participant(SCREENSHOT_SUBFOLDER_PATH,methodName,RadiationOncology.getTEST_NAME(),sa);
				LogAccess.getLogger().info("I am going to Logout");
				PFC.valLogOut(driver, "YES", SCREENSHOT_SUBFOLDER_PATH);
				sa.assertAll();
				setPositiveStatus();

			}
			catch (Throwable e) {
				e.printStackTrace();
				setNegativeStatus();
				driver.quit();
				throw e;
			}

		}
		else
		{

			//throw new SkipException("Skipping this exception");

		}
	}
	
	
	@AfterMethod(alwaysRun=true)
	public void CloseBrowser(ITestResult result)
	{

		try
		{
			if(result.getStatus() == ITestResult.FAILURE)
			{
				System.out.println("Test Method resides in " + result.getTestClass().getName());
				driver.quit();
				System.out.println("The testcase iteration has failed");
			}

			else if(result.getStatus() == ITestResult.SUCCESS)
			{
				System.out.println("Test Method resides in " + result.getTestClass().getName());
				driver.quit();
				System.out.println("The testcase iteration has passed");
			}

			else if(result.getStatus() == ITestResult.SKIP)
			{
				System.out.println("Test Method resides in " + result.getTestClass().getName());
				System.out.println("This is skipped");

			}


		}

		catch(Exception e)
		{


		}

	}

	private void setPositiveStatus() throws InterruptedException {
		CommonFunction.setResult("Passed");
		System.out.println("Application iteration has : "+CommonFunction.getResult()+"\n");
		CommonFunction.captureScreenshot(driver, RadiationOncology.getSCREENSHOT_SUBFOLDER_PATH(), CommonFunction.getResult());
		Thread.sleep(5000);
		System.out.println("This is Passed");

	}

	private void setNegativeStatus() throws InterruptedException {
		CommonFunction.setResult("Failed");
		System.out.println("Application iteration has : "+CommonFunction.getResult()+"\n");
		CommonFunction.captureScreenshot(driver, RadiationOncology.getSCREENSHOT_SUBFOLDER_PATH(), CommonFunction.getResult());
		Thread.sleep(5000);

	}


	@DataProvider(name = "getData")
	public Object[][] getData() throws Exception {
		if (processor == null) {
			processor = new Processor();

		}
		Object[][] objArray = null;
		try {
			roList=processor.getRoleFromArraylist(userID);
			ArrayList<RO> roLIST = roList;
			System.out.println("ahcLIST size: "+roLIST.size());
			objArray = new Object[roLIST.size()][];

			for(int i=0;i< roLIST.size();i++){
				objArray[i] = new Object[1];
				objArray[i][0] = roLIST.get(i);
			}
		} catch (Exception e) {

			e.printStackTrace();
		} 
		//LogAccess.getLogger().info("objArray.length: "+objArray.length);
		return objArray;
	}

}