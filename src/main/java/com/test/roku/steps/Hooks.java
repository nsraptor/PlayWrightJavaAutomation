package com.test.roku.steps;

import java.io.File;
import java.util.Date;
import java.util.Objects;

import com.microsoft.playwright.Page;
import com.test.roku.utils.BrowserUtils;
import io.cucumber.java.*;

public class Hooks {
    private BrowserUtils browserUtils;
    public static Page page;

    public Page getPage(){
        return page;
    }

    @Before
    public void setUp() {
        browserUtils = new BrowserUtils();
        page = browserUtils.getPage();
    }

    @After
    public void teardown() {
        browserUtils.tearDown();
    }

    @BeforeAll
    public static void beforeAll() {
        deleteOldReport();
    }

    @AfterStep
    /**************************************************************************************************
    Function to capture screenshots of each step
    **************************************************************************************************/

    public void afterStep(Scenario scenario) {
        Date currentDate = new Date();
        byte[] screenshot = page.screenshot(new Page.ScreenshotOptions().setFullPage(false));
        try {
            scenario.attach(screenshot, "image/png", "image");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**************************************************************************************************
     Function to delete existing test execution report and screenshots
     **************************************************************************************************/
    public static void deleteOldReport() {

        String directory = "./test-output";
        File file = new File(directory);
        String[] currentFiles;
        if (file.isDirectory()) {
            currentFiles = file.list();
            for (int i = 0; i < Objects.requireNonNull(currentFiles).length; i++) {
                File myFile = new File(file, currentFiles[i]);
                System.out.println("DelFile 12345" + myFile);
                myFile.delete();
            }
        }
    }
}
