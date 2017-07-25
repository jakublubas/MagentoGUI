package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homePage {

    private static WebElement element = null;

    public static WebElement link_SignIn(WebDriver driver){
    element = driver.findElement(By.partialLinkText("Sign In"));
        return element;
}

    public static WebElement link_CreateAnAccount(WebDriver driver){
        element = driver.findElement(By.partialLinkText("Create an Account"));
        return element;
    }
}
