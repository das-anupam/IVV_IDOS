package com.sparky.pagefunctions.ro;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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

public class BusinessOwnerPageFunctions extends CommonFunction {

	public Business_Owner boInst;
	public App_Admin aaInst;
	WebDriver driver;
	public SoftAssert sa;
	int AssertCount = 0;
	String AssertName;
	String AUID;
	@SuppressWarnings("rawtypes")
	ArrayList expectedDropDownItems = new ArrayList();

	public BusinessOwnerPageFunctions(WebDriver driver) throws Exception {
		super();
		BasicConfigurator.configure();
		System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http.client.protocol.ResponseProcessCookies", "fatal");		
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		boInst = PageFactory.initElements(driver, Business_Owner.class);
		aaInst = PageFactory.initElements(driver, App_Admin.class);
		sa = new SoftAssert();
	}

	@SuppressWarnings({ "static-access", "unused", "unchecked", "rawtypes" })
	public void BusinessOwner(String screenshotsLoc, String methodName,String testName, SoftAssert sa) throws Exception {
		RadiationOncology.setTEST_NAME("BO1");
		AUID=RadiationOncology.getTEST_NAME();
		BO1: {
			// **************************************AUT1****************************************************************************************
			LogAccess.getLogger().info("SCREENSHOT_SUBFOLDER_PATH IN AUT BEFORE: " + screenshotsLoc);

			AssertCount = 0;

			AssertName = "Assert_" + methodName + "_"+AUID+"_";

			screenshotsLoc = RadiationOncology.getSCREENSHOT_SUBFOLDER_PATH() + "\\"+AUID+"\\";

			LogAccess.getLogger().info("SCREENSHOT_SUBFOLDER_PATH IN AUT AFTER: " + screenshotsLoc);

			verifyPageLoaded(driver, "Template Upload");

			String TU = "Template Upload";

			sa.assertEquals(boInst.Header.getText(), TU, "Header Text not matching.");

			this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
					boInst.Header);

			AssertCount++;

			RO_US_002_a:{	
				sa.assertEquals(boInst.adminLanding.getText(), "Admin", "Tab Text not matching.");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.adminLanding);

				AssertCount++;

				sa.assertTrue(boInst.fshTab.isDisplayed(), "File Submission History Tab is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.fshTab);

				AssertCount++;

				sa.assertTrue(boInst.adminTab.isDisplayed(), "Admin Tab is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.adminTab);

				AssertCount++;


				sa.assertTrue(boInst.resrcTab.isDisplayed(), "Resources Tab is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.resrcTab);

				AssertCount++;

				this.findButtonClick(driver, boInst.adminTab);

				sa.assertTrue(boInst.uploadSubAdmTab.isDisplayed(), "Upload Tab is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.uploadSubAdmTab);

				AssertCount++;
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

			RO_US_006_a:{

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.fshTab);

				AssertCount++;

				this.findButtonClick(driver, boInst.fshTab);

				sa.assertTrue(boInst.fshStaticTxt.isDisplayed(), "fshStaticTxt is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.fshStaticTxt);

				AssertCount++;


				List<WebElement>  col = driver.findElements(By.xpath(".//*[@summary='File Submission History']/thead/tr/th"));
				LogAccess.getLogger().info("Total No of columns are : " +col.size());

				for (int i =0;i<col.size();i++)
				{   

					LogAccess.getLogger().info("Column Name is : " + col.get(i).getText());

					captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,col.get(i));

					AssertCount++;

				}

				sa.assertTrue(boInst.exportAll.isDisplayed(), "exportAll is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.exportAll);

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

	@SuppressWarnings({ "static-access", "unused", "unchecked", "rawtypes" })
	public void ModelTeam(String screenshotsLoc, String methodName,String testName, SoftAssert sa) throws Exception {
		RadiationOncology.setTEST_NAME("MT1");
		AUID=RadiationOncology.getTEST_NAME();
		MT1: {
			// **************************************AUT1****************************************************************************************
			LogAccess.getLogger().info("SCREENSHOT_SUBFOLDER_PATH IN AUT BEFORE: " + screenshotsLoc);

			AssertCount = 0;

			AssertName = "Assert_" + methodName + "_"+AUID+"_";

			screenshotsLoc = RadiationOncology.getSCREENSHOT_SUBFOLDER_PATH() + "\\"+AUID+"\\";

			LogAccess.getLogger().info("SCREENSHOT_SUBFOLDER_PATH IN AUT AFTER: " + screenshotsLoc);

			verifyPageLoaded(driver, "Template Upload");

			String TU = "Template Upload";

			sa.assertEquals(boInst.Header.getText(), TU, "Header Text not matching.");

			this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
					boInst.Header);

			AssertCount++;

			RO_US_002_a:{	
				sa.assertEquals(boInst.adminLanding.getText(), "Admin", "Tab Text not matching.");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.adminLanding);

				AssertCount++;

				sa.assertTrue(boInst.fshTab.isDisplayed(), "File Submission History Tab is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.fshTab);

				AssertCount++;

				sa.assertTrue(boInst.adminTab.isDisplayed(), "Admin Tab is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.adminTab);

				AssertCount++;


				sa.assertTrue(boInst.resrcTab.isDisplayed(), "Resources Tab is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.resrcTab);

				AssertCount++;

				this.findButtonClick(driver, boInst.adminTab);

				sa.assertTrue(boInst.uploadSubAdmTab.isDisplayed(), "Upload Tab is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.uploadSubAdmTab);

				AssertCount++;

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

			RO_US_006_a:{

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.fshTab);

				AssertCount++;

				this.findButtonClick(driver, boInst.fshTab);

				sa.assertTrue(boInst.fshStaticTxt.isDisplayed(), "fshStaticTxt is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.fshStaticTxt);

				AssertCount++;


				List<WebElement>  col = driver.findElements(By.xpath(".//*[@summary='File Submission History']/thead/tr/th"));
				LogAccess.getLogger().info("Total No of columns are : " +col.size());

				for (int i =0;i<col.size();i++)
				{   

					LogAccess.getLogger().info("Column Name is : " + col.get(i).getText());

					captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,col.get(i));

					AssertCount++;

				}

				sa.assertTrue(boInst.exportAll.isDisplayed(), "exportAll is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.exportAll);

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

	@SuppressWarnings({ "static-access", "unused", "unchecked", "rawtypes" })
	public void ImplementationContractor(String screenshotsLoc, String methodName,String testName, SoftAssert sa) throws Exception {
		RadiationOncology.setTEST_NAME("IC1");
		AUID=RadiationOncology.getTEST_NAME();
		IC1: {
			// **************************************AUT1****************************************************************************************
			LogAccess.getLogger().info("SCREENSHOT_SUBFOLDER_PATH IN AUT BEFORE: " + screenshotsLoc);

			AssertCount = 0;

			AssertName = "Assert_" + methodName + "_"+AUID+"_";

			screenshotsLoc = RadiationOncology.getSCREENSHOT_SUBFOLDER_PATH() + "\\"+AUID+"\\";

			LogAccess.getLogger().info("SCREENSHOT_SUBFOLDER_PATH IN AUT AFTER: " + screenshotsLoc);

			verifyPageLoaded(driver, "Template Upload");

			String TU = "Template Upload";

			sa.assertEquals(boInst.Header.getText(), TU, "Header Text not matching.");

			this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
					boInst.Header);

			AssertCount++;

			RO_US_002_a:{	
				sa.assertEquals(boInst.adminLanding.getText(), "Admin", "Tab Text not matching.");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.adminLanding);

				AssertCount++;

				sa.assertTrue(boInst.fshTab.isDisplayed(), "File Submission History Tab is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.fshTab);

				AssertCount++;

				sa.assertTrue(boInst.adminTab.isDisplayed(), "Admin Tab is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.adminTab);

				AssertCount++;


				sa.assertTrue(boInst.resrcTab.isDisplayed(), "Resources Tab is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.resrcTab);

				AssertCount++;

				//this.findButtonClick(driver, boInst.adminTab);

				sa.assertTrue(boInst.uploadSubAdmTab.isDisplayed(), "Upload Tab is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.uploadSubAdmTab);

				AssertCount++;

				sa.assertTrue(boInst.selectFileTypeDD.get(0).isDisplayed(), "Select File Type DD is not Displayed");


				this.dropDownByIndex(driver, boInst.selectFileTypeDD.get(0), 2);

				this.findButtonClick(driver, boInst.selectFileTypeDD.get(0));
				


				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.selectFileTypeDD.get(0));


				
				AssertCount++;	

				/*	WebDriverWait wait=new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.elementToBeClickable(boInst.selectFile.get(1)));
				 */


				// Get Parent window handle
				String winHandleBefore = driver.getWindowHandle();
				Thread.sleep(5000);
				this.findButtonClick(driver, boInst.selectFile.get(1));
				System.out.println("Script reached  here : window handling page");
				for (String winHandle : driver.getWindowHandles()) {
					// Switch to child window
					driver.switchTo().window(winHandle);
				//	StringSelection input = new StringSelection(System.getProperty("user.dir")+"\\Input\\"+"DF.txt");
					StringSelection path = new StringSelection("C:\\Users\\meenashisundar.palan\\eclipse-workspace\\IVV\\Input\\DF.txt");//sundar added
					String currentDirectory = System.getProperty("user.dir")+"\\Input\\"+"DF.txt";
					System.out.println("user.dir: " + currentDirectory);
					System.out.println("input file is: "+path);
					Toolkit.getDefaultToolkit().getSystemClipboard().setContents(path, null);  
					

					Robot robot = new Robot();


					robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
					robot.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
					robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
					robot.keyPress(java.awt.event.KeyEvent.VK_V);
					robot.keyRelease(java.awt.event.KeyEvent.VK_V);
					robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);

					Thread.sleep(3000);
					robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
					//	uploadFile(System.getProperty("user.dir")+"\\Input\\"+"DF.txt");

					robot.keyRelease(KeyEvent.VK_ENTER);


					driver.switchTo().activeElement();

				}
				// to switch to parent window.
				driver.switchTo().window(winHandleBefore);


				System.out.println("I am here with title: "+driver.getTitle());

				// driver.findElement(By.xpath(".//*[@summary='Selected files for for Delta File']/tbody/tr/td[3]/div/div/div[2]/div/div/button[1]/span")).click();
				//.//table[1]/tbody/tr/td[3]/div/div/div[2]/div/div/button[1]/span
				// this.findButtonClick(driver, boInst.uploadList.get(1));
				this.findButtonClick(driver, boInst.DFupload);
				String successMsg="You have successfully uploaded a file.";
				successMsg=successMsg.trim();
				sa.assertEquals(boInst.SuccessMessage.getText(), successMsg,
						"Success Text not matching.");
				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.SuccessMessage);

				AssertCount++;


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

			RO_US_006_a:{

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.fshTab);

				AssertCount++;

				this.findButtonClick(driver, boInst.fshTab);

				sa.assertTrue(boInst.fshStaticTxt.isDisplayed(), "fshStaticTxt is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.fshStaticTxt);

				AssertCount++;


				List<WebElement>  col = driver.findElements(By.xpath(".//*[@summary='File Submission History']/thead/tr/th"));
				LogAccess.getLogger().info("Total No of columns are : " +col.size());

				for (int i =0;i<col.size();i++)
				{   

					LogAccess.getLogger().info("Column Name is : " + col.get(i).getText());

					captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,col.get(i));

					AssertCount++;

				}

				sa.assertTrue(boInst.exportAll.isDisplayed(), "exportAll is not Displayed");

				this.captureHighlightScreenshot(driver, screenshotsLoc, AssertName + AssertCount,
						boInst.exportAll);

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
	public void HelpDesk(String screenshotsLoc, String methodName,String testName, SoftAssert sa) throws Exception {
		RadiationOncology.setTEST_NAME("HD1");
		AUID=RadiationOncology.getTEST_NAME();
		HD1: {
			// **************************************AUT1****************************************************************************************
			LogAccess.getLogger().info("SCREENSHOT_SUBFOLDER_PATH IN AUT BEFORE: " + screenshotsLoc);

			AssertCount = 0;

			AssertName = "Assert_" + methodName + "_"+AUID+"_";

			screenshotsLoc = RadiationOncology.getSCREENSHOT_SUBFOLDER_PATH() + "\\"+AUID+"\\";

			LogAccess.getLogger().info("SCREENSHOT_SUBFOLDER_PATH IN AUT AFTER: " + screenshotsLoc);

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



