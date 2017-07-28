package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class checkoutPage {

    private static WebElement element = null;
    private static Select oSelect = null;

    public static WebElement firstName(WebDriver driver){
        element = driver.findElement(By.id("WE30DIQ"));
        return element;
    }

    public static WebElement lastName(WebDriver driver){
        element = driver.findElement(By.id("XBWC2CS"));
        return element;
    }

    public static WebElement company (WebDriver driver){
        element = driver.findElement(By.id("W3BUVCU"));
        return element;
    }

    public static WebElement streetAddress_1(WebDriver driver){
        element = driver.findElement(By.id("CB5B3E9"));
        return element;
    }

    public static WebElement streetAddress_2(WebDriver driver){
        element = driver.findElement(By.id("FBIKRPT"));
        return element;
    }

    public static void stateProvince(WebDriver driver, String text){
        oSelect = new Select(driver.findElement(By.id("VN2BPYV")));
        oSelect.deselectByVisibleText(text);
    }

    public static WebElement zipCode(WebDriver driver){
        element = driver.findElement(By.id("CDIYL2Q"));
        return element;
    }

    public static void country(WebDriver driver, String text){
        oSelect = new Select(driver.findElement(By.id("W0O8Y5M")));
        oSelect.deselectByVisibleText(text);
    }

    public static void setPhoneNumber(WebDriver driver, String text){
        element = driver.findElement(By.id("UWO2S39"));
        element.sendKeys(text);
    }

    public static void chooseShippingMethod_TableRate(WebDriver driver){
        driver.findElement(By.id("s_method_tablerate_bestway")).click();
    }

    public static void chooseShippingMethod_Fixed(WebDriver driver){
        driver.findElement(By.id("s_method_flatrate_flatrate")).click();
    }

    public static WebElement button_Next(WebDriver driver){
        element = driver.findElement(By.partialLinkText("Next"));
        return element;
    }
}
