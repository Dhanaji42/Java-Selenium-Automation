package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ECommerceAutomation {

    WebDriver driver;

    private static final Logger logger =
            LogManager.getLogger(ECommerceAutomation.class);

    public ECommerceAutomation(WebDriver driver) {
        this.driver = driver;
        logger.info("ECommerce Page Initialized");
    }

    By clickaddcartbtn = By.xpath("(//input[@value='Add to cart'])[2]");
    By clickshoppingcart = By.xpath("//p[@class='content']/a");
    By verifyproduct = By.xpath("//a[@class='product-name']");
    By clickcheckbox = By.xpath("//input[@id='termsofservice']");
    By clickcheckout = By.xpath("//button[@id='checkout']");
    By verifycheckoutpage = By.xpath("//div[@class='page-title']/h1");
    By Selectcntry = By.xpath("//select[@id='BillingNewAddress_CountryId']");
    By citytxt = By.xpath("//input[@id='BillingNewAddress_City']");
    By Addresstxt = By.xpath("//input[@id='BillingNewAddress_Address1']");
    By Addresstxt1 = By.xpath("//input[@id='BillingNewAddress_Address2']");
    By postalcodetxt = By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']");
    By phnenotxt = By.xpath("//input[@id='BillingNewAddress_PhoneNumber']");
    By faxtxt = By.xpath("//input[@id='BillingNewAddress_FaxNumber']");
    By Billingadclick = By.xpath("//input[@onclick='Billing.save()']");
    By shippingadd = By.xpath("//select[@id='shipping-address-select']");
    By Clickchckbx =By.xpath("//input[@type='checkbox']");
    By clickshipingsave =By.xpath("//input[@onclick='Shipping.save()']");
    By clickCOD = By.xpath("//input[@value='Payments.CashOnDelivery']");
    By clickpymtsave =By.xpath("//input[@onclick='PaymentMethod.save()']");
    By verifyCOD =By.xpath("//p[normalize-space()='You will pay by COD']");
    By clickpymtinf =By.xpath("//input[@onclick='PaymentInfo.save()']");
    //By Chckotconfmorder =By.xpath("//div[@id='checkout-step-confirm-order']");
    By Clickcnforder =By.xpath("//input[@onclick='ConfirmOrder.save()']");
    By verfychckotpg =By.xpath("//div[@class='page checkout-page']");
  //select[@id='shipping-address-select'] verify
  
  //p[normalize-space()='You will pay by COD'] verify
    
  //div[@id='checkout-step-confirm-order'] verify 
      
  //div[@class='page checkout-page'] verify
//    Thank you
//    Your order has been successfully processed!
//    Order number: 2375837
//    Click here for order details.
  
    
    public void clickaddcartbtn() {
        logger.info("Clicking Add To Cart button");
        driver.findElement(clickaddcartbtn).click();
    }

    public void clickshoppingcart() {
        logger.info("Clicking Shopping Cart");
        driver.findElement(clickshoppingcart).click();
    }

    public String Verifyproduct() {
        logger.info("Verifying Product");
        return driver.findElement(verifyproduct).getText();
    }

    public void clickoncheckbox() {
        logger.info("Clicking Terms of Service Checkbox");
        driver.findElement(clickcheckbox).click();
    }

    public void Clickoncheckoutbtn() {
        logger.info("Clicking Checkout Button");
        driver.findElement(clickcheckout).click();
    }

    public String verifychecktpage() {
        logger.info("Verifying Checkout Page");
        return driver.findElement(verifycheckoutpage).getText();
    }
    

    public void Selectcntry() {
        logger.info("Selecting Country");

        Select country = new Select(driver.findElement(Selectcntry));
        country.selectByVisibleText("India");
    }    
    
    public void entercityname(String City) {
        logger.info("Entering city name");
        driver.findElement(citytxt).sendKeys(City);
    }
    public void  enterAddress (String address) {
   	 logger.info("Entering address");
   	 driver.findElement(Addresstxt).sendKeys(address);
    }
    
    public void  enterAddress1 (String address) {
      	 logger.info("Entering address");
      	 driver.findElement(Addresstxt1).sendKeys(address);
       }
    
    public void  enterpostalcode (String postalcode) {
     	 logger.info("Entering postal code");
     	 driver.findElement(postalcodetxt).sendKeys(postalcode);
      }
    
    public void  enterphonenumber (String phonenumber) {
    	 logger.info("Entering phone numeber");
    	 driver.findElement(phnenotxt).sendKeys(phonenumber);
     }
    
    public void  enterfaxnumber (String faxnumber) {
   	 logger.info("Entering fax numeber");
   	 driver.findElement(faxtxt).sendKeys(faxnumber);
    }
    
    public void clickBillingAddressSave() {
        logger.info("Clicking Billing Address Save button");
        driver.findElement(Billingadclick).click();
    }

    public void selectShippingAddress() {
        logger.info("Selecting Shipping Address");
        driver.findElement(shippingadd).click();
    }

    public void clickShippingAddressCheckbox() {
        logger.info("Clicking Shipping Address checkbox");
        driver.findElement(Clickchckbx).click();
    }

    public void clickShippingSave() {
        logger.info("Clicking Shipping Save button");
        driver.findElement(clickshipingsave).click();
    }
    
    

    public void selectCashOnDelivery() {
        logger.info("Selecting Cash On Delivery payment method");
        driver.findElement(clickCOD).click();
    }

    public void clickPaymentMethodSave() {
        logger.info("Clicking Payment Method Save button");
        driver.findElement(clickpymtsave).click();
    }

    public boolean verifyCashOnDeliveryMessage() {
        logger.info("Verifying Cash On Delivery message");
        return driver.findElement(verifyCOD).isDisplayed();
    }

    public void clickPaymentInfoSave() {
        logger.info("Clicking Payment Info Save button");
        driver.findElement(clickpymtinf).click();
    }

//    public boolean verifyCheckoutConfirmOrderSection() {
//        logger.info("Verifying Checkout Confirm Order section");
//        return driver.findElement(Chckotconfmorder).isDisplayed();
//    }

    public void clickConfirmOrder() {
        logger.info("Clicking Confirm Order button");
        driver.findElement(Clickcnforder).click();
    }

    public boolean verifyCheckoutPage() {
        logger.info("Verifying Checkout Page");
        return driver.findElement(verfychckotpg).isDisplayed();
    }
 }
