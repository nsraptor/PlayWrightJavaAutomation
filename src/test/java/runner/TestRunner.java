package runner;

 import io.cucumber.testng.AbstractTestNGCucumberTests;
 import io.cucumber.testng.CucumberOptions;
 import org.testng.annotations.DataProvider;

@CucumberOptions(
        tags = "@Regression",
        plugin = { "pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" },
        glue = "com.test.roku.steps",
        features = "src/test/java/features/")
public class TestRunner extends AbstractTestNGCucumberTests {
// @Override
// @DataProvider(parallel = true)
// public Object[][] scenarios() {
//  return super.scenarios();
// }
}