package registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.homePage;
import pageObject.registrationPage;

import java.util.concurrent.TimeUnit;

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
        String exePath = "C:\\Users\\int_jalu.MOBICAPL\\Selenium\\ChromeWebDriver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("ID | C_REG_1 | User left empty required fields");
        System.out.println("----------------------------------------------");
        System.out.println("1.Launch the browser");

        //2.Navigate to Home Page
        driver.get("http://localhost/Magento2/");
        System.out.println("2.Navigate to Home Page");

        //3.Click the Create an Account button on Home Page
        homePage.link_CreateAnAccount(driver).click();
        System.out.println("3.Click the Create an Account button on Home Page");

        //4.Click the Create an Account button
        registrationPage.button_CreateAnAccount(driver).click();
        System.out.println("4.Click the Create an Account button");

        //5.Check Error message
        System.out.println("5.Check Error message");
        System.out.println("INFO : "+registrationPage.getRequiredFieldsErrorMessage(driver));

        //6.Close the browser
        driver.close();
        System.out.println("6.Close the browser");
        System.out.println("-----------Test C_REG_1 PASSED----------------");
    }

}
