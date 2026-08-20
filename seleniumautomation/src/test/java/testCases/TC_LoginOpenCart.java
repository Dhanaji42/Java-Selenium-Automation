package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;

import factory.BaseClass;
import Pages.LoginPageOpencart;




public class TC_LoginOpenCart extends BaseClass {
	@Test
    public void verifyLogin() {

        ExtentTest test = extent.createTest("Verify Login");

        LoginPageOpencart lp = new LoginPageOpencart(driver);
        
        test.info("Clicking Login Button");
        lp.clickLoginOpenCart();
        
        test.info("Entering Eanail Id");
        lp.enterEmail("dhanaji1234@gmail.com");
        
        test.info("Entering Password");
        lp.enterPassword("Dhanaji@0303");

        test.info("Clicking Login Button");
        lp.clicklogin1();

        test.info("Verifying Login");

        Assert.assertEquals(
                lp.getWelcomeMessage(),
                "Welcome to our store",
                "Welcome message is not displayed");

        
    }
}