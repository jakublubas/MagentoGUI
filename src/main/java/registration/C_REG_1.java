package registration;

import object.Browser;
import object.Constant;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.homePage;
import pageObject.registrationPage;

/**
 *
 *  ID | C_REG_1 | User left empty required fields
 *  ----------------------------------------------
 *  Step | Scenario
 *
 *  1.Launch the browser
 *  2.Navigate to Home Page
 *  3.Click the Create an Account button
 *  4.Click the Create an Account button
 *  5.Check Error message
 *  6.Close the browser
 *
 **/

public class C_REG_1 {

   private static WebDriver driver = null;

    @BeforeTest
    public void openBrowser() {
        //1.Launch the browser
        //driver = Browser.openChrome();
        driver = Browser.htmlUtilDriver();
    }

    @Test
    public void userLefrEmptyRequiredFields(){
        System.out.println("ID | C_REG_1 | User left empty required fields");
        System.out.println("----------------------------------------------");
        System.out.println("1.Launch the browser");

        //2.Navigate to Home Page
        driver.get(Constant.homePage);
        System.out.println("2.Navigate to Home Page");

        //3.Click the Create an Account button on Home Page
        homePage.link_CreateAnAccount(driver).click();
        System.out.println("3.Click the Create an Account button on Home Page");

        //4.Click the Create an Account button
        registrationPage.button_CreateAnAccount(driver).click();
        System.out.println("4.Click the Create an Account button");

        Assert.assertTrue(registrationPage.getRequiredFieldsErrorMessage(driver).length()>0);

        if(registrationPage.getRequiredFieldsErrorMessage(driver).length()>0) {
            //5.Check Error message
            System.out.println("5.Check Error message");
            System.out.println("INFO : " + registrationPage.getRequiredFieldsErrorMessage(driver));

            //6.Close the browser
            System.out.println("6.Close the browser");
            System.out.println("-----------Test C_REG_1 PASSED----------------");
        }
    }

    @AfterTest
    public void closeBrowser(){
        driver.close();
    }

}
