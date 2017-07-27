package editCart;

import actions.logInSuccessfully;
import object.Browser;
import object.Constant;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.cartPage;
import pageObject.homePage;
import pageObject.loginPage;
import pageObject.productPage;

/**
 *
 *  ID | C_EC_2 | Customer remove product from Cart
 *  Step | Scenario
 *  1.Launch the browser
 *  2.Navigate to Home Page
 *  3.Log In successfully
 *  4.Add product to Cart
 *  5.Navigate to Cart
 *  6.Remove product from Cart
 *  7.Check Quantity
 *  8.Close the Browser
 *
 **/

public class C_EC_2 {

    private static WebDriver driver = null;

    @BeforeTest
    public void openBrowser() {
        driver = Browser.htmlUtilDriver();
    }

    @Test
    public void customerRemoveProductFromCart(){

        System.out.println("ID | C_EC_2 | Customer remove product from Cart");
        System.out.println("-----------------------------------------------");

        //1.Launch the browser
        System.out.println("1.Launch the browser");

        //2.Navigate to Home Page
        driver.get(Constant.cartURL);
        System.out.println("2.Navigate to Home Page");

        //3.Log In successfully
        logInSuccessfully.execute(driver);

        //4.Add product to Cart
        driver.get(Constant.homePage);
        homePage.prod_Backpack(driver).click();
        productPage.button_AddToCart(driver);
        Assert.assertTrue(productPage.getProductAddedSuccessMessage(driver).isDisplayed());
        System.out.println("4.Add product to Cart");

        //5.Navigate to Cart
        driver.get(Constant.cartURL);
        System.out.println("5.Navigate to Cart");

        //6.Remove product from Cart
        cartPage.setQtyValue(driver,"0");
        System.out.println("6.Remove product from Cart");

        //7.Check Quantity
        String value = cartPage.getQtyValue(driver);
        System.out.println("7.Check Quantity");
        System.out.println("New Qty = "+value);

        Assert.assertEquals(value,"0");

        //8.Close the Browser
        System.out.println("8.Close the Browser");
        System.out.println("---------------Test C_EC_2 PASSED--------------");
    }

    @AfterTest
    public void closeBrowser(){
        driver.close();
    }
}
