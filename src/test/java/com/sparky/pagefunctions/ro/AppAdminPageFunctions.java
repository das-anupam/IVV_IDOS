package com.sparky.pagefunctions.ro;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import com.sparky.commonfunctions.ro.CommonFunction;
import com.sparky.flows.ro.RadiationOncology;
import com.sparky.helper.ro.LogAccess;
import com.sparky.objectrepository.ro.App_Admin;
import com.sparky.objectrepository.ro.Business_Owner;

public class AppAdminPageFunctions extends CommonFunction {

	public App_Admin aaInst;
	public Business_Owner boInst;
	WebDriver driver;
	public SoftAssert sa;
	int AssertCount = 0;
	String AssertName;
	String AUID;
	@SuppressWarnings("rawtypes")
	ArrayList expectedDropDownItems = new ArrayList();

	public AppAdminPageFunctions(WebDriver driver) throws Exception {
		super();
		BasicConfigurator.configure();
		System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http.client.protocol.ResponseProcessCookies", "fatal");		
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		aaInst = PageFactory.initElements(driver, App_Admin.class);
		boInst = PageFactory.initElements(driver, Business_Owner.class);
		sa = new SoftAssert();
	}

	@SuppressWarnings({ "static-access", "unused", "unchecked", "rawtypes" })
	public void AppAdmin(String screenshotsLoc, String methodName,String testName, SoftAssert sa) throws Exception {
		RadiationOncology.setTEST_NAME("AA1");
		AUID=RadiationOncology.getTEST_NAME();
		AA1: {
			// **************************************AUT1****************************************************************************************
			LogAccess.getLogger().info("SCREENSHOT_SUBFOLDER_PATH IN AUT BEFORE: " + screenshotsLoc);

			AssertCount = 0;

			AssertName = "Assert_" + methodName + "_"+AUID+"_";

			screenshotsLoc = RadiationOncology.getSCREENSHOT_SUBFOLDER_PATH() + "\\"+AUID+"\\";

			LogAccess.getLogger().info("SCREENSHOT_SUBFOLDER_PATH IN AUT AFTER: " + screenshotsLoc);

			verifyPageLoaded(driver, "Template Upload");

			String TU = "Template Upload";

			sa.assertEquals(aaInst.Header.getText(), TU, "Header Text not matching.");

			this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
					aaInst.Header);

			AssertCount++;



			RO_US_001_a:{	
				sa.assertEquals(aaInst.adminLanding.getText(), "Admin", "Tab Text not matching.");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.adminLanding);

				AssertCount++;

				sa.assertTrue(aaInst.fshTab.isDisplayed(), "File Submission History Tab is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.fshTab);

				AssertCount++;

				sa.assertTrue(aaInst.adminTab.isDisplayed(), "Admin Tab is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.adminTab);

				AssertCount++;


				sa.assertTrue(aaInst.resrcTab.isDisplayed(), "Resources Tab is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.resrcTab);

				AssertCount++;

				this.findButtonClick(driver, aaInst.adminTab);

				sa.assertTrue(aaInst.uploadSubAdmTab.isDisplayed(), "Upload Tab is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.uploadSubAdmTab);

				AssertCount++;

				sa.assertTrue(aaInst.eswSubAdmTab.isDisplayed(), "Extend Submission Window Tab is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.eswSubAdmTab);

				AssertCount++;

				sa.assertTrue(aaInst.rswSubAdmTab.isDisplayed(), "Reopen Submission Window Tab is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.rswSubAdmTab);

				AssertCount++;

				sa.assertTrue(aaInst.poSubAdmTab.isDisplayed(), "Participant Organizations Tab is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.poSubAdmTab);

				AssertCount++;

				sa.assertTrue(aaInst.Header.isDisplayed(), "Template Upload Header is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.Header);

				AssertCount++;

				String SH = "Select template type to use for future submission windows.";

				sa.assertEquals(aaInst.selectTempType.getText(), SH, "Select Template Type Text not matching.");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.selectTempType);

				AssertCount++;


				expectedDropDownItems.add("[SELECT]");
				expectedDropDownItems.add("Clinical Data Template for Electronic Health Record (EHR) Extracted");
				expectedDropDownItems.add("Clinical Data Template for Manual Input");
				expectedDropDownItems.add("Quality Measure Data Template for EHR Extracted");
				expectedDropDownItems.add("Quality Measure Data Template for Manual Input");

				for(int k=0;k<expectedDropDownItems.size();k++)
				{
					LogAccess.getLogger().info("expectedDropDownItems Drop-down values are: "+"\n"+expectedDropDownItems.get(k));

				}
				List<WebElement> valuesInUIDropDown  =  aaInst.tempTypeDD;

				ArrayList actualDropDownItems = new ArrayList();

				for(WebElement value : valuesInUIDropDown){
					actualDropDownItems.add(value.getText().trim());
				}
				LogAccess.getLogger().info("actualDropDownItems size is :"+actualDropDownItems.size());
				LogAccess.getLogger().info("expectedDropDownItems size is :"+expectedDropDownItems.size());
				// Compare expected and actual list
				for (int i = 0; i < expectedDropDownItems.size(); i++) {
					if ((actualDropDownItems.get(i).equals(expectedDropDownItems.get(i))))
					{
						LogAccess.getLogger().info("Drop-down values are in correct order: "+expectedDropDownItems.get(i));
					}else
					{
						LogAccess.getLogger().info("actualDropDownItems Drop-down values are not in correct order: "+"\n"+actualDropDownItems.get(i));

					}
				}

				expectedDropDownItems.clear();

				this.dropDownByIndex(driver, aaInst.tempTypeDDSelect.get(0), 2);

				sa.assertTrue(aaInst.tempTypeDDSelect.get(0).isDisplayed(), "Template Type DD is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.tempTypeDDSelect.get(0));

				AssertCount++;

				sa.assertTrue(aaInst.tempTypeSelectFile.isDisplayed(), "Select File is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.tempTypeSelectFile);

				AssertCount++;

				sa.assertTrue(aaInst.tempUploadHistory.isDisplayed(), "Template Upload History is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.tempUploadHistory);

				AssertCount++;

				List<WebElement>  col = driver.findElements(By.xpath(".//*[@summary='Template Upload History']/thead/tr/th"));
				LogAccess.getLogger().info("Total No of columns are : " +col.size());

				for (int i =0;i<col.size();i++)
				{   

					LogAccess.getLogger().info("Column Name is : " + col.get(i).getText());

					captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,col.get(i));

					AssertCount++;

				}
			}

			RO_US_003_a:{

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.eswSubAdmTab);

				AssertCount++;

				this.findButtonClick(driver, aaInst.eswSubAdmTab);

				sa.assertTrue(aaInst.rswSubAdmTab.isDisplayed(), "Reopen Submission Window Tab is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.rswSubAdmTab);

				AssertCount++;

				sa.assertTrue(aaInst.poSubAdmTab.isDisplayed(), "Participant Organizations Tab is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.poSubAdmTab);

				AssertCount++;

				String Comment="To complete this action, please enter a short explanation for the update of the submission window in the Comment field below, then select the Update button. If you need to make any changes to the submission window, please do so at this point.";

				sa.assertEquals(aaInst.comment.getText(),Comment, "Comment Doesn't match");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.comment);

				AssertCount++;

				sa.assertTrue(aaInst.eswHdr.isDisplayed(), "ESW Header is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.eswHdr);

				AssertCount++;

				expectedDropDownItems.add("[SELECT]");
				expectedDropDownItems.add("Clinical Data");
				expectedDropDownItems.add("Quality Measures Data");

				List<WebElement> valuesInUIDropDown  =  aaInst.fileTypeDD;

				ArrayList actualDropDownItems = new ArrayList();

				for(WebElement value : valuesInUIDropDown){
					actualDropDownItems.add(value.getText().trim());
				}
				LogAccess.getLogger().info("actualDropDownItems size is :"+actualDropDownItems.size());
				LogAccess.getLogger().info("expectedDropDownItems size is :"+expectedDropDownItems.size());
				// Compare expected and actual list
				for (int i = 0; i < expectedDropDownItems.size(); i++) {
					if ((actualDropDownItems.get(i).equals(expectedDropDownItems.get(i))))
					{
						LogAccess.getLogger().info("Drop-down values are in correct order: "+expectedDropDownItems.get(i));
					}else
					{
						LogAccess.getLogger().info("actualDropDownItems Drop-down values are not in correct order: "+"\n"+actualDropDownItems.get(i));

					}
				}

				expectedDropDownItems.clear();

				this.dropDownByIndex(driver, aaInst.fileTypeDDSelect.get(0), 1);

				sa.assertTrue(aaInst.fileTypeDDSelect.get(0).isDisplayed(), "File Type DD is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.fileTypeDDSelect.get(0));

				AssertCount++;

				sa.assertTrue(aaInst.reportPeriodDD.get(0).isDisplayed(), "Reporting Period DD is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.reportPeriodDD.get(0));

				AssertCount++;

				sa.assertTrue(aaInst.submissionStartDate.isDisplayed(), "submissionStartDate is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.submissionStartDate);

				AssertCount++;

				sa.assertTrue(aaInst.submissionEndDate.isDisplayed(), "submissionEndDate is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.submissionEndDate);

				AssertCount++;

				sa.assertTrue(aaInst.stateDD.get(0).isDisplayed(), "stateDD is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.stateDD.get(0));

				AssertCount++;

				sa.assertTrue(aaInst.tinDD.get(0).isDisplayed(), "tinDD is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.tinDD.get(0));

				AssertCount++;

				sa.assertTrue(aaInst.commentHdr.isDisplayed(), "commentHdr is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.commentHdr);

				AssertCount++;

				sa.assertTrue(aaInst.update.isDisplayed(), "update is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.update);

				AssertCount++;

				//Field Validations
				String AttrComment=this.getAttribute(driver, aaInst.commentTextarea, "maxlength");
				sa.assertEquals(AttrComment, "200", "ERROR: Wrong maxlenght is Displayed in Comment!! ");
			}

			RO_US_004_a:{

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.rswSubAdmTab);

				AssertCount++;	

				this.findButtonClick(driver, boInst.rswSubAdmTab);

				sa.assertTrue(boInst.eswSubAdmTab.isDisplayed(), "Extend Submission Window Tab is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.eswSubAdmTab);

				AssertCount++;

				sa.assertTrue(boInst.poSubAdmTab.isDisplayed(), "Participant Organizations Tab is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.poSubAdmTab);

				AssertCount++;

				String Comment="To complete this action, please enter a short explanation for the update of the submission window in the Comment field below, then select the Reopen button. If you need to make any changes to the submission window, please do so at this point.";

				sa.assertEquals(boInst.comment.getText(),Comment, "Comment Doesn't match");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.comment);

				AssertCount++;

				sa.assertTrue(boInst.rswHdr.isDisplayed(), "ESW Header is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.rswHdr);

				AssertCount++;

				expectedDropDownItems.add("[SELECT]");
				expectedDropDownItems.add("Clinical Data");
				expectedDropDownItems.add("Quality Measures Data");

				List<WebElement> valuesInUIDropDown  =  boInst.fileTypeDD;

				ArrayList actualDropDownItems = new ArrayList();

				for(WebElement value : valuesInUIDropDown){
					actualDropDownItems.add(value.getText().trim());
				}
				LogAccess.getLogger().info("actualDropDownItems size is :"+actualDropDownItems.size());
				LogAccess.getLogger().info("expectedDropDownItems size is :"+expectedDropDownItems.size());
				// Compare expected and actual list
				for (int i = 0; i < expectedDropDownItems.size(); i++) {
					if ((actualDropDownItems.get(i).equals(expectedDropDownItems.get(i))))
					{
						LogAccess.getLogger().info("Drop-down values are in correct order: "+expectedDropDownItems.get(i));
					}else
					{
						LogAccess.getLogger().info("actualDropDownItems Drop-down values are not in correct order: "+"\n"+actualDropDownItems.get(i));

					}
				}

				expectedDropDownItems.clear();

				this.dropDownByIndex(driver, boInst.fileTypeDDSelect.get(0), 1);

				sa.assertTrue(boInst.fileTypeDDSelect.get(0).isDisplayed(), "File Type DD is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.fileTypeDDSelect.get(0));

				AssertCount++;

				sa.assertTrue(boInst.reportPeriodDD.get(0).isDisplayed(), "Reporting Period DD is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.reportPeriodDD.get(0));

				AssertCount++;

				sa.assertTrue(boInst.submissionStartDate.isDisplayed(), "submissionStartDate is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.submissionStartDate);

				AssertCount++;

				sa.assertTrue(boInst.submissionEndDate.isDisplayed(), "submissionEndDate is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.submissionEndDate);

				AssertCount++;

				sa.assertTrue(boInst.stateDD.get(0).isDisplayed(), "stateDD is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.stateDD.get(0));

				AssertCount++;

				sa.assertTrue(boInst.tinDD.get(0).isDisplayed(), "tinDD is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.tinDD.get(0));

				AssertCount++;

				sa.assertTrue(boInst.commentHdr.isDisplayed(), "commentHdr is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.commentHdr);

				AssertCount++;

				sa.assertTrue(boInst.reopen.isDisplayed(), "reopen is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.reopen);

				AssertCount++;

				//Field Validations
				String AttrComment=this.getAttribute(driver, boInst.commentTextarea, "maxlength");
				sa.assertEquals(AttrComment, "200", "ERROR: Wrong maxlenght is Displayed in Comment!! ");
			}
			RO_US_005_a:{

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.poSubAdmTab);

				AssertCount++;

				this.findButtonClick(driver, aaInst.poSubAdmTab);

				sa.assertTrue(aaInst.reportPeriodDD.get(0).isDisplayed(), "Reporting Period DD is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.reportPeriodDD.get(0));

				AssertCount++;

				List<WebElement>  col = driver.findElements(By.xpath(".//*[@summary='Participating Organizations']/thead/tr/th"));
				LogAccess.getLogger().info("Total No of columns are : " +col.size());

				for (int i =0;i<col.size();i++)
				{   

					LogAccess.getLogger().info("Column Name is : " + col.get(i).getText());

					captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,col.get(i));

					AssertCount++;

				}

				sa.assertTrue(aaInst.exportAll.isDisplayed(), "exportAll is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.exportAll);

				AssertCount++;

			}
			RO_US_007_a:{

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.fshTab);

				AssertCount++;

				this.findButtonClick(driver, aaInst.fshTab);

				sa.assertTrue(aaInst.consReports.isDisplayed(), "consReports is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.consReports);

				AssertCount++;

				List<WebElement>  col = driver.findElements(By.xpath(".//*[@summary='Consolidated Reports']/thead/tr/th"));
				LogAccess.getLogger().info("Total No of columns are : " +col.size());

				for (int i =0;i<col.size();i++)
				{   

					LogAccess.getLogger().info("Column Name is : " + col.get(i).getText());

					captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,col.get(i));

					AssertCount++;

				}

			}


			RO_US_009_a:{


				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.submitFilesTab);

				AssertCount++;

				this.findButtonClick(driver, aaInst.submitFilesTab);

				sa.assertTrue(aaInst.download.isDisplayed(), "download is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.download);

				AssertCount++;

				sa.assertTrue(aaInst.landingHdr.isDisplayed(), "landingHdr is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.landingHdr);

				AssertCount++;

				sa.assertTrue(aaInst.loaTemplates.isDisplayed(), "loaTemplates is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.loaTemplates);

				AssertCount++;

				List<WebElement>  col = driver.findElements(By.xpath(".//*[@summary='List of Available Templates']/thead/tr/th"));
				LogAccess.getLogger().info("Total No of columns are : " +col.size());

				for (int i =0;i<col.size();i++)
				{   

					LogAccess.getLogger().info("Column Name is : " + col.get(i).getText());

					captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,col.get(i));

					AssertCount++;

				}

			}
			RO_US_0011_a:{

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.fshTab);

				AssertCount++;

				this.findButtonClick(driver, aaInst.fshTab);

				sa.assertTrue(aaInst.fshHdr.isDisplayed(), "fshHdr is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.fshHdr);

				AssertCount++;

				sa.assertTrue(aaInst.fshStaticTxt.isDisplayed(), "fshStaticTxt is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.fshStaticTxt);

				AssertCount++;


				List<WebElement>  col = driver.findElements(By.xpath(".//*[@summary='File Submission History']/thead/tr/th"));
				LogAccess.getLogger().info("Total No of columns are : " +col.size());

				for (int i =0;i<col.size();i++)
				{   

					LogAccess.getLogger().info("Column Name is : " + col.get(i).getText());

					captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,col.get(i));

					AssertCount++;

				}

				sa.assertTrue(aaInst.exportAll.isDisplayed(), "exportAll is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.exportAll);

				AssertCount++;

			}

			RO_US_008_a:{

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.homeTab);

				AssertCount++;

				this.findButtonClick(driver, aaInst.homeTab);

				sa.assertTrue(aaInst.homeTabHdr.isDisplayed(), "Home Tab Header is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.homeTabHdr);

				AssertCount++;

				String HTT="Welcome to the secure data portal for the Radiation Oncology Model. Beneficiary-level clinical data and practice-level quality measures data will be submitted here.";

				sa.assertEquals(aaInst.homeStaticTxt.getText(), HTT, "Static Text not matching.");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.homeStaticTxt);

				AssertCount++;

				sa.assertTrue(aaInst.submitFilesTab.isDisplayed(), "Home Tab is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.submitFilesTab);

				AssertCount++;

			}
			RO_US_0012_a:{


				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.resrcTab);

				AssertCount++;

				this.findButtonClick(driver, boInst.resrcTab);

				sa.assertTrue(boInst.resrcStaticTxt.isDisplayed(), "resrcStaticTxt is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.resrcStaticTxt);

				AssertCount++;

				sa.assertTrue(boInst.resrcHD.isDisplayed(), "resrcHD is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.resrcHD);

				AssertCount++;

				sa.assertTrue(boInst.resrcUM.isDisplayed(), "resrcUM is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.resrcUM);

				AssertCount++;

				sa.assertTrue(boInst.resrcRL.isDisplayed(), "resrcRL is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.resrcRL);

				AssertCount++;

				sa.assertTrue(boInst.resrcRL.isDisplayed(), "resrcRL is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.resrcRL);

				AssertCount++;

				sa.assertTrue(boInst.resrcHDInfo.isDisplayed(), "resrcHDInfo is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.resrcHDInfo);

				AssertCount++;

				List<WebElement>  col = driver.findElements(By.xpath(".//*[@summary='User Manual']/thead/tr/th"));
				LogAccess.getLogger().info("Total No of columns are : " +col.size());

				for (int i =0;i<col.size();i++)
				{   

					LogAccess.getLogger().info("Column Name is : " + col.get(i).getText());

					captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,col.get(i));

					AssertCount++;

				}

			}
		}
	}

	@SuppressWarnings({ "static-access", "unused" })
	public void Participant(String screenshotsLoc, String methodName,String testName, SoftAssert sa) throws Exception {
		RadiationOncology.setTEST_NAME("PA1");
		AUID=RadiationOncology.getTEST_NAME();
		PA1: {
			// **************************************AUT1****************************************************************************************
			LogAccess.getLogger().info("SCREENSHOT_SUBFOLDER_PATH IN AUT BEFORE: " + screenshotsLoc);

			AssertCount = 0;

			AssertName = "Assert_" + methodName + "_"+AUID+"_";

			screenshotsLoc = RadiationOncology.getSCREENSHOT_SUBFOLDER_PATH() + "\\"+AUID+"\\";

			LogAccess.getLogger().info("SCREENSHOT_SUBFOLDER_PATH IN AUT AFTER: " + screenshotsLoc);



			RO_US_008_a:{

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.homeTab);

				AssertCount++;

				this.findButtonClick(driver, aaInst.homeTab);

				sa.assertTrue(aaInst.homeTabHdr.isDisplayed(), "Home Tab Header is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.homeTabHdr);

				AssertCount++;

				String HTT="Welcome to the secure data portal for the Radiation Oncology Model. Beneficiary-level clinical data and practice-level quality measures data will be submitted here.";

				sa.assertEquals(aaInst.homeStaticTxt.getText(), HTT, "Static Text not matching.");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.homeStaticTxt);

				AssertCount++;

				sa.assertTrue(boInst.tinDD.get(0).isDisplayed(), "tinDD is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.tinDD.get(0));

				AssertCount++;

				sa.assertTrue(aaInst.submitFilesTab.isDisplayed(), "Home Tab is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.submitFilesTab);

				AssertCount++;
			}

			RO_US_009_a:{


				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.submitFilesTab);

				AssertCount++;

				this.findButtonClick(driver, aaInst.submitFilesTab);

				sa.assertTrue(aaInst.download.isDisplayed(), "download is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.download);

				AssertCount++;

				sa.assertTrue(aaInst.landingHdr.isDisplayed(), "landingHdr is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.landingHdr);

				AssertCount++;

				sa.assertTrue(aaInst.loaTemplates.isDisplayed(), "loaTemplates is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.loaTemplates);

				AssertCount++;

				List<WebElement>  col = driver.findElements(By.xpath(".//*[@summary='List of Available Templates']/thead/tr/th"));
				LogAccess.getLogger().info("Total No of columns are : " +col.size());

				for (int i =0;i<col.size();i++)
				{   

					LogAccess.getLogger().info("Column Name is : " + col.get(i).getText());

					captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,col.get(i));

					AssertCount++;

				}

				sa.assertTrue(aaInst.uploadSubAdmTab.isDisplayed(), "uploadSubAdmTab is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.uploadSubAdmTab);

				AssertCount++;

				this.findButtonClick(driver, aaInst.uploadSubAdmTab);

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.homeTabHdr);

				AssertCount++;


				this.dropDownByIndex(driver, aaInst.fileTypeDDSelect.get(0), 1);

				sa.assertTrue(aaInst.fileTypeDDSelect.get(0).isDisplayed(), "File Type DD is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.fileTypeDDSelect.get(0));

				AssertCount++;

				this.dropDownByIndex(driver, aaInst.tempTypeDDSelect.get(0), 2);

				sa.assertTrue(aaInst.tempTypeDDSelect.get(0).isDisplayed(), "Template Type DD is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.tempTypeDDSelect.get(0));

				AssertCount++;

				sa.assertTrue(aaInst.reportPeriodDD.get(0).isDisplayed(), "Reporting Period DD is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.reportPeriodDD.get(0));

				AssertCount++;

				sa.assertTrue(aaInst.tempTypeSelectFile.isDisplayed(), "Select File is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.tempTypeSelectFile);

				AssertCount++;

			}


			RO_US_0011_a:{

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.fshTab);

				AssertCount++;

				this.findButtonClick(driver, aaInst.fshTab);

				sa.assertTrue(aaInst.fshHdr3.isDisplayed(), "fshHdr3 is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.fshHdr3);

				AssertCount++;

				sa.assertTrue(aaInst.fshStaticTxt.isDisplayed(), "fshStaticTxt is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.fshStaticTxt);

				AssertCount++;


				List<WebElement>  col = driver.findElements(By.xpath(".//*[@summary='File Submission History']/thead/tr/th"));
				LogAccess.getLogger().info("Total No of columns are : " +col.size());

				for (int i =0;i<col.size();i++)
				{   

					LogAccess.getLogger().info("Column Name is : " + col.get(i).getText());

					captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,col.get(i));

					AssertCount++;

				}

				sa.assertTrue(aaInst.exportAll.isDisplayed(), "exportAll is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						aaInst.exportAll);

				AssertCount++;

			}

			RO_US_0012_a:{


				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.resrcTab);

				AssertCount++;

				this.findButtonClick(driver, boInst.resrcTab);

				sa.assertTrue(boInst.resrcStaticTxt.isDisplayed(), "resrcStaticTxt is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.resrcStaticTxt);

				AssertCount++;

				sa.assertTrue(boInst.resrcHD.isDisplayed(), "resrcHD is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.resrcHD);

				AssertCount++;

				sa.assertTrue(boInst.resrcUM.isDisplayed(), "resrcUM is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.resrcUM);

				AssertCount++;

				sa.assertTrue(boInst.resrcRL.isDisplayed(), "resrcRL is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.resrcRL);

				AssertCount++;

				sa.assertTrue(boInst.resrcRL.isDisplayed(), "resrcRL is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.resrcRL);

				AssertCount++;

				sa.assertTrue(boInst.resrcHDInfo.isDisplayed(), "resrcHDInfo is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.resrcHDInfo);

				AssertCount++;

				List<WebElement>  col = driver.findElements(By.xpath(".//*[@summary='User Manual']/thead/tr/th"));
				LogAccess.getLogger().info("Total No of columns are : " +col.size());

				for (int i =0;i<col.size();i++)
				{   

					LogAccess.getLogger().info("Column Name is : " + col.get(i).getText());

					captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,col.get(i));

					AssertCount++;

				}

			}

		}

	}
}