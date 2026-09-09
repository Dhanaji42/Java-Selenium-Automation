package testCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DataProviders;
import Pages.ECommerceAutomation;
import Pages.LoginPageOpencart;
import factory.BaseClass;

public class TC_ECommerceAutomation extends BaseClass {

	@Test(priority = 1, dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void verifyLoginEcommerce(String email, String password)
     {

        test.set(extent.createTest("ECommerceAutomation"));

        // Login
        LoginPageOpencart lp = new LoginPageOpencart(getDriver());

        test.get().info("Clicking Login Button");
        lp.clickLoginOpenCart();

//        test.get().info("Entering Email"+ email);
//        lp.enterEmail(email);
//
//        test.get().info("Entering Password"+ password);
//        lp.enterPassword(password);

        test.get().info("Clicking Login");
        lp.clicklogin1();

        test.get().pass("Login Successful");

        getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        // E-Commerce

        ECommerceAutomation EC = new ECommerceAutomation(getDriver());

        test.get().info("Clicking Add To Cart Button");
        EC.clickaddcartbtn();

        test.get().info("Clicking Shopping Cart");
        EC.clickshoppingcart();

        String productName = EC.Verifyproduct();

        test.get().info("Product Name: " + productName);

        Assert.assertEquals(productName, "14.1-inch Laptop");

        test.get().info("Clicking Terms of Service Checkbox");
        EC.clickoncheckbox();

        test.get().info("Clicking Checkout Button");
        EC.Clickoncheckoutbtn();

        String checkoutPage = EC.verifychecktpage();

        test.get().info("Checkout Page: " + checkoutPage);

        Assert.assertEquals(checkoutPage, "Checkout");

        test.get().info("Clicking on Select Billing Address");
        EC.selectNewBillingAddress();

        test.get().info("Selecting Country");
        EC.Selectcntry();

        test.get().info("Entering City");
        EC.entercityname("Pune");

        test.get().info("Entering Address");
        EC.enterAddress("Pune near dmart");

        test.get().info("Entering Address Line 2");
        EC.enterAddress1("hinjewadi phase3");

        test.get().info("Entering Postal Code");
        EC.enterpostalcode("442356");

        test.get().info("Entering Phone Number");
        EC.enterphonenumber("7066254567");

        test.get().info("Entering Fax Number");
        EC.enterfaxnumber("234-7066254567");

        test.get().info("Clicking Billing Address Save Button");
        EC.clickBillingAddressSave();

        test.get().info("Selecting Shipping Address");
        EC.selectShippingAddress();

        test.get().info("Clicking Shipping Address Checkbox");
        EC.clickShippingAddressCheckbox();

        test.get().info("Clicking Shipping Save Button");
        EC.clickShippingSave();

        test.get().info("Selecting Cash On Delivery");
        EC.selectCashOnDelivery();

        test.get().info("Clicking Payment Method Save");
        EC.clickPaymentMethodSave();

        test.get().info("Verifying Cash On Delivery Message");
        Assert.assertTrue(EC.verifyCashOnDeliveryMessage());

        test.get().info("Clicking Payment Info Save");
        EC.clickPaymentInfoSave();

        test.get().info("Clicking Confirm Order");
        EC.clickConfirmOrder();

        test.get().info("Verifying Checkout Completion");
        Assert.assertTrue(EC.verifyCheckoutPage());

        test.get().pass("ECommerce Flow Completed Successfully");
    }
}