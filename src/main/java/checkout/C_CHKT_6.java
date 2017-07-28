package checkout;

import object.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 *  ID | C_CHKT_6 | Customer clicked Next button without selecting shipping method
 *  ------------------------------------------------------------------------------
 *  Step | Scenario
 *
 *  1.Launch the browser
 *  2.Navigate to Home Page
 *  3.Log In successfully
 *  4.Add product successfully
 *  5.Navigate to Cart
 *  6.Go to Checkout
 *  7.Enter all details without selecting shipping method
 *  8.Click Next
 *
 **/

public class C_CHKT_6 {

    public static WebDriver driver = null;

    @BeforeTest
    public void openBrowser(){
        driver = Browser.htmlUtilDriver();
    }

    @Test
    public void customerClickedNextButtonWithoutSelectingShippingMethod(){

    }

    @AfterTest
    public void closeBrowser(){
        driver.close();
    }


}
