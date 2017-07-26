package addToCart;

import object.Browser;
import object.Constant;
import org.openqa.selenium.WebDriver;
import pageObject.homePage;
import pageObject.loginPage;
import pageObject.productPage;

import java.util.concurrent.TimeUnit;

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

    public static void main(String[] args){

        //1.Launch the browser
        driver = Browser.openFirefox();
        //driver = Browser.htmlUtilDriver();
        System.out.println("ID | C_AC_1 | Customer selects product and clicks add to cart button");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("1.Launch the browser");

        //2.Navigate to Home Page
        driver.get(Constant.homePage);
        System.out.println("2.Navigate to Home Page");

        //3.Log in successfully
        System.out.println("3.Log in successfully");
            homePage.link_SignIn(driver).click();
                System.out.println("\t3.1.Click the Sign In button");
            loginPage.input_Email(driver).sendKeys(Constant.userName);
                System.out.println("\t3.2.Enter Email");
            loginPage.input_Password(driver).sendKeys(Constant.password);
                System.out.println("\t3.3.Enter Password");
            loginPage.button_Submit(driver).click();
                System.out.println("\t3.4.Click Login button");

        //4.Navigate to Home Page
        driver.get(Constant.homePage);
        System.out.println("4.Navigate to Home Page");

        //5.Click on the product
        homePage.prod_Backpack(driver).click();
        System.out.println("5.Click on the product");

        //6.Click Add to Cart button
        productPage.button_AddToCart(driver).click();
        System.out.println("6.Click Add to Cart button");

        if (productPage.getProductAddedSuccessMessage(driver).isDisplayed()){
            ///7.Check Message
            System.out.println("7.Check Message");
            System.out.println("INFO: SUCCESS!");
            //8.Close the browser
            driver.close();
            System.out.println("8.Close the browser");
            System.out.println("----------------------------Test C_AC_1 PASSED----------------------");
        }else{
            System.out.println("--------------------------Test C_AC_1 NOT PASSED--------------------");
            driver.close();
        }


    }

}
