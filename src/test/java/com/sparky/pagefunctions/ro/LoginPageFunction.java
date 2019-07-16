package com.sparky.pagefunctions.ro;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import com.sparky.commonfunctions.ro.CommonFunction;
import com.sparky.helper.ro.LogAccess;
import com.sparky.model.ro.RO;
import com.sparky.objectrepository.ro.Login_Logout;


public class LoginPageFunction extends CommonFunction{

	public Login_Logout val_login_obj;
	WebDriver driver;
	public SoftAssert sa;
	int AssertCount=0;
	String AssertName;
	String methodName;
	WebDriverWait wait;
	
	@SuppressWarnings("unused")
	public LoginPageFunction(WebDriver driver) throws Exception {
		super();
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 30);
		val_login_obj = PageFactory.initElements(driver, Login_Logout.class);
		sa = new SoftAssert();
	}

	static String uname=null;
	static String pwd=null;
	static String role=null;
	
	@SuppressWarnings("static-access")
	public void valLogin(WebDriver driver,RO vo, String uname,String pwd,String role, String ScreenshotSubFolderPath, String Region ) throws Exception {
		
		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		
		AssertName="Assert_"+methodName;
		
		LogAccess.getLogger().info("I am going to Work on Login Screen");
		
		uname = vo.getUserid();
		System.out.println(uname);//Sundar added this step.delete this step after sample test
		pwd = vo.getPassword();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		
		this.inputTextField(driver, val_login_obj.userid, uname);
		
		this.inputTextField(driver, val_login_obj.userpswrd, pwd);
		
		this.findButtonClick(driver, val_login_obj.iVal_loginbtn);
		
		this.findButtonClick(driver, val_login_obj.userlogin);
		
		System.out.println("Check Loop count");//Sundar added this step.delete this step after sample test
		
		
		
		try {
			verifyPageLoaded(driver,"Innovation Center - DEV1");
			
			LogAccess.getLogger().info("Login Success");
		
		
		} catch (Exception e) {
			if(val_login_obj.errorspan.isDisplayed())
			{
				if(this.findByElement(driver, val_login_obj.userid))
				{
				this.inputTextField(driver, val_login_obj.userid, uname);
				}
					
				if(this.findByElement(driver, val_login_obj.userpswrd))
				{
				this.inputTextField(driver, val_login_obj.userpswrd, pwd);
				}
				this.captureHighlightScreenshot(driver, ScreenshotSubFolderPath, AssertName+"_AppLoginPage", val_login_obj.iVal_loginbtn);
				if(this.findByElement(driver, val_login_obj.iVal_loginbtn)&val_login_obj.iVal_loginbtn.isSelected())
				{
				LogAccess.getLogger().info("Checkbox is selected");
				}else
				{
					this.buttonClick(driver, val_login_obj.iVal_loginbtn);
				}
				
				//Login Button
				if(this.findByElement(driver, val_login_obj.userlogin))
				{
				try {
					this.buttonClick(driver, val_login_obj.userlogin);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					((JavascriptExecutor)driver).executeScript("arguments[0].click()",val_login_obj.userlogin);
				}
				}
				
			}
		
			
		}
		
		
if(Region.equalsIgnoreCase("LMDC")) {		
	
	this.captureHighlightScreenshot(driver, ScreenshotSubFolderPath, AssertName+"_AppLoginSuccess", val_login_obj.innvocVAL1);
	
	this.findButtonClick(driver, val_login_obj.innvocVAL1);

	verifyPageLoaded(driver,"Application Console");
	
	this.findButtonClick(driver, val_login_obj.innvocVALAppcon);
	
	System.out.println("Reached LMDC if loop"); //Sundar added this step.delete this step after sample test
	
}
		verifyPageLoaded(driver,"Radiation Oncology");
		
		if(val_login_obj.launchroapp.size()>1)
		{
			int valSize=val_login_obj.launchroapp.size(); //Sundar added
			
			System.out.println("The size of the list is: " +valSize); // Sundar added 
			
			switch(valSize) { //Added the swirch statement to handle the variable size of list in the Development environment
			
			case 9:
				this.captureHighlightScreenshot(driver, ScreenshotSubFolderPath, AssertName+"_RO", val_login_obj.launchroapp.get(valSize-1));//Sundar added
				this.findButtonClick(driver, val_login_obj.launchroapp.get(valSize-1));//Sundar added
				
				break;
			case 8:
				this.captureHighlightScreenshot(driver, ScreenshotSubFolderPath, AssertName+"_RO", val_login_obj.launchroapp.get(valSize-1));//Sundar added
				this.findButtonClick(driver, val_login_obj.launchroapp.get(valSize-1));//Sundar added
				
				break;
			case 7:
				this.captureHighlightScreenshot(driver, ScreenshotSubFolderPath, AssertName+"_RO", val_login_obj.launchroapp.get(valSize-2));//Sundar added
				this.findButtonClick(driver, val_login_obj.launchroapp.get(valSize-2));//Sundar added
				break;
			}
		//this.captureHighlightScreenshot(driver, ScreenshotSubFolderPath, AssertName+"_RO", val_login_obj.launchroapp.get(1));
		//this.findButtonClick(driver, val_login_obj.launchroapp.get(1));

		}else
		{
			this.captureHighlightScreenshot(driver, ScreenshotSubFolderPath, AssertName+"_RO", val_login_obj.launchroapp.get(0));
			
			this.findButtonClick(driver, val_login_obj.launchroapp.get(0));
		}
		
		if(driver.getPageSource().contains("This portlet is unavailable."))
		{
			this.findButtonClick(driver, val_login_obj.viewApps);
			
			this.captureHighlightScreenshot(driver, ScreenshotSubFolderPath, AssertName+"_RO", val_login_obj.viewAppsConsole);
			
			this.findButtonClick(driver, val_login_obj.viewAppsConsole);
		}
		
		
	}




	/// Val Logout
	@SuppressWarnings("static-access")
	public void valLogOut(WebDriver driver, String iScreenshotYes_NO, String ScreenshotSubFolderPath) throws Exception {

		verifyPageLoaded(driver, "Log Out");
		
		System.out.println("Script is in the logout method");//Sundar added this step.delete this step after sample test
		
		this.captureHighlightScreenshot(driver, ScreenshotSubFolderPath, AssertName+"_RO_Logout", val_login_obj.Logout);
		
		this.findButtonClick(driver, val_login_obj.Logout);
	
		//verifyPageLoaded(driver, "Learn About Your Application");
	} 

	
	@SuppressWarnings("static-access")
	public void valLogOutRmvAttest(WebDriver driver, String iScreenshotYes_NO, String ScreenshotSubFolderPath) throws Exception {
		
		this.captureHighlightScreenshot(driver, ScreenshotSubFolderPath, AssertName+"_RO_Logout", val_login_obj.Logout);
		
		this.findButtonClick(driver, val_login_obj.Logout);

		this.findButtonClick(driver, val_login_obj.iVal_loginbtn);
		
	} 
	
	@SuppressWarnings({ "unused", "static-access" })
	public void valLoginMFAEnabled(WebDriver driver,RO vo,String uname,String pwd,String role, String ScreenshotSubFolderPath) throws Exception {


		uname = vo.getUserid();
		pwd = vo.getPassword();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		Login_Logout val_login_obj = PageFactory.initElements(driver, Login_Logout.class);
		WebDriverWait wait = new WebDriverWait(driver, 30);
	
		System.out.println("Entered Login Page");
		this.inputTextField(driver, val_login_obj.userid, uname);	
		this.inputTextField(driver, val_login_obj.userpswrd, pwd);
		Thread.sleep(3000);

		//Select s = new Select(WebElement);
		new Select(driver.findElement(By.xpath("//select[@id='cms-mfa-selectbox']"))).selectByVisibleText("Phone/Tablet/PC/Laptop");

		//((JavascriptExecutor) driver).executeScript("arguments[0].click()", val_login_obj.icpcuserselbx);
		//CommonFunction.dropDownByValue(driver, val_login_obj.icpcuserselbx, "Phone/Tablet/PC/Laptop");

		String OpenVIP = "C:\\Program Files (x86)\\Symantec\\VIP Access Client\\VIPUIManager.exe";
		String CloseVIP="VIPUIManager.exe";
		Runtime run = Runtime.getRuntime();
		run.exec(OpenVIP);
		try {
			Thread.sleep(2000);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		StringSelection stringSelection = new StringSelection("");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		//Copy the one time security code
		Robot robot=new Robot();

		//Send("{CTRLDOWN}c{CTRLUP}")	
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_C);
		Thread.sleep(2000L);
		robot.keyRelease(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000L);

		//Kill the Process of VIP
		run.exec("taskkill /F /IM "+CloseVIP+"");					 
		val_login_obj.icpcuserMFAseccodeTB.click();
		//driver.findElement(By.id("cms-mfa-securitycode-std")).click();
		Thread.sleep(3000L);
		this.buttonClick(driver, val_login_obj.userta);

		//Paste One time security code
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(3000L);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL); 
		Thread.sleep(2000);

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebElement elementChkBox= driver.findElement(By.cssSelector("input[type='checkbox']"));
		//jse.executeScript("arguments[0].click();", elementChkBox);

		WebElement LoginButton=driver.findElement(By.cssSelector("input[value='Login']"));
		Thread.sleep(2000L);
		jse.executeScript("arguments[0].click();", LoginButton);


		//iCommonVariables.iCommonFunction.iButtonClick(driver, val_login_obj.icpcuserta);
			

		//Val Clicking
		this.buttonClick(driver, val_login_obj.userlogin);
		this.buttonClick(driver, val_login_obj.innvocVAL1);
		this.buttonClick(driver, val_login_obj.innvocVALAppcon);
		Thread.sleep(5000);
		try {
			this.highlight(driver, val_login_obj.launchroapp.get(1));
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", val_login_obj.launchroapp.get(1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Thread.sleep(6000);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(".//h1[contains(text(),'HHVBP') and @class='ng-binding']"))));
		this.captureScreenshot(driver, ScreenshotSubFolderPath, "HHVBP_HomePage");
		Thread.sleep(5000);
	}
	
	
	
	
}
