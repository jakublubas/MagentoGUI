package logIn;

import object.Browser;
import object.Constant;
import org.openqa.selenium.WebDriver;
import pageObject.homePage;
import pageObject.loginPage;

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
        loginPage.input_Email(driver).sendKeys("test3@test.com");
        System.out.println("4.EnterEmail");

        //5.Enter wrong Password
        loginPage.input_Password(driver).sendKeys("pass");
        System.out.println("5.Enter Password");

        //6.Click Login button
        loginPage.button_Submit(driver).click();
        System.out.println("6.Click Login button");

        if(loginPage.getPasswordErrorMessage(driver).length()>0) {
            //7.Check Error message
            System.out.println("7.Check Error message");
            System.out.println("INFO: "+loginPage.getPasswordErrorMessage(driver));

            // 8.Close the browser
            driver.close();
            System.out.println("8.Close the browser");
            System.out.println("----------Test C_LOG_2 PASSED--------------");
        }
        else {
            driver.close();
            System.out.println("--------Test C_LOG_2 NOT PASSED------------");
        }
    }

}
