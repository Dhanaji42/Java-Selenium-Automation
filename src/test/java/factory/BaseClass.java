package factory;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utilities.ExtentManager;
import utilities.ScreenshotUtil;

public class BaseClass {

    // Thread-safe WebDriver
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Thread-safe ExtentTest
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    static Properties p;
    static Logger logger;

    public static ExtentReports extent;

    @BeforeSuite
    public void setupReport() {
        extent = ExtentManager.getReportInstance();
    }

    @AfterSuite
    public void tearDownReport() {
        extent.flush();
    }

    @BeforeMethod
    @Parameters("browser")
    public void setup(@Optional("chrome") String browser)
            throws IOException {

        WebDriver webDriver = initializeBrowser(browser);

        driver.set(webDriver);

        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();

        getDriver().get("https://demowebshop.tricentis.com/");

        getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(60));
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        try {

            String screenshotPath =
                    ScreenshotUtil.captureScreenshot(result.getName());

            if (test.get() != null) {

                if (result.getStatus() == ITestResult.SUCCESS) {

                    test.get()
                            .pass("Test Passed")
                            .addScreenCaptureFromPath(screenshotPath);

                } else if (result.getStatus() == ITestResult.FAILURE) {

                    test.get()
                            .fail(result.getThrowable())
                            .addScreenCaptureFromPath(screenshotPath);

                } else if (result.getStatus() == ITestResult.SKIP) {

                    test.get()
                            .skip("Test Skipped")
                            .addScreenCaptureFromPath(screenshotPath);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }

    public static WebDriver initializeBrowser(String browser)
            throws IOException {

        WebDriver localDriver = null;

        switch (browser.toLowerCase()) {

        case "chrome":

            System.setProperty(
                    "webdriver.chrome.driver",
                    "C:\\drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--disable-popup-blocking");

            localDriver = new ChromeDriver(chromeOptions);
            break;

        case "edge":

            System.setProperty(
                    "webdriver.edge.driver",
                    "C:\\drivers\\edgedriver_win64\\msedgedriver.exe");

            localDriver = new EdgeDriver();
            break;

//        case "firefox":
//
//            System.setProperty(
//                    "webdriver.gecko.driver",
//                    "C:\\drivers\\geckodriver.exe");
//
//            localDriver = new FirefoxDriver();
//            break;

        default:
            throw new RuntimeException(
                    "Unsupported Browser : " + browser);
        }

        return localDriver;
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static Properties getProperties() throws IOException {

        FileReader file = new FileReader(
                System.getProperty("user.dir")
                        + "\\src\\test\\resources\\config.properties");

        p = new Properties();
        p.load(file);

        return p;
    }
}