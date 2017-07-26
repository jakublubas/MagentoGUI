package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class cartPage {

    private static WebElement element = null;

    public static void setQtyValue(WebDriver driver,String value){
        element = driver.findElement(By.id("cart-14-qty"));
        element.clear();
        element.sendKeys(value);
    }

    public static WebElement button_UpdateCart(WebDriver driver){

        element = driver.findElement(By.name("update_cart_action"));
        return element;
    }

    public static WebElement button_GoToCheckout(WebDriver driver){

        element = driver.findElement(By.className("action primary checkout"));
        return element;
    }
}
