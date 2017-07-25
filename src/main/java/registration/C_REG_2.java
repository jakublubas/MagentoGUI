package registration;


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
        String exePath = "C:\\Users\\int_jalu.MOBICAPL\\Selenium\\ChromeWebDriver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("ID | C_REG_2 | User selects already existing Email");
        System.out.println("--------------------------------------------------");
        System.out.println("1.Launch the browser");

        //2.Navigate to Home Page
        driver.get("http://localhost/Magento2/");
        System.out.println("2.Navigate to Home Page");

        //3.Click the Create an Account button
        homePage.link_CreateAnAccount(driver).click();
        System.out.println("3.Click the Create an Account button on Home Page");

        //4.Enter Wrong Email


        //5.Click the Create an Account button
        registrationPage.button_CreateAnAccount(driver).click();
        System.out.println("5.Click the Create an Account button");

        //6.Check error message


        //7.Close the browser
        driver.close();
        System.out.println("7.Close the Browser");
        System.out.println("---------------Test C_REG_2 PASSED----------------");
    }
}
