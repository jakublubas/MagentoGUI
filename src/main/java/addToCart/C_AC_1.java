package addToCart;

import actions.logInSuccessfully;
import object.Browser;
import object.Constant;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObject.homePage;
import pageObject.loginPage;
import pageObject.productPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 *  ID | C_AC_1 | Customer selects product and clicks add to cart button
 *  --------------------------------------------------------------------
 *  Step | Scenario
 *
 *  1.Launch the browser
 *  2.Navigate to Home Page
 *  3.Log in successfully
 *  4.Navigate to Home Page
 *  5.Click on the product
 *  6.Click Add to Cart button
 *  7.Check Message
 *  8.Close the browser
 *
 **/

public class C_AC_1 {

    private static WebDriver driver = null;

    @BeforeTest
    public void openBrowser(){
        //1.Launch the browser
        //driver = Browser.openFirefox();
        driver = Browser.htmlUtilDriver();
    }
    @Test
    public void customerSelectsProductAndClicksAddToCartButton(){
        //driver = Browser.htmlUtilDriver();
        System.out.println("ID | C_AC_1 | Customer selects product and clicks add to cart button");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("1.Launch the browser");

        //2.Navigate to Home Page
        driver.get(Constant.homePage);
        System.out.println("2.Navigate to Home Page");

        //3.Log in successfully
        logInSuccessfully.execute(driver);

        //4.Navigate to Home Page
        driver.get(Constant.homePage);
        System.out.println("4.Navigate to Home Page");

        //5.Click on the product
        homePage.prod_Backpack(driver).click();
        System.out.println("5.Click on the product");

        //6.Click Add to Cart button
        productPage.button_AddToCart(driver).click();
        System.out.println("6.Click Add to Cart button");

        Assert.assertTrue(productPage.getProductAddedSuccessMessage(driver).isDisplayed());

        if (productPage.getProductAddedSuccessMessage(driver).isDisplayed()){
            ///7.Check Message
            System.out.println("7.Check Message");
            System.out.println("INFO: SUCCESS!");
            //8.Close the browser
            System.out.println("8.Close the browser");
            System.out.println("----------------------------Test C_AC_1 PASSED----------------------");
        }
    }

    @AfterTest
    public void closeBrowser(){
        driver.close();
    }

}
