package editCart;

import actions.addProduct;
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
 *  ID | C_EC_1 | Customer changes the Quantity
 *  -------------------------------------------
 *  Step | Scenario
 *
 *  1.Launch the browser
 *  2.Navigate to Home Page
 *  3.Log In successfully
 *  4.Add product to Cart
 *  5.Navigate to Cart
 *  6.Change the Quantity
 *  7.Check Quantity
 *  8.Close the Browser
 *
 **/

public class C_EC_1 {

        private static WebDriver driver = null;

        @BeforeTest
        public void openBrowser() {
            //driver = Browser.openFirefox();
            driver = Browser.htmlUtilDriver();
        }

        @Test
        public void customerChangesTheQuantity() {

            System.out.println("ID | C_EC_1 | Customer changes the Quantity");
            System.out.println("-------------------------------------------");
            //1.Launch the browser
            System.out.println("1.Launch the browser");

            //2.Navigate to Home Page
            driver.get(Constant.homePage);
            System.out.println("2.Navigate to Home Page");

            //3.Log In successfully
            logInSuccessfully.execute(driver);

            //4.Add product to Cart
            addProduct.execute(driver);

            //5.Navigate to Cart
            driver.get(Constant.cartURL);
            System.out.println("5.Navigate to Cart");

            //6.Change the Quantity
            String newValue = "1";
            cartPage.setQtyValue(driver,newValue);
            System.out.println("6.Change the Quantity");
            //cartPage.button_UpdateCart(driver).click();

            //7.Check Quantity
            String value = cartPage.getQtyValue(driver);
            System.out.println("7.Check Quantity");
            System.out.println("Qty = "+value);

            Assert.assertEquals(value,newValue);

            //8.Close the Browser
            System.out.println("8.Close the Browser");
            System.out.println("-------------Test C_EC_3 PASSED------------");
        }

        @AfterTest
        public void closeBrowser(){
            driver.close();
        }
}
