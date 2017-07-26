package registration;

import object.Browser;
import object.Constant;
import org.openqa.selenium.WebDriver;
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

    public static void main(String[] args){

        //1.Launch the browser
        driver = Browser.openChrome();
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

        if(registrationPage.getRequiredFieldsErrorMessage(driver).length()>0) {
            //5.Check Error message
            System.out.println("5.Check Error message");
            System.out.println("INFO : " + registrationPage.getRequiredFieldsErrorMessage(driver));

            //6.Close the browser
            driver.close();
            System.out.println("6.Close the browser");
            System.out.println("-----------Test C_REG_1 PASSED----------------");
        }
        else
            System.out.println("---------Test C_REG_1 NOT PASSED--------------");

    }

}
