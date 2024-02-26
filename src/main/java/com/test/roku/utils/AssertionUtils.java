package com.test.roku.utils;

import com.microsoft.playwright.Locator;
import org.testng.Assert;
import static com.test.roku.utils.CommonUtils.waitForVisible;

public class AssertionUtils {
    public static void assertPresent(Locator locator) {
        waitForVisible(locator);
        Assert.assertTrue(locator.isVisible(), String.format("Element %s should be displayed !!!", locator.textContent()));
    }

    public static void assertEquals(Locator locator, String expected) {
        waitForVisible(locator);
        Assert.assertTrue(locator.textContent().contains(expected), String.format("Actual text is %s and expected text is %s", locator.textContent(), expected));
    }

    public static void assertEquals(String actual, String expected) {
        Assert.assertTrue(actual.contains(expected), String.format("Actual text is %s and expected text is %s", actual, expected));
    }

    public static void assertFail(String errorMessage) {
        Assert.fail(errorMessage);
    }
}