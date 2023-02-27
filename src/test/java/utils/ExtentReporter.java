package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReporter {
    public ExtentSparkReporter spark;
    public ExtentReports extentReports;
    public ExtentTest reportLogger;

    public ExtentTest initReport() {
        extentReports = new ExtentReports();
        spark = new ExtentSparkReporter(System.getProperty("user.dir") + "target/reports/AutomationTestReport.html");
        extentReports.attachReporter(spark);
        return reportLogger;
    }

    public void reportLogs() {

    }

    public ExtentTest getReportLogger(){
        return reportLogger;
    }

    public void flushReport() {
        extentReports.flush();
    }

    public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException, IOException {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
// after execution, you could see a folder "FailedTestsScreenshots" under src folder
        String destination = System.getProperty("user.dir") + "target/Screenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;
    }
}
