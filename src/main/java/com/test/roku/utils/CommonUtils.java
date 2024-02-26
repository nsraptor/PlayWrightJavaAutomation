package com.test.roku.utils;

import com.microsoft.playwright.Locator;

public class CommonUtils {
    static Long timeout = Long.parseLong("30");
    public static void clickOnElement(Locator locator) {
        locator.click();
    }
    public static void sendKeysTo(Locator locator, String text) {
        locator.fill(text);
    }

    public static void waitForVisible(Locator locator) {
        try {
            locator.isVisible();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void waitForNotVisible(Locator locator) {
        try {
            locator.isHidden();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
