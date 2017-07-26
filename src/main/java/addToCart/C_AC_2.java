package addToCart;

import object.Browser;
import object.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObject.homePage;
import pageObject.productPage;

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

    public static void main(String[] args){

        //1.Launch the Browser
        driver = Browser.openChrome();
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
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        //5.Check Message
        if (productPage.getProductAddedSuccessMessage(driver).isDisplayed()){
            System.out.println("5.Check Message");
            System.out.println("INFO: SUCCESS!");
            //8.Close the browser
            driver.close();
            System.out.println("8.Close the browser");
            System.out.println("------------------------Test C_AC_2 PASSED-----------------------");
        }else{
            System.out.println("----------------------Test C_AC_2 NOT PASSED---------------------");
            driver.close();
        }
    }

}
