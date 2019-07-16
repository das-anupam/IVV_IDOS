package com.sparky.objectrepository.ro;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Business_Owner {


	@FindBy(xpath ="//h2[contains(text(),'Template Upload')]")
	public WebElement Header;
	
	@FindBy(xpath =".//*[@class='rf-nav-heading ng-scope']")
	public WebElement adminLanding;

	@FindBy(xpath="//a[contains(text(),'Home')]")
	public  WebElement homeTab;
	
	@FindBy(xpath="//a[contains(text(),'Admin')]")
	public  WebElement adminTab;
	
	@FindBy(xpath="//a[contains(text(),'File Submission History')]")
	public  WebElement fshTab;
	
	@FindBy(xpath="//a[contains(text(),'Resources')]")
	public  WebElement resrcTab;
	
	@FindBy(xpath="//div[contains(text(),'We are available to answer ')]")
	public  WebElement resrcStaticTxt;
	
	@FindBy(xpath="//h2[contains(text(),'Help Desk')]")
	public  WebElement resrcHD;
	
	@FindBy(xpath="//h2[contains(text(),'User Manuals')]")
	public  WebElement resrcUM;
	
	@FindBy(xpath="//h2[contains(text(),'Related Links')]")
	public  WebElement resrcRL;
	
	@FindBy(xpath=".//*[@class='rfm-left rfm-blue']")
	public  WebElement resrcHDInfo;
	
	@FindBy(xpath="//a[contains(text(),'Upload')]")
	public  WebElement uploadSubAdmTab;
	
	  //Select File button
  	@FindBy(xpath="//span[contains(text(),'Select File')]")
	public List<WebElement> selectFile;
  	
  	@FindBy(xpath ="//span[contains(text(),'File Name')]/preceding-sibling::select/option")
	public  List<WebElement> selectFileDD;
	
	@FindBy(xpath ="//span[contains(text(),'File Name')]/preceding-sibling::select")
	public  List<WebElement> selectFileTypeDD;
	
	@FindBy(xpath ="//span[contains(text(),'Upload') ]")
	public  List<WebElement> uploadList;
	
	@FindBy(xpath="//div[contains(text(),'You have successfully uploaded a file.')]")
	public  WebElement SuccessMessage;
	
	
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
	
	@FindBy(xpath ="//h2[contains(text(),'Reopen Submission Window')]")
	public  WebElement rswHdr;
	
	@FindBy(xpath =".//table[1]/tbody/tr/td[3]/div/div/div[2]/div/div/button[1]/span")
	public  WebElement DFupload;
	
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
	
	@FindBy(xpath="//span[contains(text(),'Reopen')]")
	public  WebElement reopen;
	
	@FindBy(xpath="//span[contains(text(),'Update')]")
	public  WebElement update;
	
	@FindBy(xpath="//span[contains(text(),'Export All')]")
	public  WebElement exportAll;
	
	@FindBy(xpath="//h2[contains(text(),'Consolidated Reports')]")
	public  WebElement consReports;
	
	@FindBy(xpath="//a[contains(text(),'Submit Files')]")
	public  WebElement submitFiles;
	
	@FindBy(xpath="//a[contains(text(),'Download')]")
	public  WebElement download;
	
	@FindBy(xpath =".//*[@id='rfMainContent']/div[1]/div[1]/h1")
	public WebElement landingHdr;
	
	@FindBy(xpath="//h2[contains(text(),'List of Available Templates')]")
	public  WebElement loaTemplates;
	
	@FindBy(xpath="//h2[contains(text(),'File Submission History')]")
	public  WebElement fshHdr;
	
	@FindBy(xpath="//div[contains(text(),'captures the submission history')]")
	public  WebElement fshStaticTxt;
	
	//Add Organization all Required fields Label 
	@FindBy(xpath="//span[@class ='rf-required ng-scope' and @title='Required']")
	public  WebElement AddOrg_reqLabels;
	
	//Add Organization all Lables
	@FindBy(xpath="//span[@class ='rf-required ng-scope']/following::input[@type='text']/preceding::label[1]")
	public static  List<WebElement> AddOrg_TextBoxesLbls;
	
	//Add Organization all Text Boxes
	@FindBy(xpath="//span[@class ='rf-required ng-scope']/following::input[@type='text']")
	public static  List<WebElement> AddOrg_TextBoxes;
	
	//Add phone Button List
	@FindBy(xpath="//button/span[3][@data-ng-if='!object.iconOnly' and contains(text(),'Add Phone')]")
	public  List<WebElement> AddOrgPhone;
	
	// Phone Drop down
	@FindBy(xpath="//select[@title= 'Phone Type' ]")
	public static WebElement AddOrg_PhDrpdwn;
	
	//select organization dropdown
	@FindBy(xpath = "//select[contains(@title,'Select Organization')]")
	public WebElement orgSelectDD;
	
	@FindBy(xpath = "//div[@class='rf-message-valid rf-message']")
	public WebElement successMsg;
	
	//select program name dropdown
	@FindBy(xpath = "//select[contains(@title,'Select Program')]")
	public WebElement prgmSelectDD;
	
	// Language Drop Down Options
    @FindBy(xpath=".//*[@class='item']")
   	public WebElement AddResour_LangdrpdwnList;
	
  //Add Resource button
  	@FindBy(xpath="//span[contains(text(),'Add Resource')]")
	public List<WebElement> addRsrc;

	@FindBy(xpath ="//*[@class='selectize-input items not-full has-options']/input")
	public WebElement rsrcSelNeed;
	
	//REquired Field Error Message
	@FindBy(xpath="//span[@data-ng-bind ='errorMsg']")
	public List<WebElement> AddResourcs_ErrorMessage;
	
	 //All Resource button
  	@FindBy(xpath="//a[contains(text(),'All Resources')]")
	public WebElement allRsrc;
	

	
	@FindBy(xpath ="//select[@title='Resources For']")
	public WebElement allRsrcFor;
	
	@FindBy(xpath ="//span[contains(text(),'Search')]")
	public WebElement allRsrcSearch;
	
	@FindBy(xpath ="//span[contains(text(),'Zipcode textbox')]/preceding-sibling::input[1]")
	public WebElement allRsrcZipcode;
	
	@FindBy(xpath ="//select[@title='Language']")
	public WebElement allRsrcLanguage;
	
	@FindBy(xpath ="//select[@title='Language']/option")
	public List<WebElement> allRsrcLanguages;
	
	@FindBy(xpath ="//span[contains(text(),'Resource Name textbox')]/preceding-sibling::input[1]")
	public WebElement allRsrcName;
	
	@FindBy(xpath =".//*[@id='rfButton_object_link_uiGrid-002J']")
	public WebElement allRsrcSearchRecord;
	
	
}
