package testCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import Pages.ECommerceAutomation;
import Pages.LoginPageOpencart;
import factory.BaseClass;

public class TC_ECommerceAutomation extends BaseClass {

    @Test(priority = 1)
    public void verifyLogin() {

        ExtentTest test = extent.createTest("ECommerceAutomation");

        // Login
        LoginPageOpencart lp = new LoginPageOpencart(driver);

        test.info("Clicking Login Button");
        lp.clickLoginOpenCart();

        test.info("Entering Email");
        lp.enterEmail("dhanaji1234@gmail.com");

        test.info("Entering Password");
        lp.enterPassword("Dhanaji@0303");

        test.info("Clicking Login");
        lp.clicklogin1();

        test.pass("Login Successful");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // E-Commerce

        ECommerceAutomation EC = new ECommerceAutomation(driver);

        test.info("Clicking Add To Cart Button");
        EC.clickaddcartbtn();

        test.info("Clicking Shopping Cart");
        EC.clickshoppingcart();

        String productName = EC.Verifyproduct();
        test.info("Product Name: " + productName);

        Assert.assertEquals(productName, "14.1-inch Laptop");

        test.info("Clicking Terms of Service Checkbox");
        EC.clickoncheckbox();

        test.info("Clicking Checkout Button");
        EC.Clickoncheckoutbtn();

        String checkoutPage = EC.verifychecktpage();
        test.info("Checkout Page: " + checkoutPage);

        Assert.assertEquals(checkoutPage, "Checkout");
        
        
        test.info("Clicking on select country Button");
        EC.Selectcntry();
        
        test.info("Entering city name");
        EC.entercityname("Pune");
        
        test.info("Entering address");
        EC.enterAddress("Pune near dmart");
        
        test.info("Entering address");
        EC.enterAddress1("hinjewadi phase3");
        
        test.info("Entering postal code");
        EC.enterpostalcode("442356");
        
        test.info("Entering phone number");
        EC.enterphonenumber("7066254567");
        
        test.info("Entering fax number");
        EC.enterfaxnumber("234-7066254567");
        
        test.info("Clicking Billing Address Save button");
        EC.clickBillingAddressSave();

        test.info("Selecting Shipping Address");
        EC.selectShippingAddress();

        test.info("Clicking Shipping Address Checkbox");
        EC.clickShippingAddressCheckbox();

        test.info("Clicking Shipping Save button");
        EC.clickShippingSave();

        test.info("Selecting Cash On Delivery payment method");
        EC.selectCashOnDelivery();

        test.info("Clicking Payment Method Save button");
        EC.clickPaymentMethodSave();

        test.info("Verifying Cash On Delivery message");
        Assert.assertTrue(EC.verifyCashOnDeliveryMessage());

        test.info("Clicking Payment Info Save button");
        EC.clickPaymentInfoSave();

        //test.info("Verifying Checkout Confirm Order section");
        
        //Assert.assertTrue(EC.verifyCheckoutConfirmOrderSection());

        test.info("Clicking Confirm Order button");
        EC.clickConfirmOrder();

        test.info("Verifying Checkout Page");
        Assert.assertTrue(EC.verifyCheckoutPage());

       
        test.pass("ECommerce Flow Completed Successfully");
    }
}