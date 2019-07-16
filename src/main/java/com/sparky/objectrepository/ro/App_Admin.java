package com.sparky.objectrepository.ro;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class App_Admin {


	@FindBy(xpath ="//h2[contains(text(),'Template Upload')]")
	public WebElement Header;
	
	@FindBy(xpath =".//*[@class='rf-nav-heading ng-scope']")
	public WebElement adminLanding;
	
	@FindBy(xpath="//a[contains(text(),'Home')]")
	public  WebElement homeTab;
	
	@FindBy(xpath =".//*[@id='rfMainContent']/div/div[1]/h1")
	public  WebElement homeTabHdr;
	
	@FindBy(xpath="//div[contains(text(),'secure data portal')]")
	public  WebElement homeStaticTxt;
	
	@FindBy(xpath="//a[contains(text(),'Admin')]")
	public  WebElement adminTab;
	
	@FindBy(xpath="//a[contains(text(),'File Submission History')]")
	public  WebElement fshTab;
	
	@FindBy(xpath="//a[contains(text(),'Resources')]")
	public  WebElement resrcTab;
	
	@FindBy(xpath="//a[contains(text(),'Upload')]")
	public  WebElement uploadSubAdmTab;
	
	  //Select File button
	@FindBy(xpath="//span[contains(text(),'Select File')]")
	public List<WebElement> selectFile;
	
	@FindBy(xpath="//a[contains(text(),'Extend Submission Window')]")
	public  WebElement eswSubAdmTab;
	
	@FindBy(xpath="//a[contains(text(),'Reopen Submission Window')]")
	public  WebElement rswSubAdmTab;
	
	@FindBy(xpath="//a[contains(text(),'Participating Organizations')]")
	public  WebElement poSubAdmTab;
	
	@FindBy(xpath="//div[contains(text(),'Select template type to use for future submission windows.')]")
	public  WebElement selectTempType;
	
	@FindBy(xpath ="//span[contains(text(),'Template Type')]/preceding-sibling::select")
	public  List<WebElement> tempTypeDDSelect;
	
	@FindBy(xpath ="//span[contains(text(),'Template Type')]/preceding-sibling::select/option")
	public  List<WebElement> tempTypeDD;
	
	@FindBy(xpath ="//span[contains(text(),'Select File')]")
	public  WebElement tempTypeSelectFile;
	 
	@FindBy(xpath ="//h3[contains(text(),'Template Upload History')]")
	public  WebElement tempUploadHistory;
	
	@FindBy(xpath="//div[contains(text(),'To complete this action')]")
	public  WebElement comment;
	
	@FindBy(xpath ="//h2[contains(text(),'Extend Submission Window')]")
	public  WebElement eswHdr;
	
	@FindBy(xpath ="//span[contains(text(),'File Type')]/preceding-sibling::select")
	public  List<WebElement> fileTypeDDSelect;
	
	@FindBy(xpath ="//span[contains(text(),'File Type')]/preceding-sibling::select/option")
	public  List<WebElement> fileTypeDD;
	
	@FindBy(xpath ="//span[contains(text(),'Reporting Period')]/preceding-sibling::select")
	public  List<WebElement> reportPeriodDD;
	
	@FindBy(xpath="//input[@title='Submission Start Date (MM/DD/YYYY)']")
	public   WebElement submissionStartDate;
	
	@FindBy(xpath="//input[@title='Submission End Date (MM/DD/YYYY)']")
	public   WebElement submissionEndDate;
	
	@FindBy(xpath ="//span[contains(text(),'State')]/preceding-sibling::select")
	public  List<WebElement> stateDD;
	
	@FindBy(xpath ="//span[contains(text(),'TIN')]/preceding-sibling::select")
	public  List<WebElement> tinDD;
	
	@FindBy(xpath="//span[contains(text(),'Comment')]")
	public  WebElement commentHdr;
	
	@FindBy(xpath ="//span[contains(text(),'Comment Textarea')]/preceding-sibling::textarea")
	public  WebElement commentTextarea;
	
	@FindBy(xpath="//span[contains(text(),'Update')]")
	public  WebElement update;
	
	@FindBy(xpath="//span[contains(text(),'Export All')]")
	public  WebElement exportAll;
	
	@FindBy(xpath="//h2[contains(text(),'Consolidated Reports')]")
	public  WebElement consReports;
	
	@FindBy(xpath="//a[contains(text(),'Submit Files')]")
	public  WebElement submitFilesTab;
	
	@FindBy(xpath="//a[contains(text(),'Download')]")
	public  WebElement download;
	
	@FindBy(xpath =".//*[@id='rfMainContent']/div[1]/div[1]/h1")
	public WebElement landingHdr;
	
	@FindBy(xpath="//h2[contains(text(),'List of Available Templates')]")
	public  WebElement loaTemplates;
	
	@FindBy(xpath="//h2[contains(text(),'File Submission History')]")
	public  WebElement fshHdr;
	
	@FindBy(xpath="//h3[contains(text(),'File Submission History')]")
	public  WebElement fshHdr3;
	
	@FindBy(xpath="//div[contains(text(),'captures the submission history')]")
	public  WebElement fshStaticTxt;
}
