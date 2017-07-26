package logIn;

import object.Browser;
import object.Constant;
import org.openqa.selenium.WebDriver;
import pageObject.homePage;
import pageObject.loginPage;

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

    public static void main(String[] args){

        //1.Launch the browser
        driver = Browser.openChrome();
        System.out.println("ID | C_LOG_1 | Customer entered wrong Email");
        System.out.println("-------------------------------------------");
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

        if(URL.equals(Constant.userLogInPage)) {
            System.out.println("Succesfull Logged In");
            driver.close();
            System.out.println("7.Close the browser");
            System.out.println("----------Test C_LOG_3 PASSED--------------");
        } else {

            System.out.println("Not logged in");
            System.out.println("7.Close the browser");
            System.out.println("--------Test C_LOG_3 NOT PASSED------------");

        }
    }

}
