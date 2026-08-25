package Pages;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.apache.logging.log4j.LogManager;
	import org.apache.logging.log4j.Logger;

	public class UserprofileOpencart {

	    WebDriver driver;

	    private static final Logger logger =LogManager.getLogger(LoginPageTest.class);

	    public UserprofileOpencart(WebDriver driver) {
	        this.driver = driver;
	        logger.info("LoginPageTest initialized.");
	    }

	    By Myaccountbtn = By.cssSelector("div[class='column my-account'] a[class='account']");
	    By Custinfo = By.xpath("//*[normalize-space()='Your Personal Details']");

	    public void clickingmyaccount() {
	        logger.debug("Clicking my account btn");
	        driver.findElement(Myaccountbtn).click();
	    }

	    public String Customerinfo() {
	        logger.debug("Verfying customer info");
	        return driver.findElement(Custinfo).getText();
	    }

	    
	    
	}


