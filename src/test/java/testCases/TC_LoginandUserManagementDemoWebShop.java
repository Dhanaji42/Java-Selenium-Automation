package testCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ForgotPassDemoWebShopPage;
import Pages.LoginDemoWebShopPage;
import Pages.LogoutDemoWebShopPage;
import Pages.UserprofileDemoWebShopPage;
import factory.BaseClass;
import utilities.RetryAnalyzer;

public class TC_LoginandUserManagementDemoWebShop extends BaseClass {

    @Test(
        priority = 1,
        retryAnalyzer = RetryAnalyzer.class
    )
    public void verifyLogin() throws InterruptedException {

        test.set(extent.createTest("Verify Login Test"));

        LoginDemoWebShopPage lp = new LoginDemoWebShopPage(getDriver());


        // Login
        test.get().info("Clicking Login Button");
        lp.clickLoginOpenCart();

        test.get().info("Entering Email");
        lp.enterEmail("dhanaji1234@gmail.com");

        test.get().info("Entering Password");
        lp.enterPassword("Dhanaji@0303");

        test.get().info("Clicking Login");
        lp.clicklogin1();

        Assert.assertEquals(
                lp.getWelcomeMessage(),
                "Welcome to our store",
                "Welcome message is not displayed");

        test.get().pass("Login Successful");

        getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        // User Profile
        UserprofileDemoWebShopPage UP =
                new UserprofileDemoWebShopPage(getDriver());

        test.get().info("Clicking My Account");
        UP.clickingmyaccount();

        test.get().info("Verifying Personal Details");
        UP.Customerinfo();

        test.get().pass("Personal Details Verified Successfully");

        getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        // Logout
        LogoutDemoWebShopPage lo =
                new LogoutDemoWebShopPage(getDriver());

        test.get().info("Clicking Logout");
        lo.clickLogout();

        test.get().pass("Logout Successful");

        getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        // Forgot Password
        lp.clickLoginOpenCart();

        ForgotPassDemoWebShopPage fP =
                new ForgotPassDemoWebShopPage(getDriver());

        test.get().info("Clicking Forgot Password");
        fP.clickForgotPassword();

        test.get().info("Entering Email ID");
        fP.enteremail("dhanaji1234@gmail.com");

        test.get().info("Clicking Recover Button");
        fP.Clickrecoverbtn();

        test.get().info("Verifying Password Recovery Message");
        fP.Passwordrecovery();

        test.get().pass("Forgot Password Flow Completed Successfully");
    }
}