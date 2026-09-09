package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageOpencart {
	
	WebDriver driver;
	
	private static final Logger logger =LogManager.getLogger(LoginPageOpencart.class);
	
	public LoginPageOpencart(WebDriver driver) {
        this.driver = driver;
        logger.info("LoginPageTest initialized.");
    }
	     By Loginbtn = By.xpath("(//a[@class='ico-login'])");
	     By Emailtxt = By.xpath("//input[@id='Email']");
	     By Passwordtxt =By.xpath("//input[@id='Password']");
	     By LoginBtn1 =By.cssSelector(".button-1.login-button");
	     By welcomeMessage = By.xpath("//h2[normalize-space()='Welcome to our store']");
	     
	     public void clickLoginOpenCart() {
	         logger.info("Clicking Login button");
	         driver.findElement(Loginbtn).click();
	     }
	     
	     public void enterEmail(String Email) {
	         logger.debug("Entering Email Id");
	         driver.findElement(Emailtxt).sendKeys(Email);
	     }
         public void  enterPassword (String Password) {
        	 logger.debug("Enter username");
        	 driver.findElement(Passwordtxt).sendKeys(Password);
         }
         
         public void clicklogin1( ) {
        	 logger.info("Clicking Login button");
	         driver.findElement(LoginBtn1).click();
        	 
         }
      

         public String getWelcomeMessage() {
             logger.info("Getting welcome message");
             return driver.findElement(welcomeMessage).getText();
         }

}
