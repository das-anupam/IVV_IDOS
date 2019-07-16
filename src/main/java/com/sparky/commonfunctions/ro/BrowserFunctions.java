package com.sparky.commonfunctions.ro;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.sparky.commonvariables.ro.CommonVariables;
import com.sparky.helper.ro.LogAccess;



public class BrowserFunctions {

	//public static WebDriver driver;
	protected static ThreadLocal<RemoteWebDriver> threadDriver = null;

	public static WebDriver CallingBrowser(String BROWSERSELECT) throws Exception{

		LogAccess.getLogger().info("Inhouse Browser Calling Function");
		
		if (CommonVariables.BROWSERSELECT.equalsIgnoreCase("FireFox")){
			LogAccess.getLogger().info("Browser Selection:- "+ CommonVariables.BROWSERSELECT);
			fireFoxBrowser();				
		}else if (CommonVariables.BROWSERSELECT.equalsIgnoreCase("Gecko")){
			LogAccess.getLogger().info("Browser Selection:- "+ CommonVariables.BROWSERSELECT);
			GeckoBrowser(CommonVariables.GECKO_DRIVER_PATH);
		}else if (CommonVariables.BROWSERSELECT.equalsIgnoreCase("Chrome")){
			LogAccess.getLogger().info("Browser Selection:- "+ CommonVariables.BROWSERSELECT);
			Chrome();
		
		}
		else if (CommonVariables.BROWSERSELECT.equalsIgnoreCase("FirefoxDownload")){
			LogAccess.getLogger().info("Browser Selection:- "+ CommonVariables.BROWSERSELECT);
			FirefoxDriverProfile();
		}else{
			LogAccess.getLogger().info("Browser Selection:- None Hence Default FireFox");
		
		}
		return threadDriver.get();
	}


	public static void GeckoBrowser(String iGeckoDriverPath){
		
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
		System.setProperty("webdriver.gecko.driver", iGeckoDriverPath);
		 threadDriver = new ThreadLocal<RemoteWebDriver>();
		 threadDriver.set(new FirefoxDriver());
		 
		//driver = new FirefoxDriver();
		 threadDriver.get().manage().deleteAllCookies();
		 threadDriver.get().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//return;
	}

	public static WebDriver FirefoxDriver(){

		System.out.println("Initializing Browser");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/src/main/resources/Drivers/chromedriver.exe");
		System.out.println("Browser Wait");
		JOptionPane.showMessageDialog(null,"FireFox Browser Function");
		threadDriver = new ThreadLocal<RemoteWebDriver>();
		threadDriver.set(new FirefoxDriver());
		return threadDriver.get();
	}

	public static WebDriver Chrome(){

		System.out.println("Initializing Browser");
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "/src/main/resources/Drivers/chromedriver.exe");
		System.out.println("Browser Wait");
		String win64 = System.getProperty("user.dir")+ "/src/main/resources/Drivers/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", win64);
		String downloadFilepath = System.getProperty("user.dir")+"/Download_File";
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadFilepath);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		threadDriver = new ThreadLocal<RemoteWebDriver>();
		threadDriver.set(new ChromeDriver(cap));
		return threadDriver.get();
		
	}

	public static void geckoFireFoxBrowser(String iGeckoDriverPath){
		
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
		System.setProperty("webdriver.gecko.driver", CommonVariables.GECKO_DRIVER_PATH);
		 threadDriver = new ThreadLocal<RemoteWebDriver>();
		 threadDriver.set(new FirefoxDriver());
		 
		//driver = new FirefoxDriver();
		 threadDriver.get().manage().deleteAllCookies();
		 threadDriver.get().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	
	}

	public static WebDriver fireFoxBrowser(){

		System.out.println("Initializing Browser");
		System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir")+ "/src/main/resources/Drivers/geckodriver.exe");
		System.out.println("Browser Wait");
		threadDriver = new ThreadLocal<RemoteWebDriver>();
		threadDriver.set(new FirefoxDriver());
		return threadDriver.get();
	}

	public static WebDriver FirefoxDriverProfile() throws Exception {
		threadDriver = new ThreadLocal<RemoteWebDriver>();
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.download.manager.showWhenStarting", false);
		profile.setPreference("browser.download.dir", System.getProperty("user.dir")+"/Download_File");
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf,application/zip,text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;octet/stream");
		profile.setPreference("browser.helperApps.neverAsk.openFile", "application/pdf,application/zip,text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;octet/stream");
		profile.setPreference("browser.helperApps.alwaysAsk.force", false);
		profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
		profile.setPreference("browser.download.manager.focusWhenStarting", false);
		profile.setPreference("browser.download.manager.useWindow", false);
		profile.setPreference("browser.download.manager.showAlertOnComplete", false);
		profile.setPreference("browser.download.manager.closeWhenDone", true);
		profile.setPreference("pdfjs.disabled", true);

		profile.setPreference("browser.helperApps.alwaysAsk.force", false);
		profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
		profile.setPreference("browser.download.manager.focusWhenStarting", false);
		profile.setPreference("browser.download.manager.useWindow", false); 	
		profile.setPreference("browser.download.manager.showAlertOnComplete", false);
		profile.setPreference("browser.download.manager.closeWhenDone", true);
		threadDriver.set(new FirefoxDriver(profile));
		return threadDriver.get();
		
	}


	public static void accessUrl(String iAccessUrl){
		
		threadDriver.get().get(iAccessUrl);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		threadDriver.get().manage().window().maximize();
		return;
	}

	public static void closeBrowser(){
		
		threadDriver.get().close();
		//threadDriver.get().quit();
	}

}
