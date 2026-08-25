package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutpageOpencart {

    WebDriver driver;

    public LogoutpageOpencart(WebDriver driver) {
        this.driver = driver;
    }
    

    By btnlogout = By.xpath("//a[@class='ico-logout']");

    public void clickLogout() {
        driver.findElement(btnlogout).click();
    }
}