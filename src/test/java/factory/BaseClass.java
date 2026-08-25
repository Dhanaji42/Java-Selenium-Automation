package factory;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.io.FileReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;

import utilities.ExtentManager;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
public class BaseClass {
	protected static WebDriver driver;
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
	public void setup() throws IOException {
	    driver = initilizeBrowser();
	    driver.manage().window().maximize();
	    //driver.get("https://the-internet.herokuapp.com/login");
	    driver.get("https://demowebshop.tricentis.com/");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}

//	@AfterMethod
//	public void tearDown() {
//	    if(driver != null) {
//	        driver.quit();
//	    }
//	}
	


	// Initializes and returns a WebDriver instance based on execution environment,
	// browser, and OS configuration
	public static WebDriver initilizeBrowser() throws IOException {

		// HIGHLIGHT: If a driver exists from the previous scenario, quit it first
		// If a driver exists but the session is closed, we must reset it

		p = new Properties();

		FileReader fr = new FileReader("src/test/resources/config.properties");

		p.load(fr);

		if (driver != null) {
			driver.quit();
		}

		p = getProperties();

		String executionEnv = System.getProperty("execution_env", p.getProperty("execution_env", "local"))
				.toLowerCase();
		String browser = System.getProperty("browser", p.getProperty("browser", "chrome")).toLowerCase();
		String os = System.getProperty("os", p.getProperty("os", "windows")).toLowerCase();

		if (executionEnv.equalsIgnoreCase("remote")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();

			// os
			switch (os) {
			case "windows":
				capabilities.setPlatform(Platform.WINDOWS);
				break;
			case "mac":
				capabilities.setPlatform(Platform.MAC);
				break;
			case "linux":
				capabilities.setPlatform(Platform.LINUX);
				break;
			default:
				System.out.println("No matching OS");
				return null;
			}

			// browser
			switch (browser) {
			case "chrome":

				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-first-run-ui");
				options.addArguments("--no-default-browser-check");
				options.addArguments("--disable-popup-blocking");
				options.addArguments("--start-maximized");
				options.addArguments("--disable-infobars");
				options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
				options.setExperimentalOption("useAutomationExtension", false);

				driver = new ChromeDriver(options);
				break;

			// capabilities.setBrowserName("chrome");
			// break;
			case "edge":
				capabilities.setBrowserName("MicrosoftEdge");
				break;
			case "firefox":
				capabilities.setBrowserName("firefox");
				break;
			default:
				System.out.println("No matching browser");
				return null;
			}

		}

		else if (executionEnv.equalsIgnoreCase("local")) {
			switch (browser.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			default:
				System.out.println("No matching browser");
				driver = null;
			}
		}
		driver.manage().deleteAllCookies();

		return driver;

	}

	//Returns the current WebDriver instance
	public static WebDriver getDriver() {
		return driver;
	}
	
	//Loads and returns application properties from the config.properties file
		public static Properties getProperties() throws IOException {
			FileReader file = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
			p = new Properties();
			p.load(file);
			return p;
		}
}
