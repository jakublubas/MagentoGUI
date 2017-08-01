package actions;

import object.Constant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObject.homePage;
import pageObject.loginPage;

import java.util.concurrent.TimeUnit;

public class logInSuccessfully {

    public static WebDriver driver = null;

    public static void execute(WebDriver driver){
        System.out.println("3.Log in successfully");
        homePage.link_SignIn(driver).click();
        System.out.println("\t3.1.Click the Sign In button");
        loginPage.input_Email(driver).sendKeys(Constant.userName);
        System.out.println("\t3.2.Enter Email");
        loginPage.input_Password(driver).sendKeys(Constant.password);
        System.out.println("\t3.3.Enter Password");
        loginPage.button_Submit(driver).click();
        System.out.println("\t3.4.Click Login button");

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.titleIs("My Account"));

        Assert.assertEquals(driver.getTitle(),"My Account");
    }
}
