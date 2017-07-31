package checkout;

import actions.addProduct;
import actions.logInSuccessfully;
import object.Browser;
import object.Constant;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.checkoutPage;

import static org.testng.Assert.assertTrue;

/**
 *
 *
 *  ID | C_CHKT_1 | Customer left required fields empty
 *  ---------------------------------------------------
 *  Step | Scenario
 *
 *  1.Launch the browser
 *  2.Navigate to Home Page
 *  3.Log In successfully
 *  4.Add product successfully
 *  5.Navigate to Cart
 *  6.Go to Checkout
 *  7.Click Next button
 *
 **/

public class C_CHKT_1 {

    public static WebDriver driver = null;

    @BeforeTest
    public void openBrowser(){
        driver = Browser.openFirefox();
        //driver = Browser.htmlUtilDriver();
    }

    @Test
    public void customerLeftRequiredFieldsEmpty(){

        System.out.println("ID | C_CHKT_1 | Customer left required fields empty");
        System.out.println("---------------------------------------------------");

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

        //7.Click Next button
        checkoutPage.button_Next(driver).click();
        System.out.println("7.Click Next button");

        assertTrue(checkoutPage.requiredFieldErrorIsDisplayed(driver));
            System.out.println("-----------------Test C_CHKT_1 PASSED--------------");



    }

    @AfterTest
    public void closeBrowser(){
        driver.close();
    }


}
