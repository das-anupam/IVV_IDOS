package com.sparky.commonfunctions.ro;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.sparky.commonvariables.ro.CommonVariables;
import com.sparky.helper.ro.Helper;
import com.sparky.helper.ro.LogAccess;
import com.sparky.helper.ro.Processor;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class CommonFunction {

	protected static String Result = "Default";
	protected static Processor processor = null;
	protected static Helper helper = null;
	static String userID = null;
	static String runTC = null;
	public String uname = null;
	protected String pwd = null;
	protected String role = null;
	public static ArrayList<String> UserIDList = new ArrayList<String>();
	static CommonFunction Setup = null;
	private int timeout = 30;
	CommonVariables c;
	static int size;

	/**
	 * @return the size
	 */
	public static int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public static void setSize(int size) {
		CommonFunction.size = size;
	}

	public static String getResult() {
		return Result;
	}

	public static void setResult(String result) {
		Result = result;
	}

	public CommonFunction() throws Exception {

	}

	// Read Data From Excel
	protected static String readDataFromExcel(int rowcount, int columncount, String filepath, String Sheetname) {
		String data = null;
		try {
			FileInputStream input = new FileInputStream(filepath);
			XSSFWorkbook wb = new XSSFWorkbook(input);
			XSSFSheet sh = wb.getSheet(Sheetname);
			try {
				sh.createFreezePane(0, 0);
			} catch (IndexOutOfBoundsException e) {

				System.out.println("The cells are not frozen");
			}
			XSSFRow row = sh.getRow(rowcount);
			String iCellVal = row.getCell(columncount).toString();
			wb.close();
			return iCellVal;
		} catch (Exception e) {
			System.out.println(e);
		}
		//JOptionPane.showMessageDialog(null, "The Parameter is Selected:-> " + data);
		return data;
	}

	protected static void actionsAutoListSelect(WebDriver driver) throws InterruptedException {
		try {
			Actions action = new Actions(driver);
			action.sendKeys(Keys.DOWN);
			Thread.sleep(1000);
			action.sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			action.perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}

	// Write Data To Excel
	protected void writeDataToExcel(int rowcount, int columncount, String filepath, String Sheetname, String value,
			String iColor) {
		try {
			FileInputStream input = new FileInputStream(filepath);
			XSSFWorkbook wb = new XSSFWorkbook(input);
			XSSFSheet sh = wb.getSheet(Sheetname);
			XSSFRow row = sh.getRow(rowcount);
			XSSFCellStyle iSatzCellStyle = wb.createCellStyle();
			iSatzCellStyle.setBorderTop(BorderStyle.THIN);
			iSatzCellStyle.setBorderBottom(BorderStyle.THIN);
			iSatzCellStyle.setBorderLeft(BorderStyle.THIN);
			iSatzCellStyle.setBorderRight(BorderStyle.THIN);
			if (iColor.equalsIgnoreCase("GREEN")) {
				// iSatzCellStyle.setFillForegroundColor(HSSFColor.SEA_GREEN.index);
				// iSatzCellStyle.setFillPattern( XSSFCellStyle.SOLID_FOREGROUND);
			} else if (iColor.equalsIgnoreCase("RED")) {
				// iSatzCellStyle.setFillForegroundColor(HSSFColor.ORANGE.index);
				// iSatzCellStyle.setFillPattern( XSSFCellStyle.SOLID_FOREGROUND);
			} else if (iColor.equalsIgnoreCase("GOLD")) {
				// iSatzCellStyle.setFillForegroundColor(HSSFColor.GOLD.index);
				// iSatzCellStyle.setFillPattern( XSSFCellStyle.SOLID_FOREGROUND);
			} else if (iColor.equalsIgnoreCase("NONE")) {
			}
			FileOutputStream webdata = new FileOutputStream(filepath);
			row.createCell(columncount).setCellValue(value);
			row.getCell(columncount).setCellStyle(iSatzCellStyle);
			wb.write(webdata);
			webdata.close();
			wb.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// ********************Move Files to Another Location for BackUP
	public static void iMoveFilesBackUP(String sourceFolder, String destinationFolder) throws IOException {
		File sourceFold = new File(sourceFolder);
		File destinationFold = new File(destinationFolder);
		if (sourceFold.exists() && sourceFold.isDirectory()) {
			if (!destinationFold.exists()) {
				destinationFold.mkdirs();
				System.out.println("Successfully Created Destination Folder:-->" + destinationFold);
			}
			File[] iAllFiles = sourceFold.listFiles();
			if (iAllFiles.length == 0) {
				System.out.println("Source Folder Exists..But No Files... Please Verify:-->" + sourceFold);
			} else {
				for (File iFileName : iAllFiles) {
					iFileName.renameTo(new File(destinationFold + "\\" + iFileName.getName()));
					System.out.println(
							"Successfully Moved Folder/File:-->" + iFileName.getName() + "-->To Destination Folder");
				}
			}
		} else {
			System.out.println("Source Folder Does Not Exists... Please Verify:-->" + sourceFold);
		}
	}

	// ****************Upload File
	// "./Upload_File/iSparkSatzAutoFileUPload.xlsx"
	protected static String uploadFile(String iUploadFilePath) throws Exception {
		File iUpfilepath = new File(iUploadFilePath);
		String iUploadAbsFilepath = iUpfilepath.getAbsolutePath();
		return iUploadAbsFilepath;
	}

	// **************Create Folder
	public static String createFolder(String iOutputReportPath, String iOutputReportFolderName) throws Exception {
		String iReportFolderName = iOutputReportFolderName;
		File iReportFolderCreate = new File(iOutputReportPath + iReportFolderName);
		if (!iReportFolderCreate.exists()) {
			if (iReportFolderCreate.mkdir()) {
				System.out.println("Folder is created!");
			}
		}
		return iReportFolderName;
	}

	// ***********Capture Date and TimeStamp
	public static String iCreateTimeStampStr() throws Exception {
		Calendar mycalendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("MMddyyy_hhmmss");
		String timeStamp = formatter.format(mycalendar.getTime());

		return timeStamp;
	}

	// ***************Screenshot Function
	public static void captureScreenshot(WebDriver driver, String iScreenShotpath, String iScreenshotName) {
		try {
			// Shutterbug.shootPage(driver,ScrollStrategy.VERTICALLY,1000,true).save(iScreenShotpath+"\\"+iScreenshotName
			// );
			File iScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(iScreenshot, new File(iScreenShotpath + "\\" + iScreenshotName + ".png"));
			LogAccess.getLogger().info("Screenshot Taken refer Folder :" + iScreenShotpath + "\\" + iScreenshotName);
		} catch (Exception e) {
			LogAccess.getLogger().info("Error While Taking Screenshot" + e);
		}
	}

	public static void captureHighlightScreenshot(WebDriver driver, String iScreenShotpath, String iScreenshotName,
			WebElement ele) throws IOException 
	{
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
			js.executeScript("arguments[0].setAttribute('style', 'background: orange; border: 2px solid red;');", ele);
			File iScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(iScreenshot, new File(iScreenShotpath + "\\" + iScreenshotName + ".png"));
			Thread.sleep(1000);
			LogAccess.getLogger().info("Screenshot Taken refer Folder" + iScreenShotpath + "\\" + iScreenshotName);
		} catch (Exception e) {

			LogAccess.getLogger().info("Error While Taking Screenshot" + e);
			try {
				throw e;
			} catch (Exception e1) {

				e1.printStackTrace();
			}
		}
	}

	// *******************Application Highlight Function
	public static void highlight(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {

			js.executeScript("arguments[0].setAttribute('style', 'background: maroon; border: 2px solid yellow;');",
					element);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white')", element);
	}

	public static void takeScreenShotRobot(String iScreenShotpath, String iScreenshotName) {
		try {
			Thread.sleep(1000);
			BufferedImage image = new Robot()
					.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			ImageIO.write(image, "jpg", new File(iScreenShotpath + "\\" + iScreenshotName + ".jpg"));
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void shutterBugScreenshot(WebDriver driver, String iScreenShotpath, String iScreenshotName) {

		// Screenshot sc = new
		// AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		// Shutterbug.shootPage(driver,ScrollStrategy.VERTICALLY,1000,true).save(iScreenShotpath
		// + "\\" + iScreenshotName + ".png");

		Screenshot sc = new AShot().shootingStrategy(ShootingStrategies.viewportRetina(100, 0, 0, 2))
				.takeScreenshot(driver);
		try {

			ImageIO.write(sc.getImage(), "png", new File(iScreenShotpath + "\\" + iScreenshotName + ".png"));
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	// **************Wait Condition
	// Implicit Wait
	public void implicitWait(WebDriver driver, int iWaitTime) {
		driver.manage().timeouts().implicitlyWait(iWaitTime, TimeUnit.SECONDS);
	}

	// **********************Object Calling Functions

	public String inputTextField(WebDriver driver, WebElement iObjectElement, String iTestDataValue) throws Exception {

		try {
			if(findByElement(driver,iObjectElement))
			{
				Assert.assertEquals(true, iObjectElement.isDisplayed());
				highlight(driver, iObjectElement);
				LogAccess.getLogger().info("I am here to highlight and find the WebElement " + iObjectElement);
				iObjectElement.click();
				iObjectElement.clear();
				iObjectElement.sendKeys(iTestDataValue);
				Thread.sleep(1000);
			} 

		}
		catch (Exception e) {


			e.printStackTrace();
			throw e;
		}
		return iTestDataValue;
	}

	public static void dropDownByIndex(WebDriver driver, WebElement iObjectElement, int iIndexValue) throws Exception {

		try {
			if(findByElement(driver,iObjectElement))
			{
				Thread.sleep(3000);
				Assert.assertEquals(true, iObjectElement.isDisplayed());
				highlight(driver, iObjectElement);
				LogAccess.getLogger().info("I am here to highlight and find the WebElement " + iObjectElement);
				//iObjectElement.click();
				Select iDropDownByIndex = new Select(iObjectElement);
				//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", iObjectElement);
				//((JavascriptExecutor) driver).executeScript("arguments[0].click()", iObjectElement);
				iDropDownByIndex.selectByIndex(iIndexValue);
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static int dropDownByIndexSize(WebDriver driver, WebElement iObjectElement) {
		int size = 0;
		try {
			highlight(driver, iObjectElement);			
			LogAccess.getLogger().info("I am here to highlight and find the WebElement " + iObjectElement);
			iObjectElement.click();
			Select iDropDownByIndex = new Select(iObjectElement);
			List<WebElement> l=iDropDownByIndex.getOptions();
			size=l.size();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return size;
	}
	public static void dropDownByValue(WebDriver driver, WebElement iObjectElement, String iSelectValue) throws Exception {

		try {
			if(findByElement(driver,iObjectElement))
			{
				Thread.sleep(3000);
				Assert.assertEquals(true, iObjectElement.isDisplayed());
				highlight(driver, iObjectElement);
				LogAccess.getLogger().info("I am here to highlight and find the WebElement " + iObjectElement);
				//iObjectElement.click();
				Select iDropDownByValue = new Select(iObjectElement);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", iObjectElement);
				((JavascriptExecutor) driver).executeScript("arguments[0].click()", iObjectElement);
				iDropDownByValue.selectByValue(iSelectValue);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static void selectItem(WebDriver driver, WebElement iobjElement, String itemToSelect) {
		iobjElement.findElement(By.xpath("//option[text()='" + itemToSelect + "']")).click();
	}

	public static String readSelectedDDValue(WebDriver driver, WebElement iobjElement) {
		WebElement temp = null;
		try {
			if(findByElement(driver,iobjElement))
			{

				Assert.assertEquals(true, iobjElement.isDisplayed());
				highlight(driver, iobjElement);
				Select select = new Select(iobjElement);
				temp = select.getFirstSelectedOption();
				LogAccess.getLogger().info("I am here to highlight and get text from DropDown WebElement " + temp.getText());

			}
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return temp.getText(); 
	}

	public static void dropDownByVisibleText(WebDriver driver, WebElement iObjectElement, String iSelectValue) throws Exception {

		try {
			if(findByElement(driver,iObjectElement))
			{
				Thread.sleep(3000);
				Assert.assertEquals(true, iObjectElement.isDisplayed());
				highlight(driver, iObjectElement);
				LogAccess.getLogger().info("I am here to highlight and find the WebElement " + iObjectElement);
				//iObjectElement.click();
				Select iDropDownByValue = new Select(iObjectElement);
				//iObjectElement.click();
				iDropDownByValue.selectByVisibleText(iSelectValue);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static void buttonClick(WebDriver driver, WebElement iObjectElement) throws InterruptedException {
		highlight(driver, iObjectElement);
		LogAccess.getLogger().info("I am here to click the button " + iObjectElement);

		try {
			iObjectElement.click();
			Thread.sleep(500);
		} catch (Exception e) {

			((JavascriptExecutor) driver).executeScript("arguments[0].click()", iObjectElement);
			Thread.sleep(500);
		}
	}

	public static void findButtonClick(WebDriver driver,  WebElement iObjectElement) throws InterruptedException {

		try {
			if(findByElement(driver,iObjectElement))
			{
				Assert.assertEquals(true, iObjectElement.isDisplayed());
				highlight(driver, iObjectElement);
				LogAccess.getLogger().info("I am here to highlight and find the WebElement " + iObjectElement);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", iObjectElement);
				iObjectElement.click();
				Thread.sleep(500);
			} 

		}catch (NoSuchElementException e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", iObjectElement);
			Thread.sleep(500);
			throw e;

		}

	}
	public String getErrorMessage(WebDriver driver, WebElement iGetErrorElement) {
		String iActualErrorMessage = iGetErrorElement.getText();
		System.out.println("Actual Error Message:- " + iActualErrorMessage);
		JOptionPane.showMessageDialog(null, "Error Message: " + iActualErrorMessage);
		return iActualErrorMessage;
	}

	public static String getText(WebDriver driver, WebElement iObjectElement) {
		String iActualText = iObjectElement.getText();
		System.out.println("Actual Page Text:- " + iActualText);
		highlight(driver, iObjectElement);
		return iActualText;
	}

	public static String getAttribute(WebDriver driver, WebElement iObjectElement, String att_type) {
		String iActualText = iObjectElement.getAttribute(att_type);
		System.out.println("Actual Page Text:- " + iActualText);
		return iActualText;
	}

	public static String generateString(int length) {
		String allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // alphabets and numbers
		String randomtext = "";
		String temp = RandomStringUtils.random(length, allowedChars);
		randomtext = "IVVTEST" + temp.substring(0, temp.length() - 2);

		return randomtext;
	}

	public static String generateRanPhoneNum(int length) {
		String allowedChars = "1234567890";   //alphabets and numbers
		String randomtext="";
		String temp=RandomStringUtils.random(length,allowedChars);
		randomtext=temp.substring(0,temp.length()-2);

		return randomtext;
	}
	public int generateRandomNumber(int digit) {
		SecureRandom random = new SecureRandom();
		int num = random.nextInt(digit);
		return num;
	}

	public int randomNumber() {
		long timeSeed = System.nanoTime(); // to get the current date time value

		double randSeed = Math.random() * 1000; // random number generation

		long midSeed = (long) (timeSeed * randSeed); // mixing up the time and

		String s = midSeed + "";
		String subStr = s.substring(0, 9);

		int finalSeed = Integer.parseInt(subStr); // integer value

		System.out.println(finalSeed);
		return finalSeed;
	}

	public String getTodaysDateEDT() {

		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("MM/dd/YYYY HH:mm a");

		System.out.println(formatter.format(date).toString() + " " + "EDT");
		return formatter.format(date).toString() + " " + "EDT";
	}

	public String getCurrentDate() {
		Date date = new Date();
		String modifiedDate = new SimpleDateFormat("MM/dd/yyyy").format(date);
		return modifiedDate;
	}

	public String getYesterdayDate() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		return dateFormat.format(cal.getTime());
	}

	public String getFutureDate() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, +1);
		return dateFormat.format(cal.getTime());
	}

	// Verify Date Time Stamp
	public static String getCurrentDateTime() throws Exception {
		Calendar mycalendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm");
		String timeStamp = formatter.format(mycalendar.getTime());
		return timeStamp;
	}

	public static String getCurrentDateTimeMeridian() throws Exception {
		Calendar mycalendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy h:mma");
		String timeStamp = formatter.format(mycalendar.getTime());
		return timeStamp;
	}

	// Delimiter
	public static String delimiterSeparator(WebDriver driver, String iObjectElement, String delimiter,
			int stringlocation) {
		String testString = iObjectElement;
		String[] parts = testString.split(delimiter);
		String iLastWord = parts[stringlocation];
		return iLastWord;
	}

	// Capture Date and TimeStamp
	public static String executionFolderCreate() throws Exception {
		Calendar iSatzmycalendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("MMdd_hhmm_ss");
		String iSatzDatetimeStamp = formatter.format(iSatzmycalendar.getTime());
		// JOptionPane.showMessageDialog(null,iSatzDatetimeStamp);
		return iSatzDatetimeStamp;
	}





	public static boolean isPresentAndDisplayed(WebDriver driver, WebElement element) {
		try {
			if(findByElement(driver,element))
			{
				Assert.assertEquals(true, element.isDisplayed());
				highlight(driver, element);
				LogAccess.getLogger().info("I am here to highlight and find the WebElement " + element);

				return element.isDisplayed();
			}

		}catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
		return false;		
	}

	public static boolean isPresentAndEnabled(WebDriver driver, WebElement element) {
		try {

			highlight(driver, element);
			return element.isEnabled();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean isElementPresent(WebDriver driver, String elementXpath) {

		int count = driver.findElements(By.xpath(elementXpath)).size();

		if (count == 0)

			return false;
		else
			return true;

	}

	public boolean isElementPresentBy(WebDriver driver, By by) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			System.out.println("Caught NoSuchElementException");
			return false;

		} catch (ElementNotVisibleException e) {
			System.out.println("Caught ElementNotVisibleException");
			return false;

		} finally {
			driver.manage().timeouts().implicitlyWait(5 * 1, TimeUnit.SECONDS);
		}
	}

	public static boolean findByElement(WebDriver driver, WebElement locator) {
		try {

			WebElement ele = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(locator));
			Assert.assertEquals(true, ele.isDisplayed());
			//highlight(driver, locator);
			LogAccess.getLogger().info("I am here to highlight and find the WebElement " + locator);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", ele);

			return true;
		} catch (NoSuchElementException e) {
			// Assert.fail("Error..Warning Element Doesn't Exist/ Visible ");

			return false;
		}

	}

	public static boolean findByElementList(WebDriver driver, List<WebElement> locator) {
		try {

			List<WebElement> ele = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOfAllElements(locator));
			Assert.assertEquals(true, ((WebElement) ele).isDisplayed());
			//highlight(driver, locator);
			LogAccess.getLogger().info("I am here to highlight and find the WebElement " + locator);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", ele);

			return true;
		} catch (NoSuchElementException e) {
			// Assert.fail("Error..Warning Element Doesn't Exist/ Visible ");

			return false;
		}

	}

	public boolean isAttribtuePresent(List<WebElement> iObjectelement, String attribute, int size) {
		Boolean result = false;
		try {
			String value = iObjectelement.get(size).getAttribute(attribute);
			if (value != null) {
				result = true;
			}
		} catch (Exception e) {
		}

		return result;
	}

	// Is File Downloaded
	public static boolean isFileDownloaded(String downloadPath, String ifileName) {
		boolean flag = false;
		File dir = new File(downloadPath);
		File[] dir_contents = dir.listFiles();

		for (int i = 0; i < dir_contents.length; i++) {
			// if (dir_contents[i].getName().equals(ifileName)) {
			if (dir_contents[i].getName().contains(ifileName)) {
				System.out.println("File Name:-->" + ifileName);
				return flag = true;
			}
		}

		return flag;

	}

	public boolean verifyDropDownValues(WebDriver driver, WebElement iObjectElement, String[] iIdentifyDrpDwnValues) {

		int iTotalCount = 0;
		WebElement iDropDownListCompare = iObjectElement;
		Select iGetDropDownList = new Select(iDropDownListCompare);

		List<WebElement> iVerifyDrpDwnValues = iGetDropDownList.getOptions();
		for (WebElement iValidateDrpDwnValues : iVerifyDrpDwnValues) {
			for (int i = 0; i < iIdentifyDrpDwnValues.length; i++) {
				if (iValidateDrpDwnValues.getText().equals(iIdentifyDrpDwnValues[i])) {
					iTotalCount++;
				}
			}
		}
		if (iTotalCount == iIdentifyDrpDwnValues.length) {
			System.out.println("Dropdown List Content Matched");
			return true;
		} else {
			System.out.println("Hi iRobot, We have a PROBLEM, Dropdown List Content NOT Matched");
			return false;
		}

	}
	
	 /**
     * This method will set any parameter string to the system's clipboard.
     */
    public static void setClipboardData(String string) {
        //StringSelection is a class that can be used for copy and paste operations.
           StringSelection stringSelection = new StringSelection(string);
           Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        }

    public static void uploadFileWinPopUp(String fileLocation) {
        try {
            //Setting clipboard with file location
            setClipboardData(fileLocation);
            //native key strokes for CTRL, V and ENTER keys
            Robot robot = new Robot();
            robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
            robot.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
            robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
            robot.keyPress(java.awt.event.KeyEvent.VK_V);
            robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
            Thread.sleep(3000);
            robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
            Thread.sleep(3000);
         /*   robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);*/
            LogAccess.getLogger().info("Robot finished selecting file");
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

	// Auto Upload File
	public static void autoUploadFile(String iUploadFilePath, WebElement iObjectElement) throws Exception {
		File iUpfilepath = new File(iUploadFilePath);
		String iUploadAbsFilepath = iUpfilepath.getAbsolutePath();
		iObjectElement.sendKeys(iUploadAbsFilepath);
		Thread.sleep(1500);
	}

	public void threadSleep(int i) {
		try {

			if (!Thread.interrupted()) {
				Thread.sleep(i);
			} else {
				System.out.println("thread Interupted");
				throw new InterruptedException();
			}
		} catch (Exception e) {

			System.out.println(e);
		}
	}

	public boolean isElementPresent(WebDriver driver, By by) {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			System.out.println("Caught NoSuchElementException");
			return false;

		} catch (ElementNotVisibleException e) {
			System.out.println("Caught ElementNotVisibleException");
			return false;

		} finally {
			driver.manage().timeouts().implicitlyWait(10 * 1, TimeUnit.SECONDS);
		}
	}

	public boolean isFontBold(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		String fontWeight = (String) js
				.executeScript("return getComputedStyle(arguments[0]).getPropertyValue('font-Weight');", ele);
		String fontSize = ele.getCssValue("font-size");
		System.out.println("Font Size -> " + fontSize);

		Assert.assertTrue(fontWeight.equals("bold") || fontWeight.equals("700"));

		if (fontWeight.trim().equals("700")) {
			System.out.println("The element Is Bold");
			return true;
		} else {
			System.out.println("The element Is Not Bold - " + fontWeight);
			return false;
		}

	}

	public CommonFunction verifyPageLoaded(WebDriver driver, String pageLoadedText) {
		(new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				LogAccess.getLogger().info(pageLoadedText);
				return d.getPageSource().contains(pageLoadedText);
			}
		});
		return this;
	}

	public static boolean isValidDate(String inDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy mm:ss a");
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(inDate.trim());
		} catch (ParseException pe) {
			return false;
		}
		return true;
	}

	public static String getCurrentDateFormat(String specifyFormat) {
		Date date = new Date();
		String modifiedDate = new SimpleDateFormat(specifyFormat).format(date);
		return modifiedDate;
	}

	public static void bufferedWrite(String filename, ArrayList<String> arr ) throws IOException {

		FileWriter writer = new FileWriter(new File(filename));

		for (String t:arr) {
			writer.write(t);
		}
		writer.close();}

	public static String ReadExcelRecords(String ifilepath,String iSheetname) throws IOException {		
		String iExcelPath = ifilepath;
		FileInputStream iFilePath = new FileInputStream (iExcelPath);
		@SuppressWarnings("resource")
		XSSFWorkbook iWB = new XSSFWorkbook (iFilePath);
		XSSFSheet iActualSheet =iWB.getSheet(iSheetname);		
		try {
			iActualSheet.createFreezePane(0, 0);
		} catch (IndexOutOfBoundsException e) {

			System.out.println("The cells are not frozen");
		}
		int iTotalRowsCount =iActualSheet.getPhysicalNumberOfRows();
		String totalrws = Integer.toString(iTotalRowsCount);
		int iTotalColumnsCount = iActualSheet.getRow(iTotalRowsCount).getPhysicalNumberOfCells();
		System.out.println("Total Rows:-->" + iTotalRowsCount);
		System.out.println("Total Columns:-->" + iTotalColumnsCount);
		return totalrws;			

	}

	public static void readExcelData(int rowcount, int columncount, String filepath, String Sheetname) {

		try {
			FileInputStream input = new FileInputStream(filepath);
			XSSFWorkbook wb = new XSSFWorkbook(input);
			XSSFSheet sh = wb.getSheet(Sheetname);
			try {
				sh.createFreezePane(0, 0);
			} catch (IndexOutOfBoundsException e) {

				System.out.println("The cells are not frozen");
			}
			XSSFRow row = sh.getRow(rowcount);
			String iCellVal = row.getCell(columncount).toString();
			CommonVariables.ACTUAL_COLVALUE = iCellVal;
			wb.close();
			//return iCellVal;
		} catch (Exception e) {
			System.out.println(e);
		}
		//JOptionPane.showMessageDialog(null, "The Parameter is Selected:-> " + data);

	}
	public static void unFreezePanes(String filepath, String Sheetname) {

		try {
			FileInputStream input = new FileInputStream(filepath);
			XSSFWorkbook wb = new XSSFWorkbook(input);
			XSSFSheet sh = wb.getSheet(Sheetname);
			try {
				sh.createFreezePane(0, 0);
			} catch (IndexOutOfBoundsException e) {

				System.out.println("The cells are not frozen");
			}

			wb.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		//JOptionPane.showMessageDialog(null, "The Parameter is Selected:-> " + data);

	}
	public static  String createExecutionFolder() throws Exception {
		Calendar imycalendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("MMdd_hhmm_ss");
		String iDatetimeStamp = formatter.format(imycalendar.getTime());
		//JOptionPane.showMessageDialog(null,iDatetimeStamp);
		return iDatetimeStamp; 
	}

	public void absenceOfElement(WebDriver driver,SoftAssert sa, String text) {
		List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + text + "')]"));
		sa.assertFalse(list.size() > 0);
	}
	public static String getTextNode(WebElement e)
	{
		String text = e.getText().trim();
		List<WebElement> children = e.findElements(By.xpath("./*"));
		for (WebElement child : children)
		{
			text = text.replaceFirst(child.getText(), "").trim();
		}
		return text;
	}
	//Added 2/11/19

	public static int getDropDownSize(WebDriver driver, WebElement iObjectElement) {
		Select dropDown = new Select(iObjectElement);
		List <WebElement> elementCount = dropDown.getOptions();
		int itemSize = elementCount.size();

		System.out.println("The number of options in dropdown is-->"+itemSize);

		return itemSize;
	}

	public String getDOB(int min, int max)
	{
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		int year = min + new Random().nextInt(max - min + 1);
		calendar.set(Calendar.YEAR, year);
		int day = 1+new Random().nextInt(calendar.getActualMaximum(Calendar.DAY_OF_YEAR));
		calendar.set(Calendar.DAY_OF_YEAR, day);
		return new SimpleDateFormat("MM/dd/YYYY").format(calendar.getTime());
	}

	public static void hoverAndClick(WebDriver driver,WebElement elementToHover,WebElement elementToClick) throws InterruptedException {
		try {
			if(findByElement(driver,elementToClick))
			{

				highlight(driver, elementToClick);
				Actions action = new Actions(driver);
				action.moveToElement(elementToHover).click(elementToClick).build().perform();

				LogAccess.getLogger().info("I am here to highlight and find the WebElement " + elementToClick);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", elementToClick);

			} 

		}catch (NoSuchElementException e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", elementToClick);
			Thread.sleep(500);

		}

	}
}
