package com.sparky.listeners.ro;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;

import org.testng.IInvokedMethodListener;

import org.testng.ISuite;

import org.testng.ISuiteListener;

import org.testng.ITestContext;

import org.testng.ITestListener;

import org.testng.ITestNGMethod;

import org.testng.ITestResult;

import org.testng.Reporter;

import io.qameta.allure.Attachment;

public class Listener implements ITestListener, ISuiteListener, IInvokedMethodListener {

	 private static String getTestMethodName(ITestResult iTestResult) {
	        return iTestResult.getMethod().getConstructorOrMethod().getName();
	    }
	/* 
	 //Text attachments for Allure
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG (WebDriver driver) {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    //Text attachments for Allure
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog (String message) {
        return message;
    }

    //HTML attachments for Allure
    @Attachment(value = "{0}", type = "text/html")
    public static String attachHtml(String html) {
        return html;
    }
	*/
	// This belongs to ISuiteListener and will execute before the Suite start

	@Override

	public void onStart(ISuite arg0) {

		Reporter.log("Listener About to begin executing Suite " + arg0.getName(), true);

	}

	// This belongs to ISuiteListener and will execute, once the Suite is finished

	@Override

	public void onFinish(ISuite arg0) {

		Reporter.log("Listener About to end executing Suite " + arg0.getName(), true);

	}

	// This belongs to ITestListener and will execute before starting of Test set/batch 

	public void onStart(ITestContext arg0) {

		Reporter.log("Listener About to begin executing Test " + arg0.getName(), true);

	}

	// This belongs to ITestListener and will execute, once the Test set/batch is finished

	public void onFinish(ITestContext arg0) {

		Reporter.log("Listener Completed executing test " + arg0.getName(), true);
		

	}

	// This belongs to ITestListener and will execute only when the test is pass

	public void onTestSuccess(ITestResult arg0) {

		// This is calling the printTestResults method

		printTestResults(arg0);
		  /* Object testClass = arg0.getInstance();
	        WebDriver driver = CompositionFlow.driver;

	        //Allure ScreenShotRobot and SaveTestLog
	        if (driver instanceof WebDriver) {
	            System.out.println("Screenshot captured for test case:" + getTestMethodName(arg0));
	            saveScreenshotPNG(driver);
	        }*/
		
	}

	// This belongs to ITestListener and will execute only on the event of fail test

	public void onTestFailure(ITestResult arg0) {

		// This is calling the printTestResults method
		
		
		printTestResults(arg0);
		//Get driver from BaseTest and assign to local webdriver variable.
      /*  Object testClass = arg0.getInstance();
        WebDriver driver = CompositionFlow.driver;

        //Allure ScreenShotRobot and SaveTestLog
        if (driver instanceof WebDriver) {
            System.out.println("Screenshot captured for test case:" + getTestMethodName(arg0));
            saveScreenshotPNG(driver);
        }
		*/
		
	}

	// This belongs to ITestListener and will execute before the main test start (@Test)

	public void onTestStart(ITestResult arg0) {

		System.out.println("Listener The execution of the main test starts now");

	}

	// This belongs to ITestListener and will execute only if any of the main test(@Test) get skipped

	public void onTestSkipped(ITestResult arg0) {

		printTestResults(arg0);

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

	}

	// This is the method which will be executed in case of test pass or fail

	// This will provide the information on the test

	private void printTestResults(ITestResult result) {

		Reporter.log("Listener Test Method resides in " + result.getTestClass().getName(), true);

		if (result.getParameters().length != 0) {

			String params = null;

			for (Object parameter : result.getParameters()) {

				params += parameter.toString() + ",";

			}

			Reporter.log("Listener Test Method had the following parameters : " + params, true);

		}
			
	
		String status = null;

		switch (result.getStatus()) {

		case ITestResult.SUCCESS:

			status = "Pass";

			break;

		case ITestResult.FAILURE:

			status = "Failed";

			break;

		case ITestResult.SKIP:

			status = "Skipped";

		}

		Reporter.log("Listener Test Status has : " + status, true);

	}

	// This belongs to IInvokedMethodListener and will execute before every method including @Before @After @Test

	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {

		String textMsg = "Listener About to begin executing following method : " + returnMethodName(arg0.getTestMethod());

		Reporter.log(textMsg, true);

	}

	// This belongs to IInvokedMethodListener and will execute after every method including @Before @After @Test

	public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {

		String textMsg = "Listener Completed executing following method : " + returnMethodName(arg0.getTestMethod());

		Reporter.log(textMsg, true);

	}

	// This will return method names to the calling function

	private String returnMethodName(ITestNGMethod method) {

		return method.getRealClass().getSimpleName() + "." + method.getMethodName();

	}

}