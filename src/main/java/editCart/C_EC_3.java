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
 *  ID | C_EC_3 | Customer decided to go to Checkout
 *  ------------------------------------------------
 *  Step | Scenario
 *
 *  1.Launch the browser
 *  2.Navigate to Home Page
 *  3.Log In successfully
 *  4.Add product to Cart
 *  5.Navigate to Cart
 *  6.Go to Checkout
 *  7.Check URL
 *  8.Close the Browser
 *
 **/

public class C_EC_3 {

    private static WebDriver driver = null;

    @BeforeTest
    public void openBrowser() {
        driver = Browser.htmlUtilDriver();
    }

    @Test
    public void customerDecidedToGoToCheckout(){

        System.out.println("ID | C_EC_3 | Customer decided to go to Checkout");
        System.out.println("------------------------------------------------");

        //1.Launch the browser
        System.out.println("1.Launch the browser");

        //2.Navigate to Home Page
        driver.get(Constant.homePage);
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

        //6.Go to Checkout
        //cartPage.button_GoToCheckout(driver).click();
        driver.navigate().to(Constant.checkoutURL);
        System.out.println("6.Go to Checkout");

        //7.Check URL

        Assert.assertEquals(driver.getTitle(),"Checkout");
        System.out.println("7.Check URL");

        //8.Close the Browser
        System.out.println("8.Close the Browser");
        System.out.println("---------------Test C_EC_3 PASSED---------------");
    }

    @AfterTest
    public void closeBrowser(){
        driver.close();
    }
}
