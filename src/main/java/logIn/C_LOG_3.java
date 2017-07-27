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

import static org.testng.Assert.*;

/**
 *
 *  ID | C_LOG_3 | Customer entered correct Email and Password
 *  ----------------------------------------------------------
 *  Step | Scenario
 *
 *  1.Launch the browser
 *  2.Navigate to Home Page
 *  3.Click the Sign In button
 *  4.Enter Email
 *  4.Enter Password
 *  5.Click Login button
 *  6.Check URL
 *  7.Close the browser
 *
 **/

public class C_LOG_3 {

    private static WebDriver driver = null;

    @BeforeTest
    public void openBrowser() {
        //driver = Browser.openChrome();
        driver = Browser.htmlUtilDriver();
        //driver = Browser.openFirefox();
    }

    @Test
    public void customerEnteredCorrectEmailAndPassword(){
        //1.Launch the browser
        System.out.println("ID | C_LOG_3 | Customer entered correct Email and Password");
        System.out.println("----------------------------------------------------------");
        System.out.println("1.Launch the browser");

        //2.Navigate to Home Page
        driver.get(Constant.homePage);
        System.out.println("2.Navigate to Home Page");

        //3.Click the Sign In button
        homePage.link_SignIn(driver).click();
        System.out.println("3.Click the Sign In button");

        //4.Enter Email
        loginPage.input_Email(driver).sendKeys(Constant.userName);
        System.out.println("4.Enter Email");

        //5.Enter Password
        loginPage.input_Password(driver).sendKeys(Constant.password);
        System.out.println("5.Enter Password");

        //5.Click Login button
        loginPage.button_Submit(driver).click();
        System.out.println("5.Click Login button");

        //6.Check URL
        String URL = driver.getCurrentUrl();
        System.out.println("6.Checking URL...");

        Assert.assertEquals(Constant.userLogInPage,URL);

        if(URL.equals(Constant.userLogInPage)) {
            System.out.println("Succesfull Logged In");
            System.out.println("7.Close the browser");
            System.out.println("----------Test C_LOG_3 PASSED--------------");
        }
    }

    @AfterTest
    public void closeBrowser(){
        driver.close();
    }

}
