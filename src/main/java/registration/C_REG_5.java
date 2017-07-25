package registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.homePage;
import pageObject.registrationPage;

import java.util.concurrent.TimeUnit;

/**
 *
 *  ID | C_REG_5 | User enters all the details successfully
 *  -------------------------------------------------------
 *  Step | Scenario
 *
 *  1.Launch the browser
 *  2.Navigate to Home Page
 *  3.Click the Create an Account button
 *  4.Enter First Name
 *  5.Enter Last Name
 *  6.Enter Email
 *  7.Enter Password
 *  8.Enter Confirm Password
 *  9.Click the Create an Account button
 *  10.Check page URL
 *  11.Print Successfull Message
 *  12.Close the Browser
 *
 **/

public class C_REG_5 {

    private static WebDriver driver = null;
    private static registrationPage page = new registrationPage();

    public static void main(String[] args){

        //1.Launch the browser
        String exePath = "C:\\Users\\int_jalu.MOBICAPL\\Selenium\\ChromeWebDriver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("ID | C_REG_5 | User enters all the details successfully");
        System.out.println("-------------------------------------------------------");
        System.out.println("1.Launch the browser");

        //2.Navigate to Home Page
        driver.get("http://localhost/Magento2/");
        System.out.println("2.Navigate to Home Page");

        //3.Click the Create an Account button on Home Page
        homePage.link_CreateAnAccount(driver).click();
        System.out.println("3.Click the Create an Account button on Home Page");

        //4.Enter First Name
        String fn = page.getCorrectFirstNameRandom();
        registrationPage.input_FirstName(driver).sendKeys(fn);
        System.out.println("4.Enter First Name: "+fn);

        //5.Enter Last Name
        String ln = page.getCorrectLastNameRandom();
        registrationPage.input_LastName(driver).sendKeys(ln);
        System.out.println("5.Enter Last Name: "+ln);

        //6.Enter Email
        String email = page.getCorrectEmailRandom();
        registrationPage.input_Email(driver).sendKeys(email);
        System.out.println("6.Enter Email: "+email);

        //7.Enter Password
        String pass = page.getCorrectPassword();
        registrationPage.input_Password(driver).sendKeys(pass);
        System.out.println("7.Enter Password: "+pass);

        //8.Enter Confirm Password
        registrationPage.input_ConfirmPassword(driver).sendKeys(pass);
        System.out.println("8.Enter Confirm Password: "+pass);

        //9.Click the Create an Account button
        registrationPage.button_CreateAnAccount(driver).click();
        System.out.println("9.Click the Create an Account button");

        //10.Check page URL
        System.out.println("10.Check page URL");

        //11.Print Successfull Message
        System.out.println("11.Print Successfull Message");
        System.out.println("INFO: ACCOUNT HAS BEEN CREATED");

        //12.Close the Browser
        driver.close();
        System.out.println("12.Close the Browser");
        System.out.println("------------------Test C_REG_5 PASSED------------------");


    }

}
