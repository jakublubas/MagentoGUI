package checkout;

import object.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 *
 *  ID | C_CHKT_4 | Customer didn’t select Country
 *  ----------------------------------------------
 *  Step | Scenario
 *
 *  1.Launch the browser
 *  2.Navigate to Home Page
 *  3.Log In successfully
 *  4.Add product successfully
 *  5.Navigate to Cart
 *  6.Go to Checkout
 *  7.Enter all details without selecting Country
 *  8.Click Next
 *
 **/

public class C_CHKT_4 {

    public static WebDriver driver = null;

    @BeforeTest
    public void openBrowser(){
        driver = Browser.htmlUtilDriver();
    }

    @Test
    public void customerDidNotSelectCountry(){

    }

    @AfterTest
    public void closeBrowser(){
        driver.close();
    }


}
