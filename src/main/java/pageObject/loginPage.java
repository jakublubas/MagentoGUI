package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {

    private static WebElement element = null;

    public static WebElement input_Email(WebDriver driver){
        element = driver.findElement(By.name("login[username]"));
        return element;
    }

    public static WebElement input_Password(WebDriver driver){
        element = driver.findElement(By.name("login[password]"));
        return element;
    }

    public static WebElement button_Submit(WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"send2\"]/span"));
        return element;
    }

    public static String getEmailErrorMessage(WebDriver driver){

        WebElement emailError = driver.findElement(By.id("email-error"));

        if(emailError.isDisplayed())
            return "User entered invalid email address";
        else
            return "All correct!";

    }

    public static String getPasswordErrorMessage(WebDriver driver){

        WebElement passwordError = driver.findElement(By.id("pass-error"));

        if(passwordError.isDisplayed())
            return "User entered invalid password";
        else
            return "All correct";
    }
}
