package registration;


import object.Browser;
import object.Constant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.homePage;
import pageObject.registrationPage;

import java.util.concurrent.TimeUnit;

/**
 *
 *  ID | C_REG_2 | User selects already existing Email
 *  --------------------------------------------------
 *  Step | Scenario
 *
 *  1.Launch the browser
 *  2.Navigate to Home Page
 *  3.Click the Create an Account button
 *  4.Enter Email
 *  5.Click the Create an Account button
 *  6.Check error message
 *  7.Close the browser
 *
 **/

public class C_REG_2 {

    private static WebDriver driver = null;
    private static registrationPage page = new registrationPage();

    public static void main(String[] args){
        //1.Launch the browser
        driver = Browser.open();
        System.out.println("ID | C_REG_2 | User selects already existing Email");
        System.out.println("--------------------------------------------------");
        System.out.println("1.Launch the browser");

        //2.Navigate to Home Page
        driver.get(Constant.homePage);
        System.out.println("2.Navigate to Home Page");

        //3.Click the Create an Account button
        homePage.link_CreateAnAccount(driver).click();
        System.out.println("3.Click the Create an Account button on Home Page");

        //4.Enter Wrong Email
        registrationPage.input_Email(driver).sendKeys("test@test.com");
        System.out.println("4.Enter Email: test@test.com");

        //Enter other details properly
        String fn = page.getCorrectFirstNameRandom();
        registrationPage.input_FirstName(driver).sendKeys(fn);

        String ln = page.getCorrectLastNameRandom();
        registrationPage.input_LastName(driver).sendKeys(ln);

        String pass = page.getCorrectPassword();
        registrationPage.input_Password(driver).sendKeys(pass);

        registrationPage.input_ConfirmPassword(driver).sendKeys(pass);


        //5.Click the Create an Account button
        registrationPage.button_CreateAnAccount(driver).click();
        System.out.println("5.Click the Create an Account button");


        if(registrationPage.getAlreadyUsedEmailErrorMessage(driver).length()>0) {
           //6.Check error message
           System.out.println("6.Check error message");
           System.out.print("INFO: "+registrationPage.getAlreadyUsedEmailErrorMessage(driver)+"\n");

           //7.Close the browser
           driver.close();
           System.out.println("7.Close the Browser");
           System.out.println("---------------Test C_REG_2 PASSED----------------");
       }
       else {
           driver.close();
           System.out.println("-------------Test C_REG_2 NOT PASSED--------------");
       }

    }
}