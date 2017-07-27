package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class cartPage {

    private static WebElement element = null;

    public static void setQtyValue(WebDriver driver, String value){
        element = driver.findElement(By.id("cart-14-qty"));
        element.clear();
        element.sendKeys(value);
    }

    public static String getQtyValue(WebDriver driver){

        element = driver.findElement(By.id("cart-14-qty"));
        String qtyValue = element.getAttribute("value");
        return qtyValue;
    }

    public static WebElement button_UpdateCart(WebDriver driver){

        element = driver.findElement(By.name("update_cart_action"));
        return element;
    }

    public static WebElement button_GoToCheckout(WebDriver driver){

        element = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/ul/li[1]/button"));
        return element;
    }
}
