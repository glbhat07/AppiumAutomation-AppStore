package Runner;

import Utils.AppTest;
import io.cucumber.java.Scenario;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;


//@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Feature",
        glue = {"StepDefinitions", "Helper"},  // Use package names instead of file paths
        plugin = {
                "html:target/selenium-reports/report.html",
                "json:target/cucumber-reports/report.json",
                "rerun:target/failedrerun.txt"
        }
)

public class TestRunner extends AbstractTestNGCucumberTests {
    int i;

    @BeforeSuite
    public void setUp() throws IOException {
        i = 0;
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        i++;
        if (ITestResult.FAILURE == result.getStatus()) {
            System.out.println("<<<<<<<<<Test Failed>>>>>>>>");
            AppTest.captureScreenshot("Scenario-", i); // Capture screenshot with Scenario index
        }
    }
}


