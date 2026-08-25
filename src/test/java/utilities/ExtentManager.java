package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getReportInstance() {

        if (extent == null) {

            String reportPath = System.getProperty("user.dir") + "/reports/AutomationExtentReport.html";

            ExtentSparkReporter sparkReporter =   new ExtentSparkReporter(reportPath);

            sparkReporter.config().setReportName("Selenium Test Execution Report");
            sparkReporter.config().setDocumentTitle("Automation Results");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);

            extent.setSystemInfo("Tester", "Dhanaji");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Browser", "Chrome");
        }

        return extent;
    }
}