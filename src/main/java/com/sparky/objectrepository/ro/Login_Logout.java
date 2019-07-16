package com.sparky.objectrepository.ro;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//import iAAmainPackage.iAACommonFunction;


public class Login_Logout {


	// Val Login button
	@FindBy(xpath =".//*[@id='cms-label-tc']")
	public WebElement iVal_loginbtn;

	// Val - I Accept button
	@FindBy(id ="acceptButton")
	public WebElement iVal_Acceptbtn;


	//user Id text box

	@FindBy(id ="cms-login-userid")
	public WebElement userid;

	//MFA pw
	@FindBy(id ="cms-login-password")
	public WebElement bpciAdv_pwd;

	//MFA devices dropdown
	@FindBy(id ="devices")
	public WebElement userMFAdv;

	//MFA send code
	@FindBy(id ="sendOTP")
	public WebElement MFAsendcode;


	//MFA security code
	@FindBy(id ="securityCode")
	public WebElement MFAseccode;

	// MFA Security Code Txt Box
	@FindBy(id ="cms-mfa-securitycode-std")
	public WebElement MFAseccodeTB;
	
	@FindBy(xpath  ="//input[@id='cms-mfa-securitycode-std']")
	public WebElement icpcuserMFAseccodeTB;

	// next button 
	@FindBy(id ="buttonUserID")
	public WebElement useridnext;

	// password textboc
	@FindBy(id ="cms-login-password")
	public WebElement userpswrd;  

	//Select textboc
	@FindBy(id ="cms-mfa-selectbox")
	public WebElement userselbx; 

	@FindBy(xpath  ="//label[contains(text(),'Agree to our')]")
	public WebElement userta;


	// Login Button
	@FindBy(id ="cms-login-submit")
	public WebElement userlogin;
	
	@FindBy(xpath  ="//span[contains(text(),'Unexpected Error while processing your request.Please try again.')]")
	public WebElement errorspan;

	//Innovation center VAL 1 dropdown  //Sundar changed the id from VAL1 to DEV1
	@FindBy(id ="cms_InnovationCenterDEV1_tileid")
	public WebElement innvocVAL1;

	// Application console      //Sundar changed the id from VAL1 to DEV1
	//@FindBy(xpath =".//*[@id='cms_InnovationCenter_ApplicationConsole_pidb']/span")
	@FindBy(xpath =".//*[@id='cms_InnovationCenter-DEV1_ApplicationConsole_pidb']/span")
	//@FindBy(xpath  ="//span[contains(text(),'Application Console')]")
	public WebElement innvocVALAppcon;


	//launch RO button
	@FindBy(xpath=".//*[@id='consoleHome']/div/a/div[1]/span")
	public List<WebElement> launchroapp;
		
	//CPCMainContent
	@FindBy(id ="CPCMainContent")
	public WebElement maincontent;

	//launch eMTM button
	@FindBy(xpath=".//*[@class='app-block']")
	public List<WebElement> launchapp;

	//logout
	@FindBy(id ="logoutlink")
	public WebElement Logout;

/**LMDC**/	
	@FindBy(xpath ="//a[@id='cms_InnovationCenter_tileid']")
	public WebElement lmdcInnoCenterTile;
	
	@FindBy(xpath ="//*[@id='cms_InnovationCenter_ApplicationConsole_pidb']/span")
	public WebElement lmdcInnoCenterAppConsole;
	
	@FindBy(xpath ="//a[@id='cms-viewmyapps-button']")
	public WebElement viewApps;
	
	@FindBy(xpath ="//*[@id='cms_InnovationCenter-VAL1_ApplicationConsole_pidh']/span")
	public WebElement viewAppsConsole;
	
	
	
}
