//package testCases;
//
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import com.aventstack.extentreports.ExtentTest;
//
//import factory.BaseClass;
//import Pages.LoginPageTest;
//
//public class TC_LoginTest extends BaseClass {
//
//    @Test
//    public void verifyLogin() {
//
//        ExtentTest test = extent.createTest("Verify Login");
//
//        LoginPageTest lp = new LoginPageTest(driver);
//
//        test.info("Entering Username");
//        lp.enterUserName("tomsmith");
//
//        test.info("Entering Password");
//        lp.enterPassword("SuperSecretPassword!");
//
//        test.info("Clicking Login Button");
//        lp.clickLogin();
//
//        String actualMessage = lp.getSuccessMessage();
//
//        Assert.assertTrue(
//                actualMessage.contains("You logged into a secure area!"),
//                "Login Failed"
//        );
//
//        test.pass("Login Successful");
//    }
//}