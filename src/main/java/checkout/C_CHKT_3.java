package checkout;

import actions.addProduct;
import actions.logInSuccessfully;
import object.Browser;
import object.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.checkoutPage;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 *
 *  ID | C_CHKT_3 | Customer entered wrong ZIP Code
 *  -----------------------------------------------
 *  Step | Scenario
 *
 *  1.Launch the browser
 *  2.Navigate to Home Page
 *  3.Log In successfully
 *  4.Add product successfully
 *  5.Navigate to Cart
 *  6.Go to Checkout
 *  7.Enter all details and wrong ZIP Code
 *  8.Click Next
 *
 **/

public class C_CHKT_3 {

    public static WebDriver driver = null;

    @BeforeTest
    public void openBrowser(){
        //driver = Browser.htmlUtilDriver();
        driver = Browser.openFirefox();
    }

    @Test
    public void customerEnteredWrongZipCode(){

        System.out.println("ID | C_CHKT_3 | Customer entered wrong ZIP Code");
        System.out.println("-----------------------------------------------");

        //1.Launch the browser
        System.out.println("1.Launch the browser");

        //2.Navigate to Home Page
        driver.get(Constant.homePage);
        System.out.println("2.Navigate to Home Page");

        //3.Log In successfully
        logInSuccessfully.execute(driver);
        System.out.println("3.Log In successfully");

        //4.Add product successfully
        addProduct.execute(driver);
        System.out.println("4.Add product successfully");

        //5.Navigate to Cart
        driver.get(Constant.cartURL);
        System.out.println("5.Navigate to Cart");

        //6.Go to Checkout
        driver.get(Constant.checkoutURL);
        System.out.println("6.Go to Checkout");

        //7.Enter all details without selecting State/Province
        checkoutPage.firstName(driver).sendKeys(checkoutPage.randomFirstName());
        checkoutPage.lastName(driver).sendKeys(checkoutPage.randomLastName());
        checkoutPage.company(driver).sendKeys(checkoutPage.randomCompany());
        checkoutPage.streetAddress_1(driver).sendKeys(checkoutPage.randomStreetAddress_1());
        checkoutPage.streetAddress_2(driver).sendKeys(checkoutPage.randomStreetAddress_2());
        checkoutPage.city(driver).sendKeys(checkoutPage.randomCity());
        checkoutPage.stateProvince(driver,"Alaska");
        checkoutPage.zipCode(driver).sendKeys("");
        checkoutPage.country(driver, "Togo");
        checkoutPage.setPhoneNumber(driver,"123456789");
        checkoutPage.chooseShippingMethod_Fixed(driver);

        System.out.println("7.Enter all details and wrong ZIP Code");

        //8.Click Next
        checkoutPage.button_Next(driver).click();
        System.out.println("8.Click Next");

        Assert.assertTrue(checkoutPage.zipErrorMessage(driver).isDisplayed());
            System.out.println("---------------Test C_CHKT_3 PASSED------------");
    }

    @AfterTest
    public void closeBrowser(){
        driver.close();
    }


}
