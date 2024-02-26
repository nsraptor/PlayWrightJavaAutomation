# Contact Us Form Automation

## About Project
Purpose of this project is to automate Contact Us Form at "https://automationintesting.online/" as an assignment using [Playwright 1.41.2](https://playwright.dev/java/docs/intro) with Java as a programming language and [BDD approach](https://www.browserstack.com/guide/what-is-bdd) using [Cucumber](https://www.browserstack.com/guide/learn-about-cucumber-testing-tool) based framework.
It generates an HTML report, using extent spark report which also includes web application screenshots for every test steps (pass and failed both)

As per the required scope i.e. Automate UI tests, it covers only UI Functional tests with an extended possibility of automation non-functional tests for API testing. 

This project follows the Maven structure, centralizing dependencies in the pom.xml file for straightforward local installation by anyone.
Utilizing the Page Object Model (POM) design pattern, the implementation leverages Page Factory to enhance simplicity and ease of maintenance. 
Page Factory initializes an instance of the designated class and employs a lazy proxy for each declared WebElement and List<WebElement> field, streamlining object creation and management.


*The project is structured in 6 main parts:*
- Page Objects      : Page Objects container,Each screen in the application has its own Java class which contains elements and actions/methods specific to the respective screens.
- Step Definitions  : Step Definitions and Hooks container comprises individual Java classes, each corresponding to a distinct screen within the application. These classes encapsulate the definitions for Given, When, and Then steps associated with their respective scenarios.
- Utils             : Framework utility container, contains various level java classes which holds the utility methods to be used across teh framework
- Feature files     : Feature files container which contains one feature file for each screen of the application in our case "Contact Us Page" containing the actual test scenarios written in Gherkin language.
- Resources         : Properties file container for test data management, .properties files contain relevant test data.
- Reporting         : ExtentSparkReporter for generating the report and publishing to reports.cucumber.io

***This project supports cross-browser functionality and could be run with following browsers:***
1. Chrome
2. Firefox
3. Safari
4. I haven't tried for Edge but it will work for that as well.

***This project supports multi-device testing and could be run with following device :***
1. Desktop
2. Mobile
3. Tablet

***This project mainly covers following features:***

1) User should be able to submit contact us request
   - Verify user should be displayed the field specific icons
   - Verify user should be displayed the message filed caption
   - Verify user should be displayed the field labels
   - Verify that user should be able to submit contact us form with valid successfully
   - Verify user should see error all error messages when submit with blank fields
   - Verify user should not be able to enter invalid format entries for Name, Email & Phone field
   - Verify user should not be able to enter out of range Phone Number, Subject and Message

# How do set up the project? ##

### Summary of set up

Fork / Clone repository from [here](https://github.com/nsraptor/AutomationRoku)
or download zip and set it up in your local workspace.

### Dependencies

**Pre-requisite**
1. JDK  (make sure Java class path is set)
2. Maven & Maven CLI plugin(make sure .m2 class path is set)
3. IDE: Eclipse, Intelli J, VS Code, etc
4. Plugin for Cucumber based on your IDE
   [Eclipse](https://marketplace.eclipse.org/content/cucumber-eclipse-plugin), [Intelli J](https://www.jetbrains.com/help/idea/enabling-cucumber-support-in-project.html), [VS Code](https://marketplace.visualstudio.com/items?itemName=alexkrechik.cucumberautocomplete)

#### With an IDE

1. Clone the repository;
2. Open your IDE (Eclipse, Intelli J, VS Code, etc);
3. Import the project into IDE;
4. Wait until all dependencies are downloaded and installed;
5. Install Cucumber IDE plugin for IDE to view the feature files better and be able to navigate to the step definition from the feature file.

#### Without an IDE

To execute tests via the Command Line, ensure Maven is installed and configured correctly on your system.

### Execution

#### With an IDE

1. Open the TestRunner java class in the IDE (located here: src/test/java/Runner/TestRunner.java);
2. Update the 'tags' option with the tag for which tests you want to run (e.g. the tags = `”@Regression or @ContactUs”` will run ContactUs test scenarios
3. Right-click on the root tests folder and select Run
4. On the right panel of Run, select Run As TestNG

Each version of Playwright needs specific versions of browser binaries to operate.
With every release, Playwright updates the versions of the browsers it supports, so that the latest Playwright would support the latest browsers at any moment. 
It means that every time you update Playwright, you might need to re-run the install CLI command.
When you try to run test for the first time, Playwright downloads the required browser specific binaries automatically and uses them to run tests 
It supports C
1. Chromium based browsers e.g. Chrome and Edge
2. Webkit based browsers e.g. Safari
3. Firefox engine based e.g. Firefox.
   
**Steps to follow to execute the tests:**

#### Without an IDE via command line

The command to run tests from the Command Line (Terminal) is: `mvn clean test`.
You can pass the various arguments

For Eg: `mvn clean test -DbrowserName=Safari -DdeviceType=Mobile`


### Reporting

**View reports**
Generated reports can be viewed from below path:
1) For personal debugging and analysis: Always can open test-output/SparkReport/Spark.html (i.e. in your browser, recommend: chrome or safari)
2) For wider stakeholders visibility, Extent reports are also being published to [report.cucumber.io](https://reports.cucumber.io/report-collections/1efbbc1b-cc55-4b53-802e-f13cd8614652)
   Note:
   For this to be done it is required to set an environment variable i.e. export CUCUMBER_PUBLISH_TOKEN=<project_token>
   project_token can be generated on report.cucumber.io portal.



### Arguments

**For Cross Browser testing**
Default browser is set as Chrome, to update browser type use any one option from below: 
1. Update config.properties
   - Navigate to /src/test/resources/config.properties
2. Update browserName=Chrome to browserName=Edge or browserName=Firefox or browserName=Safari
   (choose the browser you want to run your test suite)

**OR**

   `mvn clean test -DbrowserName=<nameOfBrowser> ` to run from command line on a specific browser

**For Cross Device testing**
Default device is set as desktop, to update device type use any one option from below:
1. Update config.properties 
   - Navigate to /src/test/resources/config.properties
2. Update deviceType=Desktop to deviceType=Mobile or deviceType=Tablet
   (choose the device type you want to run your test suite)

   **OR**

   `mvn clean test -DdeviceType=<typeOfDevice>` to run from command line on a specific type of device

### Parallel execution mechanism is in place:
All test cases are running in parallel as we have running scenarios using TestNG's data provider annotation while overriding the method(i.e. Object[][] scenarios) in TestRunner class.


**Scope of improvement for this project**
  - Verification of data being sent in  POST API
  - API response codes testing
  - Integration with Selenium grid for multi-browser execution in parallel.
  - Publish the report to the organisation's internal resources for security purposes.

***Bugs in Contact Us form and submission***
1. Invalid Phone numbers are allowed in Phone textField and getting submitted : **Client side & Server side validation missing**
2. Invalid names are allowed in Name textField and getting submitted : **Client side & Server side validation missing**

Report at Scenario level
![Screenshot](https://github.com/nsraptor/AutomationRoku/blob/main/Screenshorts/Scenario.png)

Report at Step level
![Screenshot](https://github.com/nsraptor/AutomationRoku/blob/main/Screenshorts/Step.png)
