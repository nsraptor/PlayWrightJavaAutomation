package com.test.roku.utils;

import com.microsoft.playwright.*;

import java.util.List;

import static com.test.roku.utils.ConfigUtils.*;

public class BrowserUtils {
    Browser browser;
    BrowserType browserType;
    BrowserContext browserContext;
    Page page;
    BrowserType.LaunchOptions launchOptions = (new BrowserType.LaunchOptions()).setHeadless(false);

    public void initPage() {
        loadProperties();
        String deviceType;
        String browserName;
        if ((System.getProperty("browserName") != null)) {
            browserName = System.getProperty("browserName");
        } else {
            browserName = getPropertyByKey("browserName");
        }

        if ((System.getProperty("deviceType") != null)) {
            deviceType = System.getProperty("deviceType");
        } else {
            deviceType = getPropertyByKey("deviceType");
        }

        Playwright playwright = Playwright.create();
            switch (browserName) {
                case "Firefox":
                    browserType = playwright.firefox();
                    break;
                case "Safari":
                    browserType = playwright.webkit();
                    break;
                default:
                    browserType = playwright.chromium();
                    break;
            }
            switch (deviceType) {
                case "Mobile":
                    browser = browserType.launch(launchOptions);
                    browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(375, 667));
                    break;
                case "Tablet":
                    browser = browserType.launch(launchOptions);
                    browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(768, 1024));
                    break;
                default:
                    browser = browserType.launch(launchOptions.setArgs(List.of("--start-maximized")));
                    browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
                    break;
            }
            page = browserContext.newPage();
            page.navigate(getPropertyByKey("contactUsPage.URL"));

    }

    public Page getPage() {
        if (page == null) {
            initPage();
        }
        return page;
    }

    public void tearDown() {
        if (browser != null) {
            page.close();
            browser.close();
        }
        page = null;
        browser = null;
    }
}
