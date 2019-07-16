package com.sparky.helper.ro;

import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.asserts.Assertion;
import org.testng.asserts.IAssert;
import org.testng.collections.Maps;

import com.sparky.commonfunctions.ro.BrowserFunctions;
import com.sparky.commonvariables.ro.CommonVariables;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

/**
 * When an assertion fails, don't throw an exception but record the failure.
 * Calling {@code assertAll()} will cause an exception to be thrown if at least
 * one assertion failed.
 */
public class SoftAsserts extends Assertion {
    // LinkedHashMap to preserve the order
    private final Map<AssertionError, IAssert<?>> m_errors = Maps.newLinkedHashMap();
    private String assertMessage = null;

    @Override
    protected void doAssert(IAssert<?> a) {
        onBeforeAssert(a);
        try {
            assertMessage = a.getMessage();
            a.doAssert();
            onAssertSuccess(a);
        } catch (AssertionError ex) {
            onAssertFailure(a, ex);
            m_errors.put(ex, a);
            try {
				saveScreenshot(assertMessage);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } finally {
            onAfterAssert(a);
        }
    }

    public void assertAll() {
        if (!m_errors.isEmpty()) {
            StringBuilder sb = new StringBuilder("The following asserts failed:");
            boolean first = true;
            for (Map.Entry<AssertionError, IAssert<?>> ae : m_errors.entrySet()) {
                if (first) {
                    first = false;
                } else {
                    sb.append(",");
                }
                sb.append("\n\t");
                sb.append(ae.getKey().getMessage());
            }
            throw new AssertionError(sb.toString());
        }
    }

    @Step("Validation fail: {assertMessage}")
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(String assertMessage) throws WebDriverException, Exception {
        byte[] screenshot = null;
        screenshot = ((TakesScreenshot)BrowserFunctions.CallingBrowser(CommonVariables.BROWSERSELECT) ).getScreenshotAs(OutputType.BYTES);
        return screenshot;
    }
}