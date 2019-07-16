package com.sparky.listeners.ro;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


public class RetryAnalyzer implements IRetryAnalyzer {

    /**
	 * @return the retryCount
	 */
	public static int getRetryCount() {
		return retryCount;
	}

	/**
	 * @param retryCount the retryCount to set
	 */
	public static void setRetryCount(int retryCount) {
		RetryAnalyzer.retryCount = retryCount;
	}


	private static int retryCount = 0;
    private int maxRetryCount = 0;

    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            System.out.println("Retrying test " + result.getName() + " with status "
                    + getResultStatusName(result.getStatus()) + " for the " + (retryCount + 1) + " time(s).");
            RetryAnalyzer.setRetryCount(retryCount);
            retryCount++;
            return true;
        }
        retryCount = 0;
        return false;
    }

    String getResultStatusName(int status) {
        String resultName = null;
        if (status == 1)
            resultName = "SUCCESS";
        if (status == 2)
            resultName = "FAILURE";
        if (status == 3)
            resultName = "SKIP";
        return resultName;
    }
    
   
    public boolean retry2(ITestResult result) {
    try {
        if (result.getThrowable().toString()
            .contains("NoSuchElementException")) // Checking for specific reasons of failure
            if (retryCount < maxRetryCount) {
                retryCount++;
                return true;
            }
        return false;
        } catch (Exception e) {
            return false;
        }
    }
}

	

