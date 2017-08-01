package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class productPage {

    private static WebElement element = null;

    public static WebElement button_AddToCart(WebDriver driver){

        element = driver.findElement(By.id("product-addtocart-button"));
        return element;
    }

    public static WebElement getProductAddedSuccessMessage(WebDriver driver){

        //element = driver.findElement(By.xpath(".//*[@id='maincontent']/div[1]/div[2]/div[2]/div/div[text()='You added Fusion Backpack to your shopping cart.']"));
        element = driver.findElement(By.xpath(".//*[@id='maincontent']/div[1]/div[2]/div[2]/div"));
        return element;
    }

}
