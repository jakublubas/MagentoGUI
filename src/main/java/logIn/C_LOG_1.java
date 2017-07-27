package logIn;

import object.Browser;
import object.Constant;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.homePage;
import pageObject.loginPage;

/**
 *
 *  ID | C_LOG_1 | Customer entered wrong Email
 * --------------------------------------------
 * Step | Scenario
 *
 *  1.Launch the browser
 *  2.Navigate to Home Page
 *  3.Click the Sign In button
 *  4.Enter wrong Email
 *  5.Enter Password
 *  6.Click Login button
 *  7.Check Error message
 *  8.Close the browser
 *
 **/

public class C_LOG_1 {

    private static WebDriver driver = null;

    @BeforeTest
        public void openBrowser(){
        //1.Launch the browser
        driver = Browser.openChrome();
        //driver = Browser.htmlUtilDriver();
    }

    @Test
    public void customerEnteredWrongEmailTest(){
        System.out.println("ID | C_LOG_1 | Customer entered wrong Email");
        System.out.println("-------------------------------------------");
        System.out.println("1.Launch the browser");

        //2.Navigate to Home Page
        driver.get(Constant.homePage);
        System.out.println("2.Navigate to Home Page");

        //3.Click the Sign In button
        homePage.link_SignIn(driver).click();
        System.out.println("3.Click the Sign In button");

        //4.Enter wrong Email
        loginPage.input_Email(driver).sendKeys("wrongEmailtest.com");
        System.out.println("4.Enter wrong Email");

        //5.Enter Password
        loginPage.input_Password(driver).sendKeys("password");
        System.out.println("5.Enter Password");

        //6.Click Login button
        loginPage.button_Submit(driver).click();
        System.out.println("6.Click Login button");

        Assert.assertTrue(loginPage.getEmailErrorMessage(driver).length()>0);

        if(loginPage.getEmailErrorMessage(driver).length()>0) {
            //7.Check Error message
            System.out.println("7.Check Error message");
            System.out.println("INFO: "+loginPage.getEmailErrorMessage(driver));

            //8.Close the browser
            System.out.println("8.Close the browser");
            System.out.println("----------Test C_LOG_1 PASSED--------------");
        }
    }

    @AfterTest
    public void closeBrowser(){
        driver.close();
    }

}
