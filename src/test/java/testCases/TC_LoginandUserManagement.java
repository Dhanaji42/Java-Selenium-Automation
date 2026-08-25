package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import Pages.ForgotpassOpencart;
import Pages.LoginPageOpencart;
import Pages.LogoutpageOpencart;
import Pages.UserprofileOpencart;
import factory.BaseClass;

public class TC_LoginandUserManagement extends BaseClass {

    @Test(priority = 1)
    public void verifyLogin() {

        ExtentTest test = extent.createTest("Verify Login");

        LoginPageOpencart lp = new LoginPageOpencart(driver);

        // Login
        test.info("Clicking Login Button");
        lp.clickLoginOpenCart();

        test.info("Entering Email");
        lp.enterEmail("dhanaji1234@gmail.com");

        test.info("Entering Password");
        lp.enterPassword("Dhanaji@0303");

        test.info("Clicking Login");
        lp.clicklogin1();

        Assert.assertEquals(
                lp.getWelcomeMessage(),
                "Welcome to our store",
                "Welcome message is not displayed");

        test.pass("Login Successful");
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //User Profile
        UserprofileOpencart UP = new UserprofileOpencart(driver);
        		
        test.info("Clicking my account btn");
        UP.clickingmyaccount();
        
        test.info("Verify Your Personal Details");
        UP.Customerinfo();
        
        test.pass("Personal detail verified succesfully");
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Logout
//        wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//a[@class='ico-logout']")));

        LogoutpageOpencart lo = new LogoutpageOpencart(driver);

        test.info("Clicking Logout");
        lo.clickLogout();

        test.pass("Logout Successful");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Forgot Password	
        lp.clickLoginOpenCart();
        ForgotpassOpencart fP =new ForgotpassOpencart(driver);

        test.info("Clicking Forgot Password");
        fP.clickForgotPassword();
        
        test.info("Entering Email Id");
        fP.enteremail("dhanaji1234@gmail.com");
        
        test.info("Clicking recover btn");
        fP.Clickrecoverbtn();
        
        test.info("Email with instructions has been sent to you text");
        fP.Passwordrecovery();
        
        
        test.pass("Forgot Password Clicked Successfully");
    }
}