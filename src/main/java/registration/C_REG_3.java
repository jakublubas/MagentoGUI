package registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.homePage;
import pageObject.registrationPage;

import java.util.concurrent.TimeUnit;

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

    public static void main(String[] args){

        //1.Launch the browser
        String exePath = "C:\\Users\\int_jalu.MOBICAPL\\Selenium\\ChromeWebDriver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("ID | C_REG_3 | User enters different password in password confirm field");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("1.Launch the browser");

        //2.Navigate to Home Page
        driver.get("http://localhost/Magento2/");
        System.out.println("2.Navigate to Home Page");

        //3.Click the Create an Account button
        homePage.link_CreateAnAccount(driver).click();
        System.out.println("3.Click the Create an Account button on Home Page");

        //4.Enter Password
        registrationPage.input_Password(driver).sendKeys(page.getCorrectPassword());
        System.out.println("4.Enter Password");

        //5.Enter Confirm Password wrong
        registrationPage.input_ConfirmPassword(driver).sendKeys(page.getCorrectPassword()+"1");
        System.out.println("Enter Confirm Password wrong");

        //6.Click the Create an Account button
        registrationPage.button_CreateAnAccount(driver).click();
        System.out.println("6.Click the Create an Account button");

        if(registrationPage.getConfirmPasswordErrorMessage(driver).length()>0) {
            //7.Check Error message
            System.out.println("7.Check Error message");
            System.out.println("INFO: "+registrationPage.getConfirmPasswordErrorMessage(driver));

            //8.Close the browser
            driver.close();
            System.out.println("8.Close the browser");
            System.out.println("-------------------------Test C_REG_3 PASSED---------------------------");
        }
        else
            driver.close();
            System.out.println("-----------------------Test C_REG_3 NOT PASSED-------------------------");
    }
}
