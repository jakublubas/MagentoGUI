package logIn;

import object.Browser;
import object.Constant;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObject.homePage;
import pageObject.loginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 *  ID | C_LOG_2 | Customer entered wrong Password
 *  ----------------------------------------------
 *  Step | Scenario
 *
 *  1.Launch the browser
 *  2.Navigate to Home Page
 *  3.Click the Sign In button
 *  4.Enter Email
 *  5.Enter wrong Password
 *  6.Click Login button
 *  7.Check Error message
 *  8.Close the browser
 *
 **/

public class C_LOG_2 {

    private static WebDriver driver = null;

    @BeforeTest
    public void openBrowser() {
        //1.Launch the browser
        driver = Browser.openChrome();
        //driver = Browser.htmlUtilDriver();
    }
    @Test
    public void customerEnteredWrongPassword(){

        System.out.println("ID | C_LOG_1 | Customer entered wrong Password");
        System.out.println("----------------------------------------------");
        System.out.println("1.Launch the browser");

        //2.Navigate to Home Page
        driver.get(Constant.homePage);
        System.out.println("2.Navigate to Home Page");

        //3.Click the Sign In button
        homePage.link_SignIn(driver).click();
        System.out.println("3.Click the Sign In button");

        //4.Enter Email
        loginPage.input_Email(driver).sendKeys("test3@test.com");
        System.out.println("4.EnterEmail");

        //5.Enter wrong Password
        loginPage.input_Password(driver).sendKeys("pass");
        System.out.println("5.Enter Password");


        //6.Click Login button
        loginPage.button_Submit(driver).click();
        System.out.println("6.Click Login button");


        Assert.assertTrue(loginPage.getPasswordErrorMessage(driver).isDisplayed());

        if(loginPage.getPasswordErrorMessage(driver).isDisplayed()) {
            //7.Check Error message
            System.out.println("7.Check Error message");

            // 8.Close the browser
            System.out.println("8.Close the browser");
            System.out.println("----------Test C_LOG_2 PASSED--------------");
        }
    }

    @AfterTest
    public void closeBrowser(){
        driver.close();
    }

}
