package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static pageObject.registrationPage.getRandomString;

public class checkoutPage {

    private static WebElement element = null;
    private static Select oSelect = null;

    public static WebElement firstName(WebDriver driver){
        element = driver.findElement(By.xpath(".//*[@id='shipping-new-address-form']/div[1]/div/input"));
        return element;
    }

    public static String randomFirstName(){

        return "FirstName"+getRandomString();
    }

    public static WebElement lastName(WebDriver driver){
        element = driver.findElement(By.xpath(".//*[@id='shipping-new-address-form']/div[2]/div/input"));
        return element;
    }

    public static String randomLastName(){

        return "LastName"+getRandomString();
    }

    public static WebElement company (WebDriver driver){
        element = driver.findElement(By.xpath(".//*[@id='shipping-new-address-form']/div[3]/div/input"));
        return element;
    }

    public static String randomCity(){
        return "City"+getRandomString();
    }

    public static String randomCompany(){

        return "Company"+getRandomString();
    }

    public static WebElement streetAddress_1(WebDriver driver){
        element = driver.findElement(By.xpath(".//*[@id='shipping-new-address-form']/fieldset/div/div[1]/div/input"));
        return element;
    }

    public static String randomStreetAddress_1(){

        return "Street Addres 1 "+getRandomString();
    }

    public static WebElement streetAddress_2(WebDriver driver){
        element = driver.findElement(By.xpath(".//*[@id='shipping-new-address-form']/fieldset/div/div[2]/div/input"));
        return element;
    }

    public static String randomStreetAddress_2(){

        return "Street Address 2 "+getRandomString();
    }

    public static WebElement city(WebDriver driver){
        element = driver.findElement(By.xpath(".//*[@id='shipping-new-address-form']/div[4]/div/input"));
        return element;
    }

    public static void stateProvince(WebDriver driver, String text){
        oSelect = new Select(driver.findElement(By.xpath(".//*[@id='shipping-new-address-form']/div[5]/div/select")));
        oSelect.selectByVisibleText(text);
    }

    public static WebElement zipCode(WebDriver driver){
        element = driver.findElement(By.xpath(".//*[@id='shipping-new-address-form']/div[7]/div/input"));
        return element;
    }

    public static void country(WebDriver driver, String text){
        oSelect = new Select(driver.findElement(By.xpath(".//*[@id='shipping-new-address-form']/div[8]/div/select")));
        oSelect.selectByVisibleText(text);
    }

    public static void setPhoneNumber(WebDriver driver, String text){
        element = driver.findElement(By.xpath("//*[@id='shipping-new-address-form']/div[9]/div/input"));
        element.sendKeys(text);
    }

    public static WebElement phoneNumberErrorMessage(WebDriver driver){
        element = driver.findElement(By.xpath(".//*[@id='shipping-new-address-form']/div[9]/div/div"));
        return element;
    }

    public static void chooseShippingMethod_TableRate(WebDriver driver){
        driver.findElement(By.id("s_method_tablerate_bestway")).click();
    }

    public static void chooseShippingMethod_Fixed(WebDriver driver){
        driver.findElement(By.id("s_method_flatrate_flatrate")).click();
    }

    public static WebElement button_Next(WebDriver driver){
       //element = driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button/span/span"));
        element = driver.findElement(By.xpath(".//*[@id='shipping-method-buttons-container']/div/button/span/span[text()='Next']"));

        return element;
    }

    public static WebElement zipErrorMessage(WebDriver driver){
        element = driver.findElement(By.xpath(".//*[@id='shipping-new-address-form']/div[7]/div/div"));
        return element;
    }

    public static WebElement countryErrorMessage(WebDriver driver){
        element = driver.findElement(By.xpath(".//*[@id='shipping-new-address-form']/div[8]/div/div"));
        return element;
    }
    public static boolean requiredFieldErrorIsDisplayed(WebDriver driver){

        WebElement requiredFieldErrorMessage = driver.findElement(By.className("mage-error"));
        //WebElement requiredShippingMethodErrorMessage = driver.findElement(By.className("message notice"));
        //When the test is running on the Chrome Browser text message is showing but on the Firefox it's not that's why here is comment

        if (requiredFieldErrorMessage.isDisplayed() /*|| requiredShippingMethodErrorMessage.isDisplayed()*/)
            return true;
        else
            return false;

    }
}
