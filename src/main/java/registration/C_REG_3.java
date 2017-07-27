package registration;

import object.Browser;
import object.Constant;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObject.homePage;
import pageObject.registrationPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 *
 *  ID | C_REG_3 | User enters different password in password confirm field
 *  -----------------------------------------------------------------------
 *  Step | Scenario
 *
 *  1.Launch the browser
 *  2.Navigate to Home Page
 *  3.Click the Create an Account button
 *  4.Enter Password
 *  5.Enter Confirm Password wrong
 *  6.Click the Create an Account button
 *  7.Check Error message
 *  8.Close the browser
 *
 **/

public class C_REG_3 {

    private static WebDriver driver = null;
    private static registrationPage page = new registrationPage();

    @BeforeTest
    public void openBrowser() {
        //1.Launch the browser
        //driver = Browser.openChrome();
        driver = Browser.htmlUtilDriver();
    }
    @Test
    public void userEntersDifferentPasswordInPasswordConfirmField() {

        System.out.println("ID | C_REG_3 | User enters different password in password confirm field");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("1.Launch the browser");

        //2.Navigate to Home Page
        driver.get(Constant.homePage);
        System.out.println("2.Navigate to Home Page");

        //3.Click the Create an Account button
        homePage.link_CreateAnAccount(driver).click();
        System.out.println("3.Click the Create an Account button on Home Page");

        //4.Enter Password
        registrationPage.input_Password(driver).sendKeys(page.getCorrectPassword());
        System.out.println("4.Enter Password");

        //5.Enter Confirm Password wrong
        registrationPage.input_ConfirmPassword(driver).sendKeys(page.getCorrectPassword() + "1");
        System.out.println("Enter Confirm Password wrong");

        //6.Click the Create an Account button
        registrationPage.button_CreateAnAccount(driver).click();
        System.out.println("6.Click the Create an Account button");

        Assert.assertTrue(registrationPage.getConfirmPasswordErrorMessage(driver).length() > 0);

        if (registrationPage.getConfirmPasswordErrorMessage(driver).length() > 0) {
            //7.Check Error message
            System.out.println("7.Check Error message");
            System.out.println("INFO: " + registrationPage.getConfirmPasswordErrorMessage(driver));

            //8.Close the browser
            System.out.println("8.Close the browser");
            System.out.println("-------------------------Test C_REG_3 PASSED---------------------------");
        }
    }

        @AfterTest
        public void closeBrowser(){
            driver.close();
        }
}
