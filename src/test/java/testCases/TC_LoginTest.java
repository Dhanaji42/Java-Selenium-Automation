package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPageTest;
import factory.BaseClass;

public class TC_LoginTest extends BaseClass {

    @Test
    public void verifyLogin() {

        // Create Extent Report Test for current thread
        test.set(extent.createTest("Verify Login"));

        // Initialize Page Object
        LoginPageTest lp = new LoginPageTest(getDriver());

        // Enter Username
        test.get().info("Entering Username");
        lp.enterUserName("tomsmith");

        // Enter Password
        test.get().info("Entering Password");
        lp.enterPassword("SuperSecretPassword!");

        // Click Login
        test.get().info("Clicking Login Button");
        lp.clickLogin();

        // Get Success Message
        String actualMessage = lp.getSuccessMessage();

        // Validate Login
        test.get().info("Validating Success Message");

        Assert.assertTrue(
                actualMessage.contains("You logged into a secure area!"),
                "Login Failed"
        );

        // Mark Test Passed
        test.get().pass("Login Successful");
    }
}