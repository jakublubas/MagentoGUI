package addToCart;

import object.Browser;
import object.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObject.homePage;
import pageObject.productPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 *
 *  ID | C_AC_2 | Guest selects product and clicks add to cart button
 *  --------------------------------------------------------------------
 *  Step | Scenario
 *
 *  1.Launch the browser
 *  2.Navigate to Home Page
 *  3.Click on the product
 *  4.Click Add to Cart button
 *  5.Check Message
 *  6.Close the Browser
 *
 **/

public class C_AC_2 {

    private static WebDriver driver = null;

    @BeforeTest
    public void openBrowser(){
        //1.Launch the Browser
        //driver = Browser.openChrome();
        //driver = Browser.htmlUtilDriver();
        driver = Browser.openFirefox();
    }

    @Test
    public void guestSelectsProductsAndClicksAddToCartButton(){

        System.out.println("ID | C_AC_2 | Guest selects product and clicks add to cart button");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("1.Launch the Browser");

        //2.Navigate to Home Page
        driver.get(Constant.homePage);
        System.out.println("2.Navigate to Home Page");

        //3.Click on the product
        homePage.prod_Backpack(driver).click();
        System.out.println("3.Click on the product");

        //4.Click Add to Cart button
        productPage.button_AddToCart(driver).click();
        System.out.println("4.Click Add to Cart button");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(productPage.getProductAddedSuccessMessage(driver).isDisplayed());

        //5.Check Message
        if (productPage.getProductAddedSuccessMessage(driver).isDisplayed()){
            System.out.println("5.Check Message");
            System.out.println("INFO: SUCCESS!");
            //8.Close the browser
            System.out.println("8.Close the browser");
            System.out.println("------------------------Test C_AC_2 PASSED-----------------------");
        }
    }

    @AfterTest
    public void closeBrowser(){
        driver.close();
    }

}
