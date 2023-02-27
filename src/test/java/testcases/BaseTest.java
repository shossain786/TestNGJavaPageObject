package testcases;

import base.TestBase;
import com.aventstack.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.ExtentReporter;

public class BaseTest extends TestBase {
    Logger logger = Logger.getLogger(BaseTest.class);
    WebDriver driver;
    public ExtentTest reportLogger;

    @BeforeSuite
    public void suiteSetup() {
        logger.debug("Inside Before Suite!");
        reportLogger = new ExtentReporter().initReport();
        driver = initProject();
    }

    @BeforeMethod
    public void loginSetUp() {
        logger.debug("Inside Before Method!");
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult) {
        logger.debug("Inside After Method!");
        driver.manage().deleteAllCookies();
    }

    @AfterSuite
    public void afterSuite() {
        logger.debug("Inside After Suite!");
        driver.quit();
    }
}
