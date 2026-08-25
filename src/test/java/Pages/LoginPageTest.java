package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginPageTest {

    WebDriver driver;

    private static final Logger logger =LogManager.getLogger(LoginPageTest.class);

    public LoginPageTest(WebDriver driver) {
        this.driver = driver;
        logger.info("LoginPageTest initialized.");
    }

    By txtUsername = By.id("username");
    By txtPassword = By.id("password");
    By btnLogin = By.cssSelector("button[type='submit']");
    By successMessage = By.id("flash");

    public void enterUserName(String username) {
        logger.debug("Entering username");
        driver.findElement(txtUsername).sendKeys(username);
    }

    public void enterPassword(String password) {
        logger.debug("Entering password");
        driver.findElement(txtPassword).sendKeys(password);
    }

    public void clickLogin() {
        logger.info("Clicking Login button");
        driver.findElement(btnLogin).click();
    }

    public String getSuccessMessage() {
        logger.info("Getting success message");
        return driver.findElement(successMessage).getText();
    }
}