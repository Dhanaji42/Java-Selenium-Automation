package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPassDemoWebShopPage {

    WebDriver driver;

    private static final Logger logger =LogManager.getLogger(ForgotPassDemoWebShopPage.class);

    public ForgotPassDemoWebShopPage(WebDriver driver) {
	        this.driver = driver;
	        logger.info("Forgot Password Page initialized.");
    }

    // Locators
    By loginBtn = By.xpath("//a[@class='ico-login']");
    By forgotBtn = By.xpath("//a[normalize-space()='Forgot password?']");
    By Emailtxtt =By.xpath("//input[@id='Email']");
    By recoverbtn =By.xpath("//input[@name='send-email']");
    By passwordrecovery =By.xpath("//div[@class='result']");
    // Actions
    public void clickLoginOpenCart() {
        logger.info("Clicking Login button");
        driver.findElement(loginBtn).click();
    }

    public void clickForgotPassword() {
        logger.info("Clicking Forgot Password link");
        driver.findElement(forgotBtn).click();
    }
    
    public void  enteremail (String Email) {
   	 logger.debug("Entering Eanail Id");
   	 driver.findElement(Emailtxtt).sendKeys(Email);
    }
    public void  Clickrecoverbtn () {
      	 logger.debug("Clicking recover btn");
      	 driver.findElement(recoverbtn).click();
       }
    
    public String Passwordrecovery() {
        logger.info("Email with instructions has been sent to you.");
        return driver.findElement(passwordrecovery).getText();
    }  
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
	       
//	         
//	       
//	      
//
	         

	

	


